package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.model.crawer.QunarHotelExample;

import java.util.List;
import java.util.Map;

public interface QunarHotelMapper {
    int countByExample(QunarHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QunarHotel record);

    int insertSelective(QunarHotel record);

    List<QunarHotel> selectByExample(QunarHotelExample example);

    QunarHotel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QunarHotel record);

    int updateByPrimaryKey(QunarHotel record);

    int updateByHotelSourceId(QunarHotel record);

    List<Map<String,String>> seletAllHotelCity();
    List<QunarHotel> selectHotelByCity(String city);
    List<QunarHotel>  selectNoImageHotel(String city);
    List<Map<String, String>>selectQHotel(String hotelId);
}