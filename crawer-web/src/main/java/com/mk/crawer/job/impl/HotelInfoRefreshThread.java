package com.mk.crawer.job.impl;

import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.AppUtils;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import com.mk.framework.proxy.http.RedisUtil;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class HotelInfoRefreshThread implements Runnable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelInfoRefreshThread.class);

    private String hotelId;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    @Override
    public void run() {
        done();
    }

    private void done() {
        try {

            LOGGER.info("开始刷新酒店:{}价格", hotelId);

            HotelDetailCrawlService hotelDetailCrawlService = AppUtils.getBean(HotelDetailCrawlService.class);

            hotelDetailCrawlService.crawl(hotelId);

            /**
             * 价格刷新成功，移除任务
             */
            Jedis jedis = null;
            try {
                jedis = RedisUtil.getJedis();

                jedis.srem(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_THREAD_SET, JSONUtil.toJson(this));

                LOGGER.info("从价格刷新队列中移除酒店：{}", hotelId);
            } finally {
                if (jedis != null) {
                    jedis.close();
                    LOGGER.info("Redis连接关闭成功");
                }
            }

            LOGGER.info("结束刷新酒店{}的价格，还剩{}家酒店的价格需要刷新。", hotelId, jedis.scard(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_THREAD_SET));
        } catch (Exception e) {
            LOGGER.error("刷新酒店:{}价格出错。", hotelId);
        }
    }

}
