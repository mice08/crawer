package com.mk.crawer.job.impl;

import com.google.gson.Gson;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.Hotel;
import com.mk.crawer.biz.model.crawer.HotelExample;
import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.crawer.biz.servcie.IHotelService;
import com.mk.crawer.job.Worker;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ReFreshOTAPriceTask implements Worker {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ReFreshOTAPriceTask.class);

    private static final ExecutorService EXECUTOR_100 = Executors.newFixedThreadPool(20);
    private static final ExecutorService EXECUTOR_1000 = Executors.newFixedThreadPool(20);
    private static final ExecutorService EXECUTOR_OTHER = Executors.newFixedThreadPool(20);

    private static MkJedisConnectionFactory connectionFactory = null;

    @Autowired
    private IHotelService iHotelService;

    class HotelInfoReFleshJob implements Runnable {

        private String hotelId;

        public HotelInfoReFleshJob(String hotelId) {
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
                LOGGER.info("结束刷新酒店:{}价格", hotelId);
            } catch (Exception e) {
                LOGGER.error("价格刷新线程出错：", e);
            }
        }
    }

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                EXECUTOR_100.shutdownNow();
                EXECUTOR_1000.shutdownNow();
                EXECUTOR_OTHER.shutdownNow();
                LOGGER.info("价格刷新线程池关闭。");
            }
        });
    }


    @Scheduled(cron = "0/50 * * * * ? ")
    @Override
    public void work() {
        try {
            LOGGER.error("定时任务执行开始");

            Jedis jedis = null;

            try {
                jedis = getJedis();

                Set<String> jsonStrSet = jedis.smembers(RedisCacheName.CRAWER_CITY_NAME_SET);

                for (String s : jsonStrSet) {
                    Gson gson = new Gson();
                    CityList city = gson.fromJson(s, CityList.class);

                    HotelExample hotelExample = new HotelExample();
                    hotelExample.createCriteria().andCityNameEqualTo(city.getCityName());

                    List<Hotel> hotelList = iHotelService.selectByExample(hotelExample);

                    for (Hotel hotel : hotelList) {
                        HotelInfoReFleshJob hotelInfoReFleshJob = new HotelInfoReFleshJob(hotel.getSourceId());

                        if ( Config.HOT_CITY_100_SET.contains(city.getCityName()) ) {
                            EXECUTOR_100.execute(hotelInfoReFleshJob);
                        } else if ( Config.HOT_CITY_1000_SET.contains(city.getCityName()) ) {
                            EXECUTOR_1000.execute(hotelInfoReFleshJob);
                        } else {
                            EXECUTOR_OTHER.execute(hotelInfoReFleshJob);
                        }
                    }
                }
            }
            finally {
                if (jedis != null) {
                    jedis.close();
                }
            }

            LOGGER.error("定时任务执行结束");
        } catch (Exception e) {
            LOGGER.error("定时任务执行出错：", e);
        }
    }

    private static Jedis getJedis() {
        return ReFreshOTAPriceTask.getConnectionFactory().getJedis();
    }

    private static MkJedisConnectionFactory getConnectionFactory() {
        if (ReFreshOTAPriceTask.connectionFactory == null) {
            synchronized (ReFreshOTAPriceTask.class) {
                if (ReFreshOTAPriceTask.connectionFactory == null) {
                    ReFreshOTAPriceTask.connectionFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
                }
            }
        }
        return ReFreshOTAPriceTask.connectionFactory;
    }
}