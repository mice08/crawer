package com.mk.crawer.web.controller;

import com.mk.framework.proxy.http.ProxyServerJob;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 振涛 on 2016/1/7.
 */

@Controller
@RequestMapping(value = "/proxy-server-job")
public class ProxyServerJobController {

    @RequestMapping(value = "/valid-and-remove")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> validAndRemove() {
        ProxyServerJob.validAndRemove();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

    @RequestMapping(value = "/fetch-and-add")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> fetchAndAdd() {
        ProxyServerJob.fetchAndAdd();

        HashMap hm = new HashMap();
        String result = "请求成功";
        boolean  success = true;
        hm.put("result",result);
        hm.put("success",success);
        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }




}
