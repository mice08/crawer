package com.mk.crawer.web.controller;


import com.mk.crawer.api.QunarHotelSyncService;
import com.mk.crawer.biz.servcie.IHotelImageService;
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
public class QunarHotelSyncController {
    @Autowired
    private IHotelImageService hotelImageService;
    @Autowired
    private QunarHotelSyncService qunarHotelSyncService;

    @RequestMapping(value = "/qunarhotelsync", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> qunarHotelSync() {
        Map<String, Object> result = new HashMap<String, Object>();

        result=qunarHotelSyncService.qunarHotelSync();
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotelsync", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> hotelSyncByCity(String city) {
        Map<String, Object> result = new HashMap<String, Object>();
        result=qunarHotelSyncService.hotelSyncByCity(city);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotelimagesync", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> hotelImageSync() {
        Map<String, Object> result = new HashMap<String, Object>();

        result=qunarHotelSyncService.qunarHotelImageSync();
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/hotelimagesynccity", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> hotelSyncImageByCity(String city) {
        Map<String, Object> result = new HashMap<String, Object>();
        qunarHotelSyncService.doImageSync(city);
        result.put("success", true);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

}
