package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.HotelSurround;

public interface HotelSurroundMapper {
    int deleteByPrimaryKey(Long id);

    int insert(HotelSurround record);

    int insertSelective(HotelSurround record);

    HotelSurround selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelSurround record);

    int updateByPrimaryKey(HotelSurround record);
}