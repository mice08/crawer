package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.MtCity;

import java.util.List;

/**
 * Created by BurizaDo on 2/19/16.
 */
public interface MtCityMapper {
    List<MtCity> getCityList();
    boolean insert(MtCity city);
}
