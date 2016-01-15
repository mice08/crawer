package com.mk.crawer.job.hotel.price;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import com.mk.framework.proxy.SystemStatus;
import com.mk.framework.proxy.ThreadUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 振涛 on 2016/1/8.
 */
@Component
public class HotelDetailRefreshJob implements InitializingBean {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelDetailRefreshJob.class);

    private static final ThreadPoolExecutor EXECUTOR_100 = initExecutor();

    static class HotelInfoRefreshThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public HotelInfoRefreshThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null)? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "Hotel-price-refresh-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }


    class RedisRefreshPriceListener implements Runnable {
        @Override
        public void run() {
            Jedis jedis = null;

            try {
                jedis = RedisUtil.getJedis();

                while (!SystemStatus.JVM_IS_SHUTDOWN) {

                    Set<String> jsonSet = jedis.zrange(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, 0, 0);

                    if (jsonSet.size() > 0) {
                        for (String s : jsonSet) {
                            HotelDetail hotelDetail = JSONUtil.fromJson(s, HotelDetail.class);

                            HotelDetailManager.put(hotelDetail);

                            LOGGER.info("酒店：{}加入待刷新价格队列", hotelDetail.getHotelId());
                        }
                    } else {
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
            } catch (InterruptedException e) {
                Thread.interrupted();
                LOGGER.error("监听酒店价格刷新线程发生错误：",e);
            } finally {
                RedisUtil.close(jedis);
            }
        }
    }

    class StartRefreshThread implements Runnable {
        @Override
        public void run() {
            LOGGER.info("开始添加刷新酒店信息的线程");
            try {
                Integer count = 0;
                while (!SystemStatus.JVM_IS_SHUTDOWN) {
                    if ( count++ < Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT ) {
                        EXECUTOR_100.execute(new HotelDetailRefreshThread());
                        //一秒钟增加一个，防止同一时刻发送大量请求，导致服务器拒绝服务
                        TimeUnit.SECONDS.sleep(1);
                    } else {
                        break;
                    }
                }
            } catch (InterruptedException e) {
                Thread.interrupted();
            }
            LOGGER.info("结束添加刷新酒店信息的线程");
        }

    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                EXECUTOR_100.shutdownNow();
                LOGGER.info("刷新酒店价格任务的线程池关闭");
            }
        });
    }

    private static ThreadPoolExecutor initExecutor() {
        LOGGER.info("初始化线程池");
        if ( EXECUTOR_100 != null ) {
            EXECUTOR_100.shutdown();
        }

        return new ThreadPoolExecutor(
                Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT,
                Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new HotelInfoRefreshThreadFactory());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Thread redisRefreshPriceListener = new Thread(new RedisRefreshPriceListener(), "RedisRefreshPriceListener");
        redisRefreshPriceListener.setDaemon(false);
        redisRefreshPriceListener.start();

        Thread startRefreshThread = new Thread(new StartRefreshThread(), "StartRefreshThread");
        startRefreshThread.setDaemon(false);
        startRefreshThread.start();
    }
}
