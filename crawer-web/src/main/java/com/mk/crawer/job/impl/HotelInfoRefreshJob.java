package com.mk.crawer.job.impl;

import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 振涛 on 2016/1/8.
 */
@Component
public class HotelInfoRefreshJob implements InitializingBean {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelInfoRefreshJob.class);

    private static final ExecutorService EXECUTOR_100 = Executors.newFixedThreadPool(Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT);
//    private static final ExecutorService EXECUTOR_1000 = Executors.newFixedThreadPool(Config.HOT_CITY_1000_CONCURRENCY_THREAD_COUNT);
//    private static final ExecutorService EXECUTOR_OTHER = Executors.newFixedThreadPool(Config.NO_HOT_CITY_CONCURRENCY_THREAD_COUNT);

    private static final Integer JOB_LIMIT = 1000;

    private static volatile boolean addJobEnable = true;

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
                    if ( GlobalValues.HOTEL_INFO_REFRESH_JOB_COUNT.get() <= JOB_LIMIT ) {

                        jedis = getJedis();

                        String jsonStr = jedis.srandmember(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_THREAD_SET);

                        if (!StringUtils.isEmpty(jsonStr)) {
                            HotelInfoRefreshThread hotelInfoRefreshThread = JSONUtil.fromJson(jsonStr, HotelInfoRefreshThread.class);
                            EXECUTOR_100.execute(hotelInfoRefreshThread);

                            GlobalValues.HOTEL_INFO_REFRESH_JOB_COUNT.getAndDecrement();
                        }
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            LOGGER.error("^_^！睡觉失败...", e);
                        }
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
                LOGGER.info("关闭线程池");
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
