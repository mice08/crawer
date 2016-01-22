package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.CityList;

import java.util.Map;

/**
 * Created by kangxiaolong 2016-01-05
 */
public interface QunarHotelMapSyncService {
    public Map<String,Object> qunarHotelMapSync();
    public Map<String,Object> hotelMapSyncByCity(CityList bean);
}
