package com.mk.framework.proxy.http;

import org.slf4j.Logger;

/**
 * Created by 振涛 on 2016/1/13.
 */
public class SystemStatus {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(SystemStatus.class);

    public static volatile Boolean JVM_IS_SHUTDOWN = Boolean.FALSE;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                JVM_IS_SHUTDOWN = Boolean.TRUE;
                LOGGER.info("JVM正在关闭");
            }
        });
    }

}
