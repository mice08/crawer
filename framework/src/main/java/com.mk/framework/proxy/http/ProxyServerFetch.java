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

            List proxyList = JSONUtil.fromJson(ipListJSONStr, List.class);

            for (Object o : proxyList) {
                String proxy = String.valueOf(o);
                String[] proxyTemp = proxy.split(":");

                ProxyServer proxyServer = new ProxyServer();
                proxyServer.setIp(proxyTemp[0]);
                proxyServer.setPort(Integer.valueOf(proxyTemp[1]));

                proxyServerList.add(proxyServer);
            }
        } catch (IOException e) {
            LOGGER.error("获取眯客的代理IP列表出错：", e);
        }

        return proxyServerList;
    }

    public static void main(String[] args) throws IOException {
        List<ProxyServer> proxyServerList = byMike();
        for (ProxyServer proxyServer : proxyServerList) {
            LOGGER.info("代理IP：{}", JSONUtil.toJson(proxyServer));
        }
    }

}
