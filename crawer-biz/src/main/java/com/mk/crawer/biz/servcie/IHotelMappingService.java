package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;
import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.HotelMappingExample;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 2016/1/8.
 */
public interface IHotelMappingService {

    public int deleteByPrimaryKey(Long id);

    public int insert(HotelMapping record);

    public  int insertSelective(HotelMapping record);

    public   HotelMapping selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(HotelMapping record);

    public int updateByPrimaryKey(HotelMapping record);

    public   List<HotelMapping>  queryHotelMapping(HashMap hm);

}
