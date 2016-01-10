package com.mk.framework.proxy.http;

import org.slf4j.Logger;

import java.util.Random;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class ThreadUtil {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ThreadUtil.class);

    private static final Random RANDOM = new Random();

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.error("sleep error", e);
        }
    }

    public static void randomSleep(int millisMin, int millisMax) {
        try {
            Integer millis = RANDOM.nextInt(millisMax);

            if ( millis < millisMin ) {
                millis = millisMin;
            }

            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.error("sleep error", e);
        }
    }

}
