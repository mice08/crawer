package com.mk.framework.proxy;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 振涛 on 2016/1/11.
 */
public class RedisUtil {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RedisUtil.class);

    private static MkJedisConnectionFactory mkJedisConnectionFactory = null;

    private static Lock lock = new ReentrantLock();

    private static void init() {
        if ( mkJedisConnectionFactory == null ) {
            lock.lock();

            while (mkJedisConnectionFactory == null) {

                try {
                    mkJedisConnectionFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
                } catch (Exception e) {
                    LOGGER.error("get redis client happen an error, will try again after 5s: ", e);
                    ThreadUtil.sleep(5000);
                }
            }

            lock.unlock();
        }
    }

    public static Jedis getJedis() {
        init();
        return mkJedisConnectionFactory.getJedis();
    }

    public static void close(Jedis jedis) {
        if ( jedis != null ) {
            jedis.close();
            LOGGER.debug("Redis连接关闭成功");
        }
    }

}
