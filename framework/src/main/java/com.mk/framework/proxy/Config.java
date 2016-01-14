package com.mk.framework.proxy;

import com.google.common.collect.ImmutableSet;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class Config {

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
     * api.goubanjia.com
     */
    public static final String BILL_PROXY_IP_API_GBJ = "http://api.goubanjia.com/api/get.shtml?order=7fad4d177bdcd13da3ae957aef770bd5&num=10000&carrier=0&protocol=0&an1=1&an2=2&sp1=1&sp2=2&sp3=3&sort=1&distinct=0&rettype=0&seprator=%0D%0A&f_loc=1&f_anoy=1&f_speed=1";
    /**
     * 付费IP代理提取地址
     * svip.kuaidaili.com
     */
    public static final String BILL_PROXY_IP_API_KDL = "http://svip.kuaidaili.com/api/getproxy/?orderid=985277419450057&num=9999&protocol=1&method=1&an_an=1&an_ha=1&format=json&sep=1";
    /**
     * 付费IP代理提取地址
     * svip.kuaidaili.com
     */
    public static final String BILL_PROXY_IP_API_DL666 = "http://xvre.daili666api.com/ip/?tid=556875355340186&num=10000";
    /**
     * 每次通过API获取代理IP的时间间隔，单位：毫秒
     */
    public static final Integer FETCH_PROXY_TIME_INTERVAL = 2*60*1000;
    /**
     * 用来检测代理IP是否有效的线程数量
     */
    public static final Integer CHECK_PROXY_THREAD_COUNT = 100;

}
