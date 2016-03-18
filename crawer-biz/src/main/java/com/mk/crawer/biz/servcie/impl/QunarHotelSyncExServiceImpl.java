package com.mk.crawer.biz.servcie.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.biz.model.crawer.*;
import com.mk.crawer.biz.servcie.BrandsService;
import com.mk.crawer.biz.servcie.ICityListService;
import com.mk.crawer.biz.servcie.QunarHotelService;
import com.mk.crawer.biz.servcie.QunarHotelSyncExService;
import com.mk.crawer.biz.utils.Constant;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.JsonUtils;
import com.mk.framework.proxy.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kangxiaolong on 2016-01-06.
 */
@Service
public class QunarHotelSyncExServiceImpl implements QunarHotelSyncExService {
    private static Logger logger = LoggerFactory.getLogger(QunarHotelSyncExServiceImpl.class);
    @Autowired
    private ICityListService cityListService ;
    @Autowired
    private QunarHotelService qunarHotelService ;
    @Autowired
    private BrandsService brandsService ;
    public Map<String,Object> hotelSyncExByCity(CityList bean){
        Cat.logEvent("hotelSyncExByCity", "去哪儿酒店信息扩展信息同步", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime()
        );
        logger.info("====================hotelSyncExByCity beginTime={}====================",DateUtils.getDatetime());
        Map<String,Object> resultMap=new HashMap<String,Object>();
        CityListExample cityListExample=new CityListExample();
        if (!StringUtils.isEmpty(bean.getCityUrl())) {
            cityListExample.createCriteria().andCityUrlEqualTo(bean.getCityUrl());
            logger.info("====================hotelSyncExByCity hotelSyncExByCity cityUrl={}====================",bean.getCityUrl());
        }else if (!StringUtils.isEmpty(bean.getCityName())){
            cityListExample.createCriteria().andCityNameEqualTo(bean.getCityName());
            logger.info("====================cityName={}====================",bean.getCityName());
        }
        List<CityList> cityLists=cityListService.selectByExample(cityListExample);
        if (CollectionUtils.isEmpty(cityLists)){
            logger.info("==================== cityLists  is empty====================");
            resultMap.put("message","cityList is empty");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        CityList city=cityLists.get(0);
        resultMap=doSync(city);
        Cat.logEvent("hotelSyncExByCity", "去哪儿酒店信息扩展信息同步", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info("====================hotelSyncExByCity endTime={}====================",DateUtils.getDatetime());
        return resultMap;
    }
    public Map<String,Object> qunarHotelSyncEx(){
        Cat.logEvent("qunarHotelSyncEx", "去哪儿酒店信息扩展信息同步", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime()
        );
        logger.info("====================qunarHotelSyncEx beginTime={}====================",DateUtils.getDatetime());
        Map<String,Object> resultMap=new HashMap<String,Object>();
        CityListExample cityListExample=new CityListExample();
        cityListExample.createCriteria().andCityTypeEqualTo("-1");
        List<CityList> cityLists=cityListService.selectByExample(cityListExample);
        if (CollectionUtils.isEmpty(cityLists)){
            resultMap.put("message","cityList is empty");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        for (CityList city:cityLists) {
            doSync(city);
        }
        Cat.logEvent("qunarHotelSyncEx", "去哪儿酒店信息扩展信息同步", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info("====================qunarHotelSync method endTime={}===================="
                , DateUtils.getDatetime());
        resultMap.put("message","执行结束");
        resultMap.put("SUCCESS", true);
        return resultMap;
    }
    public Map<String,Object> doSync(CityList city){

        Map<String,Object> resultMap=new HashMap<String,Object>();
        String fromDate=DateUtils.getCertainDate(1);
        String toDate=DateUtils.getCertainDate(2);
        String url=Constant.qunar_touch_hostlist+"?city="+city.getCityName()+"&fromDate="+fromDate+"&toDate="+toDate;
        logger.info(String.format("\n========{}=========\n"),url);
        String hotelResult=HttpUtil.doGetNoProxy(url);
//        try{
//            hotelResult= URLEncoder.encode(hotelResult, "GBK");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        Map<String,String> urlMaps=getJsonList(hotelResult);
        if(urlMaps==null){
            logger.info("\n==========hotelResult={}============\n",hotelResult);
            logger.info("====================qunarHotelSyncEx city={}  continue because url reslut is null====================",city.getCityName());
            resultMap.put("message","urlMaps is null");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }

        String info=urlMaps.get("info");
        String hotels =urlMaps.get("hotels");
        if(info==null||hotels==null){
            Cat.logEvent("qunarHotelSyncEx", "去哪儿酒店信息扩展信息同步", Event.SUCCESS,
                    "info is null || hotels is null");
            logger.info("====================qunarHotelSyncEx method end because info is null || hotels is null====================");
            resultMap.put("message","info is null || hotels is nul");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        Map<String,String> infoMap=getJsonList(info);
        if (infoMap==null){
            logger.info("====================qunarHotelSyncEx method end because infoMap is null====================");
            resultMap.put("message","infoMap");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        if(infoMap.get("brands")!=null){
            saveBrands(city,infoMap.get("brands"));
        }
        saveHotel(hotels,city.getCityName());


        resultMap.put("message","保存成功");
        resultMap.put("SUCCESS", true);

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
    public void saveHotel(String hotelStr, String cityName){
        List<Object> hotelList=JsonUtils.jsonToList(hotelStr);
        for(int i=0;i<hotelList.size();i++){
            try {
                Map<String,String> hotelMap=JsonUtils.jsonToMap(hotelList.get(i).toString());
                if(hotelMap==null){
                    logger.info("====================hotelMap is null====================");
                    continue;
                }
                QunarHotel hotel=new QunarHotel();
                hotel.setCityName(cityName);
                hotel.setSourceId(hotelMap.get("id"));

                if (hotelMap.get("distance")!=null)
                    hotel.setDistance(hotelMap.get("distance"));
                if (hotelMap.get("attrs")!=null){
                    Map<String,String> attrsMap=JsonUtils.jsonToMap(hotelMap.get("attrs"));
                    if (attrsMap==null){
                        logger.info("====================attrsMap is null====================");
                        continue;
                    }

                    hotel.setBpoint(attrsMap.get("bpoint"));
                    hotel.setPhoneNumber(attrsMap.get("phoneNumber"));
                    //hotel.setHotelBrand(attrsMap.get("hotelBrand"));
                    //hotel.setShortName(attrsMap.get("shortName"));
                    //hotel.setOneSentence(attrsMap.get("oneSentence"));

                }
                QunarHotelExample hotelExample = new QunarHotelExample();
                hotelExample.createCriteria().andSourceIdEqualTo(hotel.getSourceId());
                List<QunarHotel> checkHotelExist=qunarHotelService.selectByExample(hotelExample);
                if(!CollectionUtils.isEmpty(checkHotelExist)){
                    QunarHotel existHotel=checkHotelExist.get(0);
                    hotel.setId(existHotel.getId());
                    hotel.setUpdateTime(new Date());
                    System.out.println("====================================update hotel="+ existHotel.getId() +"&phone=" + hotel.getPhoneNumber());
                    if (StringUtils.isEmpty(existHotel.getPhoneNumber())) {
                        qunarHotelService.updateByPrimaryKeySelective(hotel);
                    }else {
                        logger.info("====================phone is exist continue====================",hotel.getSourceId());
                    }
                    logger.info("====================update t_qunar_hotel values(source_id={})===================="
                            ,hotel.getSourceId());
                }

            }catch (Exception e){
                e.printStackTrace();
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
