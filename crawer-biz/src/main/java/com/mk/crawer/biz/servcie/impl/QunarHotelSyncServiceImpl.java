package com.mk.crawer.biz.servcie.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.api.QunarHotelSyncService;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.JsonUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by kangxiaolong on 2016-01-06.
 */
@Service
public class QunarHotelSyncServiceImpl implements QunarHotelSyncService {
    private static Logger logger = LoggerFactory.getLogger(QunarHotelSyncServiceImpl.class);

    public Map<String,Object> qunarHotelSync(){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        String hotelResult="{" +
                "\"info\": {" +
                "\"cityurl\": \"zhongwei\"," +
                "\"cityName\": \"中卫\"," +
                "\"count\": 483," +
                "\"fromDate\": \"2016-01-05\"," +
                "\"toDate\": \"2016-01-06\"," +
                "\"key\": \"\"," +
                "\"brands\": {" +
                "\"速8\": {" +
                "\"name\": \"速8\"," +
                "\"count\": 2," +
                "\"group\": \"经济型\"," +
                "\"logo\": \"https://source.qunarzz.com//site/images/brandlogo/square50/su8_0.png\"" +
                "}" +
                "}" +
                "}," +
                "\"hotels\": [" +
                "{" +
                "\"id\": \"zhongwei_133\"," +
                "\"cityName\": \"\"," +
                "\"distance\": 0," +
                "\"price\": 262," +
                "\"attrs\": {" +
                "\"hasBreakfast\": \"Y\"," +
                "\"imageCount\": \"0\"," +
                "\"HasFitnessRoom\": \"\"," +
                "\"CommentScore\": \"4.3\"," +
                "\"HasBusinessCenter\": \"N\"," +
                "\"HasRestaurant\": \"Y\"," +
                "\"hotelStars\": \"0\"," +
                "\"bpoint\": \"37.511486,105.201036\"," +
                "\"gpoint\": \"37.50572,105.19446\"," +
                "\"phoneNumber\": \"0955-3989666\"," +
                "\"hotelBrand\": \"\"," +
                "\"tradingArea\": \"中卫站\"," +
                "\"isWebFree\": \"Y\"," +
                "\"dangci\": \"4\"," +
                "\"hotelName\": \"宁夏雷迪森国际饭店\"," +
                "\"hotelAddress\": \"宁夏中卫市沙坡头区文昌南街文化广场东侧\"," +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201312/18/Z7-ECT9tOOuXj-h3Z76.jpg\"," +
                "\"HasMeetingORBanquetSpace\": \"Y\"," +
                "\"HasIndoorPool\": \"N\"," +
                "\"HasNonSmokingAvailable\": \"N\"," +
                "\"oneSentence\": \"\"," +
                "\"CommentCount\": \"156\"," +
                "\"hotelArea\": \"\"," +
                "\"shortName\": \"\"" +
                "}" +
                "}," +
                "{" +
                "\"id\": \"zhongwei_12\"," +
                "\"cityName\": \"\"," +
                "\"distance\": 0," +
                "\"price\": 120," +
                "\"attrs\": {" +
                "\"hasBreakfast\": \"\"," +
                "\"imageCount\": \"0\"," +
                "\"HasFitnessRoom\": \"\"," +
                "\"CommentScore\": \"4.5\"," +
                "\"HasBusinessCenter\": \"Y\"," +
                "\"HasRestaurant\": \"Y\"," +
                "\"hotelStars\": \"4\"," +
                "\"bpoint\": \"37.521341341084,105.19712044138\"," +
                "\"gpoint\": \"37.515614,105.19054\"," +
                "\"phoneNumber\": \"0955-7017666\"," +
                "\"hotelBrand\": \"\"," +
                "\"tradingArea\": \"中卫站\"," +
                "\"isWebFree\": \"Y\"," +
                "\"dangci\": \"3\"," +
                "\"hotelName\": \"中卫逸兴大酒店\"," +
                "\"hotelAddress\": \"中卫市沙坡头区鼓楼北街2号\"," +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201211/22/Z7-ECTZ2D4VZaNtXZ76.jpg\"," +
                "\"HasMeetingORBanquetSpace\": \"Y\"," +
                "\"HasIndoorPool\": \"\"," +
                "\"HasNonSmokingAvailable\": \"\"," +
                "\"oneSentence\": \"地处中卫市鼓楼东街与鼓楼北街交汇处，步行可至中卫火车站、高庙。\"," +
                "\"CommentCount\": \"713\"," +
                "\"hotelArea\": \"\"," +
                "\"shortName\": \"\"" +
                "}" +
                "}," +
                "{" +
                "\"id\": \"zhongwei_202\"," +
                "\"cityName\": \"\"," +
                "\"distance\": 0," +
                "\"price\": 322," +
                "\"attrs\": {" +
                "\"hasBreakfast\": \"Y\"," +
                "\"imageCount\": \"0\"," +
                "\"HasFitnessRoom\": \"Y\"," +
                "\"CommentScore\": \"4.6\"," +
                "\"HasBusinessCenter\": \"Y\"," +
                "\"HasRestaurant\": \"Y\"," +
                "\"hotelStars\": \"0\"," +
                "\"bpoint\": \"37.520997,105.211203\"," +
                "\"gpoint\": \"37.515087,105.20469\"," +
                "\"phoneNumber\": \"0955-7981111\"," +
                "\"hotelBrand\": \"\"," +
                "\"tradingArea\": \"中卫站\"," +
                "\"isWebFree\": \"Y\"," +
                "\"dangci\": \"4\"," +
                "\"hotelName\": \"中卫优派莱斯酒店\"," +
                "\"hotelAddress\": \"中卫市鼓楼东街创业城C20号\"," +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201407/18/KEO2vOK7Ru-cfxhLy76.jpg\"," +
                "\"HasMeetingORBanquetSpace\": \"Y\"," +
                "\"HasIndoorPool\": \"\"," +
                "\"HasNonSmokingAvailable\": \"N\"," +
                "\"oneSentence\": \"\"," +
                "\"CommentCount\": \"226\"," +
                "\"hotelArea\": \"\"," +
                "\"shortName\": \"\"" +
                "}" +
                "}," +
                "{" +
                "\"id\": \"zhongwei_113\"," +
                "\"cityName\": \"\"," +
                "\"distance\": 0," +
                "\"price\": 230," +
                "\"attrs\": {" +
                "\"hasBreakfast\": \"Y\"," +
                "\"imageCount\": \"0\"," +
                "\"HasFitnessRoom\": \"Y\"," +
                "\"CommentScore\": \"4.5\"," +
                "\"HasBusinessCenter\": \"Y\"," +
                "\"HasRestaurant\": \"Y\"," +
                "\"hotelStars\": \"0\"," +
                "\"bpoint\": \"37.521669,105.217102\"," +
                "\"gpoint\": \"37.515663,105.21062\"," +
                "\"phoneNumber\": \"0955-7608888\"," +
                "\"hotelBrand\": \"\"," +
                "\"tradingArea\": \"中卫站\"," +
                "\"isWebFree\": \"Y\"," +
                "\"dangci\": \"3\"," +
                "\"hotelName\": \"中卫中博大饭店\"," +
                "\"hotelAddress\": \"宁夏中卫市鼓楼东街与文萃南路交汇处\"," +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201307/30/JhS1_thT2XKDP6KxJ76.jpg\"," +
                "\"HasMeetingORBanquetSpace\": \"Y\"," +
                "\"HasIndoorPool\": \"Y\"," +
                "\"HasNonSmokingAvailable\": \"Y\"," +
                "\"oneSentence\": \"\"," +
                "\"CommentCount\": \"204\"," +
                "\"hotelArea\": \"\"," +
                "\"shortName\": \"\"" +
                "}" +
                "}," +
                "{" +
                "\"id\": \"zhongwei_97\"," +
                "\"cityName\": \"\"," +
                "\"distance\": 0," +
                "\"price\": 108," +
                "\"attrs\": {" +
                "\"hasBreakfast\": \"N\"," +
                "\"imageCount\": \"0\"," +
                "\"HasFitnessRoom\": \"N\"," +
                "\"CommentScore\": \"4.5\"," +
                "\"HasBusinessCenter\": \"Y\"," +
                "\"HasRestaurant\": \"Y\"," +
                "\"hotelStars\": \"0\"," +
                "\"bpoint\": \"37.519368761466,105.20540672929\"," +
                "\"gpoint\": \"37.513546,105.19886\"," +
                "\"phoneNumber\": \"0955-7064666\"," +
                "\"hotelBrand\": \"\"," +
                "\"tradingArea\": \"中卫站\"," +
                "\"isWebFree\": \"Y\"," +
                "\"dangci\": \"3\"," +
                "\"hotelName\": \"天和时尚酒店\"," +
                "\"hotelAddress\": \"宁夏中卫市沙坡头区鼓楼东街蔡桥路向南100米\"," +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201303/24/JhS1_tJBh70uP3U7J76.jpg\"," +
                "\"HasMeetingORBanquetSpace\": \"Y\"," +
                "\"HasIndoorPool\": \"N\"," +
                "\"HasNonSmokingAvailable\": \"N\"," +
                "\"oneSentence\": \"\"," +
                "\"CommentCount\": \"575\"," +
                "\"hotelArea\": \"\"," +
                "\"shortName\": \"\"" +
                "}" +
                "}]" +
                "}";
        Map<String,String> urlMaps=JsonUtils.jsonToMap(hotelResult);
        if(urlMaps==null){
            resultMap.put("message","解析url 结果为null");
            resultMap.put("SUCCESS", false);
            Cat.logEvent("qunarHotelSync", "去哪儿酒店信息同步", Event.SUCCESS,
                    "endTime=" + DateUtils.format_yMdHms(new Date())
            );
            logger.info("====================qunarHotelSync method end because url reslut is null====================");
            return resultMap;
        }
        String info=urlMaps.get("info");
        String hotels =urlMaps.get("hotels");
        if(info==null||hotels==null){
            resultMap.put("message","info is null || hotels is null");
            resultMap.put("SUCCESS", false);
            Cat.logEvent("qunarHotelSync", "去哪儿酒店信息同步", Event.SUCCESS,
                    "info is null || hotels is nul=");
            logger.info("====================qunarHotelSync method end because info is null || hotels is null====================");
            return resultMap;
        }
        Map<String,String> infoMap=JsonUtils.jsonToMap(info);
        List<Object> hotelList=JsonUtils.jsonToList(hotels);
        for(int i=0;i<hotelList.size();i++){
            Map<String,String> hotelMap=JsonUtils.jsonToMap(hotelList.get(i).toString());

        }
        resultMap.put("message","备份成功");
        resultMap.put("SUCCESS", true);
        resultMap.put("Data", infoMap);
        resultMap.put("Data1", hotelList);
        Cat.logEvent("doPriceDump", "去哪儿酒店信息同步", Event.SUCCESS,
                "endTime=" + DateUtils.format_yMdHms(new Date())
        );
        logger.info("====================doPriceDump method end time{}===================="
                , DateUtils.format_yMdHms(new Date()));
        return resultMap;
    }
}
