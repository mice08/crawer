package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.HotelImage;

public interface HotelImageMapper {

    int insert(HotelImage record);

    HotelImage selectByRecord(HotelImage record);

}