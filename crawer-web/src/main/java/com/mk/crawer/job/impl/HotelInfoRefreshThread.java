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

            LOGGER.info("成功刷新酒店{}的价格", hotelId);
        } catch (Exception e) {
            /**
             * 刷新酒店价格失败，任务重新添加到队列
             */
            Jedis jedis = null;
            try {
                jedis = RedisUtil.getJedis();

                String jsonStr = JSONUtil.toJson(this);

                jedis.sadd(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_THREAD_SET, jsonStr);

                LOGGER.info("刷新酒店价格失败，任务重新添加到队列：{}", jsonStr);
            } finally {
                if (jedis != null) {
                    jedis.close();
                    LOGGER.info("Redis连接关闭成功");
                }
            }
        }
    }

}
