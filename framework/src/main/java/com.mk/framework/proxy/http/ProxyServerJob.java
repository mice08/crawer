package com.mk.framework.proxy.http;

import java.util.List;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerJob {

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
