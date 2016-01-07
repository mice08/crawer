package com.mk.framework.proxy.http;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import org.apache.http.HttpHost;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by 振涛 on 2016/1/6.
 */
class ProxyServerManager {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerManager.class);

    private static final Random RANDOM = new Random();

    private static MkJedisConnectionFactory connectionFactory = null;

    static ProxyServer random() {
        String jsonStr = null;

        try {
            Jedis jedis = getJedis();

            jsonStr = jedis.srandmember(RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET);

            return JSONUtil.fromJson(jsonStr, ProxyServer.class);
        } catch (Exception e) {
            LOGGER.error("获取代理IP失败：", e);

            List<ProxyServer> proxyServerList = ProxyServerFetch.byMike();

            ProxyServer proxyServer = proxyServerList.get(RANDOM.nextInt(proxyServerList.size()));

            LOGGER.warn("使用备用代理IP：{}", JSONUtil.toJson(proxyServer));

            return proxyServer;
        }
    }

    static Long add(ProxyServer proxyServer) {
        Jedis jedis = getJedis();

        return jedis.sadd(
                RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET,
                JSONUtil.toJson(proxyServer));
    }

    static void remove(ProxyServer proxyServer) {
        Jedis jedis = getJedis();
        jedis.srem(
                RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET,
                JSONUtil.toJson(proxyServer));
    }

    static List<ProxyServer> listProxyServer() {
        Jedis jedis = getJedis();
        Set<String> jsonStrList = jedis.smembers(RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET);

        List<ProxyServer> proxyServerList = new LinkedList<>();

        for (String s : jsonStrList) {
            ProxyServer proxyServer = JSONUtil.fromJson(s, ProxyServer.class);
            proxyServerList.add(proxyServer);
        }

        return proxyServerList;
    }

    static boolean check(ProxyServer proxyServer) {

        for (String url : Config.TEST_URL) {
            try {
                HttpUtil.doGet(url, proxyServer);
            } catch (IOException e) {
                return false;
            }
        }

        return true;
    }

    static Long count() {
        Jedis jedis = getJedis();

        return jedis.scard(RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET);
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
