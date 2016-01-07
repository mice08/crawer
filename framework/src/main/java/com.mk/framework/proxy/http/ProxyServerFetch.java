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

        try {
            String ipListJSONStr = HttpUtil.doGetNoProxy(Config.IMIKE_PROXY_IP_LIST_URL);

            GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

            for (GBJProxy.Proxy proxy : gbjProxy.data) {
                ProxyServer proxyServer = new ProxyServer();
                proxyServer.setIp(proxy.ip);
                proxyServer.setPort(proxy.port);

                proxyServerList.add(proxyServer);
            }
        } catch (IOException e) {
            LOGGER.error("获取眯客的代理IP列表出错：", e);
        }

        return proxyServerList;
    }

    public static List<ProxyServer> byBill() {
        List<ProxyServer> proxyServerList = new LinkedList<>();

        try {
            String ipListJSONStr = HttpUtil.doGetNoProxy(Config.BILL_PROXY_IP_LIST_URL);

            GBJProxy gbjProxy = JSONUtil.fromJson(ipListJSONStr, GBJProxy.class);

            for (GBJProxy.Proxy proxy : gbjProxy.data) {
                ProxyServer proxyServer = new ProxyServer();
                proxyServer.setIp(proxy.ip);
                proxyServer.setPort(proxy.port);

                proxyServerList.add(proxyServer);
            }
        } catch (IOException e) {
            LOGGER.error("获取眯客的代理IP列表出错：", e);
        }

        return proxyServerList;
    }

    public static List<ProxyServer> byMikeBI() {
        List<ProxyServer> proxyServerList = new LinkedList<>();

        try {
            String ipListStr = HttpUtil.doGetNoProxy(Config.IMIKE_BI_PROXY_IP_LIST_URL);

            String[] ipListStrArray = ipListStr.split("123");

            for (String proxy : ipListStrArray) {
                String[] temp = proxy.split(":");

                if ( temp.length == 2 ) {
                    ProxyServer proxyServer = new ProxyServer();
                    proxyServer.setIp(temp[0]);
                    proxyServer.setPort(Integer.valueOf(temp[1]));

                    proxyServerList.add(proxyServer);
                }
            }
        } catch (IOException e) {
            LOGGER.error("获取眯客的代理IP列表出错：", e);
        }

        return proxyServerList;
    }

    public static void main(String[] args) throws IOException {
//        List<ProxyServer> proxyServerList = byMike();
//        List<ProxyServer> proxyServerList = byBill();
        List<ProxyServer> proxyServerList = byMikeBI();
        for (ProxyServer proxyServer : proxyServerList) {
            LOGGER.info("代理IP：{}", JSONUtil.toJson(proxyServer));
        }
    }

}
