package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.HotelSurround;

public interface HotelSurroundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelSurround record);

    int insertSelective(HotelSurround record);

    HotelSurround selectByPrimaryKey(Long id);
}