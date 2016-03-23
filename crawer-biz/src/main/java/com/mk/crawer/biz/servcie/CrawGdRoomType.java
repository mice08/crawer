package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.GdHotel;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/22.
 */
public interface CrawGdRoomType {
    void executeRoomTypeToDb(LinkedBlockingQueue queue);

    void crawGdRoomType(GdHotel bean, LinkedBlockingQueue queue);
}
