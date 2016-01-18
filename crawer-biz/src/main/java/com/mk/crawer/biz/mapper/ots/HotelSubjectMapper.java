package com.mk.crawer.biz.mapper.ots;

import com.mk.crawer.biz.model.ots.HotelSubject;

public interface HotelSubjectMapper {
	public void insert(HotelSubject hotelSubject);
	
	public void updateByHotelId(HotelSubject hotelSubject);
}
