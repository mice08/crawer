package com.mk.framework.proxy.http;

import java.util.Objects;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServer implements Comparable {

    private String ip;

    private Integer port;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProxyServer that = (ProxyServer) o;
        return Objects.equals(ip, that.ip) &&
                Objects.equals(port, that.port);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, port);
    }

    @Override
    public int compareTo(Object o) {
        if (this == o) return 0;
        ProxyServer that = (ProxyServer) o;

        return ip.compareTo(that.ip);
    }
}
