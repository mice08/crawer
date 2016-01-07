package com.mk.crawer.job.impl;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by kirinli on 16/1/7.
 */
public class TaskServiceManager {
    private static MkJedisConnectionFactory connectionFactory = null;

    static Long add(CityList cityList) {
        Jedis jedis = null;
        try{
            jedis = getJedis();
            return jedis.sadd(
                    RedisCacheName.CRAWER_CITY_NAME_SET,
                    JSONUtil.toJson(cityList));
        }catch (Exception e){
            throw  e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }

    }

    static void remove(CityList cityList) {
        Jedis jedis = null;
        try{
            jedis = getJedis();
            jedis.srem(
                    RedisCacheName.CRAWER_CITY_NAME_SET,
                    JSONUtil.toJson(cityList));
        }catch (Exception e){
            throw  e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }

    }

    static List<CityList> listAllCity() {
        Jedis jedis = null;
        try{
            jedis = getJedis();
            Set<String> jsonStrList = jedis.smembers(RedisCacheName.CRAWER_CITY_NAME_SET);

            List<CityList> cityLists = new LinkedList<>();

            for (String s : jsonStrList) {
                CityList cityList = JSONUtil.fromJson(s, CityList.class);
                cityLists.add(cityList);
            }
            return cityLists;
        }catch (Exception e){
            throw  e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }

    }



    static Long count() {
        Jedis jedis = null;
        try{
            jedis = getJedis();
            return jedis.scard(RedisCacheName.CRAWER_CITY_NAME_SET);

        }catch (Exception e){
            throw  e;
        }finally {
            if (null != jedis){
                jedis.close();
            }
        }
    }

    private static Jedis getJedis() {
        return TaskServiceManager.getConnectionFactory().getJedis();
    }

    private static MkJedisConnectionFactory getConnectionFactory() {
        if (TaskServiceManager.connectionFactory == null) {
            synchronized (TaskServiceManager.class) {
                if (TaskServiceManager.connectionFactory == null) {
                    TaskServiceManager.connectionFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
                }
            }
        }
        return TaskServiceManager.connectionFactory;
    }
}
