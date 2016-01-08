package com.mk.framework.proxy.http;

import org.slf4j.Logger;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerFetch {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HttpUtil.class);

    public static List<ProxyServer> byMike() {
        List<ProxyServer> proxyServerList = new LinkedList<>();

            String ipListJSONStr = HttpUtil.doGetNoProxy(Config.IMIKE_PROXY_IP_LIST_URL);

            GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

            for (GBJProxy.Proxy proxy : gbjProxy.data) {
                ProxyServer proxyServer = new ProxyServer();
                proxyServer.setIp(proxy.ip);
                proxyServer.setPort(proxy.port);

                proxyServerList.add(proxyServer);
            }


        return proxyServerList;
    }

    public static List<ProxyServer> byBill() {
        List<ProxyServer> proxyServerList = new LinkedList<>();


            String ipListJSONStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_LIST_URL);

            GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

            for (GBJProxy.Proxy proxy : gbjProxy.data) {
                ProxyServer proxyServer = new ProxyServer();
                proxyServer.setIp(proxy.ip);
                proxyServer.setPort(proxy.port);

                proxyServerList.add(proxyServer);
            }


        return proxyServerList;
    }

    public static void main(String[] args) throws IOException {
//        List<ProxyServer> proxyServerList = byMike();
        List<ProxyServer> proxyServerList = byBill();
//        List<ProxyServer> proxyServerList = byMikeBI();
        for (ProxyServer proxyServer : proxyServerList) {
            LOGGER.info("代理IP：{}", JSONUtil.toJson(proxyServer));
        }
    }

}
