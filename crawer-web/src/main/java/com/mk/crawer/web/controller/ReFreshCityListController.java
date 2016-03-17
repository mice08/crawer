package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.job.hotel.price.HotelDetailManager;
import com.mk.crawer.job.impl.HotelInfoRefreshThreadAddJob;
import com.mk.crawer.job.impl.TaskService;
import org.apache.commons.lang.StringUtils;
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
@RequestMapping(value = "/citylist")
public class ReFreshCityListController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private HotelInfoRefreshThreadAddJob hotelInfoRefreshThreadAddJob;

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
        taskService.reFreshCityList();

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
        List<CityList> cityLists =  taskService.allCityList();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        hm.put("citylist",cityLists);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/refreshhotel")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> refreshHotel() {

        hotelInfoRefreshThreadAddJob.doJob();
        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/addCityToFirst")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> addCityToFirst(String cityName) {

        HashMap hm = new HashMap();
        if (StringUtils.isEmpty(cityName)) {
            hm.put("message","cityName is null");
            hm.put("success",false);
            return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
        }

        // add city to first
        HotelDetailManager.addCityToFirst(cityName);
        hm.put("success",true);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }


}
