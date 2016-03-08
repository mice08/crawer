package com.mk.crawer.job.hotel.price;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by 振涛 on 2016/1/13.
 */
@Component
public class HotelDetailManager implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelDetailManager.class);

//    private static final BlockingQueue<HotelDetail> HOTEL_DETAIL_BLOCKING_QUEUE =
//            new ArrayBlockingQueue<>(Config.WAIT_FOR_REFRESH_HOTEL_PRICE_QUEUE_SIZE);

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

//        //启动恢复 之前序列Runnable
//        final Thread reloadRefreshingQueue = new Thread(new ReloadRefreshingQueue(), "ReloadRefreshingQueue");
//        reloadRefreshingQueue.setDaemon(true);
//        reloadRefreshingQueue.start();

//        //向队列中 添加待刷新的酒店
//        final Thread redisRefreshPriceListener = new Thread(new RedisRefreshPriceListener(), "RedisRefreshPriceListener");
//        redisRefreshPriceListener.setDaemon(true);
//        redisRefreshPriceListener.start();

//        Runtime.getRuntime().addShutdownHook(new Thread() {
//            @Override
//            public void run() {
////                //启动恢复 之前序列Runnable
////                reloadRefreshingQueue.interrupt();
//
//                redisRefreshPriceListener.interrupt();
//            }
//        });
    }

//    private static class RedisRefreshPriceListener implements Runnable {
//        @Override
//        public void run() {
//            Jedis jedis = null;
//
//            try {
//                jedis = RedisUtil.getJedis();
//
//                while (!Thread.currentThread().isInterrupted()) {
//
//                    Set<String> jsonSet = new HashSet<>();
//
//                    if ( jsonSet.size() == 0 ) {
//                        jsonSet = jedis.zrangeByScore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, 0, 0, 0, 100);
//                    }
//                    if ( jsonSet.size() == 0 ) {
//                        jsonSet = jedis.zrangeByScore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, 1, 1, 0, 100);
//                    }
//                    if ( jsonSet.size() == 0 ) {
//                        jsonSet = jedis.zrangeByScore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, 2, 2, 0, 100);
//                    }
//                    if ( jsonSet.size() == 0 ) {
//                        jsonSet = jedis.zrangeByScore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, 3, 3, 0, 100);
//                    }
//                    if ( jsonSet.size() == 0 ) {
//                        jsonSet = jedis.zrangeByScore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, 4, 4, 0, 100);
//                    }
//                    if ( jsonSet.size() == 0 ) {
//                        jsonSet = jedis.zrangeByScore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, Double.MAX_VALUE, Double.MAX_VALUE, 0, 100);
//                    }
//
//
//                    if (jsonSet.size() > 0) {
//                        for (String s : jsonSet) {
//                            HotelDetail hotelDetail = JSONUtil.fromJson(s, HotelDetail.class);
//
//                            put(hotelDetail);
//
//                            LOGGER.info("酒店：{}加入待刷新价格队列", hotelDetail.getHotelId());
//                        }
//                    } else {
//                        TimeUnit.SECONDS.sleep(1);
//                    }
//                }
//            } catch (InterruptedException e) {
//                LOGGER.error("监听酒店价格刷新线程被中断：",e);
//            } finally {
//                RedisUtil.close(jedis);
//            }
//        }
//    }
//
//    private static class ReloadRefreshingQueue implements Runnable {
//        @Override
//        public void run() {
//            Jedis jedis = null;
//
//            try {
//                jedis = RedisUtil.getJedis();
//
//                Set<String> jsonSet = jedis.zrange(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESHING_SET, 0, Long.MAX_VALUE);
//                LOGGER.info("正在恢复上次程序关闭前，未处理完的酒店信息队列");
//
//                for (String s : jsonSet) {
//                    HotelDetail hotelDetail = JSONUtil.fromJson(s, HotelDetail.class);
//                    HOTEL_DETAIL_BLOCKING_QUEUE.put(hotelDetail);
//                    LOGGER.info("酒店加入待刷新队列：{}", s);
//                }
//
//                LOGGER.info("恢复待刷新信息的酒店成功");
//            } catch (InterruptedException e) {
//                LOGGER.error("初始化待刷新信息的酒店时线程被中断：", e);
//            } finally {
//                RedisUtil.close(jedis);
//            }
//        }
//    }

    /**
     * 获取待刷新的酒店
     * 从本地阻塞队列获取
     * 该方法会阻塞
     * @return
     * @throws InterruptedException
     */
    public static HotelDetail take() throws InterruptedException {
//        return HOTEL_DETAIL_BLOCKING_QUEUE.take();

        return null;
    }

//    /**
//     * 添加待刷新的酒店
//     * 添加到本地阻塞队列
//     * 该方法会阻塞
//     * @param hotelDetail
//     * @throws InterruptedException
//     */
//    public static void put(HotelDetail hotelDetail) throws InterruptedException {
//        Jedis jedis = null;
//        Transaction transaction = null;
//
//        try {
//            jedis = RedisUtil.getJedis();
//
//            String jsonStr = JSONUtil.toJson(hotelDetail);
//
//            transaction = jedis.multi();
//
//            transaction.zrem(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, jsonStr);
//            transaction.zadd(
//                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESHING_SET,
//                    ScoreUtil.getScore(hotelDetail.getCityName()),
//                    jsonStr);
//
//            HOTEL_DETAIL_BLOCKING_QUEUE.put(hotelDetail);
//
//            transaction.exec();
//        } catch (Exception e) {
//            if ( transaction != null ) {
//                transaction.discard();
//            }
//            throw e;
//        } finally {
//            RedisUtil.close(jedis);
//        }
//    }

    /**
     * 将要刷新的酒店添加到Redis,并从正在刷新队列中移除
     * @param hotelDetail
     * @return
     */
    public static void rollback(HotelDetail hotelDetail) {
        Jedis jedis = null;
        Transaction transaction = null;

        try {
            jedis = RedisUtil.getJedis();

            String jsonStr = JSONUtil.toJson(hotelDetail);

            transaction = jedis.multi();

            transaction.zrem(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, jsonStr);
            transaction.zadd(
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET,
                    ScoreUtil.getScore(hotelDetail.getCityName()),
                    jsonStr);

            transaction.exec();
        } catch (Exception e) {
            if ( transaction != null ) {
                transaction.discard();
            }
            throw e;
        } finally {
            RedisUtil.close(jedis);
        }
    }

    /**
     * 从Redis移除正在刷新的酒店，代表该酒店的价格完成刷新
     * @param hotelDetail
     * @return 如果存在该元素返回true，如果不存在该元素返回false
     */
    public static boolean complete(HotelDetail hotelDetail) {
        Jedis jedis = null;

        try {
            jedis = RedisUtil.getJedis();

            String jsonStr = JSONUtil.toJson(hotelDetail);

            Long reply = jedis.zrem(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET, jsonStr);

            return reply > 0;
        } finally {
            RedisUtil.close(jedis);
        }
    }

    public static boolean add(HotelDetail hotelDetail) {
        Jedis jedis = null;
        try {
            jedis = RedisUtil.getJedis();

            String jsonStr = JSONUtil.toJson(hotelDetail);

            Long reply = jedis.zadd(
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET,
                    ScoreUtil.getScore(hotelDetail.getCityName()),
                    jsonStr);

            return reply > 0;
        } finally {
            RedisUtil.close(jedis);
        }
    }


}
