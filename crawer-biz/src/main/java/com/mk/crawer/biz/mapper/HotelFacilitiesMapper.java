package com.mk.crawer.biz.mapper;

import com.mk.crawer.biz.model.HotelFacilities;
import com.mk.crawer.biz.model.RoomTypeFacilitiesExample;
import java.util.List;

public interface HotelFacilitiesMapper {
    int countByExample(RoomTypeFacilitiesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelFacilities record);

    int insertSelective(HotelFacilities record);

    List<HotelFacilities> selectByExample(RoomTypeFacilitiesExample example);

    HotelFacilities selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelFacilities record);

    int updateByPrimaryKey(HotelFacilities record);
}