package com.mk.crawer.biz.servcie.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.api.QunarHotelSyncService;
import com.mk.crawer.biz.model.crawer.Brands;
import com.mk.crawer.biz.model.crawer.BrandsExample;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;
import com.mk.crawer.biz.model.crawer.Hotel;
import com.mk.crawer.biz.model.crawer.HotelExample;
import com.mk.crawer.biz.servcie.BrandsService;
import com.mk.crawer.biz.servcie.ICityListService;
import com.mk.crawer.biz.servcie.IHotelService;
import com.mk.crawer.biz.utils.Constant;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.JsonUtils;
import com.mk.framework.proxy.http.HttpUtil;

/**
 * Created by kangxiaolong on 2016-01-06.
 */
@Service
public class QunarHotelSyncServiceImpl implements QunarHotelSyncService {
    private static Logger logger = LoggerFactory.getLogger(QunarHotelSyncServiceImpl.class);
    @Autowired
    private ICityListService cityListService ;
    @Autowired
    private IHotelService hotelService ;
    @Autowired
    private BrandsService brandsService ;

    public Map<String,Object> qunarHotelSync(){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        CityListExample cityListExample=new CityListExample();
        List<CityList> cityLists=cityListService.selectByExample(cityListExample);
        if (CollectionUtils.isEmpty(cityLists)){
            resultMap.put("message","cityList is empty");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        for (CityList city:cityLists){
            String fromDate=DateUtils.getCertainDate(1);
            String toDate=DateUtils.getCertainDate(2);
            String url=Constant.qunar_touch_hostlist+"?city="+city.getCityName()+"&fromDate="+fromDate+"&toDate="+toDate;
            String hotelResult=HttpUtil.doGet(url);

            Map<String,String> urlMaps=getJsonList(hotelResult);
            if(urlMaps==null){
                logger.info("====================qunarHotelSync city={}  continue because url reslut is null====================",city.getCityName());
                 continue;
            }
            if (urlMaps.get("error")!=null){
                Cat.logEvent("qunarHotelSync", "去哪儿酒店信息同步", Event.SUCCESS,
                        hotelResult
                );
                logger.info("====================qunarHotelSync method end because {}====================",hotelResult);
                continue;
            }
            String info=urlMaps.get("info");
            String hotels =urlMaps.get("hotels");
            if(info==null||hotels==null){
                Cat.logEvent("qunarHotelSync", "去哪儿酒店信息同步", Event.SUCCESS,
                        "info is null || hotels is nul=");
                logger.info("====================qunarHotelSync method end because info is null || hotels is null====================");
                continue;
            }
            Map<String,String> infoMap=getJsonList(info);
            if (infoMap==null){
                logger.info("====================qunarHotelSync method end because infoMap is null====================");

            }
            if(infoMap.get("brands")!=null){
                saveBrands(city,infoMap.get("brands"));
            }
            saveHotel(hotels);
        }


        resultMap.put("message","备份成功");
        resultMap.put("SUCCESS", true);
        Cat.logEvent("qunarHotelSync", "去哪儿酒店信息同步", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info("====================qunarHotelSync method end time{}===================="
                , DateUtils.getDatetime());
        return resultMap;
    }
    public void saveBrands(CityList city,String brandsStr){
        if(brandsStr!=null||city==null||city.getCityUrl()==null) {
            return;
        }
        Map<String,String> brandsMap=getJsonList(brandsStr);
        if(brandsMap!=null){
            for (String key:brandsMap.keySet()){
                Map<String,String> brandMap=getJsonList(brandsMap.get(key));
                if (brandMap==null){
                    continue;
                }
                Brands brands =new Brands();
                brands.setName(brandMap.get("name"));
                if (brandMap.get("count")!=null)
                    brands.setCount(Long.valueOf(brandMap.get("count")));
                brands.setGroup(brandMap.get("group"));
                brands.setLog(brandMap.get("logo"));
                brands.setCityUrl(city.getCityUrl());
                BrandsExample brandsExample=new BrandsExample();
                brandsExample.createCriteria().andCityUrlEqualTo(city.getCityUrl());
                brandsExample.createCriteria().andNameEqualTo(brands.getName());
                List<Brands> checkBrandsExist=brandsService.selectByExample(brandsExample);
                if (CollectionUtils.isEmpty(checkBrandsExist)){
                    brands.setCreateTime(new Date());
                    brandsService.insert(brands);
                }else {
                    Brands existBrands=checkBrandsExist.get(0);
                    brands.setId(existBrands.getId());
                    brands.setUpdateTime(new Date());
                    brandsService.updateByPrimaryKeySelective(brands);
                }
            }
        }
    }
    public void saveHotel(String hotelStr){
        List<Object> hotelList=JsonUtils.jsonToList(hotelStr);
        for(int i=0;i<hotelList.size();i++){
            Map<String,String> hotelMap=JsonUtils.jsonToMap(hotelList.get(i).toString());
            if(hotelMap==null){
                logger.info("====================hotelMap is null====================");
                continue;
            }
            Hotel hotel=new Hotel();
            hotel.setSourceId(hotelMap.get("id"));
            hotel.setCityName(hotelMap.get("cityName"));
            if (hotelMap.get("distance")!=null)
                hotel.setDistance(Long.valueOf(hotelMap.get("distance")));
            if (hotelMap.get("price")!=null)
                hotel.setPrice(new BigDecimal(hotelMap.get("price")));
            if (hotelMap.get("attrs")!=null){
                Map<String,String> attrsMap=JsonUtils.jsonToMap(hotelMap.get("attrs"));
                if (attrsMap==null){
                    logger.info("====================attrsMap is null====================");
                    continue;
                }
                hotel.setHasBreakfast(attrsMap.get("hasBreakfast"));
                if(attrsMap.get("imageCount")!=null)
                    hotel.setImageCount(Long.valueOf(attrsMap.get("imageCount")));
                hotel.setHasFitnessRoom(attrsMap.get("HasFitnessRoom"));
                if(attrsMap.get("imageCount")!=null)
                    hotel.setCommentScore(new BigDecimal(attrsMap.get("CommentScore")));
                hotel.setHasBusinessCenter(attrsMap.get("HasBusinessCenter"));
                hotel.setHasRestaurant(attrsMap.get("HasRestaurant"));
                if(attrsMap.get("hotelStars")!=null)
                    hotel.setHotelStars(Long.valueOf(attrsMap.get("hotelStars")));
                hotel.setBpoint(attrsMap.get("bpoint"));
                hotel.setGpoint(attrsMap.get("gpoint"));
                hotel.setPhoneNumber(attrsMap.get("phoneNumber"));
                hotel.setHotelBrand(attrsMap.get("hotelBrand"));
                hotel.setTradingArea(attrsMap.get("tradingArea"));
                hotel.setIsWebFree(attrsMap.get("isWebFree"));
                hotel.setDangCi(attrsMap.get("dangci"));
                hotel.setHotelName(attrsMap.get("hotelName"));
                hotel.setHotelAddress(attrsMap.get("hotelAddress"));
                hotel.setImageId(attrsMap.get("imageID"));
                hotel.setHasMeetingOrBanquetSpace(attrsMap.get("HasMeetingORBanquetSpace"));
                hotel.setHasIndoorPool(attrsMap.get("HasIndoorPool"));
                hotel.setHasNonSmokingAvailable(attrsMap.get("HasNonSmokingAvailable"));
                hotel.setOneSentence(attrsMap.get("oneSentence"));
                hotel.setHotelArea(attrsMap.get("CommentCount"));
                hotel.setShortName(attrsMap.get("shortName"));
            }
            HotelExample hotelExample = new HotelExample();
            hotelExample.createCriteria().andSourceIdEqualTo(hotel.getSourceId());
            List<Hotel> checkHotelExist=hotelService.selectByExample(hotelExample);
            if(CollectionUtils.isEmpty(checkHotelExist)){
                hotel.setCreateTime(new Date());
                hotelService.insert(hotel);
                logger.info("====================insert t_es_hotel values(source_id={},hotelName={})===================="
                        ,hotel.getSourceId(),hotel.getHotelName());
            }else {
                Hotel existHotel=checkHotelExist.get(0);
                hotel.setId(existHotel.getId());
                hotel.setUpdateTime(new Date());
                hotelService.updateByPrimaryKeySelective(hotel);
                logger.info("====================update t_es_hotel values(source_id={},hotelName={})===================="
                        ,hotel.getSourceId(),hotel.getHotelName());
            }

        }
    }
    public Map<String,String> getJsonList(String value){
        Map<String,String> resultMap=new HashMap<String,String>();
        try {
            resultMap=JsonUtils.jsonToMap(value);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return resultMap;
    }
}
