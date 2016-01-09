package com.mk.framework.proxy.http;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerManager {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerManager.class);

    private static final Random RANDOM = new Random();

    private static MkJedisConnectionFactory connectionFactory = null;

    static ProxyServer random() {
        List<ProxyServer> proxyServerList = null;

        while (proxyServerList ==null || proxyServerList.size()==0) {
            ThreadUtil.randomSleep(1000, 5000);
            try {
                proxyServerList = ProxyServerFetch.byBill();
            } catch (Exception e) {
                proxyServerList = ProxyServerFetch.byMike();
            }
        }

        ProxyServer proxyServer = proxyServerList.get(RANDOM.nextInt(proxyServerList.size()));

        while (!check(proxyServer)) {
            proxyServer = proxyServerList.get(RANDOM.nextInt(proxyServerList.size()));
        }

        return proxyServer;
    }

    public  static ProxyServer randomBlock() {
        String jsonStr;
        Jedis jedis = null;
        try {
            jedis = getJedis();

            jsonStr = jedis.srandmember(RedisCacheName.CRAWER_BAD_PROXY_SERVER_POOL_SET);

            if (StringUtils.isEmpty(jsonStr)) {
                throw new IllegalArgumentException("无法从Redis里面获取到代理IP");
            }

            return JSONUtil.fromJson(jsonStr, ProxyServer.class);
        } catch (Exception e) {
            List<ProxyServer> proxyServerList = ProxyServerFetch.byMike();

            ProxyServer proxyServer = proxyServerList.get(RANDOM.nextInt(proxyServerList.size()));

            LOGGER.warn("使用备用代理IP：{}", JSONUtil.toJson(proxyServer));

            return proxyServer;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }

    static Long add(ProxyServer proxyServer) {
        Jedis jedis = null;

        Long count = null;

        try {
            jedis = getJedis();
            count = jedis.sadd(
                    RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET,
                    JSONUtil.toJson(proxyServer));
        } catch (Exception e) {
            LOGGER.error("错误：", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return count;
    }

    static boolean isExist(ProxyServer proxyServer) {
        Jedis jedis = null;

        boolean flag = false;

        try {
            jedis = getJedis();
            flag = jedis.sismember(
                    RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET,
                    JSONUtil.toJson(proxyServer));
        } catch (Exception e) {
            LOGGER.error("错误：", e);
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }

        return flag;
    }

    static void remove(ProxyServer proxyServer) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            jedis.srem(
                    RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET,
                    JSONUtil.toJson(proxyServer));
        }catch (Exception e){
            throw e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }


    }

   public static void removeBlock(ProxyServer proxyServer) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
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


    static List<ProxyServer> listProxyServer() {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            Set<String> jsonStrList = jedis.smembers(RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET);

            List<ProxyServer> proxyServerList = new LinkedList<>();

            for (String s : jsonStrList) {
                ProxyServer proxyServer = JSONUtil.fromJson(s, ProxyServer.class);
                proxyServerList.add(proxyServer);
            }

            return proxyServerList;
        }catch (Exception e){
            throw e;
        } finally {
            if (jedis != null) {
                jedis.close();
            }
        }
    }


    static boolean check(ProxyServer proxyServer) {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return !jedis.sismember(
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

    static Long count() {
        Jedis jedis = null;
        try {
            jedis = getJedis();
            return jedis.scard(RedisCacheName.CRAWER_PROXY_SERVER_POOL_SET);
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
            jedis = getJedis();
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
            jedis = getJedis();
            return jedis.scard(RedisCacheName.CRAWER_BAD_PROXY_SERVER_POOL_SET);
        }catch (Exception e){
            throw e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }
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
