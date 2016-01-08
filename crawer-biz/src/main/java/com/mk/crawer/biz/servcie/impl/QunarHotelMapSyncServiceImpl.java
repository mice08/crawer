package com.mk.crawer.biz.servcie.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.api.QunarHotelSyncService;
import com.mk.crawer.biz.model.crawer.*;
import com.mk.crawer.biz.servcie.*;
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

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kangxiaolong on 2016-01-08.
 */
@Service
public class QunarHotelMapSyncServiceImpl implements QunarHotelMapSyncService {
    private static Logger logger = LoggerFactory.getLogger(QunarHotelMapSyncServiceImpl.class);
    @Autowired
    private ICityListService cityListService ;
    @Autowired
    private QunarHotelService qunarHotelService;

    public Map<String,Object> hotelMapSyncByCity(String cityName){
        Cat.logEvent("hotelMapSyncByCity", "去哪儿酒店信息同步", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime()
        );
        logger.info("====================hotelMapSyncByCity beginTime={}====================",DateUtils.getDatetime());
        Map<String,Object> resultMap=new HashMap<String,Object>();
        CityListExample cityListExample=new CityListExample();
        cityListExample.createCriteria().andCityNameEqualTo(cityName);
        List<CityList> cityLists=cityListService.selectByExample(cityListExample);
        if (CollectionUtils.isEmpty(cityLists)){
            logger.info("====================hotelMapSyncByCity cityLists because is empty====================");
            resultMap.put("message","cityList is empty");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        CityList city=cityLists.get(0);
        resultMap=doSync(city);
        Cat.logEvent("hotelMapSyncByCity", "去哪儿酒店信息同步", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info("====================hotelMapSyncByCity endTime={}====================",DateUtils.getDatetime());
        return resultMap;
    }
    public Map<String,Object> qunarHotelMapSync(){
        Cat.logEvent("qunarHotelMapSync", "去哪儿酒店信息同步", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime()
        );
        logger.info("====================qunarHotelMapSync beginTime={}====================",DateUtils.getDatetime());
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
        Cat.logEvent("qunarHotelMapSync", "去哪儿酒店信息同步", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info("====================qunarHotelMapSync method endTime={}===================="
                , DateUtils.getDatetime());
        resultMap.put("message","执行结束");
        resultMap.put("SUCCESS", true);
        return resultMap;
    }
    public Map<String,Object> doSync(CityList city){
        Map<String,Object> resultMap=new HashMap<String,Object>();

        int start=0;
        int len=100;
        String hotelResult=getRemoteDate(city.getCityName(),start,len);
        if(hotelResult==null){
            logger.info("====================hotelResult city={}  continue because url reslut is null====================",city.getCityName());
            resultMap.put("message","hotelResult is null");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        Map<String,String> urlMaps=getJsonList(hotelResult);
        if(urlMaps==null){
            logger.info("====================city={}  continue because urlMaps reslut is null====================",city.getCityName());
            resultMap.put("message","urlMaps is noll");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }

        String data=urlMaps.get("data");
        if(data==null){
            Cat.logEvent("qunarHotelMapSync", "去哪儿酒店信息同步", Event.SUCCESS,
                    "data=null&city="+city.getCityName());
            logger.info("====================qunarHotelMapSync city={} end because data is null====================",city.getCityName());
            resultMap.put("message","data is null");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        Map<String,String> dataMaps=getJsonList(data);
        if(dataMaps==null){
            logger.info("====================city={}  continue because dataMaps reslut is null====================",city.getCityName());
            resultMap.put("message","dataMaps is noll");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        String info=dataMaps.get("info");
        String hotels = dataMaps.get("hotels");
        if(info==null||hotels==null){
            Cat.logEvent("qunarHotelMapSync", "去哪儿酒店信息同步", Event.SUCCESS,
                    "city="+city.getCityName()+"info=null&hotels=null");
            logger.info("====================qunarHotelMapSync city={} end because info is null || hotels is null====================",city.getCityName());
            resultMap.put("message","info is null || hotels is nul");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        Map<String,String> infoMap=getJsonList(info);
        if (infoMap==null){
            logger.info("====================qunarHotelMapSync city={} end because infoMap is null====================",city.getCityName());
            resultMap.put("message","infoMap is null");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        if(StringUtils.isEmpty(city.getCityUrl())||infoMap.get("cityurl")!=null){
            city.setCityUrl(infoMap.get("cityurl"));
            cityListService.updateByPrimaryKeySelective(city);
        }
        if (infoMap.get("count")==null){
            logger.info("==================== city={} count is null====================",city.getCityName());
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        saveQunarHotel(hotels,city.getCityName());
        int count=Integer.valueOf(infoMap.get("count"));
        if (count>len){
            for (int i=1;i<=count/len;i++){
                hotelResult=getRemoteDate(city.getCityName(),i*len,len);
                if (hotelResult==null){
                    continue;
                }
                String hotelsJson=getMapHotelStr(hotelResult);
                if(hotelsJson==null){
                    continue;
                }
                saveQunarHotel(hotelsJson,city.getCityName());

            }
        }

        resultMap.put("message","保存成功");
        resultMap.put("SUCCESS", true);

        return resultMap;
    }
    private String getMapHotelStr(String json){
        if(json==null){
            logger.info("json == null return");
            return null;
        }
        Map<String,String> urlMaps=getJsonList(json);
        if(urlMaps==null){
            logger.info("urlMaps == null return");
            return null;
        }
        String data=urlMaps.get("data");
        if(data==null){
            logger.info("data == null return");
            return null;
        }
        Map<String,String> dataMaps=getJsonList(data);
        if(dataMaps==null){
            logger.info("dataMaps == null return");
            return null;
        }
        String hotels =urlMaps.get("hotels");
        if(hotels==null){
            logger.info("hotes == null return");
            return null;
        }
        return hotels;

    }
    private void saveQunarHotel(String hotelStr, String cityName){
        if (hotelStr==null){
            return;
        }
        List<Object> hotelList=JsonUtils.jsonToList(hotelStr);
        for(int i=0;i<hotelList.size();i++){
            Map<String,String> hotelMap=JsonUtils.jsonToMap(hotelList.get(i).toString());
            if(hotelMap==null){
                logger.info("====================hotelMap is null====================");
                continue;
            }
            QunarHotel qunarHotel=new QunarHotel();
            qunarHotel.setIsLmFullRoom(getBoolean(hotelMap.get("isLMFullRoom")));
            qunarHotel.setDistance(hotelMap.get("distance"));
            qunarHotel.setSpecialPriceBit(getInteger(hotelMap.get("specialPriceBit")));
            qunarHotel.setHasFiveFtarHongbao(getBoolean(hotelMap.get("hasFiveStarHongbao")));
            qunarHotel.setHasSigninRed(getBoolean(hotelMap.get("hasSignInRed")));
            qunarHotel.setShowRedPack(getBoolean(hotelMap.get("showRedPack")));
            qunarHotel.setWapInfo(getInteger(hotelMap.get("wapInfo")));
            qunarHotel.setHourResultInfo(getInteger(hotelMap.get("hourResultInfo")));
            qunarHotel.setWapType(getInteger(hotelMap.get("wapType")));
            qunarHotel.setHasBnbHongbao(getBoolean(hotelMap.get("hasBNBHongbao")));
            qunarHotel.setHasBnb9Hongbao(getBoolean(hotelMap.get("hasBNB9Hongbao")));
            qunarHotel.setPpcimgUrl(hotelMap.get("ppcImgUrl"));
            qunarHotel.setJpM(getInteger(hotelMap.get("jpM")));
            qunarHotel.setCorrDist(hotelMap.get("corrDist"));
            qunarHotel.setIsLm(getInteger(hotelMap.get("isLM")));
            qunarHotel.setLmPrice(hotelMap.get("lmPrice"));
            qunarHotel.setLmOldPrice(hotelMap.get("lmOldPrice"));
            qunarHotel.setLmFullRoom(getBoolean(hotelMap.get("lmFullRoom")));
            qunarHotel.setAvgPrice(hotelMap.get("avgPrice"));
            qunarHotel.setHasGroupBuy(getBoolean(hotelMap.get("hasGroupBuy")));
            qunarHotel.setHasTeHui(getBoolean(hotelMap.get("hasTeHui")));
            qunarHotel.setHasDay7(getBoolean(hotelMap.get("hasDay7")));
            qunarHotel.setHasChainPrice(getBoolean(hotelMap.get("hasChainPrice")));
            qunarHotel.setSupportHongBao(getBoolean(hotelMap.get("supportHongBao")));
            qunarHotel.setHasExclusive(getBoolean(hotelMap.get("hasExclusive")));
            qunarHotel.setHasGift(getBoolean(hotelMap.get("hasGift")));
            qunarHotel.setHasDay7Crash(getBoolean(hotelMap.get("hasDay7Crash")));
            qunarHotel.setHasQuick(getBoolean(hotelMap.get("hasQuick")));
            qunarHotel.setHasFiveStarDacu(getBoolean(hotelMap.get("hasFiveStarDacu")));
            qunarHotel.setHasDistancePreference(getBoolean(hotelMap.get("hasDistancePreference")));
            qunarHotel.setLmLowestPrice(getBoolean(hotelMap.get("lmLowestPrice")));
            qunarHotel.setHasFiveDiscount(getBoolean(hotelMap.get("hasFiveDiscount")));
            qunarHotel.setShowCanUserGold(getBoolean(hotelMap.get("showCanUserGold")));
            qunarHotel.setShowRetureGold(getBoolean(hotelMap.get("showRetureGold")));
            qunarHotel.setBundlingRate(getInteger(hotelMap.get("bundlingRate")));
            qunarHotel.setTimeLimitPrice(getBigDecimal(hotelMap.get("timeLimitPrice")));
            qunarHotel.setTopList(getInteger(hotelMap.get("topList")));
            qunarHotel.setRecommendDesc(hotelMap.get("recommendDesc"));
            qunarHotel.setHotelLabel(hotelMap.get("hotelLabel"));
            qunarHotel.setQualityLabelList(hotelMap.get("qualityLabelList"));
            qunarHotel.setPackOperateType(getInteger(hotelMap.get("packOperateType")));
            qunarHotel.setBrowseMonth(getInteger(hotelMap.get("browseMonth")));
            qunarHotel.setSpecialRec(getInteger(hotelMap.get("specialRec")));
            qunarHotel.setHourRoomRecLm(getBoolean(hotelMap.get("hourRoomRecLm")));
            qunarHotel.setCityName(cityName);
            qunarHotel.setRankInfo(hotelMap.get("rankInfo"));
            qunarHotel.setLogicBit(hotelMap.get("logicBit"));
            qunarHotel.setMobilePrice(getBigDecimal(hotelMap.get("mobilePrice")));
            qunarHotel.setMobileRoomStatus(getInteger(hotelMap.get("mobileRoomStatus")));
            qunarHotel.setActivity(hotelMap.get("activity"));
            qunarHotel.setPrice(getBigDecimal(hotelMap.get("price")));
            qunarHotel.setDiscount(getBigDecimal(hotelMap.get("discount")));
            qunarHotel.setTagName(hotelMap.get("tagName"));
            qunarHotel.setSourceId(hotelMap.get("id"));

            if (hotelMap.get("attrs")!=null){
                Map<String,String> attrsMap=JsonUtils.jsonToMap(hotelMap.get("attrs"));
                if (attrsMap==null){
                    logger.info("====================attrsMap is null====================");
                    continue;
                }
                qunarHotel.setWhenBuilt(attrsMap.get("WhenBuilt"));
                qunarHotel.setCommentScore(getBigDecimal(attrsMap.get("CommentScore")));
                qunarHotel.setCommentCount(getInteger(attrsMap.get("CommentCount")));
                qunarHotel.setHotelArea(attrsMap.get("HotelArea"));
                qunarHotel.setPolicyInfo(attrsMap.get("PolicyInfo"));
                qunarHotel.setMiniRetailPrice(getBigDecimal(attrsMap.get("MiniRetailPrice")));
                qunarHotel.setHasInternetAccess(attrsMap.get("HasInternetAccess"));
                qunarHotel.setWifiAccess(attrsMap.get("WifiAccess"));
                qunarHotel.setTradingArea(attrsMap.get("tradingArea"));
                qunarHotel.setImageId(attrsMap.get("imageID"));
                qunarHotel.setWhenFitment(attrsMap.get("whenFitment"));
                qunarHotel.setNearAddress(attrsMap.get("nearAddress"));
                qunarHotel.setIsLp(attrsMap.get("isLp"));
                qunarHotel.setIsTop500(attrsMap.get("isTop500"));
                qunarHotel.setIsCwt(attrsMap.get("isCwt"));
                qunarHotel.setTheme(attrsMap.get("theme"));
                qunarHotel.setHotelStars(getBigDecimal(attrsMap.get("hotelStars")));
                qunarHotel.setIsWebFree(attrsMap.get("isWebFree"));
                qunarHotel.setDangci(getInteger(attrsMap.get("dangci")));
                qunarHotel.setHasWifiinRoom(getInteger(attrsMap.get("hasWifiInRoom")));
                qunarHotel.setHasParkingArea2(getInteger(attrsMap.get("hasParkingArea2")));
                qunarHotel.setHotelName(attrsMap.get("hotelName"));
                qunarHotel.setHotelAddress(attrsMap.get("hotelAddress"));
                qunarHotel.setGpoint(attrsMap.get("gpoint"));

            }
            QunarHotelExample hotelExample = new QunarHotelExample();
            hotelExample.createCriteria().andSourceIdEqualTo(qunarHotel.getSourceId());
            List<QunarHotel> checkHotelExist= qunarHotelService.selectByExample(hotelExample);
            if(CollectionUtils.isEmpty(checkHotelExist)){
                qunarHotel.setCreateTime(new Date());
                qunarHotelService.insert(qunarHotel);
                logger.info("====================insert t_qunar_hotel values(source_id={},hotelName={})===================="
                        ,qunarHotel.getSourceId(),qunarHotel.getHotelName());
            }else {
                QunarHotel existHotel=checkHotelExist.get(0);
                qunarHotel.setId(existHotel.getId());
                qunarHotel.setUpdateTime(new Date());
                qunarHotelService.updateByPrimaryKeySelective(qunarHotel);
                logger.info("====================update t_qunar_hotel values(source_id={},hotelName={})===================="
                        ,qunarHotel.getSourceId(),qunarHotel.getHotelName());
            }

        }
    }
    private  String getBoolean(String value){
        if ("true".equals(value)){
            return "1";
        }else{
            return "0";
        }
    }
    private  Integer getInteger(String value){
        if (value==null){
            return null;
        }else{
            try {
                return Integer.valueOf(value);
            }catch (Exception e){
                return null;
            }
        }
    }
    private  BigDecimal getBigDecimal(String value){
        if (value==null){
            return null;
        }else{
            try {
                return new BigDecimal(value);
            }catch (Exception e){
                return null;
            }
        }
    }
    public String getRemoteDate(String city,int start,int len){
        String tpl="hotel.hotelListTpl";
        String fromDate=DateUtils.getCertainDate(1);
        String toDate=DateUtils.getCertainDate(2);
        String pramas="city="+city+
                "&fromDate="+fromDate+"&toDate="+toDate
                +"&start="+start
                +"&len="+len
                +"&tpl="+tpl;
        String url=Constant.qunar_map_hostlist+"?"+pramas;
        return HttpUtil.doGet(url);
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
