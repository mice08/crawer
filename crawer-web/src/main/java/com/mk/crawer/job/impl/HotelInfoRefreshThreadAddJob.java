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

    //每天凌晨0点10分执行
    @Scheduled(cron = "0 10 0 * * ? ")
    @Override
    public void work() {
        try {
            Long start = System.currentTimeMillis();
            LOGGER.info("定时任务执行开始");

            Jedis jedis = null;

            try {
                Integer hotelCount = 0;

                jedis = RedisUtil.getJedis();

                Set<String> jsonStrSet = jedis.zrange(RedisCacheName.CRAWLER_CITY_NAME_SET,0 , -1);

                LOGGER.info("共{}个城市的酒店信息等待更新", jsonStrSet.size());

                for (String s : jsonStrSet) {
                    CityList city = JSONUtil.fromJson(s, CityList.class);

                    LOGGER.info("开始查询{}的酒店列表", city.getCityName());

                    QunarHotelExample hotelExample = new QunarHotelExample();
                    hotelExample.createCriteria().andCityNameEqualTo(city.getCityName());

                    if (qunarHotelService == null){
                        qunarHotelService = AppUtils.getBean(QunarHotelService.class);
                    }
                    LOGGER.info("*******************刷新城市缓存{} ***************",city.getCityName());

                    List<QunarHotel> hotelList = qunarHotelService.selectByExample(hotelExample);

                    LOGGER.info("{}共有{}家酒店，将被添加到信息刷新队列", city.getCityName(), hotelList.size());

                    for (QunarHotel hotel : hotelList) {
                        HotelDetail hotelDetail = new HotelDetail();
                        hotelDetail.setHotelId(hotel.getSourceId());
                        hotelDetail.setCityName(hotel.getCityName());

                        HotelDetailManager.add(hotelDetail);

                        ++hotelCount;

                        LOGGER.info("{}加入信息刷新队列，酒店ID为：{}", hotel.getHotelName(), hotel.getSourceId());
                    }

                    LOGGER.info("共{}家酒店添加到信息刷新队列", hotelCount);
                }
            }
            finally {
                if (jedis != null) {
                    jedis.close();
                }
            }

            Long end = System.currentTimeMillis();
            LOGGER.info("定时任务执行结束，耗时：{}毫秒", end - start);
            LOGGER.info("酒店信息刷新任务队列，酒店需要刷新。");
        } catch (Exception e) {
            LOGGER.error("定时任务执行出错：", e);
            e.printStackTrace();
        }
    }

    public void doJob(){
        work();
    }
}
