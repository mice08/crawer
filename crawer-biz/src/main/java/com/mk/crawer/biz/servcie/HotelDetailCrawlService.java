package com.mk.crawer.biz.servcie;

import java.util.List;

public interface HotelDetailCrawlService {
	public void crawl(List<String> hotelIds, String city, String cityUrl) throws Exception ;
}
