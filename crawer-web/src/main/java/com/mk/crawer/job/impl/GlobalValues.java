package com.mk.crawer.job.impl;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class GlobalValues {

    /**
     *  线程池中最大等待处理的线程队列
     */
    public static final AtomicInteger HOTEL_INFO_REFRESH_JOB_COUNT = new AtomicInteger(0);

}
