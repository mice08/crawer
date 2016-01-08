package com.mk.crawer.job.impl;

import com.google.common.collect.ImmutableSet;

/**
 * Created by 振涛 on 2016/1/7.
 */
public class Config {

    /**
     * 中国热门城市100个集合
     */
    public static final ImmutableSet<String> HOT_CITY_100_SET = ImmutableSet.of(
            "北京",
            "上海",
            "广州"
    );
    /**
     * 中国热门城市1000个集合
     */
    public static final ImmutableSet<String> HOT_CITY_1000_SET = ImmutableSet.of(
            "长沙",
            "成都",
            "西安"
    );



    /**
     * 中国热门城市100个集合的线程池并发数
     */
    public static final Integer HOT_CITY_100_CONCURRENCY_THREAD_COUNT = 5;
    /**
     * 中国热门城市1000个集合的线程池并发数
     */
    public static final Integer HOT_CITY_1000_CONCURRENCY_THREAD_COUNT = 5;
    /**
     * 中国非热门城市的线程池并发数
     */
    public static final Integer NO_HOT_CITY_CONCURRENCY_THREAD_COUNT = 5;


}
