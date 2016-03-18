package com.mk.crawer.biz.mapper.ots;

import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.ots.TDistrict;

import java.util.List;

public interface TDistrictMapper {
    public List<TDistrict> qureyByPramas(TDistrict bean);
    public TDistrict getByPramas(TDistrict bean);
    public Integer save(TDistrict bean);
    public Integer delete(Integer id);
    public Integer updateById(TDistrict bean);
    public Integer count(TDistrict bean);
}