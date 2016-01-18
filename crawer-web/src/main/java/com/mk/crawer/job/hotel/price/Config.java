package com.mk.crawer.job.hotel.price;

/**
 * Created by 振涛 on 2016/1/7.
 */
public class Config {

    /**
     * 中国热门城市100个集合的线程池并发数
     */
    public static final Integer HOT_CITY_100_CONCURRENCY_THREAD_COUNT = 4000;
    /**
     * 中国热门城市1000个集合的线程池并发数
     */
    public static final Integer HOT_CITY_1000_CONCURRENCY_THREAD_COUNT = 5;
    /**
     * 中国非热门城市的线程池并发数
     */
    public static final Integer NO_HOT_CITY_CONCURRENCY_THREAD_COUNT = 5;
    /**
     * 待刷新价格的酒店的队列大小，这里是指内存中的阻塞队列的大小
     */
    public static final Integer WAIT_FOR_REFRESH_HOTEL_PRICE_QUEUE_SIZE = 2000;
    /**
     * 单个价格刷新线程每次进行价格刷新的时间间隔
     */
    public static final Integer REFRESH_PRICE_INTERVAL_TIME = 60 * 1000;
    /**
     * 刷新酒店信息的线程池每个线程加入线程池的时间间隔
     */
    public static final Integer THREAD_INIT_INTERVAL_TIME = 200;

}
