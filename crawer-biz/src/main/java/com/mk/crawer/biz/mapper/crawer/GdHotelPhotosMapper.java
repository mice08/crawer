package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.crawer.GdHotelPhotos;

import java.util.List;

public interface GdHotelPhotosMapper {
    public List<GdHotelPhotos> qureyByPramas(GdHotelPhotos bean);
    public GdHotelPhotos getByPramas(GdHotelPhotos bean);
    public Integer save(GdHotelPhotos bean);
    public Integer delete(Integer id);
    public Integer updateById(GdHotelPhotos bean);
    public Integer count(GdHotelPhotos bean);
}