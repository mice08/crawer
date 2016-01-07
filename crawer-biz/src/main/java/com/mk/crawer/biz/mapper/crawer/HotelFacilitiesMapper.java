package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.HotelFacilities;

public interface HotelFacilitiesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HotelFacilities record);

    int insertSelective(HotelFacilities record);

    HotelFacilities selectByPrimaryKey(Long id);
}