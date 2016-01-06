package com.mk.framework.proxy.server;


import com.mk.framework.proxy.http.HttpUtil;

import java.util.List;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class ProxyServerFetch {

    public List<ProxyServer> byMike() {

        String ipListJSONStr = HttpUtil.doGetWithoutProxy("http://zetas-app.oss-cn-shanghai.aliyuncs.com/ip.json");

        return null;
    }

}
