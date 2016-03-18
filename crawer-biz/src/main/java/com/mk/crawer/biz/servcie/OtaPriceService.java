package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.OtaPrice;

import java.util.List;
import java.util.Map;

/**
 * Created by kangxiaolong 2016-01-05
 */
public interface OtaPriceService {
    Map<String,Object> getOtaPrice(OtaPrice record);
    Map<String,Object> catheOtaPrice(HotelMapping record);
}
