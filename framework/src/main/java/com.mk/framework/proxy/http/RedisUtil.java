package com.mk.framework.proxy.http;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by 振涛 on 2016/1/11.
 */
public class RedisUtil {

    public static Jedis getJedis() throws InterruptedException {
        Jedis jedis = null;
        while (jedis == null) {

            try {
                MkJedisConnectionFactory mkJedisConnectionFactory =
                        AppUtils.getBean(MkJedisConnectionFactory.class);
                if ( mkJedisConnectionFactory != null ) {
                    jedis = mkJedisConnectionFactory.getJedis();
                }
            } catch (Exception e) {
                Thread.sleep(5000);
            }

        }
        return jedis;
    }

}
