package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.ots.TDistrict;
import com.mk.crawer.biz.servcie.CrawGdHotelReviewService;
import com.mk.crawer.biz.servcie.CrawGdHotelService;
import com.mk.crawer.biz.servcie.CrawGdRoomType;
import com.mk.crawer.biz.thread.GdRoomTypeQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
    @Autowired
    private CrawGdRoomType crawGdRoomType;

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

    @RequestMapping(value = "/createGdRoomTypeSync" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> createGdRoomTypeSync(GdHotel bean) {
        crawGdRoomType.crawGdRoomType(bean, GdRoomTypeQueue.getQueue());
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("message","执行结束");
        resultMap.put("SUCCESS", true);
        return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
    }


    @RequestMapping(value = "/excuteRoomTypeToDb" , method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String,Object>> gdHotelSync() {
        crawGdRoomType.executeRoomTypeToDb(GdRoomTypeQueue.getQueue());
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("message","执行结束");
        resultMap.put("SUCCESS", true);
        return new ResponseEntity<Map<String,Object>>(resultMap, HttpStatus.OK);
    }

}
