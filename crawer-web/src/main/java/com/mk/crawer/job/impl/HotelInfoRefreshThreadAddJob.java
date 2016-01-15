package com.mk.crawer.job.impl;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.model.crawer.QunarHotelExample;
import com.mk.crawer.biz.servcie.QunarHotelService;
import com.mk.crawer.job.Worker;
import com.mk.crawer.job.hotel.price.HotelDetail;
import com.mk.crawer.job.hotel.price.HotelDetailManager;
import com.mk.framework.AppUtils;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Set;

/**
 * Created by 振涛 on 2016/1/8.
 */
@Component
public class HotelInfoRefreshThreadAddJob implements Worker {

    private static final Logger LOGGER =  org.slf4j.LoggerFactory.getLogger(HotelInfoRefreshThreadAddJob.class);

    @Autowired
    private QunarHotelService qunarHotelService;

    @Scheduled(cron = "0 10 0 * * ? ")
    @Override
    public void work() {
        try {
            Long start = System.currentTimeMillis();
            LOGGER.info("定时任务执行开始");

            Jedis jedis = null;

            try {
                jedis = RedisUtil.getJedis();

                Set<String> jsonStrSet = jedis.smembers(RedisCacheName.CRAWLER_CITY_NAME_SET);

                for (String s : jsonStrSet) {
                    CityList city = JSONUtil.fromJson(s, CityList.class);

                    QunarHotelExample hotelExample = new QunarHotelExample();
                    hotelExample.createCriteria().andCityNameEqualTo(city.getCityName());

                    if (qunarHotelService == null){
                        qunarHotelService = AppUtils.getBean(QunarHotelService.class);
                    }
                    LOGGER.info("*******************刷新城市缓存{} ***************",city.getCityName());

                    List<QunarHotel> hotelList = qunarHotelService.selectByExample(hotelExample);
                    if (hotelList != null){
                        for (QunarHotel hotel : hotelList) {
                            HotelDetail hotelDetail = new HotelDetail();
                            hotelDetail.setHotelId(hotel.getSourceId());
                            hotelDetail.setCityName(hotel.getCityName());

                            HotelDetailManager.add(hotelDetail);

                            LOGGER.info("*******************加入酒店属性缓存队列{} ***************",hotel.getHotelName());
                        }
                    }

                }
            }
            finally {
                if (jedis != null) {
                    jedis.close();
                }
            }

            Long end = System.currentTimeMillis();
            LOGGER.info("定时任务执行结束，耗时：{}毫秒", end - start);
            LOGGER.info("酒店信息刷新任务队列，有{}酒店需要刷新。", jedis.scard(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET));
        } catch (Exception e) {
            LOGGER.error("定时任务执行出错：", e);
            e.printStackTrace();
        }
    }

    public void doJob(){
        work();
    }
}
