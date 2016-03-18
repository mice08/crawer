package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.MtCity;

/**
 * Created by BurizaDo on 2/17/16.
 */
public interface MtHotelDetailCrawlerService {
    int crawHotelList(MtCity city);
    MtCity.MtCityList crawCityList();
}
