package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.HotelMappingExample;

import java.util.HashMap;
import java.util.List;

public interface HotelMappingMapper {

    int deleteByPrimaryKey(Long id);

    int insert(HotelMapping record);

    int insertSelective(HotelMapping record);

    HotelMapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelMapping record);

    int updateByPrimaryKey(HotelMapping record);

    public  List<HotelMapping>   queryHotelMapping(HashMap hm);
}