package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.Hotel;
import com.mk.crawer.biz.model.crawer.HotelExample;


import java.util.List;

public interface HotelMapper {
    int countByExample(HotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Hotel record);

    int insertSelective(Hotel record);

    List<Hotel> selectByExample(HotelExample example);

    Hotel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Hotel record);

    int updateByPrimaryKey(Hotel record);
}