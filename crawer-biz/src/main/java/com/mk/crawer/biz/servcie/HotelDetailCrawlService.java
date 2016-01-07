package com.mk.crawer.biz.servcie;

import java.util.List;

public interface HotelDetailCrawlService {
	public void crawl(String hotelId, String city, String cityUrl) throws Exception ;
	public void crawl(List<String> hotelIds, String city, String cityUrl) throws Exception ;
}
