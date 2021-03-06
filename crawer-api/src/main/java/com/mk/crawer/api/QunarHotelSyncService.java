package com.mk.crawer.api;

import java.util.Map;

/**
 * Created by kangxiaolong 2016-01-05
 */
public interface QunarHotelSyncService {
    public Map<String,Object> qunarHotelSync();
    public Map<String,Object> qunarHotelImageSync(Boolean useProxy);
    public void doImageSync(String city, Boolean useProxy);
    public Map<String,Object> hotelSyncByCity(String cityName);
}
