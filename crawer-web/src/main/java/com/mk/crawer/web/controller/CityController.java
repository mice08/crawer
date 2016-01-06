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

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jeashi on 2016/1/6.
 */

@Controller
@RequestMapping(value = "/citylict", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    @Autowired
    private  ITCityListBusinessService  itcityListBusinessService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> deleteByParams(HttpRequest request) {
        String  url = "" ;
        boolean bl = itcityListBusinessService.saveCityList(url);

        return new ResponseEntity<Map<String,Object>>(new HashMap(), HttpStatus.OK);
    }


}
