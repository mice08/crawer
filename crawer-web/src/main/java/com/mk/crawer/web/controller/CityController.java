package com.mk.crawer.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mk.crawer.biz.servcie.ITCityListBusinessService;
import com.mk.crawer.biz.utils.JsonUtils;
import io.netty.handler.codec.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.unidal.helper.Objects;
import  com.mk.framework.proxy.http.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeashi on 2016/1/6.
 */

@Controller
@RequestMapping(value = "/citylict")
public class CityController {

    @Autowired
    private  ITCityListBusinessService  itCityListBusinessService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> deleteByParams(HttpServletRequest request) {
        String  url = "http://touch.qunar.com/h5/hotel/hotelcitylist" ;
        boolean bl = itCityListBusinessService.saveCityList(url);
        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }


}
