package com.mk.framework.manager;

/**
 * Created by 振涛 on 2015/12/25.
 */
public class RedisCacheName {

    /**
     * 存储微信授权信息的MAP的KEY
     */
    public static final String W_HOTEL_WE_CHAT_AUTHORIZATION_MAP = "w_hotel_we_chat_authorization_map";

    /**
     * 存储获取其他网站酒店信息的代理IP的SET的KEY
     */
    public static final String CRAWER_PROXY_SERVER_POOL_SET = "crawer_proxy_server_pool_set";

    /**
     * 存储获取其他网站酒店信息的代理IP的SET的KEY
     */
    public static final String CRAWER_BAD_PROXY_SERVER_POOL_SET = "crawer_bad_proxy_server_pool_set";


    public static final String CRAWER_CITY_NAME_SET = "crawer_city_list_and_city_name";

    public static final String CRAWER_HOTEL_INFO_REFRESH_THREAD_SET = "crawer_hotel_info_refresh_thread_set";
    /********动态价格-OTA价格***********/
    public static final String DYNAMIC_PRICE_OTA = "DYNAMIC:PRICE:OTA";
    /********动态价格-协议价***********/
    public static final String DYNAMIC_PRICE_AGREEMENT = "DYNAMIC:PRICE:AGREEMENT";
    /********动态价格-mike价***********/
    public static final String DYNAMIC_PRICE_MK = "DYNAMIC:PRICE:MK";
    /********动态价格-门市价***********/
    public static final String DYNAMIC_PRICE_MARKET = "DYNAMIC:PRICE:MARKET";


}
