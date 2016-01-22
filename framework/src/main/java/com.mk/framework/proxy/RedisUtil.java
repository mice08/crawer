package com.mk.framework.proxy;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import org.slf4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by 振涛 on 2016/1/11.
 */
@Component
public class RedisUtil implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(RedisUtil.class);

    private static volatile MkJedisConnectionFactory mkJedisConnectionFactory = null;

    private static Lock lock = new ReentrantLock();

    private static Condition initWait = lock.newCondition();

    public static Jedis getJedis() {
        waitForInit();

        return mkJedisConnectionFactory.getJedis();
    }

    public static void close(Jedis jedis) {
        if ( jedis != null ) {
            jedis.close();
            LOGGER.debug("Redis连接关闭成功");
        }
    }

    private static void waitForInit() {
        if ( mkJedisConnectionFactory == null ) {
            try {
                lock.lock();

                initWait.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            } finally {
                lock.unlock();
            }
        }
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        try {
            lock.lock();

            ApplicationContext applicationContext = event.getApplicationContext();

            mkJedisConnectionFactory = applicationContext.getBean(MkJedisConnectionFactory.class);

            initWait.signalAll();

            LOGGER.info("redis client factory init success");
        } catch (Exception e) {
            LOGGER.error("redis client factory init fail：", e);
        } finally {
            lock.unlock();
        }
    }
}
