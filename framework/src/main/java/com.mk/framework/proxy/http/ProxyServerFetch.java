package com.mk.framework.proxy.http;

import org.slf4j.Logger;
import org.springframework.security.access.method.P;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerFetch {

    private static final String CHECK_URL = "http://1212.ip138.com/ic.asp";

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerFetch.class);

    private static final BlockingQueue<ProxyServer> BY_BILL = new LinkedBlockingQueue<>();

    private static final BlockingQueue<ProxyServer> WAITING_FOR_CHECK = new LinkedBlockingQueue<>();

    private static final ThreadPoolExecutor CHECK_EXECUTOR = initExecutor();

    private static ThreadPoolExecutor initExecutor() {
        LOGGER.info("初始化线程池");
        if ( CHECK_EXECUTOR != null ) {
            CHECK_EXECUTOR.shutdown();
        }

        return new ThreadPoolExecutor(
                Config.CHECK_PROXY_THREAD_COUNT,
                Config.CHECK_PROXY_THREAD_COUNT,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(),
                new ProxyServerCheckThreadFactory());
    }

    static class ProxyServerCheckThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public ProxyServerCheckThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null)? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "Proxy-server-check-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            t.setDaemon(true);
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }

    static class AddToCheckPool implements Runnable {
        @Override
        public void run() {
            while (!SystemStatus.JVM_IS_SHUTDOWN) {
                try {
                    ProxyServer proxyServer = WAITING_FOR_CHECK.take();
                    Check check = new Check(proxyServer);

                    CHECK_EXECUTOR.execute(check);
                } catch (InterruptedException e) {
                    LOGGER.error("添加代理IP检测出错：", e);
                }
            }
        }
    }

    static class Check implements Runnable {

        private ProxyServer proxyServer;

        public Check(ProxyServer proxyServer) {
            this.proxyServer = proxyServer;
        }

        @Override
        public void run() {
            try {
                HttpUtil.doGet(CHECK_URL, proxyServer);

                BY_BILL.put(proxyServer);
            } catch (Exception e) {
                LOGGER.debug("代理IP检测结果：{}", e);
            }
        }
    }

    static class Fetch implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    fetchByBill();
                } catch (Exception e) {
                    LOGGER.error("获取新的代理IP出错：", e);
                } finally {
                    ThreadUtil.sleep(Config.FETCH_PROXY_TIME_INTERVAL);
                }
            }
        }
    }

    static class Info implements Runnable {
        @Override
        public void run() {
            while (true) {
                LOGGER.info("待验证的代理IP{}个---验证过的代理IP{}个", WAITING_FOR_CHECK.size(), BY_BILL.size());
                ThreadUtil.sleep(1000);
            }
        }
    }

    static {
        Thread fetch = new Thread(new Fetch(), "Fetch");
        fetch.setDaemon(true);
        fetch.start();

        Thread info = new Thread(new Info(), "Info");
        info.setDaemon(true);
        info.start();

        Thread addToCheckPool = new Thread(new AddToCheckPool(), "AddToCheckPool");
        addToCheckPool.setDaemon(true);
        addToCheckPool.start();
    }

    private static List<ProxyServer> list(List<GBJProxy.Proxy> proxyList) {
        List<ProxyServer> proxyServerList = new LinkedList<>();

        for (GBJProxy.Proxy proxy : proxyList) {
            ProxyServer proxyServer = new ProxyServer();
            proxyServer.setIp(proxy.ip);
            proxyServer.setPort(proxy.port);

            proxyServerList.add(proxyServer);
        }

        return proxyServerList;
    }

    private static void fetchByBill() {
        String ipListJSONStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_LIST_URL);

        GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

        List<ProxyServer> proxyServerList = list(gbjProxy.data);

        for (ProxyServer proxyServer : proxyServerList) {
            if ( !WAITING_FOR_CHECK.contains(proxyServer) ) {
                WAITING_FOR_CHECK.add(proxyServer);
            }
        }

        LOGGER.info("付费渠道获取到{}代理IP", proxyServerList.size());
    }

    public static BlockingQueue<ProxyServer> byBill() {
        return BY_BILL;
    }

    public static void main(String[] args) throws IOException {
    }

}
