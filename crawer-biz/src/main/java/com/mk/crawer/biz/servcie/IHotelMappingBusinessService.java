package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.HotelMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 2016/1/8.
 */
public interface IHotelMappingBusinessService {

    public HotelMapping queryByPrimaryKey(Long  id);

    public  int  insert(HotelMapping  hotelMapping);

    public int deleteByPrimaryKey(Long id);

    public  int update(HotelMapping record);

    public List<HotelMapping> queryHotelMapping(HashMap hm);
}
