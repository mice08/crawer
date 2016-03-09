package com.mk.crawer.job.impl;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.JSONUtil;
import redis.clients.jedis.Jedis;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by kirinli on 16/1/7.
 */
public class TaskServiceManager {
    private static MkJedisConnectionFactory connectionFactory = null;

    public static Long add(CityList cityList) {
        Jedis jedis = getJedis();

        try {
            return jedis.zadd(
                    RedisCacheName.CRAWLER_CITY_NAME_SET,
                    cityList.getId(),
                    JSONUtil.toJson(cityList));
        } finally {
            jedis.close();
        }
    }

    public static void remove(CityList cityList) {
        Jedis jedis = getJedis();
        try {
            jedis.zrem(
                    RedisCacheName.CRAWLER_CITY_NAME_SET,
                    JSONUtil.toJson(cityList));
        } finally {
            jedis.close();
        }
    }

    public static List<CityList> listAllCity() {
        Jedis jedis = getJedis();
        try {
            Set<String> jsonStrList = jedis.zrange(RedisCacheName.CRAWLER_CITY_NAME_SET, 0, -1);

            List<CityList> cityLists = new LinkedList<>();

            for (String s : jsonStrList) {
                CityList cityList = JSONUtil.fromJson(s, CityList.class);
                cityLists.add(cityList);
            }

            return cityLists;
        } finally {
            jedis.close();
        }
    }

    public static Double getScore(String city) {
        if (null == city) {
            return 0d;
        }
        Jedis jedis = getJedis();

        try {
            return jedis.zscore(RedisCacheName.CRAWLER_CITY_NAME_SET, city);
        } finally {
            jedis.close();
        }
    }

    public static Long count() {
        Jedis jedis = getJedis();

        try {
            return jedis.zcard(RedisCacheName.CRAWLER_CITY_NAME_SET);
        } finally {
            jedis.close();
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
