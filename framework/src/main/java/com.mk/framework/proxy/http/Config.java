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
    public static final Integer FETCH_TIMEOUT = 2500;
    public static final Integer READ_TIMEOUT = 10000;
    /**
     * 检测其他网站是否将代理IP添加到该网站黑名单的网站地址
     */
    public static final ImmutableSet<String> TEST_URL = ImmutableSet.of(
            "http://pad.qunar.com/api/hotel/"
    );
    /**
     * 眯客自己的代理IP列表资源地址
     */
    public static final String IMIKE_PROXY_IP_LIST_URL = "http://dev-bypass.imike.cn/ip.json";
    /**
     * 付费IP代理提取地址
     */
    public static final String BILL_PROXY_IP_LIST_URL = "http://api.goubanjia.com/api/get.shtml?order=7fad4d177bdcd13da3ae957aef770bd5&num=500&carrier=0&protocol=1&an1=1&an2=2&sp1=1&sp2=2&sp3=3&sort=1&system=1&distinct=0&rettype=0&seprator=%0D%0A&f_loc=1&f_anoy=1&f_speed=1";
    /**
     * 眯客BI提供的代理提取地址
     */
    public static final String IMIKE_BI_PROXY_IP_LIST_URL = "http://xvre.daili666api.com/ip/?tid=556890485581990&num=20&operator=1&delay=1&sortby=time&foreign=none&filter=on";

}
