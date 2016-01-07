package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.RoomTypePrice;

public interface RoomTypePriceMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypePrice record);

    int insertSelective(RoomTypePrice record);

    RoomTypePrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypePrice record);

    int updateByPrimaryKey(RoomTypePrice record);
}