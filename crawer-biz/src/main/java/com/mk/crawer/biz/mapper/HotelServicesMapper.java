package com.mk.crawer.biz.mapper;

import com.mk.crawer.biz.model.HotelServices;
import com.mk.crawer.biz.model.HotelServicesExample;
import java.util.List;

public interface HotelServicesMapper {
    int countByExample(HotelServicesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelServices record);

    int insertSelective(HotelServices record);

    List<HotelServices> selectByExample(HotelServicesExample example);

    HotelServices selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelServices record);

    int updateByPrimaryKey(HotelServices record);
}