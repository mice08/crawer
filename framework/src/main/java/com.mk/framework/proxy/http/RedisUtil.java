package com.mk.framework.proxy.http;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;

/**
 * Created by 振涛 on 2016/1/11.
 */
public class RedisUtil {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RedisUtil.class);

    public static Jedis getJedis() {
        Jedis jedis = null;
        while (jedis == null) {

            try {
                MkJedisConnectionFactory mkJedisConnectionFactory =
                        AppUtils.getBean(MkJedisConnectionFactory.class);
                if ( mkJedisConnectionFactory != null ) {
                    jedis = mkJedisConnectionFactory.getJedis();
                }
            } catch (Exception e) {
                LOGGER.error("get redis client happen an error, will try again after 5s: ", e);
                ThreadUtil.sleep(5000);
            }

        }
        return jedis;
    }

}
