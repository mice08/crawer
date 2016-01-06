package com.mk.crawer.framework.proxy.http;

import com.google.gson.Gson;

/**
 * Created by 振涛 on 2015/12/24.
 */
public class JSONUtil {

    public static String toJson(Object src) {
        Gson gson = new Gson();
        return gson.toJson(src);
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }

}
