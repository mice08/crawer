package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.BrandsMapper;
import com.mk.crawer.biz.mapper.crawer.HotelMappingMapper;
import com.mk.crawer.biz.model.crawer.*;
import com.mk.crawer.biz.servcie.BrandsService;
import com.mk.crawer.biz.servcie.IHotelMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 16/1/7.
 */

@Service
public class HotelMappingServiceImpl implements IHotelMappingService {

    @Autowired
    private HotelMappingMapper hotelMappingMapper;


    public int deleteByPrimaryKey(Long id){
        return  hotelMappingMapper.deleteByPrimaryKey(id);
    }

    public int insert(HotelMapping record){
        return  hotelMappingMapper.insert(record);
    }


    public  int insertSelective(HotelMapping record){
        return  hotelMappingMapper.insertSelective(record);
    }


    public   HotelMapping selectByPrimaryKey(Long id){
        return   hotelMappingMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(HotelMapping record){
        return  hotelMappingMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(HotelMapping record){
        return  hotelMappingMapper.updateByPrimaryKey(record);
    }

    public   List<HotelMapping>  queryHotelMapping(HashMap hm){
        return  hotelMappingMapper.queryHotelMapping(hm);
    }

}
