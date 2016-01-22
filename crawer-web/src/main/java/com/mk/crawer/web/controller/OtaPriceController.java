package com.mk.crawer.web.controller;


import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.OtaPrice;
import com.mk.crawer.biz.servcie.OtaPriceService;
import com.mk.crawer.biz.servcie.QunarHotelMapSyncService;
import com.mk.crawer.biz.servcie.QunarHotelService;
import com.mk.crawer.biz.servcie.QunarHotelSyncExService;
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
public class OtaPriceController {

    @Autowired
    private OtaPriceService otaPriceService;

    @RequestMapping(value = "/getOtaPrice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> test(OtaPrice record) {
        Map<String, Object> result = new HashMap<String, Object>();
        result =otaPriceService.getOtaPrice(record);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "/catheOtaPrice", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> catheOtaPrice(HotelMapping record) {
        Map<String, Object> result = new HashMap<String, Object>();
        result =otaPriceService.catheOtaPrice(record);
        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
}
