package com.mk.crawer.biz.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/22.
 */
public class GdRoomTypeQueue {
    private static LinkedBlockingQueue queue = new LinkedBlockingQueue(3500);

    public static LinkedBlockingQueue getQueue() {
        return queue;
    }

}
