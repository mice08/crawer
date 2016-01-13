package com.mk.framework.manager;

/**
 * Created by 振涛 on 2015/12/25.
 */
public class RedisCacheName {

    /**
     * 存储被加入黑名单的代理IP的SET的KEY
     */
    public static final String CRAWER_BAD_PROXY_SERVER_POOL_SET = "crawer_bad_proxy_server_pool_set";

    /**
     * 待刷新酒店价格所在城市的SET
     */
    public static final String CRAWER_CITY_NAME_SET = "crawer_city_list_and_city_name";

    /**
     * 待刷新酒店价格的酒店ID列表
     */
    public static final String CRAWER_HOTEL_INFO_REFRESH_SET = "crawer_hotel_info_refresh_set";

    public static final String CRAWER_HOTEL_INFO_REFRESH_THREAD_SET = "crawer_hotel_info_refresh_thread_set";

    /**
     * 正在刷新酒店价格的酒店ID列表
     */
    public static final String CRAWER_HOTEL_INFO_REFRESHING_SET = "crawer_hotel_info_refreshing_set";

    /********动态价格-OTA价格***********/
    public static final String DYNAMIC_PRICE_OTA = "DYNAMIC:PRICE:OTA";
    /********动态价格-协议价***********/
    public static final String DYNAMIC_PRICE_AGREEMENT = "DYNAMIC:PRICE:AGREEMENT";
    /********动态价格-mike价***********/
    public static final String DYNAMIC_PRICE_MK = "DYNAMIC:PRICE:MK";
    /********动态价格-门市价***********/
    public static final String DYNAMIC_PRICE_MARKET = "DYNAMIC:PRICE:MARKET";

}
