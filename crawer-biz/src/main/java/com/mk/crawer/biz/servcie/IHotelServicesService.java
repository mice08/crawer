package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.HotelServices;
import com.mk.crawer.biz.model.crawer.HotelServicesExample;

import java.util.List;

public interface IHotelServicesService {
    int countByExample(HotelServicesExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HotelServices record);

    int insertSelective(HotelServices record);

    List<HotelServices> selectByExample(HotelServicesExample example);

    HotelServices selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(HotelServices record);

    int updateByPrimaryKey(HotelServices record);
}