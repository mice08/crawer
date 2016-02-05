package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.model.crawer.QunarHotelExample;

import java.util.List;

public interface QunarHotelService {
    int countByExample(QunarHotelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(QunarHotel record);

    int insertSelective(QunarHotel record);

    List<QunarHotel> selectByExample(QunarHotelExample example);

    QunarHotel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(QunarHotel record);

    int updateByPrimaryKey(QunarHotel record);
    List<String>  seletAllHotelCity();
    public List<QunarHotel>  seletHotelByCity(String city);

    public Boolean isOnlineHotel(String hotelId);
}