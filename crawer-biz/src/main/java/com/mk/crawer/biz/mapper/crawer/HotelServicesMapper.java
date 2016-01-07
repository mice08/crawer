package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.HotelServices;

public interface HotelServicesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelServices record);

    int insertSelective(HotelServices record);

    HotelServices selectByPrimaryKey(Long id);
}