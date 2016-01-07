package com.mk.crawer.job.impl;

import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.crawer.biz.servcie.ICityListService;
import com.mk.crawer.biz.servcie.IHotelService;
import com.mk.crawer.biz.servcie.ITCityListBusinessService;
import com.mk.crawer.job.Worker;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ReFreshOTAPriceTask implements Worker {

    public static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReFreshOTAPriceTask.class);

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(100);

    class RefleshJob implements Runnable {



        @Override
        public void run() {
            done();
        }

        private void done() {

        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                EXECUTOR_SERVICE.shutdown();
            }
        });
    }

    @Autowired
    private ICityListService iCityListService;
    @Autowired
    private IHotelService iHotelService;
    @Autowired
    private HotelDetailCrawlService hotelDetailCrawlService;
    @Autowired
    private ITCityListBusinessService itCityListBusinessService;

    @Scheduled(cron = "0 0/30 * * * ? ")
    @Override
    public void work() {
        try {
            LOGGER.error("定时任务执行开始");



            LOGGER.error("定时任务执行结束");
        } catch (Exception e) {
            LOGGER.error("定时任务执行出错：", e);
        }
    }

}