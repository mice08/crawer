package com.mk.crawer.job.impl;

import com.mk.crawer.job.Worker;
import com.mk.framework.proxy.http.ProxyServerJob;
import org.slf4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by 振涛 on 2016/1/7.
 */
@Component
public class ProxyServerAddJob implements Worker {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerAddJob.class);

    @Scheduled(cron = "0/5 * * * * ? ")
    @Override
    public void work() {
        try {
            LOGGER.error("定时任务执行开始");
            ProxyServerJob.fetchAndAdd();
            LOGGER.error("定时任务执行结束");
        } catch (Exception e) {
            LOGGER.error("定时任务执行出错：", e);
        }
    }

}
