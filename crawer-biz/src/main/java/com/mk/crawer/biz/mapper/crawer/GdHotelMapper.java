package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.GdHotel;

import java.util.List;

public interface GdHotelMapper {
    List<GdHotel> qureyByPramas(GdHotel bean);
    GdHotel getByPramas(GdHotel bean);
    Integer save(GdHotel bean);
    Integer delete(Integer id);
    Integer updateById(GdHotel bean);
    Integer updateBySourceId(GdHotel bean);
    Integer count(GdHotel bean);
    Integer countTelIsNull();
    List<GdHotel> queryHotelByTelIsNull(GdHotel bean);
}