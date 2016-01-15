package com.mk.framework.manager;

/**
 * Created by 振涛 on 2015/12/25.
 */
public class RedisCacheName {

    /**
     * 存储被加入黑名单的代理IP的SET的KEY
     */
    public static final String CRAWLER_BAD_PROXY_SERVER_POOL_SET = "CRAWLER:BAD:PROXY_SERVER_POOL:SET";

    /**
     * 待刷新酒店价格所在城市的SET
     */
    public static final String CRAWLER_CITY_NAME_SET = "CRAWLER:CITY:NAME:SET";

    /**
     * 待刷新酒店价格的酒店ID列表
     */
    public static final String CRAWLER_HOTEL_INFO_REFRESH_SET = "CRAWLER:HOTEL:INFO:REFRESH:SET";

    /**
     * 正在刷新酒店价格的酒店ID列表
     */
    public static final String CRAWLER_HOTEL_INFO_REFRESHING_SET = "CRAWLER:HOTEL:INFO:REFRESHING:SET";

    /**
     * 待检测有效性的代理IP集合
     */
    public static final String CRAWLER_PROXY_IP_UNCHECK_SET = "CRAWLER:PROXY_IP:UN_CHECK_SET";
    /**
     * 有效性的代理IP集合
     */
    public static final String CRAWLER_PROXY_IP_CHECKED_SET = "CRAWLER:PROXY_IP:CHECKED_SET";

    /********动态价格-OTA价格***********/
    public static final String DYNAMIC_PRICE_OTA = "DYNAMIC:PRICE:OTA:";
    /********动态价格-协议价***********/
    public static final String DYNAMIC_PRICE_AGREEMENT = "DYNAMIC:PRICE:AGREEMENT:";
    /********动态价格-mike价***********/
    public static final String DYNAMIC_PRICE_MK = "DYNAMIC:PRICE:MK:";
    /********动态价格-门市价***********/
    public static final String DYNAMIC_PRICE_MARKET = "DYNAMIC:PRICE:MARKET:";

}
