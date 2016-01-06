package com.mk.framework;

import org.slf4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * 地址管理工具
 * @author zzy
 *
 */
public class UrlUtils {
	private static Logger logger = org.slf4j.LoggerFactory.getLogger(UrlUtils.class);

	public static Map<String, String> urls = new HashMap<String, String>();
	static {
		reloadYml();
	}

	/**
	 * 获取url
	 * @param key 格式newpms.url、ots.url
	 * @return
	 */
	public static String getUrl(String key) {
		
		String hessianURL = urls.get(key);
		return hessianURL;
	}
	
	public static void reloadYml(){
		try {
			PropertiesUtil pro = new PropertiesUtil();
			pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("common_urls.properties"));
			urls = pro.getMap();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
