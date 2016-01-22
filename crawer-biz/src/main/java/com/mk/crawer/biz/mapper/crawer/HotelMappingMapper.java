package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.HotelMappingExample;
import java.util.List;

public interface HotelMappingMapper {
    int countByExample(HotelMappingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelMapping record);

    int insertSelective(HotelMapping record);

    List<HotelMapping> selectByExample(HotelMappingExample example);

    HotelMapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelMapping record);

    int updateByPrimaryKey(HotelMapping record);
}