package com.mk.crawer.job.hotel.price;

import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.AppUtils;
import com.mk.framework.proxy.SystemStatus;
import com.mk.framework.proxy.ThreadUtil;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class HotelDetailRefreshThread implements Runnable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelDetailRefreshThread.class);

    @Override
    public void run() {
        while (!SystemStatus.JVM_IS_SHUTDOWN) {
            HotelDetail hotelDetail = null;
            try {
                try {
                    hotelDetail = HotelDetailManager.take();

                    LOGGER.info("开始刷新酒店:{}的价格", hotelDetail.getHotelId());

                    HotelDetailCrawlService hotelDetailCrawlService = AppUtils.getBean(HotelDetailCrawlService.class);

                    hotelDetailCrawlService.crawl(hotelDetail.getHotelId());

                    HotelDetailManager.complete(hotelDetail);

                    LOGGER.info("成功刷新酒店：{}的价格", hotelDetail.getHotelId());
                } finally {
                    TimeUnit.MILLISECONDS.sleep(Config.REFRESH_PRICE_INTERVAL_TIME);
                }
            } catch (InterruptedException e) {
                HotelDetailManager.rollback(hotelDetail);
                LOGGER.info("刷新酒店的价格失败");
                Thread.interrupted();
            } catch (Exception e) {
                HotelDetailManager.rollback(hotelDetail);
                LOGGER.info("刷新酒店的价格失败");
            }

        }
    }

}
