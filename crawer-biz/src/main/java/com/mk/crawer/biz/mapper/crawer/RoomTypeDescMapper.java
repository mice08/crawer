package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.RoomTypeDesc;

public interface RoomTypeDescMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypeDesc record);

    int insertSelective(RoomTypeDesc record);

    RoomTypeDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypeDesc record);

    int updateByPrimaryKey(RoomTypeDesc record);
}