package com.mk.crawer.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mk.crawer.biz.utils.JsonUtils;
import org.springframework.util.StringUtils;
import org.unidal.helper.Objects;

/**
 * Created by jeashi on 2016/1/6.
 */
public class CityController {
    public  void  cityCatch(){
        String  cityCatchStr ="";
        if (StringUtils.isEmpty(cityCatchStr)){
            return ;
        }
        JSONObject  jsoCityCatch = JSONObject.parseObject(cityCatchStr);


    }
}
