package com.mk.crawer.api;

import java.util.Map;

/**
 * Created by kangxiaolong 2016-01-05
 */
public interface QunarHotelSyncService {
    public Map<String,Object> qunarHotelSync();
    public Map<String,Object> qunarHotelImageSync();
    public void doImageSync(String city);
    public Map<String,Object> hotelSyncByCity(String cityName);
}
