package com.mk.crawer.job.hotel.price;

import com.mk.crawer.api.QunarHotelSyncService;
import com.mk.framework.AppUtils;
import org.slf4j.Logger;

public class HotelImageRefreshThread implements Runnable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelImageRefreshThread.class);



    public HotelImageRefreshThread() {
    }

    @Override
    public void run() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }

        try {
            LOGGER.info("开始刷新城市{}的酒店图片");

            QunarHotelSyncService qunarHotelSyncService = AppUtils.getBean(QunarHotelSyncService.class);

            qunarHotelSyncService.qunarHotelImageSync();

            LOGGER.info("成功刷新城市{}的酒店图片");
        } catch (Exception e) {

            LOGGER.info("刷新刷新城市{}的酒店图片");
        }
    }

}
