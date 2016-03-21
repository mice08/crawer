package com.mk.crawer.job.hotel.price;

import com.mk.crawer.job.SwitchUtil;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 振涛 on 2016/1/8.
 */
//@Component
public class HotelDetailRefreshJob implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelDetailRefreshJob.class);

    private static final ThreadPoolExecutor EXECUTOR_100 = initExecutor();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                EXECUTOR_100.shutdown();
                LOGGER.info("刷新酒店价格任务的线程池关闭");
            }
        });

        EXECUTOR_100.execute(new StartRefreshThread());
    }

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

    class StartRefreshThread implements Runnable {
        @Override
        public void run() {
            LOGGER.info("开始添加刷新酒店信息的线程");
            while (!Thread.currentThread().isInterrupted()) {
                try {

                    try {
                        if (SwitchUtil.HotelDetailRefresh.isOpen()) {

                            ProxyServer proxyServer = ProxyServerManager.take();
                            HotelDetail hotelDetail = HotelDetailManager.take();
                            if (null == hotelDetail) {
                                LOGGER.info("无酒店,刷新酒店信息的任务暂时暂停");
                                TimeUnit.SECONDS.sleep(1);
                                continue;
                            }
                            HotelDetailRefreshThread refreshThread =
                                    new HotelDetailRefreshThread(proxyServer, hotelDetail);

                            EXECUTOR_100.execute(refreshThread);
                        } else {
                            LOGGER.info("刷新酒店信息的任务暂时暂停");
                            TimeUnit.SECONDS.sleep(1);
                        }

                    } catch (RejectedExecutionException e) {
                        TimeUnit.SECONDS.sleep(1);
                    }

                } catch (InterruptedException e) {
                    break;
                }
            }
            LOGGER.info("结束添加刷新酒店信息的线程");
        }

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
                new LinkedBlockingQueue<Runnable>(Config.HOT_CITY_100_CONCURRENCY_THREAD_COUNT),
                new HotelInfoRefreshThreadFactory());
    }

}
