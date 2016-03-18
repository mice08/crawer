package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.HotelMappingMapper;
import com.mk.crawer.biz.model.crawer.*;
import com.mk.crawer.biz.servcie.HotelMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeashi on 16/1/7.
 */

@Service
public class HotelMappingServiceImpl implements HotelMappingService {

    @Autowired
    private HotelMappingMapper hotelMappingMapper;


    public int countByExample(HotelMappingExample example){
        return  hotelMappingMapper.countByExample(example);
    }

    public int deleteByPrimaryKey(Long id){
        return hotelMappingMapper.deleteByPrimaryKey(id);
    }

    public int insert(HotelMapping record){
        return hotelMappingMapper.insert(record);
    }

    public int insertSelective(HotelMapping record){
        return  hotelMappingMapper.insertSelective(record);
    }

    public List<HotelMapping> selectByExample(HotelMappingExample example){
        return hotelMappingMapper.selectByExample(example);
    }

    public HotelMapping selectByPrimaryKey(Long id){
        return hotelMappingMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(HotelMapping record){
        return hotelMappingMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(HotelMapping record){
        return hotelMappingMapper.updateByPrimaryKey(record);
    }

}
