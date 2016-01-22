package com.mk.framework.proxy.server;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.Config;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerManager {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerManager.class);

    private static final BlockingQueue<ProxyServer> CHECKED = new DelayQueue<>();

    private static final Set<ProxyServer> USING_PROXY_SERVER_SET = new ConcurrentSkipListSet<>();

    static class CheckedProxyIPLoad implements Runnable {
        @Override
        public void run() {
            Jedis jedis = null;
            try {
                jedis = RedisUtil.getJedis();

                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String jsonStr = jedis.spop(RedisCacheName.CRAWLER_PROXY_IP_CHECKED_SET);

                        if ( StringUtils.isEmpty(jsonStr) ) {
                            TimeUnit.SECONDS.sleep(1);
                        } else {
                            ProxyServer proxyServer = JSONUtil.fromJson(jsonStr, ProxyServer.class);
                            proxyServer.intervalTime(0, TimeUnit.MILLISECONDS);
                            CHECKED.put(proxyServer);
                            LOGGER.info("有效代理IP加入可用队列：{}", jsonStr);
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            } finally {
                RedisUtil.close(jedis);
                LOGGER.info("载入有效代理的进程结束");
            }
        }
    }

    static {
        final Thread checkedProxyIPLoad = new Thread(new CheckedProxyIPLoad(), "Provide-checked-proxy-ip-thread");
        checkedProxyIPLoad.setDaemon(true);
        checkedProxyIPLoad.start();

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                checkedProxyIPLoad.interrupt();
            }
        });

        ProxyServerFetch.start();
    }

    public static ProxyServer take() throws InterruptedException {
        ProxyServer proxyServer = CHECKED.take();

        while (USING_PROXY_SERVER_SET.contains(proxyServer)) {
            LOGGER.info("代理IP：{}正在被使用", proxyServer.getIp());
            proxyServer = CHECKED.take();
        }
        LOGGER.info("从队列中获取代理IP：{}", proxyServer.getIp());

        USING_PROXY_SERVER_SET.add(proxyServer);

        return proxyServer;
    }

    public static void put(ProxyServer proxyServer) throws InterruptedException {
        proxyServer.intervalTime(Config.VISIBLE_TIME_INTERVAL, TimeUnit.MILLISECONDS);
        CHECKED.put(proxyServer);

        USING_PROXY_SERVER_SET.remove(proxyServer);
    }

    public static void remove(ProxyServer proxyServer) {
        USING_PROXY_SERVER_SET.remove(proxyServer);
    }

    public  static ProxyServer randomBlock() {
        String jsonStr;
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();

            jsonStr = jedis.srandmember(RedisCacheName.CRAWLER_BAD_PROXY_SERVER_POOL_SET);

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


    public static void removeBlock(ProxyServer proxyServer) {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();
            jedis.srem(
                    RedisCacheName.CRAWLER_BAD_PROXY_SERVER_POOL_SET,
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
                    RedisCacheName.CRAWLER_BAD_PROXY_SERVER_POOL_SET,
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
            return jedis.scard(RedisCacheName.CRAWLER_BAD_PROXY_SERVER_POOL_SET);
        }catch (Exception e){
            throw e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }
    }

}
