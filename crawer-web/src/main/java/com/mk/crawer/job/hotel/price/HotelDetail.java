package com.mk.crawer.job.hotel.price;

import java.util.Objects;

/**
 * Created by 振涛 on 2016/1/13.
 */
public class HotelDetail {

    private String hotelId;

    private String cityName;

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelDetail that = (HotelDetail) o;
        return Objects.equals(hotelId, that.hotelId) &&
                Objects.equals(cityName, that.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hotelId, cityName);
    }
}
