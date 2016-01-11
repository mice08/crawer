package com.mk.crawer.job.impl;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import com.mk.framework.proxy.http.ThreadUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 振涛 on 2016/1/8.
 */
@Component
public class HotelInfoRefreshJob implements InitializingBean {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelInfoRefreshJob.class);


    private static final ThreadPoolExecutor EXECUTOR_100 =
            new ThreadPoolExecutor(Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT,
                    Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT,
                    100L, TimeUnit.MILLISECONDS,
                    new ArrayBlockingQueue<Runnable>(Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT),
                    new HotelInfoRefreshThreadFactory());

    private static volatile boolean addJobEnable = true;

    static class HotelInfoRefreshThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public HotelInfoRefreshThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null)? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            t.setDaemon(true);
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    class DoJob implements Runnable {

        @Override
        public void run() {
            doJob();
        }

        private void doJob() {
            LOGGER.info("刷新酒店价格任务执行开始");

            while (addJobEnable) {
                Jedis jedis = null;

                try {
                    jedis = getJedis();

                    String jsonStr = jedis.srandmember(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_THREAD_SET);

                    if (!StringUtils.isEmpty(jsonStr)) {
                        HotelInfoRefreshThread hotelInfoRefreshThread = JSONUtil.fromJson(jsonStr, HotelInfoRefreshThread.class);

                        try {
                            EXECUTOR_100.execute(hotelInfoRefreshThread);
                        } catch (RejectedExecutionException e) {
                            int sleepTime = 1000;
                            LOGGER.info("work queue is full, hotel price refresh job thread sleep {} ms", 1, sleepTime);
                            ThreadUtil.sleep(sleepTime);
                        }
                    } else {
                        int sleepTime = 8000;
                        LOGGER.info("there is not hotel price that need to refreshed in the redis, hotel price refresh job thread sleep {} ms", EXECUTOR_100.getActiveCount(), sleepTime);
                        ThreadUtil.sleep(sleepTime);
                    }
                } catch (Exception e) {
                    LOGGER.error("刷新酒店价格任务执行出错：", e);
                } finally {
                    if (jedis!=null) {
                        jedis.close();
                    }
                }
            }

            LOGGER.info("刷新酒店价格任务执行结束");
        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                addJobEnable = false;
                LOGGER.info("停止添加任务");
                EXECUTOR_100.shutdown();
                LOGGER.info("刷新酒店价格任务的线程池关闭");
            }
        });
    }

    private static Jedis getJedis() throws InterruptedException {
        Jedis jedis = null;
        while (jedis == null) {

            MkJedisConnectionFactory mkJedisConnectionFactory = null;
            try {
                mkJedisConnectionFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
            } catch (Exception e) {
                Thread.sleep(5000);
            }
            if ( mkJedisConnectionFactory != null ) {
                jedis = mkJedisConnectionFactory.getJedis();
            }
        }
        return jedis;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread doJob = new Thread(new DoJob());
        doJob.setDaemon(true);
        doJob.start();
    }
}
