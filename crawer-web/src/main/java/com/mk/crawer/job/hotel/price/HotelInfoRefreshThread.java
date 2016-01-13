package com.mk.crawer.job.hotel.price;

import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.AppUtils;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import com.mk.framework.proxy.http.RedisUtil;
import com.mk.framework.proxy.http.ThreadUtil;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class HotelInfoRefreshThread implements Runnable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelInfoRefreshThread.class);

    @Override
    public void run() {
        Jedis jedis = RedisUtil.getJedis();

        try {
            while (!SystemStatus.JVM_IS_SHUTDOWN) {
                HotelDetail hotelDetail = null;

                try {
                    hotelDetail = HotelPriceManager.take();

                    LOGGER.info("开始刷新酒店:{}的价格", hotelDetail.getHotelId());

                    HotelDetailCrawlService hotelDetailCrawlService = AppUtils.getBean(HotelDetailCrawlService.class);

                    hotelDetailCrawlService.crawl(hotelDetail.getHotelId());

                    HotelPriceManager.remove(hotelDetail);

                    LOGGER.info("成功刷新酒店：{}的价格", hotelDetail.getHotelId());
                } catch (Exception e) {
                    HotelPriceManager.add(hotelDetail);
                } finally {
                    ThreadUtil.sleep(Config.REFRESH_PRICE_INTERVAL_TIME);
                }
            }
        } finally {
            RedisUtil.close(jedis);
        }
    }

}
