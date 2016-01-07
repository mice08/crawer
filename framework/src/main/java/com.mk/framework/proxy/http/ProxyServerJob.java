package com.mk.framework.proxy.http;

import org.slf4j.Logger;

import java.util.List;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerJob {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ProxyServerJob.class);

    public static void validAndRemove() {
        List<ProxyServer> proxyServerList = ProxyServerManager.listProxyServer();
        for (ProxyServer proxyServer : proxyServerList) {
            if ( !ProxyServerManager.check(proxyServer) ) {
                ProxyServerManager.remove(proxyServer);
                LOGGER.info("移除：{}，还有{}个代理IP。", JSONUtil.toJson(proxyServer), ProxyServerManager.count());
            }
        }
    }

    public static void fetchAndAdd() {
        List<ProxyServer> proxyServerList = ProxyServerFetch.byBill();
        for (ProxyServer proxyServer : proxyServerList) {
            ProxyServerManager.add(proxyServer);
            LOGGER.info("添加：{}，有{}个代理IP了。", JSONUtil.toJson(proxyServer), ProxyServerManager.count());
        }
    }

}
