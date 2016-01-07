package com.mk.framework.proxy.http;

import com.google.common.collect.ImmutableSet;

/**
 * Created by 振涛 on 2016/1/6.
 */
class Config {

    /**
     * 通过API提取其他网站价格数据重试次数--单位：次数
     */
    public static final Integer FETCH_RETRY_TIMES = 3;
    /**
     * 通过API提取其他网站价格数据超时时间--单位：毫秒
     */
    public static final Integer FETCH_TIMEOUT = 10000;
    /**
     * 检测其他网站是否将代理IP添加到该网站黑名单的网站地址
     */
    public static final ImmutableSet<String> TEST_URL = ImmutableSet.of(
            "http://pad.qunar.com/api/hotel/",
            "http://touch.qunar.com/h5/hotel/"
    );
    /**
     * 眯客自己的代理IP列表资源地址
     */
    public static final String IMIKE_PROXY_IP_LIST_URL = "http://zetas-app.oss-cn-shanghai.aliyuncs.com/ip.json";
    /**
     * 付费IP代理提取地址
     */
    public static final String BILL_PROXY_IP_LIST_URL = "http://api.goubanjia.com/api/get.shtml?order=7fad4d177bdcd13da3ae957aef770bd5&num=20&area=%E4%B8%AD%E5%9B%BD&carrier=0&protocol=1&an1=1&sp1=1&sp2=2&sp3=3&sort=1&system=1&distinct=0&rettype=0&seprator=%0D%0A";

}
