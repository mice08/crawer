package com.mk.crawer.biz.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/22.
 */
public class GdRoomTypeQueue {
    private static LinkedBlockingQueue queue = new LinkedBlockingQueue();

    public static LinkedBlockingQueue getQueue() {
        return queue;
    }

}
