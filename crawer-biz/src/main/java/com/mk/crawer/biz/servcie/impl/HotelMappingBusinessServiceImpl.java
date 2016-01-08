package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.servcie.IHotelMappingBusinessService;
import com.mk.crawer.biz.servcie.IHotelMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 2016/1/8.
 */

@Service
public class HotelMappingBusinessServiceImpl implements IHotelMappingBusinessService {

    @Autowired
    private IHotelMappingService hotelMappingService;

    public   HotelMapping  queryByPrimaryKey(Long  id){
        return  hotelMappingService.selectByPrimaryKey(id);
    }

    public  int  insert(HotelMapping  hotelMapping){
        return  hotelMappingService.insert(hotelMapping);
    }

    public int deleteByPrimaryKey(Long id){
        return hotelMappingService.deleteByPrimaryKey(id);
    }

    public  int update(HotelMapping record){
        return  hotelMappingService.updateByPrimaryKeySelective(record);
    }

    public List<HotelMapping> queryHotelMapping(HashMap hm){
        return   hotelMappingService.queryHotelMapping(hm);
    }
}
