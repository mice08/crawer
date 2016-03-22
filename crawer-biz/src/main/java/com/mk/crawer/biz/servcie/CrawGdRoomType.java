package com.mk.crawer.biz.servcie;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/22.
 */
public interface CrawGdRoomType {
    void executeRoomTypeToDb(LinkedBlockingQueue queue);

    void crawGdRoomType(LinkedBlockingQueue queue);
}
