package com.mk.crawer.job.hotel.price;

import com.mk.crawer.biz.servcie.QunarHotelSyncExService;
import com.mk.framework.AppUtils;
import org.slf4j.Logger;

public class HotelExInfoRefreshThread implements Runnable {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HotelExInfoRefreshThread.class);



    public HotelExInfoRefreshThread() {
    }

    @Override
    public void run() {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }

        try {
            LOGGER.info("开始刷新城市{}的酒店图片");

            QunarHotelSyncExService qunarHotelSyncExService = AppUtils.getBean(QunarHotelSyncExService.class);

            qunarHotelSyncExService.qunarHotelSyncEx();

            LOGGER.info("成功刷新城市{}的酒店图片");
        } catch (Exception e) {

            LOGGER.info("刷新刷新城市{}的酒店图片");
        }
    }

}
