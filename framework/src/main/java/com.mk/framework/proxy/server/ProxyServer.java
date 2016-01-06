package com.mk.framework.proxy.server;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServer {

    private String ip;

    private Integer port;

    private Long expirationTime;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }
}
