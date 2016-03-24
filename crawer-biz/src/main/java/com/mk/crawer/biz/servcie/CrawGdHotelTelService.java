package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.GdHotel;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/23.
 */
public interface CrawGdHotelTelService {
    void executeUpdateHotelTelToDb(LinkedBlockingQueue queue);

    void crawGdHotelTel(GdHotel bean, LinkedBlockingQueue queue);
}
