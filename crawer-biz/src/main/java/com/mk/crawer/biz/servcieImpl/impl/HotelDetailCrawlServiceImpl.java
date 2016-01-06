package com.mk.crawer.biz.servcieImpl.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.HttpUtils;

public class HotelDetailCrawlServiceImpl {
	private final String hotelDetailUrl = "http://pad.qunar.com/api/hotel/hoteldetail?city=%s&cityUrl=%s&checkInDate=%s&checkOutDate=%s&keywords=&location=&seq=%s&clickNum=0&isLM=0&type=0&extra=%s";

	private final Logger logger = Logger.getLogger(HotelDetailCrawlServiceImpl.class);

	public void crawl(List<String> hotelIds, String city, String cityUrl) throws Exception {
		Date day = new Date();
		String strCurDay = DateUtils.getStringFromDate(day, DateUtils.FORMATSHORTDATETIME);
		String strNextDay = DateUtils.getStringFromDate(DateUtils.addDays(day, 1), DateUtils.FORMATSHORTDATETIME);

		String invokeUrl = String.format(hotelDetailUrl, "city", cityUrl);
		
		String jsonString = HttpUtils.doPost(hotelDetailUrl, new HashMap<String, String>());

		logger.debug(jsonString);
	}
}
