package com.mk.crawer.web.controller;

import com.mk.crawer.biz.mapper.crawer.MtCityMapper;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.MtCity;
import com.mk.crawer.biz.servcie.MtHotelDetailCrawlerService;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by BurizaDo on 2/17/16.
 */
@Controller
public class MtHotelDetailController {
    @Autowired
    private MtHotelDetailCrawlerService crawlerService;
    @Autowired
    private MtCityMapper cityMapper;
    @RequestMapping(value = "/mthoteldetail", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> hoteldetail() {
        HashMap<String, Object> result = new HashMap<>();

//        MtCity.MtCityList cityList2 = crawlerService.crawCityList();

        List<MtCity> cityList = cityMapper.getCityList();

        for(MtCity city : cityList){
            int count = crawlerService.crawHotelList(city);
            result.put(city.name, count);
        }

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }
}
