package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.model.crawer.QunarHotelExample;
import com.mk.crawer.biz.servcie.QunarHotelService;
import com.mk.crawer.job.hotel.price.HotelDetail;
import com.mk.crawer.job.hotel.price.HotelDetailManager;
import com.mk.framework.AppUtils;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by 振涛 on 2016/1/7.
 */

@Controller
@RequestMapping(value = "/hotel-price-job")
public class HotelPriceJobController {

    private static final Logger LOGGER =  org.slf4j.LoggerFactory.getLogger(HotelPriceJobController.class);

    @RequestMapping(value = "/add-city-hotel" , method = RequestMethod.POST)
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


                QunarHotelService qunarHotelService = AppUtils.getBean(QunarHotelService.class);

                List<QunarHotel> hotelList = qunarHotelService.selectHotelByCity(city);
                if (hotelList != null){
                    for (QunarHotel hotel : hotelList) {
                        HotelDetail hotelDetail = new HotelDetail();
                        hotelDetail.setHotelId(hotel.getSourceId());
                        hotelDetail.setCityName(hotel.getCityName());

                        HotelDetailManager.add(hotelDetail);

                        LOGGER.info("添加到价格刷新队列，酒店ID：{}", hotelDetail.getHotelId());
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

    @RequestMapping(value = "/add-all-hotel")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addAllHotel() {
        HashMap hm = new HashMap();

        Jedis jedis = null;

        try {
            Integer hotelCount = 0;

            jedis = RedisUtil.getJedis();

            Set<String> jsonStrSet = jedis.zrange(RedisCacheName.CRAWLER_CITY_NAME_SET, 0, -1);

            LOGGER.info("共{}个城市的酒店信息等待更新", jsonStrSet.size());

            for (String s : jsonStrSet) {
                CityList city = JSONUtil.fromJson(s, CityList.class);

                LOGGER.info("开始查询{}的酒店列表", city.getCityName());

                QunarHotelExample hotelExample = new QunarHotelExample();
                hotelExample.createCriteria().andCityNameEqualTo(city.getCityName());
                QunarHotelService qunarHotelService = AppUtils.getBean(QunarHotelService.class);
                List<QunarHotel> hotelList = qunarHotelService.selectByExample(hotelExample);

                LOGGER.info("{}共有{}家酒店，将被添加到信息刷新队列", city.getCityName(), hotelList.size());

                for (QunarHotel hotel : hotelList) {
                    HotelDetail hotelDetail = new HotelDetail();
                    hotelDetail.setHotelId(hotel.getSourceId());
                    hotelDetail.setCityName(hotel.getCityName());

                    HotelDetailManager.add(hotelDetail);

                    ++hotelCount;

                    LOGGER.info("{}加入信息刷新队列，酒店ID为：{}", hotel.getHotelName(), hotel.getSourceId());
               }
            }

            hm.put("result", "共"+hotelCount+"家酒店添加到信息刷新队列");
            hm.put("success", true);
        } catch (Exception e) {
            hm.put("result", e.toString());
            hm.put("success", false);
        } finally {
            RedisUtil.close(jedis);
        }

        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }






}
