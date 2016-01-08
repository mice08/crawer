package com.mk.crawer.job.impl;

import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class HotelInfoRefreshThread implements Runnable {

    private static final Random RANDOM = new Random();

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

            Integer sleepTime = RANDOM.nextInt(10000);
            if ( sleepTime < 100 ) {
                sleepTime = 100;
            }
            Thread.sleep(sleepTime);

            HotelDetailCrawlService hotelDetailCrawlService = AppUtils.getBean(HotelDetailCrawlService.class);

            //hotelDetailCrawlService.crawl(hotelId);

            Jedis jedis = null;

            try {
                jedis = getJedis();

                jedis.srem(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_THREAD_SET, JSONUtil.toJson(this));
            } finally {
                if (jedis != null) {
                    jedis.close();
                }
            }

            LOGGER.info("结束刷新酒店:{}价格", hotelId);
        } catch (Exception e) {
            LOGGER.error("价格刷新线程出错：", e);
        } finally {
            GlobalValues.HOTEL_INFO_REFRESH_JOB_COUNT.decrementAndGet();
        }
    }

    private static Jedis getJedis() {
        return AppUtils.getBean(MkJedisConnectionFactory.class).getJedis();
    }

}
