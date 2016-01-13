package com.mk.crawer.job.hotel.price;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.JSONUtil;
import com.mk.framework.proxy.http.RedisUtil;
import org.slf4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by 振涛 on 2016/1/13.
 */
public class HotelDetailManager {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelDetailManager.class);

    private static final BlockingQueue<HotelDetail> HOTEL_DETAIL_BLOCKING_QUEUE =
            new ArrayBlockingQueue<>(Config.WAIT_FOR_REFRESH_HOTEL_PRICE_QUEUE_SIZE);

    static {
        init();
    }

    private static void init() {
        Jedis jedis = null;

        try {
            jedis = RedisUtil.getJedis();

            Set<String> jsonSet = jedis.smembers(RedisCacheName.CRAWER_HOTEL_INFO_REFRESHING_SET);

            for (String s : jsonSet) {
                HotelDetail hotelDetail = JSONUtil.fromJson(s, HotelDetail.class);
                HOTEL_DETAIL_BLOCKING_QUEUE.put(hotelDetail);
            }

        } catch (Exception e) {
            LOGGER.error("初始化待刷新信息的酒店时发生错误：", e);
        } finally {
            RedisUtil.close(jedis);
        }
        LOGGER.info("初始化待刷新信息的酒店完成");
    }

    /**
     * 获取待刷新的酒店
     * 从本地阻塞队列获取
     * 该方法会阻塞
     * @return
     * @throws InterruptedException
     */
    public static HotelDetail take() throws InterruptedException {
        return HOTEL_DETAIL_BLOCKING_QUEUE.take();
    }

    /**
     * 添加待刷新的酒店
     * 添加到本地阻塞队列
     * 该方法会阻塞
     * @param hotelDetail
     * @throws InterruptedException
     */
    public static void put(HotelDetail hotelDetail) throws InterruptedException {
        Jedis jedis = null;
        Transaction transaction = null;

        try {
            jedis = RedisUtil.getJedis();

            String jsonStr = JSONUtil.toJson(hotelDetail);

            transaction = jedis.multi();

            transaction.srem(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_SET, jsonStr);
            transaction.sadd(RedisCacheName.CRAWER_HOTEL_INFO_REFRESHING_SET, jsonStr);

            HOTEL_DETAIL_BLOCKING_QUEUE.put(hotelDetail);

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
     * 将要刷新的酒店添加到Redis
     * @param hotelDetail
     * @return
     */
    public static void add(HotelDetail hotelDetail) {
        Jedis jedis = null;
        Transaction transaction = null;

        try {
            jedis = RedisUtil.getJedis();

            String jsonStr = JSONUtil.toJson(hotelDetail);

            transaction = jedis.multi();

            transaction.srem(RedisCacheName.CRAWER_HOTEL_INFO_REFRESHING_SET, jsonStr);
            transaction.sadd(RedisCacheName.CRAWER_HOTEL_INFO_REFRESH_SET, jsonStr);

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
     * 从Redis移除正在刷新的酒店
     * @param hotelDetail
     * @return 如果存在该元素返回true，如果不存在改元素返回false
     */
    public static boolean remove(HotelDetail hotelDetail) {
        Jedis jedis = null;

        try {
            jedis = RedisUtil.getJedis();

            String jsonStr = JSONUtil.toJson(hotelDetail);

            Long reply = jedis.srem(RedisCacheName.CRAWER_HOTEL_INFO_REFRESHING_SET, jsonStr);

            return reply > 0;
        } catch (Exception e) {
            throw e;
        } finally {
            RedisUtil.close(jedis);
        }
    }



}
