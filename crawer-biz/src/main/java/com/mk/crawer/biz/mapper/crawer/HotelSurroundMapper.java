package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.HotelSurround;
import com.mk.crawer.biz.model.crawer.HotelSurroundExample;
import java.util.List;

public interface HotelSurroundMapper {
    int countByExample(HotelSurroundExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelSurround record);

    int insertSelective(HotelSurround record);

    List<HotelSurround> selectByExample(HotelSurroundExample example);

    HotelSurround selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelSurround record);

    int updateByPrimaryKey(HotelSurround record);
}