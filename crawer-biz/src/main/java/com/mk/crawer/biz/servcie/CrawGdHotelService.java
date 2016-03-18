package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.OtaPrice;
import com.mk.crawer.biz.model.ots.TDistrict;

import java.util.Map;

/**
 * Created by kangxiaolong 2016-03-17
 */
public interface CrawGdHotelService {
    public Map<String,Object> gdHotelSync(TDistrict bean);
}
