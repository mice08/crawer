package com.mk.crawer.biz.thread;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/22.
 */
public class GdRoomTypeQueue {
    private static LinkedBlockingQueue roomTypeQueue = new LinkedBlockingQueue(50000);

    private static LinkedBlockingQueue hotelTelUpdateQueue = new LinkedBlockingQueue(20000);

    public static LinkedBlockingQueue getRoomTypeQueue() {
        return roomTypeQueue;
    }

    public static void setRoomTypeQueue(LinkedBlockingQueue roomTypeQueue) {
        GdRoomTypeQueue.roomTypeQueue = roomTypeQueue;
    }

    public static LinkedBlockingQueue getHotelTelUpdateQueue() {
        return hotelTelUpdateQueue;
    }

    public static void setHotelTelUpdateQueue(LinkedBlockingQueue hotelTelUpdateQueue) {
        GdRoomTypeQueue.hotelTelUpdateQueue = hotelTelUpdateQueue;
    }
}
