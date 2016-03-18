package com.mk.crawer.biz.mapper.ots;

import java.util.List;
import java.util.Map;

import com.mk.crawer.biz.model.ots.HotelSubject;

public interface HotelSubjectMapper {
	public void insert(HotelSubject hotelSubject);
	
	public void updateByHotelId(HotelSubject hotelSubject);
	
	public List<Map<String, Object>> selectAllIds();
}
