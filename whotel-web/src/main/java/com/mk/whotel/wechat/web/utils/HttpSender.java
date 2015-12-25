package com.mk.whotel.wechat.web.utils;

import com.google.gson.Gson;
import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class HttpSender {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HttpSender.class);

    private String url;

    private Map<String, String> params = new HashMap<>();

    private HttpSender() {}

    public static HttpSender getInstance() {
        return new HttpSender();
    }

    public HttpSender setUrl(String url) {
        this.url = url;

        return this;
    }

    public HttpSender addParam(String name, String value) {
        params.put(name, value);

        return this;
    }

    public <T> T send(Class<T> classOfT) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(url);
        stringBuffer.append("?");

        for (Map.Entry<String, String> entry : params.entrySet()) {
            stringBuffer.append(entry.getKey()).append("=").append(entry.getValue());
            stringBuffer.append("&");

        }

        LOGGER.info("发送请求：{}", stringBuffer.toString());
        String result = HttpUtil.doGet(stringBuffer.toString());
        LOGGER.info("获得响应：{}", result);

        Gson gson = new Gson();

        return gson.fromJson(result, classOfT);
    }

}
