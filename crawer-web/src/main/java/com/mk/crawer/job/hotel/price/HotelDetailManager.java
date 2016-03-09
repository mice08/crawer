package com.mk.crawer.job.hotel.price;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Response;
import redis.clients.jedis.Transaction;

import java.util.Set;

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
        Jedis jedis = null;
        Transaction transaction = null;

        try {
            jedis = RedisUtil.getJedis();
            //
            transaction = jedis.multi();

            //当前城市队列 key
            String []cityKey = HotelDetailManager.citySwitch(transaction);
            String curCityKey = cityKey[0];
            String returnCityKey = cityKey[1];

            //
            Long count = jedis.zcard(curCityKey);
            if (null == count || count == 0) {
                return null;
            }

            //获取城市队列第一个
            String city = HotelDetailManager.getFirstFromZSet(transaction, curCityKey);
            if (null == city) {
                return null;
            }

            //当前酒店队列 key
            String[] hotelKey = HotelDetailManager.hotelSetSwitch(curCityKey);
            String curHotelKey = hotelKey[0];
            String returnHotelKey = hotelKey[1];

            //
            String hotel = HotelDetailManager.getFirstFromZSet(transaction, "");


//            //优先处理 错误 分数为3
//            transaction.zrangeByScore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR,3,3,0,1);

            //
            transaction.zincrby(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR,4,"");

            //
//            return

            //获取队列第一个
            transaction.zrange(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET,0,0);

            //移除
            transaction.zrem(curSet,"");

            //默认加入错误队列 1分
            transaction.zadd(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR,1,"");

        } catch (InterruptedException e) {
            LOGGER.error("初始化待刷新信息的酒店时线程被中断：", e);
        } finally {
            RedisUtil.close(jedis);
        }
        return null;
    }

    private static String getFirstFromZSet(Transaction transaction ,String key) {
        //获取城市队列第一个
        Response<Set<String>> citySetResponse = transaction.zrange(key, 0, 0);
        Set<String> zset = citySetResponse.get();

        for (String value : zset) {
            return value;
        }

        return null;
    }

    /**
     * 判断当前城市队列
     * @return String[]{当前队列,返还队列}
     */
    private static String[] citySwitch(Transaction transaction) {
        //
        if (null == transaction) {
            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER,
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE};
        }

        //master 数量
        Response<Long> masterCountResponse = transaction.zcard(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER);
        Long masterCount = masterCountResponse.get();

        //slave数量
        Response<Long>  slaveCountResponse = transaction.zcard(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE);
        Long slaveCount = slaveCountResponse.get();

        //错误状态,返回master
        if (null == masterCount || null == slaveCount) {
            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER,
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE};
        }

        //开关,0 使用slave队列  其他使用 master队列
        //当发现队列空,切换到另一个队列
        if (masterCount == 0) {
            //切换到slave
            transaction.set(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH, "0");

            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE,
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER};

        } else if (slaveCount == 0) {
            //切换到master
            transaction.set(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH, "1");

            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER,
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE};

        } else {
            //城市开关,0 使用slave队列  其他使用 master队列
            Response<String> crawlerSwitchResponse =
                    transaction.get(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH);
            String crawlerSwitch = crawlerSwitchResponse.get();
            if ("0".equals(crawlerSwitch)) {
                return new String[]{
                        RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE,
                        RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER};
            } else {
                return new String[]{
                        RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER,
                        RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE};
            }
        }

    }

    /**
     *
     * @param citySwitch
     * @return
     */
    private static String[] hotelSetSwitch(String citySwitch) {

        if (null == citySwitch) {
            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET,
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_SLAVE};
        } else if (RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER.equals(citySwitch)) {
            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET,
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_SLAVE};
        } else {
            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_SLAVE,
                    RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET};
        }
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
