package com.mk.crawer.biz.utils;


import java.util.HashMap;
import java.util.Map;

/**
 * @author shellingford
 * @version 创建时间：2013-1-3 上午10:54:52
 * 
 */
public class Constant {
	//session中的绑定值
	public static final String MySessionName="mysession_object";
	public static final String sysConfigService = "sysConfigService";
	public static final String chatMessagesService = "chatMessagesService";
	//系统配置type
	public static final String systype="sys";
	public static final String miketype="mike";
	public static final String mikewebtype="mikeweb";
	public static final String defaulCharset = "UTF-8";
	
	//城市地址 证件配置
	public static final String  ota_config_province = "ota_config_province";
	public static final String  ota_config_city_ = "ota_config_city_";
	public static final String  ota_config_dis_ = "ota_config_dis_";
	public static final String ota_config_hotcity = "ota_config_hotcity";
	public static final String ota_config_allcity = "ota_config_allcity";
	public static final String  ota_config_cardtype = "ota_config_cardtype";
	
	public static final String ftpName="ftpname";
	public static final String ftpPsw="ftppassword";
	public static final String ftphost="ftphost";
	public static final String pichost="pichost";
	public static final String ftpport = "ftpport";
	public static final String ftppath = "ftppath";
	public static final String ftpnoshowremoteDir = "ftpnoshowremoteDir";
	
	public static final String ftpHuanxinFileHost= "ftpHuanxinFileHost";
	public static final String ftpHuanxinFilePath="ftpHuanxinFilePath";
	public static final String ftpHuanxinFileNoShowRemoteDir="ftpHuanxinFileNoShowRemoteDir";

	public static final String huanxinbaseurl = "huanxinbaseurl";
	public static final String huanxinorgName = "huanxinorgname";
	public static final String huanxinappName = "huanxinappname";
	public static final String huanxinClientId= "huanxinclientid";
	public static final String huanxinClientSercet = "huanxinclientsercet";
	public static final String huanxinAccessToken = "huanxinaccesstoken";
	public static final String huanxinApplication = "huanxinapplication";
	public static final String huanxinExpires = "huanxinexpires";
	public static final String huanxinAppKey = "huanxinappkey";
	
	public static final String aliPaynotify_url = "aliPaynotify_url";
	public static final String aliPayreturn_url = "aliPayreturn_url";
	public static final String aliPayseller_email = "aliPayseller_email";
	public static final String aliPaypartner = "aliPaypartner";
	public static final String aliPaykey = "aliPayKey";
	
	public static final String RESERVE_DAY_NUM = "reserveDayNum";//酒店预定天数
	public static final String MONTHLY_SALES_KEY = "ots2_5_monthly30_sales_key_";   //月销量
	public static final String MONTHLY_PMS_SALES_KEY = "ots3_2_monthly30_pms_sales_key_";   //月销量
	
	public static final String orderService="orderService";
	public static final String userService = "userService";
	public static final String hotelService = "hotelService";
	public static final String cityService = "cityService";
	public static final String roomTypeService = "roomTypeService";
	public static final String priceService = "priceService";
	public static final String payService="payService";
	public static final String loginService = "loginService";
	public static final String aboutService = "aboutService";
	public static final String aboutCtrl = "aboutCtrl";
	
	public static final String orderCtrl = "orderCtrl";
	public static final String hotelCtrl = "hotelCtrl";
	public static final String userCtrl = "userCtrl";
	public static final String roomTypeCtrl = "roomTypeCtrl";
	public static final String priceCtrl = "priceCtrl";
	public static final String payCtrl = "payCtrl";
	public static final String regCtrl = "regCtrl";
	public static final String regService = "regService";
	public static final String pageConfig = "pageConfig";//用来判断酒店过少时;一个酒店显示几个数据.
	
	public static final String memberCtrl = "memberCtrl";
	public static final String memberService = "memberService";
	public static final String mikeHessianWebUrl = "mikeHessianWebUrl";
	public static final String huanxinService = "huanxinService";
	public static final String mikewebPMSUrl= "mikewebPMSUrl";
	public static final String hotCityIds = "hotCityIds";
	public static final String logService = "logService";
	public static final String tokenService = "tokenService";
	public static final String loginTokenTime = "loginTokenTime";
	public static final String mikeweb_user_accesstoken = "mikeweb_user_accesstoken_";
	public static final String ftpUserCardPath="ftpUserCardPath";
	public static final String appService = "appService";
	
	public static final String jifenRateKey = "jifen";
	public static final String xiaozhentouRateKey = "xiaozhengtou";
	
	public static final String qiekeTime = "qiekeTime";
	
	public static final String APP_ID = "APP_ID";//微信开发平台应用id
	public static final String APP_SECRET = "APP_SECRET";//应用对应的凭证
	public static final String APP_KEY = "APP_KEY";//应用对应的密钥
	public static final String PARTNER = "PARTNER";//财付通商户号
	public static final String PARTNER_KEY = "PARTNER_KEY";//商户号对应的密钥
	public static final String tenpay_notify_url = "tenpay_notify_url";
	public static final String tenpay_access_token = "tenpay_access_token";
	public static final String tenpay_access_token_expires_in = "tenpay_access_token_expires_in";
	public static final String payFunction = "payFunction";
	public static final String orderCheck ="orderCheck";
	public static final String splitTime ="splitTime";
	public static final String defaultPageSize = "defaultPageSize";
	public static final String maxSelectDay = "maxSelectDay";
	public static final String checkPayErrorTitle = "checkPayErrorTitle";
	public static final String maxprice="maxprice"; //全局配置最大价格
	
	public static final String mikeweb_jsonconfig = "mikeweb_jsonconfig";//全局配置缓存
	public static final String weixinpublic_token="weixinpublic_token";
	public static final String weixinpublic_encodingAESKey="weixinpublic_encodingAESKey";
	public static final String weixinpublic_appid="weixinpublic_appid";
	public static final String weixinpublic_appsecret="weixinpublic_appsecret";
	public static final String mikeweb_weixinpublic_access_token="mikeweb_weixinpublic_access_token";
	public static final String mikeweb_weixinpublic_access_token_expire_in="mikeweb_weixinpublic_access_token_expire_in";

	
	public static final String qieketicketno = "qieketicketno";
	public static final String yijiaticketno = "yijiaticketno";
	public static final String hmWebUrl = "hmWebUrl";
	public static final String messageDebug = "messageDebug";
	public static final String maplevel = "maplevel";
	public static final String online = "online";
	public static final String messageCodeTime = "messageCodeTime";//验证码校验有效时间
	public static final String testStr = "TEST";
	public static final String tokenCtrl="tokenCtrl";
	public static final String qiekeHtmlLimit = "qiekeHtmlLimit";
	public static final String qiekeOnlineLimit = "qiekeOnlineLimit";
	public static final String qiekeOfflineLimit = "qiekeOfflineLimit";
	public static final String qiekeLimitDays = "qiekeLimitDays";
	public static final String phptype  = "php_";
	public static final String phpips = "phpips";
	public static final String phpipsdebug="phpipsdebug";
	
	public static final String testMids = "testMids";
	public static final String cancelTime="cancelTime";
	public static final String NOCAPTCHA="NOCAPTCHA";
	public static final int pmsLogDays = 15;
	public static final String WX_TEST_DEBUG="WX_TEST_DEBUG";
	
	//同步房间使用，初始化户型下的设施
	public static final String mikeweb = "mikeweb";
	public static final String initTFacility = "initTFacility";
	
	/** 字符串 true 标识符 */
	public static final String STR_TRUE = "T";
	/** 字符串 false 标识符 */
	public static final String STR_FALSE = "F";
	/** 字符串 上海的cityid */
	public static final String STR_CITYID_SHANGHAI = "310000";
	/** 字符串 重庆的城市code */
	public static final String STR_CITYCODE_CHONGQING = "500000";
	/** 上海市经纬度坐标值 */
	public static final double LAT_SHANGHAI = 31.23817630;
	public static final double LON_SHANGHAI = 121.46926880;
	/** 内部私有token */
	public static final String STR_INNER_TOKEN = "1qaz2wsx";
	
	/** 酒店搜索默认距离：3千米 */
	public static final double DISTANCE_DEFAULT_KM = 3;
	/** 酒店搜索默认距离：3000米 */
	public static final double DISTANCE_DEFAULT_M = 3000;
	
	/** 酒店搜索最大距离：300千米 */
	public static final double DISTANCE_MIX_KM = 300;
	/** 酒店搜索最大距离：300000米 */
	public static final double DISTANCE_MAX_M = 300000;
	
	/** 
     * 已经定房间 cacheName 前缀
     * 且用时需加城市 code 
     * */
    public static final String CACHENAME_BOOKEDROOM_PRE="RM~";  
    public static final String CACHENAME_SEPARATOR="~";
    
    /**
     * 10+1活动券
     */
    public static final long ACTIVE_10YUAN_1=5L;
    /**
     * 15元体验券
     */
    public static final long ACTIVE_15YUAN=6L;
    /**
     * 100元体验券
     */
    public static final long ACTIVE_100YUAN=14L;
    /**
     * 77元七夕特享券
     */
    public static final long ACTIVE_QIXI=18L;
    
    /**
     * 30元重庆B规则活动
     */
    public static final long ACTIVE_B_30YUAN=15L;
    /**
     * 住三送一活动券，A、B规则都适用
     */
    public static final long LIVE_THREE_ACTIVE=17L;
    /**
     * 新手优惠券
     */
    public static final long ACTIVE_NEW_USER=1L;

	public static final Integer TONIGHT_PROMO_VIEWTYPE = 3;

	public static final String WEIXIN_CALLMETHOD = "3";
	public static final String IOS_CALLMETHOD = "4";
	public static final String ANDROID_CALLMETHOD = "5";

	public static final Integer ANDROID_PLATFORM = 1;

	public static final Integer IOS_PLATFORM = 2;

	public static final Integer WEIXIN_PLATFORM = 4;

	public static final Integer CITY_RECOMMEND_ITEM_LIMIT = 4;
	public static final Integer CITY_RECOMMEND_HOMEPAGE_SHORTCUT_LIMIT = 3;
	public static final Integer RECOMMEND_ITEM_LIMIT = 7;

	public static final Integer RECOMMEND_GLOBAL = -1;

	public static final Integer PROMO_FININSHED = -1;

	public static final Integer PROMOING = 1;

	public static final Integer PROMO_NOT_START = 0;
	public static final Integer DEFENSE_ZERO_PRICE = 9999;


	public static final Integer PROMO_BANNER_PROMO = 3;
	public static final Integer PROMO_BANNER_ONE_PROMO = 6;


	public static final Integer ACTIVE_CHANCE = 1;

	public static final String ACTIVE_NOTE = "您已经参与过该活动， 不能重复参与！";

	public static final Integer QIE_KE_SPREAD_USER = -1;
	/**每日多少新人单需要给酒店老板返收益的**/
	public static final Integer QIE_KE_TOP_NUM = 10;
	/**B+规则 切客收益覆盖城市**/
	public static final Map<String,String> QIE_KE_CITY_MAP = new HashMap<>();
	static {
		QIE_KE_CITY_MAP.put("410300", "410300");//洛阳
		QIE_KE_CITY_MAP.put("430100", "430100");//长沙
	}

	//非特价城市首页文案默认值

	public static final String DEFAULT_NORMAL_DISTANCE_TEXT = "最近距离";
	public static final String DEFAULT_NORMAL_DISTANCE_NOTE = "";
	public static final String DEFAULT_NORMAL_DISTANCE_ICON = "";


	public static final String DEFAULT_NORMAL_CHEAPEST_TEXT = "最便宜";
	public static final String DEFAULT_NORMAL_CHEAPEST_NOTE = "";
	public static final String DEFAULT_NORMAL_CHEAPEST_ICON = "";


	public static final String DEFAULT_NORMAL_POPULARITY_TEXT = "最受欢迎";
	public static final String DEFAULT_NORMAL_POPULARITY_NOTE = "";
	public static final String DEFAULT_NORMAL_POPULARITY_ICON = "";
	public static final Integer SHOW_HOTEL_REPAIRINFO_YEARS_LIMIT = 3;


	public static final String HOTEL_HIGHLIGHT_SHOWS_IDS ="44";
	public static final String RECOMMEND_LOADDING_POSITION = "APP-LOADING";
	public static final String RECOMMEND_HOMEPAGE_SHORTCUT_POSITION = "HOMEPAGE-SHORTCUT";

	public static final Double NANJI_POINT_LAT = -140.976563;
	public static final Double NANJI_POINT_LON = -88.075329;

	public static String qunar_touch_hostlist = new PropertiesUtil().getValue("common.properties", "qunar.touch.hostlist");
	public static String qunar_map_hostlist = new PropertiesUtil().getValue("common.properties", "qunar.map.hostlist");
	public static String gd_hotelList = new PropertiesUtil().getValue("common.properties", "gd.hotelList");
	public static String gd_hotelReview = new PropertiesUtil().getValue("common.properties", "gd.hotelReview");

	public static final String sysUser="sys";

}
