package com.mk.crawer.web.controller;


import com.mk.crawer.api.QunarHotelSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class QunarHotelSyncController {

    @Autowired
    private QunarHotelSyncService qunarHotelSyncService;

    @RequestMapping(value = "/qunarhotelsync", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> qunarHotelSync() {
        Map<String, Object> result = new HashMap<String, Object>();

        result=qunarHotelSyncService.qunarHotelSync();
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }




}
