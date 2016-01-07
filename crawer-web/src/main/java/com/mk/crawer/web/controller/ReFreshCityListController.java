package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.Hotel;
import com.mk.crawer.biz.servcie.IHotelService;
import com.mk.crawer.job.impl.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kirin on 2016/1/7.
 */

@Controller
@RequestMapping(value = "/manager")
public class ReFreshCityListController {

    @Autowired
    private IHotelService hotelService;
    @RequestMapping(value = "/removecitylist")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> remove() {

        TaskService.removeCityList();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/refreshcitylist")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> fetchAndAdd() {
        new TaskService().reFreshCityList();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/listcity")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all() {
        List<CityList> cityLists =  new TaskService().allCityList();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        hm.put("citylist",cityLists);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/listhotel")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> all(String cityname) {
        List<Hotel> hotels = hotelService.selectByCityName(cityname);


        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        hm.put("hotels",hotels);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

}
