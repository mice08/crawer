package com.mk.framework.proxy.http;

import org.slf4j.Logger;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerFetch {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerFetch.class);

    private static final List<ProxyServer> BY_MIKE = new CopyOnWriteArrayList<>();
    private static final List<ProxyServer> BY_BILL = new CopyOnWriteArrayList<>();

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
                    ThreadUtil.sleep(60000);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
    }

    private static List<ProxyServer> list(List<GBJProxy.Proxy> proxyList) {
        List<ProxyServer> proxyServerList = new LinkedList<>();

        for (GBJProxy.Proxy proxy : proxyList) {
            Jedis jedis = null;

            try {
                ProxyServer proxyServer = new ProxyServer();
                proxyServer.setIp(proxy.ip);
                proxyServer.setPort(proxy.port);

                proxyServerList.add(proxyServer);
            } catch (Exception e) {
                LOGGER.info("过滤坏代理IP时发生发送错误：", e);
            } finally {
                if ( jedis != null ) {
                    jedis.close();
                }
            }
        }

        return proxyServerList;
    }

    private static void fetchByMike() {
        String ipListJSONStr = HttpUtil.doGetNoProxy(Config.IMIKE_PROXY_IP_LIST_URL);

        GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

        List<ProxyServer> proxyServerList = list(gbjProxy.data);

        BY_MIKE.clear();
        BY_MIKE.addAll(proxyServerList);
        LOGGER.info("从眯客获取到{}个代理IP", BY_MIKE.size());
    }

    private static void fetchByBill() {
        String ipListJSONStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_LIST_URL);

        GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

        List<ProxyServer> proxyServerList = list(gbjProxy.data);

        BY_BILL.clear();
        BY_BILL.addAll(proxyServerList);
        LOGGER.info("从付费渠道获取到{}个代理IP", BY_BILL.size());
    }

    public static List<ProxyServer> byMike() {
        return BY_MIKE;
    }

    public static List<ProxyServer> byBill() {
        return BY_BILL;
    }

    public static void main(String[] args) throws IOException {
        List<ProxyServer> proxyServerList = byMike();
//        List<ProxyServer> proxyServerList = byBill();
//        List<ProxyServer> proxyServerList = byMikeBI();
        for (ProxyServer proxyServer : proxyServerList) {
            LOGGER.info("代理IP：{}", JSONUtil.toJson(proxyServer));
        }
    }

}
