package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.Hotel;
import com.mk.crawer.biz.model.crawer.HotelExample;
import com.mk.crawer.biz.model.crawer.OtaPrice;

import java.util.List;

public interface OtaPriceMapper {

    List<OtaPrice> getOtaPrice(OtaPrice record);
    OtaPrice  getValidDate(OtaPrice record);
}