package com.mk.whotel.wechat.web.bean;

import com.google.gson.Gson;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class Base {

    public String toJSONStr() {
        Gson gson = new Gson();

        return gson.toJson(this);
    }

}
