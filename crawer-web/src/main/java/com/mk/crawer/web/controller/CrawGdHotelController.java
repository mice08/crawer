package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.model.crawer.QunarHotelExample;
import com.mk.crawer.biz.model.ots.TDistrict;
import com.mk.crawer.biz.servcie.CrawGdHotelReviewService;
import com.mk.crawer.biz.servcie.CrawGdHotelService;
import com.mk.crawer.biz.servcie.QunarHotelService;
import com.mk.crawer.job.hotel.price.HotelDetail;
import com.mk.crawer.job.hotel.price.HotelDetailManager;
import com.mk.framework.AppUtils;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by kangxiaolong on 2016/3/18.
 */

@Controller
@RequestMapping(value = "/crawGdHotel")
public class CrawGdHotelController {

    @Autowired
    CrawGdHotelService crawGdHotelService;
    @Autowired
    CrawGdHotelReviewService reviewService;
    @RequestMapping(value = "/gdHotelSync" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> gdHotelSync(TDistrict bean) {
        Map<String,Object> resultMap=crawGdHotelService.gdHotelSync(bean);
        return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
    }
    @RequestMapping(value = "/gdHotelCommetSync" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> gdHotelCommetSync(GdHotel bean) {
        Map<String,Object> resultMap=reviewService.gdHotelCommetSync(bean);
        return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
    }

}
