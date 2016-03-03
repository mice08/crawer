package com.mk.crawer.thread.basic;


import common.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;

public class ThreadPoolTest extends BaseTest {
    @Autowired
    private TaskExecutor taskExecutor;// 线程池

    // 将创建的线程添加到线程池中
    @Test
    public void test() throws Exception {
        for (int i = 0; i < 10; i++) {
            this.taskExecutor.execute(new AppContentDataPushThread());
        }
    }

    class AppContentDataPushThread implements Runnable {

        public AppContentDataPushThread() {
        }

        @Override
        public void run() {
            System.out.println("执行线程");
        }
    }
}