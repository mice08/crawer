package com.mk.framework.proxy.http;

import java.util.List;

/**
 * Created by 振涛 on 2016/1/7.
 */
class GBJProxy {

    class Proxy {
        public String ip;
        public int port;
        public String country;
        public String province;
        public String city;
        public String isp;
        public String type;
        public String anonymity;
        public Integer connectTimeMs;
    }

    boolean success;

    String msg;

    List<Proxy> data;

}
