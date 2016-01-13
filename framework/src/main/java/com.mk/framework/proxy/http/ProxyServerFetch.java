package com.mk.framework.proxy.http;

import org.slf4j.Logger;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerFetch {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerFetch.class);

    private static final BlockingQueue<ProxyServer> BY_MIKE = new LinkedBlockingQueue<>();
    private static final BlockingQueue<ProxyServer> BY_BILL = new LinkedBlockingQueue<>();

    static {
        Thread thread = new Thread() {
            public void run() {
                while (true) {
                    try {
                        fetchByBill();
                        fetchByMike();
                    } catch (Exception e) {
                        LOGGER.error("获取新的代理IP出错：", e);
                    }
                    ThreadUtil.sleep(Config.FETCH_PROXY_TIME_INTERVAL);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
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

    private static void fetchByMike() {
        String ipListJSONStr = HttpUtil.doGetNoProxy(Config.IMIKE_PROXY_IP_LIST_URL);

        GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

        List<ProxyServer> proxyServerList = list(gbjProxy.data);

        for (ProxyServer proxyServer : proxyServerList) {
           if ( !BY_MIKE.contains(proxyServer) ) {
               BY_MIKE.add(proxyServer);
           }
        }

        LOGGER.info("眯客代理IP队列里面有{}个元素", BY_MIKE.size());
    }

    private static void fetchByBill() {
        String ipListJSONStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_LIST_URL);

        GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

        List<ProxyServer> proxyServerList = list(gbjProxy.data);

        for (ProxyServer proxyServer : proxyServerList) {
            if ( !BY_BILL.contains(proxyServer) ) {
                BY_BILL.add(proxyServer);
            }
        }

        LOGGER.info("付费渠道代理IP队列里面有{}个元素", BY_BILL.size());
    }

    public static BlockingQueue<ProxyServer> byMike() {
        return BY_MIKE;
    }

    public static BlockingQueue<ProxyServer> byBill() {
        return BY_BILL;
    }

    public static void main(String[] args) throws IOException {
    }

}
