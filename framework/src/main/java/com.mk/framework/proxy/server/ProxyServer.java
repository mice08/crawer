package com.mk.framework.proxy.server;

import java.util.Objects;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServer implements Delayed {

    /**
     * IP地址
     */
    private String ip;

    /**
     * 端口
     */
    private Integer port;

    /**
     * 可见时间，单位纳秒
     */
    private transient Long visibleTime;

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

    public void intervalTime(int interval, TimeUnit unit) {
        this.visibleTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(interval, unit);
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
    public int compareTo(Delayed o) {
        if (o == null) return 1;
        if (this == o) return 0;
        if ( o instanceof ProxyServer ) {
            ProxyServer proxyServer = (ProxyServer) o;
            return this.visibleTime.compareTo(proxyServer.visibleTime);
        } else {
            return -1;
        }
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return visibleTime - System.nanoTime();
    }

}
