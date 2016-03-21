package com.mk.crawer.job.hotel.price;

import com.mk.crawer.job.impl.TaskServiceManager;
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
//@Component
public class HotelDetailManager implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(HotelDetailManager.class);

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
     *
     * @return
     */
    public static HotelDetail take() {
        logger.info("HotelDetailManager.take start");

        HotelDetail first = HotelDetailManager.getFromFirst();
        if (null != first) {
            logger.info("HotelDetailManager.take return first end");
            return first;
        }

        //
        Jedis jedis = null;
        Transaction transaction = null;

        try {
            jedis = RedisUtil.getJedis();

            //当前城市队列 key
            String[] cityKey = HotelDetailManager.citySwitch(jedis);
            String curCityKey = cityKey[0];
            String returnCityKey = cityKey[1];

            logger.info("HotelDetailManager.take curCityKey:{}", curCityKey);
            //
            Long count = jedis.zcard(curCityKey);
            if (null == count || count == 0) {
                logger.info("HotelDetailManager.take curCityKey count: null");
                return null;
            }
            logger.info("HotelDetailManager.take curCityKey count:{}", count);


            //获取城市队列第一个
            String city = HotelDetailManager.getFirstFromZSet(jedis, curCityKey);
            if (null == city) {
                logger.info("HotelDetailManager.take city:null");
                return null;
            }
            logger.info("HotelDetailManager.take city:{}", city);

            //当前酒店队列 key
            Double cityScore = TaskServiceManager.getScore(city);
            String hotelKey = HotelDetailManager.hotelSetSwitch(curCityKey);
            String curHotelKey = hotelKey + "_" + String.valueOf(cityScore);

            logger.info("HotelDetailManager.take curHotelKey:{}", curHotelKey);

            //获取酒店队列第一个
            String hotel = HotelDetailManager.getFirstFromZSet(jedis, curHotelKey);
            if (null == hotel) {
                logger.info("HotelDetailManager.take hotel: null");
                //将当前城市,移动到slave队列
                cityChange(jedis, city);

                //返回空,等待重新获取

                return null;
            }

            logger.info("HotelDetailManager.take hotel:{}", hotel);

            //默认加入错误队列 1分
            Double errScore = jedis.zscore(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR, hotel);

            //
            transaction = jedis.multi();

            if (null == errScore || errScore < 0) {
                logger.info("HotelDetailManager.take hotel:{} errScore: 1", hotel);
                //不存在加入
                transaction.zadd(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR, 1, hotel);
            } else {
                logger.info("HotelDetailManager.take hotel:{} errScore:{}", hotel, errScore + 1);
                //已存在,调整
                transaction.zincrby(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR, errScore + 1, hotel);
            }

            //从酒店队列 移除
            transaction.zrem(curHotelKey, hotel);
            transaction.exec();

            logger.info("HotelDetailManager.take end");
            return JSONUtil.fromJson(hotel, HotelDetail.class);

        } catch (Exception e) {
            if (transaction != null) {
                transaction.discard();
            }
            throw e;
        } finally {
            RedisUtil.close(jedis);
        }
    }

    private static String getFirstFromZSet(Jedis jedis, String key) {
        //获取城市队列第一个
        Set<String> zset = jedis.zrange(key, 0, 0);
        for (String value : zset) {
            return value;
        }

        return null;
    }

    /**
     * 切换城市到slave队列
     *
     * @param jedis
     * @param cityName
     */
    private static void cityChange(Jedis jedis, String cityName) {
        logger.info("HotelDetailManager.cityChange start");
        if (null == jedis || null == cityName) {
            return;
        }

        //城市队列开关,0 使用slave队列  其他使用 master队列,返还时反之
        String crawlerSwitch = jedis.get(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH);

        //当前返回city
        String curCityKey;
        String returnCityKey;
        //城市队列开关,0 使用slave队列  其他使用 master队列,返还时反之
        if ("0".equals(crawlerSwitch)) {
            curCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE;
            returnCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER;
        } else {
            curCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER;
            returnCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE;
        }

        logger.info("HotelDetailManager.cityChange to returnCityKey:{}", returnCityKey);

        //slave队列长度
        Long count = jedis.zcard(returnCityKey);

        //将城市切换到slave最后
        Transaction transaction = null;

        try {
            transaction = jedis.multi();
            transaction.zrem(curCityKey, cityName);
            transaction.zadd(returnCityKey, count + 1, cityName);
            logger.info("HotelDetailManager.cityChange to returnCityKey:{} at :{} cityName: {}",
                    returnCityKey,(count + 1),cityName );

            transaction.exec();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.discard();
            }
            throw e;
        }

        logger.info("HotelDetailManager.cityChange end");
    }

    /**
     * 判断当前城市队列
     *
     * @return String[]{当前队列,返还队列}
     */
    private static String[] citySwitch(Jedis jedis) {

        if (null == jedis) {
            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER,
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE};
        }

        //master 数量
        Long masterCount = jedis.zcard(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER);

        //slave数量
        Long slaveCount = jedis.zcard(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE);

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
            jedis.set(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH, "0");

            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE,
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER};

        } else if (slaveCount == 0) {
            //切换到master
            jedis.set(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH, "1");

            return new String[]{
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER,
                    RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE};

        } else {
            //城市开关,0 使用slave队列  其他使用 master队列
            String crawlerSwitch =
                    jedis.get(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH);
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
     * @param citySwitch
     * @return
     */
    private static String hotelSetSwitch(String citySwitch) {

        if (null == citySwitch) {
            return RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET;
        } else if (RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER.equals(citySwitch)) {
            return RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET;
        } else {
            return RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_SLAVE;
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
     *
     * @param hotelDetail
     * @return
     */
    public static void rollback(HotelDetail hotelDetail) {
        logger.info("HotelDetailManager.rollback start :{}", hotelDetail.getHotelId());
        addToSlave(hotelDetail, false);
        logger.info("HotelDetailManager.rollback end :{}", hotelDetail.getHotelId());
    }

    public static void addCityToFirst(String city) {
        logger.info("HotelDetailManager.addCityToFirst start ");
        Jedis jedis = null;

        //城市id
        Double cityScore = TaskServiceManager.getScore(city);
        if (null == cityScore) {
            logger.info("HotelDetailManager.addCityToFirst city:{} cityScore is null end", city);
            return;
        }
        logger.info("HotelDetailManager.addCityToFirst city:{} cityScore:{}", city, cityScore);

        try {
            jedis = RedisUtil.getJedis();
            //城市队列开关,0 使用slave队列  其他使用 master队列,返还时反之
            String crawlerSwitch = jedis.get(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH);
            logger.info("HotelDetailManager.addCityToFirst crawlerSwitch:{}", crawlerSwitch);

            //当前city key
            String curCityKey;
            String otherCityKey;
            //城市队列开关,0 使用slave队列  其他使用 master队列,返还时反之
            if ("0".equals(crawlerSwitch)) {
                curCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE;
                otherCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER;
            } else {
                curCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER;
                otherCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE;
            }
            logger.info("HotelDetailManager.addCityToFirst curCityKey:{}", curCityKey);

            //判断城市是否在队列中
            Double cureScore = jedis.zscore(curCityKey, city);
            Double otherScore = jedis.zscore(otherCityKey, city);
            if ((null == cureScore || cureScore < 0) && (null == otherScore || otherScore < 0)) {
                //城市 不存在 不处理
                return;
            }

            //若当前已经是该城市,不处理
            String firstCity = getFirstFromZSet(jedis, curCityKey);
            if (city.equals(firstCity)) {
                return;
            }

            //酒店队列
            String curHotelKey = HotelDetailManager.hotelSetSwitch(curCityKey);
            curHotelKey = curHotelKey + "_" + String.valueOf(cityScore);
            logger.info("HotelDetailManager.addCityToFirst curHotelKey:{}", curHotelKey);

            String otherHotelKey = HotelDetailManager.hotelSetSwitch(otherCityKey);
            otherHotelKey = otherHotelKey + "_" + String.valueOf(cityScore);
            logger.info("HotelDetailManager.addCityToFirst otherHotelKey:{}", otherHotelKey);

            //队列长度
            Long curCount = jedis.zcard(curHotelKey);
            logger.info("HotelDetailManager.addCityToFirst curCount:{}", curCount);
            Long otherCount = jedis.zcard(otherHotelKey);
            logger.info("HotelDetailManager.addCityToFirst otherCount:{}", otherCount);

            //若当前队列为非0, 修改城市到当前队列首位
            //若当前队列为0,切换 开关,且修改城市到队列首位
            String changeHotelKey;
            if (curCount > 0) {
                changeHotelKey = curCityKey;
            } else {
                changeHotelKey = otherHotelKey;
                //切换开关
                if ("0".equals(crawlerSwitch)) {
                    crawlerSwitch = "1";
                } else {
                    crawlerSwitch = "0";
                }
                jedis.set(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH, crawlerSwitch);
            }

            //
            jedis.zadd(changeHotelKey, 1d, city);
            logger.info("HotelDetailManager.addCityToFirst end}");
            return;

        } catch (Exception e) {

            throw e;
        } finally {
            RedisUtil.close(jedis);
        }
    }

    /**
     * 优先要刷新的酒店
     * @param hotelDetail
     */
    public static void addToFirst (HotelDetail hotelDetail) {
        logger.info("HotelDetailManager.addToFirst start");
        Jedis jedis = null;

        //
        String jsonHotel = JSONUtil.toJson(hotelDetail);
        logger.info("HotelDetailManager.addToFirst jsonHotel:{}", jsonHotel);

        try {
            jedis = RedisUtil.getJedis();

            jedis.zadd(RedisCacheName.CRAWLER_HOTEL_FIRST_SET,1,jsonHotel);

        } catch (Exception e) {
            throw e;
        } finally {
            RedisUtil.close(jedis);
        }
        logger.info("HotelDetailManager.addToFirst end");
    }

    public static HotelDetail getFromFirst() {
        logger.info("HotelDetailManager.getFromFirst start");
        Jedis jedis = null;

        Transaction transaction = null;

        try {
            jedis = RedisUtil.getJedis();
            Long count = jedis.zcard(RedisCacheName.CRAWLER_HOTEL_FIRST_SET);
            logger.info("HotelDetailManager.getFromFirst count:{}", count);

            if (count > 0) {
                transaction = jedis.multi();
                Response<Set<String>> setResponse = transaction.zrange(RedisCacheName.CRAWLER_HOTEL_FIRST_SET, 0, 0);
                transaction.zremrangeByRank(RedisCacheName.CRAWLER_HOTEL_FIRST_SET,0,0);

                transaction.exec();

                Set<String> firstSet = setResponse.get();
                logger.info("HotelDetailManager.getFromFirst firstSet.size:{}", firstSet.size());
                if (!firstSet.isEmpty()) {
                    String jsonHotel = firstSet.iterator().next();

                    logger.info("HotelDetailManager.getFromFirst jsonHotel:{}", jsonHotel);
                    return JSONUtil.fromJson(jsonHotel, HotelDetail.class);
                }

            }

            logger.info("HotelDetailManager.getFromFirst return null");
            return null;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.discard();
            }
            throw e;
        } finally {
            RedisUtil.close(jedis);
            logger.info("HotelDetailManager.getFromFirst end");
        }
    }
    private static boolean addToSlave(HotelDetail hotelDetail, boolean isDeleteFromError) {
        logger.info("HotelDetailManager.addToSlave start isDeleteFromError:{}", isDeleteFromError);
        Jedis jedis = null;

        Transaction transaction = null;
        //
        String cityName = hotelDetail.getCityName();
        //
        String jsonHotel = JSONUtil.toJson(hotelDetail);
        logger.info("HotelDetailManager.addToSlave jsonHotel:{}", jsonHotel);
        //城市id
        Double cityScore = TaskServiceManager.getScore(cityName);
        logger.info("HotelDetailManager.addToSlave cityName:{} cityScore:{}", cityName, cityScore);

        try {
            jedis = RedisUtil.getJedis();
            //城市队列开关,0 使用slave队列  其他使用 master队列,返还时反之
            String crawlerSwitch = jedis.get(RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH);
            logger.info("HotelDetailManager.addToSlave crawlerSwitch:{}", crawlerSwitch);

            //当前返回city
            String returnCityKey;
            //城市队列开关,0 使用slave队列  其他使用 master队列,返还时反之
            if ("0".equals(crawlerSwitch)) {
                returnCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER;
            } else {
                returnCityKey = RedisCacheName.CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE;
            }

            logger.info("HotelDetailManager.addToSlave returnCityKey:{}", returnCityKey);
            //判断城市是否在队列中
            Double score = jedis.zscore(returnCityKey, cityName);
            if (null == score || score < 0) {
                Long cityCount = jedis.zcard(returnCityKey);
                jedis.zadd(returnCityKey, cityCount + 1, cityName);
            }

            //返还酒店队列
            String hotelKey = HotelDetailManager.hotelSetSwitch(returnCityKey);
            String returnHotelKey = hotelKey + "_" + String.valueOf(cityScore);
            logger.info("HotelDetailManager.addToSlave returnHotelKey:{}", returnHotelKey);

            //队列长度
            Long count = jedis.zcard(returnHotelKey);

            transaction = jedis.multi();
            if (isDeleteFromError) {
                //从错误队列中删除
                transaction.zrem(RedisCacheName.CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR, jsonHotel);
                logger.info("HotelDetailManager.addToSlave delete from error set :{}", jsonHotel);
            }

            //放置最后
            Response<Long> addResponse = transaction.zadd(
                    returnHotelKey,
                    count + 1,
                    jsonHotel);
            transaction.exec();

            logger.info("HotelDetailManager.addToSlave add returnHotelKey:{} count:{} jsonHotel:{}",
                    returnHotelKey,count + 1,jsonHotel);

            logger.info("HotelDetailManager.addToSlave end}");
            return addResponse.get() > 0;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.discard();
            }
            throw e;
        } finally {
            RedisUtil.close(jedis);
        }
    }

    /**
     * 从Redis移除正在刷新的酒店，代表该酒店的价格完成刷新
     *
     * @param hotelDetail
     * @return 如果存在该元素返回true，如果不存在该元素返回false
     */
    public static boolean complete(HotelDetail hotelDetail) {
        logger.info("HotelDetailManager.rollback complete :{}", hotelDetail.getHotelId());
        return addToSlave(hotelDetail, true);
    }

    public static boolean add(HotelDetail hotelDetail) {
        logger.info("HotelDetailManager.rollback add :{}", hotelDetail.getHotelId());
        return addToSlave(hotelDetail, false);
    }
}
