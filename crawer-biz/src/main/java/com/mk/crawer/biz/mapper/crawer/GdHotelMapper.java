package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.Comment;
import com.mk.crawer.biz.model.crawer.GdHotel;

import java.util.List;

public interface GdHotelMapper {
    public List<GdHotel> qureyByPramas(GdHotel bean);
    public GdHotel getByPramas(GdHotel bean);
    public Integer save(GdHotel bean);
    public Integer delete(Integer id);
    public Integer updateById(GdHotel bean);
    public Integer updateBySourceId(GdHotel bean);
    public Integer count(GdHotel bean);
}