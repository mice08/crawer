package com.mk.crawer.web.controller;


import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.servcie.QunarHotelMapSyncService;
import com.mk.crawer.biz.servcie.QunarHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class QunarHotelMapSyncController {

    @Autowired
    private QunarHotelMapSyncService qunarHotelSyncService; @Autowired
    private QunarHotelService qunarHotelService;

    @RequestMapping(value = "/qunarhotelmapsync", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> qunarHotelSync() {
        Map<String, Object> result = new HashMap<String, Object>();

        result=qunarHotelSyncService.qunarHotelMapSync();
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotelsmapsync", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> hotelSyncByCity(CityList bean) {
        Map<String, Object> result = new HashMap<String, Object>();
        result=qunarHotelSyncService.hotelMapSyncByCity(bean);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "/hoteltest", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> test(String city) {
        Map<String, Object> result = new HashMap<String, Object>();
        List citylist =qunarHotelService.seletAllHotelCity();
        result.put("list",citylist);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
}
