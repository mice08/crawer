package com.mk.crawer.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.crawer.biz.servcie.impl.TCityListBusinessServiceImpl;
import com.mk.framework.UrlUtils;

/**
 * Created by jeashi on 2016/1/6.
 */

@Controller
@RequestMapping(value = "/citylist", produces = MediaType.APPLICATION_JSON_VALUE)

public class CityController {

    @Autowired
    private TCityListBusinessServiceImpl itCityListBusinessService;

    @RequestMapping(value = "/add")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> deleteByParams(HttpServletRequest request, String sitename) {

        String  url = UrlUtils.getUrl("qunar.citylist");

        boolean bl = itCityListBusinessService.saveCityList(url,sitename);
        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }


}
