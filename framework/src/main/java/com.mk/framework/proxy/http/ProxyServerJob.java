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
            }
        }
    }

    public static void fetchAndAdd() {
        List<ProxyServer> proxyServerList = ProxyServerFetch.byBill();
        for (ProxyServer proxyServer : proxyServerList) {
            if ( !ProxyServerManager.isExist(proxyServer) ) {
                ProxyServerManager.add(proxyServer);
            }
        }
    }

}
