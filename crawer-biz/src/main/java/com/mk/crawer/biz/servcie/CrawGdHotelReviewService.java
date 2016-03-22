package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.ots.TDistrict;

import java.util.Map;

/**
 * Created by kangxiaolong 2016-03-17
 */
public interface CrawGdHotelReviewService {
    public Map<String,Object> gdHotelCommetSync(GdHotel bean);
}
