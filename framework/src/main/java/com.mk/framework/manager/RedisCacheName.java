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
     * 待刷新酒店图片所在城市的SET
     */
    public static final String CRAWLER_IMAGE_CITY_NAME_SET = "CRAWLER:IMAGECITY:NAME:SET";


    /**
     * 待刷新酒店价格的酒店ID列表
     */
    //优先爬虫酒店队列
    public static final String CRAWLER_HOTEL_FIRST_SET = "CRAWLER:HOTEL:FIRST:SET";

    //城市队列开关,0 使用slave队列  其他使用 master队列
    public static final String CRAWLER_HOTEL_CITY_REFRESH_SET_SWITCH = "CRAWLER:HOTEL:CITY:REFRESH:SET:SWITCH";

    //酒店城市master队列
    public static final String CRAWLER_HOTEL_CITY_REFRESH_SET_MASTER = "CRAWLER:HOTEL:CITY:REFRESH:SET:MASTER";

    //酒店城市master队列
    public static final String CRAWLER_HOTEL_CITY_REFRESH_SET_SLAVE = "CRAWLER:HOTEL:CITY:REFRESH:SET:SLAVE";

    //酒店master队列
    public static final String CRAWLER_HOTEL_INFO_REFRESH_SET = "CRAWLER:HOTEL:INFO:REFRESH:SET";

    //酒店slave队列
    public static final String CRAWLER_HOTEL_INFO_REFRESH_SET_SLAVE = "CRAWLER:HOTEL:INFO:REFRESH:SET:SLAVE";

    //错误队列 score 1 错误1次, score 错误2次 , score错误3次 ...
    public static final String CRAWLER_HOTEL_INFO_REFRESH_SET_ERROR = "CRAWLER:HOTEL:INFO:REFRESH:SET:ERROR";

//    /**
//     * 正在刷新酒店价格的酒店ID列表
//     */
//    public static final String CRAWLER_HOTEL_INFO_REFRESHING_SET = "CRAWLER:HOTEL:INFO:REFRESHING:SET";

    /**
     * 所有获取到的代理IP集合
     */
    public static final String CRAWLER_PROXY_IP_ALL_UN_CHECK_SET = "CRAWLER:PROXY_IP:ALL_UN_CHECK_SET";
    /**
     * 待检测有效性的代理IP集合
     */
    public static final String CRAWLER_PROXY_IP_UN_CHECK_SET = "CRAWLER:PROXY_IP:UN_CHECK_SET";
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

    /**
     * 开关：酒店信息刷新任务
     */
    public static final String CRAWLER_SWITCH_HOTEL_DETAIL_REFRESH_KEY = "CRAWLER:SWITCH:HOTEL_DETAIL_REFRESH_KEY";

    /**
     * city_name to cityCode
     */
    public static final String CITY_NAME_INFO = "CITY_NAME_INFO_";
}
