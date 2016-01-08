package com.mk.crawer.web.controller;


import com.mk.crawer.api.QunarHotelSyncService;
import com.mk.crawer.biz.servcie.QunarHotelMapSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class QunarHotelMapSyncController {

    @Autowired
    private QunarHotelMapSyncService qunarHotelSyncService;

    @RequestMapping(value = "/qunarhotelmapsync", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> qunarHotelSync() {
        Map<String, Object> result = new HashMap<String, Object>();

        result=qunarHotelSyncService.qunarHotelMapSync();
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotelsmapync", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> hotelSyncByCity(String city) {
        Map<String, Object> result = new HashMap<String, Object>();
        result=qunarHotelSyncService.hotelMapSyncByCity(city);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

}
