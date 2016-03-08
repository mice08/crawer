package com.mk.crawer.job.hotel.price;

import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.AppUtils;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.slf4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class HotelDetailRefreshThread implements Runnable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelDetailRefreshThread.class);

    private ProxyServer proxyServer;

    private HotelDetail hotelDetail;

    public HotelDetailRefreshThread(ProxyServer proxyServer, HotelDetail hotelDetail) {
        this.proxyServer = proxyServer;
        this.hotelDetail = hotelDetail;
    }

    @Override
    public void run() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }

        try {
            LOGGER.info("开始刷新酒店:{}的价格", hotelDetail.getHotelId());
            //为该线程绑定一个代理IP
            ThreadContext.PROXY_SERVER_THREAD_LOCAL.set(proxyServer);

            HotelDetailCrawlService hotelDetailCrawlService = AppUtils.getBean(HotelDetailCrawlService.class);

//            hotelDetailCrawlService.crawl(hotelDetail.getHotelId());

            HotelDetailManager.complete(hotelDetail);

            //代理IP从新加入延迟队列尾部
            ProxyServerManager.put(proxyServer);

            LOGGER.info("成功刷新酒店：{}的价格", hotelDetail.getHotelId());
        } catch (Exception e) {
            Thread.currentThread().interrupt();

            if ( hotelDetail != null ) {
                HotelDetailManager.rollback(hotelDetail);
            }
            if ( proxyServer != null ) {
                ProxyServerManager.remove(proxyServer);
            }
            LOGGER.info("刷新酒店的价格失败");
        }
    }

}
