package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.RoomTypeFacilities;

public interface RoomTypeFacilitiesMapper {

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypeFacilities record);

    int insertSelective(RoomTypeFacilities record);

    RoomTypeFacilities selectByPrimaryKey(Long id);

}