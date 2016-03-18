package com.mk.crawer.web.controller;

import com.mk.crawer.biz.servcie.IHotelImageService;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 振涛 on 2016/1/22.
 */
@Controller
@RequestMapping(value = "/hotel-image")
public class HotelImageController {

    @Autowired
    private IHotelImageService hotelImageService;

    @RequestMapping(value = "/insert")
    @ResponseBody
    public ResponseEntity<Map<String,Object>> insert() {

        try {
            ProxyServer proxyServer = ProxyServerManager.take();
            ThreadContext.PROXY_SERVER_THREAD_LOCAL.set(proxyServer);

            hotelImageService.crawl("beijing_city_23008",true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        HashMap hm = new HashMap();

        hm.put("result", "success");
        hm.put("success", true);

        return new ResponseEntity<Map<String,Object>>(hm, HttpStatus.OK);
    }

}
