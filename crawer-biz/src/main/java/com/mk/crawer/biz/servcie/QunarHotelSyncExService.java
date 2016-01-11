package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.CityList;

import java.util.Map;

/**
 * Created by kangxiaolong 2016-01-05
 */
public interface QunarHotelSyncExService {
    public Map<String,Object> qunarHotelSyncEx();
    public Map<String,Object> hotelSyncExByCity(CityList bean);
}
