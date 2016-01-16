package com.mk.crawer.biz.servcie;

import java.io.File;
import java.util.List;

public interface HotelDetailCrawlService {
	public void crawl(String hotelId, File hotelDetailFile) throws Exception ;
	public void crawl(String hotelId) throws Exception ;
	public void crawl(List<String> hotelIds) throws Exception ;
}
