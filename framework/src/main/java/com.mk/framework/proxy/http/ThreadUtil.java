package com.mk.framework.proxy.http;

import org.slf4j.Logger;

/**
 * Created by 振涛 on 2016/1/8.
 */
public class ThreadUtil {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerManager.class);

    static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            LOGGER.error("sleep error", e);
        }
    }

}
