package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.model.crawer.QunarHotelExample;
import com.mk.crawer.biz.servcie.QunarHotelService;
import com.mk.crawer.job.impl.HotelInfoRefreshThread;
import com.mk.framework.AppUtils;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import com.mk.framework.proxy.http.ProxyServerJob;
import com.mk.framework.proxy.http.RedisUtil;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 振涛 on 2016/1/7.
 */

@Controller
@RequestMapping(value = "/proxy-server-job")
public class ProxyServerJobController {

    private static final Logger LOGGER =  org.slf4j.LoggerFactory.getLogger(ProxyServerJobController.class);

    @RequestMapping(value = "/valid-and-remove")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> validAndRemove() {
        ProxyServerJob.validAndRemove();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/fetch-and-add")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> fetchAndAdd() {
        ProxyServerJob.fetchAndAdd();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/add-city-hotel")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addCityHotel(String city) {
        HashMap hm = new HashMap();

        if (StringUtils.isEmpty(city)) {
            hm.put("result", "没有指定城市");
            hm.put("success", false);
        } else {
            Jedis jedis = null;

            try {
                jedis = RedisUtil.getJedis();

                QunarHotelExample hotelExample = new QunarHotelExample();
                hotelExample.createCriteria().andCityNameEqualTo(city);

                QunarHotelService qunarHotelService = AppUtils.getBean(QunarHotelService.class);

                List<QunarHotel> hotelList = qunarHotelService.selectByExample(hotelExample);
                if (hotelList != null){
                    for (QunarHotel hotel : hotelList) {
                        HotelInfoRefreshThread hotelInfoRefreshThread = new HotelInfoRefreshThread();
                        hotelInfoRefreshThread.setHotelId(hotel.getSourceId());

                        String jsonStr = JSONUtil.toJson(hotelInfoRefreshThread);

                        jedis.sadd(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_THREAD_SET, jsonStr);

                        LOGGER.info("添加到价格刷新队列：{}", jsonStr);
                    }
                }

                hm.put("result", city+"的"+hotelList.size()+"家酒店添加到价格刷新队列");
                hm.put("success", true);
            } catch (Exception e) {
                hm.put("result", e.toString());
                hm.put("success", false);
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }
        }


        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }




}
