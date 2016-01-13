package com.mk.crawer.job.hotel.price;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import com.mk.framework.proxy.http.RedisUtil;
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
public class HotelDetailRefreshJob implements InitializingBean {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelDetailRefreshJob.class);

    private static final BlockingQueue<HotelDetailRefreshThread> HOTEL_INFO_REFRESH_QUEUE =
            new ArrayBlockingQueue<>(Config.WAIT_FOR_REFRESH_HOTEL_PRICE_QUEUE_SIZE);

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
            t.setDaemon(true);
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

                    String jsonStr = jedis.srandmember(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_SET);

                    if (!StringUtils.isEmpty(jsonStr)) {
                        HotelDetail hotelDetail = JSONUtil.fromJson(jsonStr, HotelDetail.class);

                        HotelDetailManager.put(hotelDetail);

                        LOGGER.debug("酒店：{}加入待刷新价格队列", hotelDetail.getHotelId());
                    } else {
                        ThreadUtil.sleep(1000);
                    }
                }
            } catch (Exception e) {
                LOGGER.error("监听酒店价格刷新线程发生错误：",e);
            } finally {
                if ( jedis != null ) {
                    jedis.close();
                }
            }
        }
    }

    class StartRefreshThread implements Runnable {
        @Override
        public void run() {
            LOGGER.info("开始添加刷新酒店信息的线程");
            Integer count = 0;
            while (!SystemStatus.JVM_IS_SHUTDOWN) {
                if ( ++count <= Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT ) {
                    EXECUTOR_100.execute(new HotelDetailRefreshThread());
                } else {
                    break;
                }
            }
            LOGGER.info("结束添加刷新酒店信息的线程");
        }

    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                EXECUTOR_100.shutdown();
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
        redisRefreshPriceListener.setDaemon(true);
        redisRefreshPriceListener.start();

        Thread startRefreshThread = new Thread(new StartRefreshThread(), "StartRefreshThread");
        startRefreshThread.setDaemon(true);
        startRefreshThread.start();
    }
}
