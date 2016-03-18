package com.mk.framework.proxy.server;

import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.Config;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.RedisUtil;
import com.mk.framework.proxy.http.HttpUtil;
import org.slf4j.Logger;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by 振涛 on 2016/1/6.
 */
@Component
public class ProxyServerFetch implements ApplicationListener<ContextRefreshedEvent> {

    private static final String CHECK_URL = "https://www.baidu.com/";

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerFetch.class);

    private static ThreadPoolExecutor EXECUTOR;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        initExecutor();

        addToThreadPool();

        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                EXECUTOR.shutdown();
                LOGGER.info("检测代理IP是否有效的线程池关闭");
            }
        });
    }

    static class ProxyServerFetchThreadFactory implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        public ProxyServerFetchThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null)? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = "Proxy-server-fetch-pool-" + poolNumber.getAndIncrement() + "-thread-";
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

    static class Fetch implements Runnable {
        @Override
        public void run() {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    try {
                        //fetchByBillGBJ();
                        fetchByBillKDL();
                        //fetchByBillDL666();
                    } finally {
                        TimeUnit.MILLISECONDS.sleep(Config.FETCH_PROXY_TIME_INTERVAL);
                    }
                } catch (InterruptedException e) {
                }
            }
        }

        private static void fetchByBillGBJ() {
            try {
                String ipListJSONStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_API_GBJ);

                GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

                List<ProxyServer> proxyServerList = new LinkedList<>();

                for (GBJProxy.Proxy proxy : gbjProxy.data) {
                    ProxyServer proxyServer = new ProxyServer();
                    proxyServer.setIp(proxy.ip);
                    proxyServer.setPort(proxy.port);

                    proxyServerList.add(proxyServer);
                }

                addToWaitForCheckQueue(proxyServerList);

                LOGGER.info("付费渠道GBJ获取到{}代理IP", proxyServerList.size());
            } catch (Exception e) {
                LOGGER.error("获取代理IP发生错误", e);
            }
        }

        private static void fetchByBillKDL() {
            try {
                String ipListJSONStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_API_KDL);

                KDLProxy kdlProxy = JSONUtil.fromJson(ipListJSONStr, KDLProxy.class);

                List<ProxyServer> proxyServerList = new LinkedList<>();

                for (String s : kdlProxy.data.proxy_list) {
                    String[] temp = s.split(":");

                    ProxyServer proxyServer = new ProxyServer();
                    proxyServer.setIp(temp[0]);
                    proxyServer.setPort(Integer.valueOf(temp[1]));

                    proxyServerList.add(proxyServer);
                }

                addToWaitForCheckQueue(proxyServerList);

                LOGGER.info("付费渠道快代理获取到{}代理IP", proxyServerList.size());
            } catch (Exception e) {
                LOGGER.error("获取代理IP发生错误", e);
            }
        }

        private static void fetchByBillDL666() {
            try {
                String ipListStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_API_DL666);

                String[] proxyArray = ipListStr.split("\\r\\n");

                List<ProxyServer> proxyServerList = new LinkedList<>();

                for (String s : proxyArray) {
                    String[] temp = s.split(":");

                    ProxyServer proxyServer = new ProxyServer();
                    proxyServer.setIp(temp[0]);
                    proxyServer.setPort(Integer.valueOf(temp[1]));

                    proxyServerList.add(proxyServer);
                }

                addToWaitForCheckQueue(proxyServerList);

                LOGGER.info("付费渠道代理666获取到{}代理IP", proxyServerList.size());
            } catch (Exception e) {
                LOGGER.error("获取代理IP发生错误", e);
            }
        }

        private static void addToWaitForCheckQueue(List<ProxyServer> proxyServerList) {
            Jedis jedis = RedisUtil.getJedis();

            for (ProxyServer proxyServer : proxyServerList) {
                String jsonStr = JSONUtil.toJson(proxyServer);
                jedis.sadd(RedisCacheName.CRAWLER_PROXY_IP_UN_CHECK_SET, jsonStr);
                jedis.sadd(RedisCacheName.CRAWLER_PROXY_IP_ALL_UN_CHECK_SET, jsonStr);
            }

            RedisUtil.close(jedis);
        }
    }


    static class AddToCheckingPool implements Runnable {
        @Override
        public void run() {
            Jedis jedis = null;
            try {
                jedis = RedisUtil.getJedis();

                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String jsonStr = jedis.spop(RedisCacheName.CRAWLER_PROXY_IP_UN_CHECK_SET);

                        if ( StringUtils.isEmpty(jsonStr) ) {
                            TimeUnit.SECONDS.sleep(1);
                        } else {
                            ProxyServer proxyServer = JSONUtil.fromJson(jsonStr, ProxyServer.class);

                            Check check = new Check(proxyServer);

                            try {
                                EXECUTOR.execute(check);
                            } catch (RejectedExecutionException e) {
                                TimeUnit.SECONDS.sleep(1);
                            }
                        }
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            } finally {
                RedisUtil.close(jedis);
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
            if (Thread.currentThread().isInterrupted()) {
                return;
            }

            Jedis jedis = null;
            try {
                URL url = new URL(CHECK_URL);

                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyServer.getIp(), proxyServer.getPort()));

                url.openConnection(proxy);

                jedis = RedisUtil.getJedis();

                jedis.sadd(RedisCacheName.CRAWLER_PROXY_IP_CHECKED_SET, JSONUtil.toJson(proxyServer));
            } catch (Exception e) {
                LOGGER.debug("代理IP检测结果：{}", e);
            } finally {
                RedisUtil.close(jedis);
            }
        }
    }

    private static void initExecutor() {
        LOGGER.info("初始化线程池");
        if ( EXECUTOR != null ) {
            EXECUTOR.shutdown();
        }

        EXECUTOR = new ThreadPoolExecutor(
                Config.CHECK_PROXY_THREAD_COUNT,
                Config.CHECK_PROXY_THREAD_COUNT,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(Config.UN_CHECK_PROXY_IP_QUEUE_SIZE),
                new ProxyServerFetchThreadFactory());
    }

    private static void addToThreadPool() {
        EXECUTOR.execute(new Fetch());
        EXECUTOR.execute(new AddToCheckingPool());
    }

    public static void main(String[] args) throws IOException {
        Fetch.fetchByBillGBJ();
        Fetch.fetchByBillKDL();
        Fetch.fetchByBillDL666();
    }

}
