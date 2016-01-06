package com.mk.crawer.biz.servcie.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;

import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.HttpUtils;

public class HotelDetailCrawlServiceImpl {
	private final String hotelDetailUrl = "http://pad.qunar.com/api/hotel/hoteldetail?city=%s&cityUrl=%s&checkInDate=%s&checkOutDate=%s&keywords=&location=&seq=%s&clickNum=0&isLM=0&type=0";

	private final Logger logger = Logger.getLogger(HotelDetailCrawlServiceImpl.class);

	public void crawl(List<String> hotelIds, String city, String cityUrl) throws Exception {
		Date day = new Date();
		String strCurDay = DateUtils.getStringFromDate(day, DateUtils.FORMATSHORTDATETIME);
		String strNextDay = DateUtils.getStringFromDate(DateUtils.addDays(day, 1), DateUtils.FORMATSHORTDATETIME);

		String hotelid = hotelIds.get(0);
		String invokeUrl = String.format(hotelDetailUrl, "city", cityUrl, strCurDay, strNextDay, hotelid);
		
		String jsonString = HttpUtils.doPost(invokeUrl, new HashMap<String, String>());

		logger.debug(jsonString);
	}
}
