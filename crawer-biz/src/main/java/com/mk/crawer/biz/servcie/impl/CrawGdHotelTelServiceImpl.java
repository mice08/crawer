package com.mk.crawer.biz.servcie.impl;

import com.alibaba.fastjson.JSON;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.biz.bean.*;
import com.mk.crawer.biz.mapper.crawer.GdHotelMapper;
import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.servcie.CrawGdHotelTelService;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.HttpUtils;
import com.mk.crawer.biz.utils.RedisUtil;
import com.mk.framework.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jredis.JredisConnection;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/22.
 */
@Service
public class CrawGdHotelTelServiceImpl implements CrawGdHotelTelService {
    private static final String GD_HOTEL_TEL_URL = "http://api.map.baidu.com/place/v2/search?ak=%s&output=json&query=%s&page_size=1&page_num=0&scope=2&region=%s";
    private static ExecutorService pool = Executors.newFixedThreadPool(32);
    private static ExecutorService exePool = Executors.newFixedThreadPool(10);
    private static Logger logger = LoggerFactory.getLogger(CrawGdHotelTelServiceImpl.class);

    @Autowired
    private GdHotelMapper gdHotelMapper;

    @Override
    public void executeUpdateHotelTelToDb(LinkedBlockingQueue queue){
        exePool.execute(new ExecuteUpdateHotelTelToDbThread(queue));
    }

    @Override
    public void crawGdHotelTel(GdHotel bean, LinkedBlockingQueue queue){
        Cat.logEvent("crawGdHotelTel","crawGdHotelTel Crawler GAODE Room type info", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime());
        logger.info(String.format("\n====================crawGdHotelTel begin time={}====================\n"),DateUtils.getDatetime());
        int count = gdHotelMapper.countTelIsNull();
        if (count<=0){
          return;
        }
        int pageSize=1000;
        int pageCount=count/pageSize;
        logger.info(String.format("\n====================size={}&pageSize={}&pageCount={}====================\n")
                ,count,pageSize,pageCount);
        Integer start =0;
        if (bean.getPageIndex()!=null){
            start=bean.getPageIndex();
        }
        Jedis jedis = RedisUtil.getJedis();
        try {
            String apiKey = jedis.lpop("BAIDUAPIACCESS");
            for (int i=start;i<=pageCount;i++){
                logger.info(String.format("\n====================pageIndex={}====================\n")
                        ,i*pageSize);
                bean.setPageSize(pageSize);
                bean.setPageIndex(i*pageSize);
                List<GdHotel> hotelList = gdHotelMapper.queryHotelByTelIsNull(bean);
                if (CollectionUtils.isEmpty(hotelList)){
                    logger.info(String.format("\n====================hotelList is empty====================\n"));
                    continue;
                }
                for(GdHotel hotel:hotelList){
                    //如果redis没有获取到key则直接返回
                    pool.execute(new crawGdHotelTelThread(queue, String.format(GD_HOTEL_TEL_URL, apiKey, hotel.getName(), hotel.getCityName()), hotel));
                }
            }
            Cat.logEvent("crawGdHotelTel","crawGdHotelTel Crawler GAODE Room type info", Event.SUCCESS,
                    "beginTime=" + DateUtils.getDatetime());
        }catch (Exception e) {
            throw e;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }

    }

    private class crawGdHotelTelThread implements Runnable {
        private LinkedBlockingQueue queue;
        private String address;
        private GdHotel gdHotel;

        crawGdHotelTelThread(LinkedBlockingQueue queue, String address, GdHotel gdHotel) {
            this.queue = queue;
            this.address = address;
            this.gdHotel = gdHotel;
        }

        @Override
        public void run() {
            String json = HttpUtils.get_data(address, "GET");
            BaiduHotelsearch baiduHotelsearch = JSON.parseObject(json, BaiduHotelsearch.class);
            //判断开发者key失效的时候重新去redis去拿
            for(int i=0; i<3; i++){
                if("302".equals(baiduHotelsearch.getStatus()+"")){
                    Jedis jedis = RedisUtil.getJedis();
                    try {
                        String apiKey = jedis.lpop("BAIDUAPIACCESS");
                        baiduHotelsearch = JSON.parseObject(String.format(GD_HOTEL_TEL_URL, apiKey, gdHotel.getName(), gdHotel.getCityName()), BaiduHotelsearch.class);
                    }catch (Exception e) {
                        throw e;
                    } finally {
                        if (null != jedis) {
                            jedis.close();
                        }
                    }
                }else{
                    break;
                }
            }
            //如果redis没有获取到key则直接返回
            if (CollectionUtils.isEmpty(baiduHotelsearch.getResults())) {
                return;
            }
            putHotelTelToQueue(baiduHotelsearch.getResults().get(0), queue);
        }

        private void putHotelTelToQueue(Results results, LinkedBlockingQueue queue) {
            if (StringUtils.isEmpty(results.getTelephone())) {
                return;
            }
            GdHotelTel hotelTel = new GdHotelTel();
            hotelTel.setTel(results.getTelephone());
            hotelTel.setHotelSourceId(gdHotel.getSourceId());
            queue.add(hotelTel);
        }
    }

    private class ExecuteUpdateHotelTelToDbThread implements Runnable {
        private LinkedBlockingQueue<GdHotelTel> queue;
        public ExecuteUpdateHotelTelToDbThread(LinkedBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            GdHotelMapper gdHotelMapper = AppUtils.getBean(GdHotelMapper.class);
            while (true){
                try {
                    GdHotelTel ht = queue.take();
                    if(ht == null){
                        Thread.sleep(10 * 1000);
                        continue;
                    }
                    GdHotel gdHotel = new GdHotel();
                    gdHotel.setSourceId(ht.getHotelSourceId());
                    gdHotel.setUpdateTime(new Date());
                    gdHotel.setTel(ht.getTel());
                    gdHotelMapper.updateBySourceId(gdHotel);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String atf[]){
        String json = HttpUtils.get_data(String.format(GD_HOTEL_TEL_URL, "B2gx3StPDNAjysEZ3w7E7RrmEYQ18BqC", "三亚崖州湾金查尔顿度假酒店", "中山市"), "GET");
        BaiduHotelsearch baiduHotelsearch = JSON.parseObject(json, BaiduHotelsearch.class);
        System.out.println(baiduHotelsearch);
    }
    
}
