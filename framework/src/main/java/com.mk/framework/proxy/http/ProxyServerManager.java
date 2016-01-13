package com.mk.framework.proxy.http;

import com.mk.framework.manager.RedisCacheName;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerManager {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerManager.class);

    private static final ThreadLocal<ProxyServer> PROXY_SERVER_THREAD_LOCAL = new ThreadLocal<>();

    private static final Set<ProxyServer> USING_PROXY_SERVER_SET = new ConcurrentSkipListSet<>();

    static ProxyServer random() throws InterruptedException {
        ProxyServer proxyServer = PROXY_SERVER_THREAD_LOCAL.get();

        if ( proxyServer != null ) {
            return proxyServer;
        } else {
            BlockingQueue<ProxyServer> queue = ProxyServerFetch.byBill();

            proxyServer = queue.take();

            while (USING_PROXY_SERVER_SET.contains(proxyServer)) {
                proxyServer = queue.take();
            }

            PROXY_SERVER_THREAD_LOCAL.set(proxyServer);
            USING_PROXY_SERVER_SET.add(proxyServer);

            return proxyServer;
        }
    }

    public  static ProxyServer randomBlock() {
        String jsonStr;
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();

            jsonStr = jedis.srandmember(RedisCacheName.CRAWER_BAD_PROXY_SERVER_POOL_SET);

            if (StringUtils.isEmpty(jsonStr)) {
                throw new IllegalArgumentException("无法从Redis里面获取到代理IP");
            }

            return JSONUtil.fromJson(jsonStr, ProxyServer.class);
        } catch (Exception e) {
            throw e;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    static void remove(ProxyServer proxyServer) {
        PROXY_SERVER_THREAD_LOCAL.remove();
        USING_PROXY_SERVER_SET.remove(proxyServer);
    }


    public static void removeBlock(ProxyServer proxyServer) {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            jedis.srem(
                    RedisCacheName.CRAWER_BAD_PROXY_SERVER_POOL_SET,
                    JSONUtil.toJson(proxyServer));
        }catch (Exception e){
            throw e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }


    }

    static void addBadServer(ProxyServer proxyServer) {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            jedis.sadd(
                    RedisCacheName.CRAWER_BAD_PROXY_SERVER_POOL_SET,
                    JSONUtil.toJson(proxyServer)
            );
        }catch (Exception e){
            throw e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }
    }

    public  static Long countBadServer() {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            return jedis.scard(RedisCacheName.CRAWER_BAD_PROXY_SERVER_POOL_SET);
        }catch (Exception e){
            throw e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }
    }

}
