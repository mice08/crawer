package com.mk.crawer.thread.callable;

import com.mk.crawer.job.hotel.price.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * Created by chenqi on 16/3/3.
 */
public class CallThreadPoolTest extends BaseTest {

    private static int produceTaskSleepTime = 10;

    private static int produceTaskMaxNumber = 1000;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void testThreadPoolExecutor() {
        for (int i = 1; i <= produceTaskMaxNumber; i++) {
            try {
                Thread.sleep(produceTaskSleepTime);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            new Thread(new StartTaskThread(threadPoolTaskExecutor, i)).start();
        }

    }

}
