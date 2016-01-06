package com.mk.framework.proxy.http;

/**
 * Created by 振涛 on 2016/1/6.
 */
class ProxyServer {

    private String ip;

    private Integer port;

    String getIp() {
        return ip;
    }

    void setIp(String ip) {
        this.ip = ip;
    }

    Integer getPort() {
        return port;
    }

     void setPort(Integer port) {
        this.port = port;
    }

}
