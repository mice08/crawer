package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.RoomTypeFacilities;
import com.mk.crawer.biz.model.crawer.RoomTypeFacilitiesExample;

import java.util.List;

public interface IRoomTypeFacilitiesService {
    int countByExample(RoomTypeFacilitiesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypeFacilities record);

    int insertSelective(RoomTypeFacilities record);

    List<RoomTypeFacilities> selectByExample(RoomTypeFacilitiesExample example);

    RoomTypeFacilities selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypeFacilities record);

    int updateByPrimaryKey(RoomTypeFacilities record);
}