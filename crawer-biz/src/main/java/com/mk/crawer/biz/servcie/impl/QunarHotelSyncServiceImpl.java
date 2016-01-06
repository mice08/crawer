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
 * Created by kirinli on 15/9/9.
 */
@Service
public class QunarHotelSyncServiceImpl implements QunarHotelSyncService {
    private static Logger logger = LoggerFactory.getLogger(QunarHotelSyncServiceImpl.class);

    public Map<String,Object> qunarHotelSync(){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        String hotelResult="{\n" +
                "\"info\": {\n" +
                "\"cityurl\": \"zhongwei\",\n" +
                "\"cityName\": \"中卫\",\n" +
                "\"count\": 483,\n" +
                "\"fromDate\": \"2016-01-05\",\n" +
                "\"toDate\": \"2016-01-06\",\n" +
                "\"key\": \"\",\n" +
                "\"brands\": {\n" +
                "\"速8\": {\n" +
                "\"name\": \"速8\",\n" +
                "\"count\": 2,\n" +
                "\"group\": \"经济型\",\n" +
                "\"logo\": \"https://source.qunarzz.com//site/images/brandlogo/square50/su8_0.png\"\n" +
                "}\n" +
                "}\n" +
                "},\n" +
                "\"hotels\": [\n" +
                "{\n" +
                "\"id\": \"zhongwei_133\",\n" +
                "\"cityName\": \"\",\n" +
                "\"distance\": 0,\n" +
                "\"price\": 262,\n" +
                "\"attrs\": {\n" +
                "\"hasBreakfast\": \"Y\",\n" +
                "\"imageCount\": \"0\",\n" +
                "\"HasFitnessRoom\": \"\",\n" +
                "\"CommentScore\": \"4.3\",\n" +
                "\"HasBusinessCenter\": \"N\",\n" +
                "\"HasRestaurant\": \"Y\",\n" +
                "\"hotelStars\": \"0\",\n" +
                "\"bpoint\": \"37.511486,105.201036\",\n" +
                "\"gpoint\": \"37.50572,105.19446\",\n" +
                "\"phoneNumber\": \"0955-3989666\",\n" +
                "\"hotelBrand\": \"\",\n" +
                "\"tradingArea\": \"中卫站\",\n" +
                "\"isWebFree\": \"Y\",\n" +
                "\"dangci\": \"4\",\n" +
                "\"hotelName\": \"宁夏雷迪森国际饭店\",\n" +
                "\"hotelAddress\": \"宁夏中卫市沙坡头区文昌南街文化广场东侧\",\n" +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201312/18/Z7-ECT9tOOuXj-h3Z76.jpg\",\n" +
                "\"HasMeetingORBanquetSpace\": \"Y\",\n" +
                "\"HasIndoorPool\": \"N\",\n" +
                "\"HasNonSmokingAvailable\": \"N\",\n" +
                "\"oneSentence\": \"\",\n" +
                "\"CommentCount\": \"156\",\n" +
                "\"hotelArea\": \"\",\n" +
                "\"shortName\": \"\"\n" +
                "}\n" +
                "},\n" +
                "{\n" +
                "\"id\": \"zhongwei_12\",\n" +
                "\"cityName\": \"\",\n" +
                "\"distance\": 0,\n" +
                "\"price\": 120,\n" +
                "\"attrs\": {\n" +
                "\"hasBreakfast\": \"\",\n" +
                "\"imageCount\": \"0\",\n" +
                "\"HasFitnessRoom\": \"\",\n" +
                "\"CommentScore\": \"4.5\",\n" +
                "\"HasBusinessCenter\": \"Y\",\n" +
                "\"HasRestaurant\": \"Y\",\n" +
                "\"hotelStars\": \"4\",\n" +
                "\"bpoint\": \"37.521341341084,105.19712044138\",\n" +
                "\"gpoint\": \"37.515614,105.19054\",\n" +
                "\"phoneNumber\": \"0955-7017666\",\n" +
                "\"hotelBrand\": \"\",\n" +
                "\"tradingArea\": \"中卫站\",\n" +
                "\"isWebFree\": \"Y\",\n" +
                "\"dangci\": \"3\",\n" +
                "\"hotelName\": \"中卫逸兴大酒店\",\n" +
                "\"hotelAddress\": \"中卫市沙坡头区鼓楼北街2号\",\n" +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201211/22/Z7-ECTZ2D4VZaNtXZ76.jpg\",\n" +
                "\"HasMeetingORBanquetSpace\": \"Y\",\n" +
                "\"HasIndoorPool\": \"\",\n" +
                "\"HasNonSmokingAvailable\": \"\",\n" +
                "\"oneSentence\": \"地处中卫市鼓楼东街与鼓楼北街交汇处，步行可至中卫火车站、高庙。\",\n" +
                "\"CommentCount\": \"713\",\n" +
                "\"hotelArea\": \"\",\n" +
                "\"shortName\": \"\"\n" +
                "}\n" +
                "},\n" +
                "{\n" +
                "\"id\": \"zhongwei_202\",\n" +
                "\"cityName\": \"\",\n" +
                "\"distance\": 0,\n" +
                "\"price\": 322,\n" +
                "\"attrs\": {\n" +
                "\"hasBreakfast\": \"Y\",\n" +
                "\"imageCount\": \"0\",\n" +
                "\"HasFitnessRoom\": \"Y\",\n" +
                "\"CommentScore\": \"4.6\",\n" +
                "\"HasBusinessCenter\": \"Y\",\n" +
                "\"HasRestaurant\": \"Y\",\n" +
                "\"hotelStars\": \"0\",\n" +
                "\"bpoint\": \"37.520997,105.211203\",\n" +
                "\"gpoint\": \"37.515087,105.20469\",\n" +
                "\"phoneNumber\": \"0955-7981111\",\n" +
                "\"hotelBrand\": \"\",\n" +
                "\"tradingArea\": \"中卫站\",\n" +
                "\"isWebFree\": \"Y\",\n" +
                "\"dangci\": \"4\",\n" +
                "\"hotelName\": \"中卫优派莱斯酒店\",\n" +
                "\"hotelAddress\": \"中卫市鼓楼东街创业城C20号\",\n" +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201407/18/KEO2vOK7Ru-cfxhLy76.jpg\",\n" +
                "\"HasMeetingORBanquetSpace\": \"Y\",\n" +
                "\"HasIndoorPool\": \"\",\n" +
                "\"HasNonSmokingAvailable\": \"N\",\n" +
                "\"oneSentence\": \"\",\n" +
                "\"CommentCount\": \"226\",\n" +
                "\"hotelArea\": \"\",\n" +
                "\"shortName\": \"\"\n" +
                "}\n" +
                "},\n" +
                "{\n" +
                "\"id\": \"zhongwei_113\",\n" +
                "\"cityName\": \"\",\n" +
                "\"distance\": 0,\n" +
                "\"price\": 230,\n" +
                "\"attrs\": {\n" +
                "\"hasBreakfast\": \"Y\",\n" +
                "\"imageCount\": \"0\",\n" +
                "\"HasFitnessRoom\": \"Y\",\n" +
                "\"CommentScore\": \"4.5\",\n" +
                "\"HasBusinessCenter\": \"Y\",\n" +
                "\"HasRestaurant\": \"Y\",\n" +
                "\"hotelStars\": \"0\",\n" +
                "\"bpoint\": \"37.521669,105.217102\",\n" +
                "\"gpoint\": \"37.515663,105.21062\",\n" +
                "\"phoneNumber\": \"0955-7608888\",\n" +
                "\"hotelBrand\": \"\",\n" +
                "\"tradingArea\": \"中卫站\",\n" +
                "\"isWebFree\": \"Y\",\n" +
                "\"dangci\": \"3\",\n" +
                "\"hotelName\": \"中卫中博大饭店\",\n" +
                "\"hotelAddress\": \"宁夏中卫市鼓楼东街与文萃南路交汇处\",\n" +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201307/30/JhS1_thT2XKDP6KxJ76.jpg\",\n" +
                "\"HasMeetingORBanquetSpace\": \"Y\",\n" +
                "\"HasIndoorPool\": \"Y\",\n" +
                "\"HasNonSmokingAvailable\": \"Y\",\n" +
                "\"oneSentence\": \"\",\n" +
                "\"CommentCount\": \"204\",\n" +
                "\"hotelArea\": \"\",\n" +
                "\"shortName\": \"\"\n" +
                "}\n" +
                "},\n" +
                "{\n" +
                "\"id\": \"zhongwei_97\",\n" +
                "\"cityName\": \"\",\n" +
                "\"distance\": 0,\n" +
                "\"price\": 108,\n" +
                "\"attrs\": {\n" +
                "\"hasBreakfast\": \"N\",\n" +
                "\"imageCount\": \"0\",\n" +
                "\"HasFitnessRoom\": \"N\",\n" +
                "\"CommentScore\": \"4.5\",\n" +
                "\"HasBusinessCenter\": \"Y\",\n" +
                "\"HasRestaurant\": \"Y\",\n" +
                "\"hotelStars\": \"0\",\n" +
                "\"bpoint\": \"37.519368761466,105.20540672929\",\n" +
                "\"gpoint\": \"37.513546,105.19886\",\n" +
                "\"phoneNumber\": \"0955-7064666\",\n" +
                "\"hotelBrand\": \"\",\n" +
                "\"tradingArea\": \"中卫站\",\n" +
                "\"isWebFree\": \"Y\",\n" +
                "\"dangci\": \"3\",\n" +
                "\"hotelName\": \"天和时尚酒店\",\n" +
                "\"hotelAddress\": \"宁夏中卫市沙坡头区鼓楼东街蔡桥路向南100米\",\n" +
                "\"imageID\": \"https://userimg.qunarzz.com/imgs/201303/24/JhS1_tJBh70uP3U7J76.jpg\",\n" +
                "\"HasMeetingORBanquetSpace\": \"Y\",\n" +
                "\"HasIndoorPool\": \"N\",\n" +
                "\"HasNonSmokingAvailable\": \"N\",\n" +
                "\"oneSentence\": \"\",\n" +
                "\"CommentCount\": \"575\",\n" +
                "\"hotelArea\": \"\",\n" +
                "\"shortName\": \"\"\n" +
                "}\n" +
                "}" +
                "}";
        List<Object> urls= JsonUtils.jsonToList(hotelResult);
        List<String> urlStrings=new ArrayList<String>();
        for (Object url:urls) {
            if (url==null){
                continue;
            }
            Map<String,String> urlMaps=JsonUtils.jsonToMap(url.toString());
            for (String url1:urlMaps.keySet())
            {
                urlStrings.add(urlMaps.get(url1));
            }
        }
        resultMap.put("message","备份成功");
        resultMap.put("SUCCESS", true);
        resultMap.put("Data", urlStrings);
        Cat.logEvent("doPriceDump", "酒店价格备份", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info("====================doPriceDump method end time{}===================="
                , DateUtils.getDatetime());
        return resultMap;
    }
}
