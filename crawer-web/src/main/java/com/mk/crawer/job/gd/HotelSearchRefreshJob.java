package com.mk.crawer.job.gd;

import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.job.SwitchUtil;
import com.mk.crawer.job.hotel.price.Config;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class HotelSearchRefreshJob implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelSearchRefreshJob.class);

    private static final ThreadPoolExecutor EXECUTOR_100 = initExecutor();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
       /* Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                EXECUTOR_100.shutdown();
                LOGGER.info("GD刷新酒店任务的线程池关闭");
            }
        });

        EXECUTOR_100.execute(new StartRefreshThread());*/
    }

    static class HotelInfoRefreshThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public HotelInfoRefreshThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null)? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "GD-Hotel-search-refresh-pool-" + poolNumber.getAndIncrement() + "-thread-";
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
            LOGGER.info("GD-开始添加刷新酒店信息的线程");
            while (!Thread.currentThread().isInterrupted()) {
                try {

                    try {
                        if (SwitchUtil.HotelDetailRefresh.isOpen()) {

                            ProxyServer proxyServer = ProxyServerManager.take();

                            //TODO
                            GdHotel hotel = null;
                            HotelSearchRefreshThread thread = new HotelSearchRefreshThread(proxyServer, hotel);
                            EXECUTOR_100.execute(thread);
                        } else {
                            LOGGER.info("GD-刷新酒店信息的任务暂时暂停");
                            TimeUnit.SECONDS.sleep(1);
                        }

                    } catch (RejectedExecutionException e) {
                        TimeUnit.SECONDS.sleep(1);
                    }

                } catch (InterruptedException e) {
                    break;
                }
            }
            LOGGER.info("GD-结束添加刷新酒店信息的线程");
        }

    }

    private static ThreadPoolExecutor initExecutor() {
        LOGGER.info("GD-初始化线程池");
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
