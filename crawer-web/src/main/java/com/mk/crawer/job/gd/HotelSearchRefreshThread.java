package com.mk.crawer.job.gd;

import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.crawer.job.hotel.price.HotelDetail;
import com.mk.crawer.job.hotel.price.HotelDetailManager;
import com.mk.framework.AppUtils;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.slf4j.Logger;

public class HotelSearchRefreshThread implements Runnable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelSearchRefreshThread.class);

    private ProxyServer proxyServer;

    private GdHotel hotelDetail;

    public HotelSearchRefreshThread(ProxyServer proxyServer, GdHotel hotel) {
        this.proxyServer = proxyServer;
        this.hotelDetail = hotel;
    }

    @Override
    public void run() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }

        try {
            LOGGER.info("GD-开始刷新酒店:{}的价格", hotelDetail.getId());
            //为该线程绑定一个代理IP
            ThreadContext.PROXY_SERVER_THREAD_LOCAL.set(proxyServer);

//            HotelDetailCrawlService hotelDetailCrawlService = AppUtils.getBean(HotelDetailCrawlService.class);

            //代理IP从新加入延迟队列尾部
            ProxyServerManager.put(proxyServer);

            LOGGER.info("GD-成功刷新酒店：{}的价格", hotelDetail.getId());
        } catch (Exception e) {
            Thread.currentThread().interrupt();

            LOGGER.info("GD-刷新酒店的价格失败");
        }
    }

}
