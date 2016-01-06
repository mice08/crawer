package com.mk.crawer.framework.proxy.server;

import com.mk.crawer.framework.AppUtils;
import com.mk.crawer.framework.MkJedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerManager {

    private static MkJedisConnectionFactory connectionFactory = null;

    public ProxyServer random() {

        return null;
    }

    public void add(ProxyServer proxyServer) {

    }

    public void remove(ProxyServer proxyServer) {

    }

    public ProxyServer get(String ip) {
        return null;
    }

    public boolean check(ProxyServer proxyServer) {
        return false;
    }

    private static Jedis getJedis() {
        return ProxyServerManager.getConnectionFactory().getJedis();
    }

    private static MkJedisConnectionFactory getConnectionFactory() {
        if (ProxyServerManager.connectionFactory == null) {
            synchronized (ProxyServerManager.class) {
                if (ProxyServerManager.connectionFactory == null) {
                    ProxyServerManager.connectionFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
                }
            }
        }
        return ProxyServerManager.connectionFactory;
    }

}
