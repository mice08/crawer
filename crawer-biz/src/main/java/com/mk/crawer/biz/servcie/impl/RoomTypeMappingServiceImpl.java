package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.HotelMappingMapper;
import com.mk.crawer.biz.mapper.crawer.RoomTypeMappingMapper;
import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.RoomTypeMapping;
import com.mk.crawer.biz.servcie.IHotelMappingService;
import com.mk.crawer.biz.servcie.IRoomTypeMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 16/1/7.
 */

@Service
public class RoomTypeMappingServiceImpl implements IRoomTypeMappingService {

    @Autowired
    private RoomTypeMappingMapper roomTypeMappingMapper;


    public int deleteByPrimaryKey(Long id){
        return  roomTypeMappingMapper.deleteByPrimaryKey(id);
    }

    public int insert(RoomTypeMapping record){
        return  roomTypeMappingMapper.insert(record);
    }


    public  int insertSelective(RoomTypeMapping record){
        return  roomTypeMappingMapper.insertSelective(record);
    }


    public  RoomTypeMapping  selectByPrimaryKey(Long id){
        return   roomTypeMappingMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(RoomTypeMapping record){
        return  roomTypeMappingMapper.updateByPrimaryKeySelective(record);
    }


    public int updateByPrimaryKey(RoomTypeMapping record){
        return  roomTypeMappingMapper.updateByPrimaryKey(record);
    }

    public   List<RoomTypeMapping>  queryRoomTypeMapping(HashMap hm){
        return  roomTypeMappingMapper.queryRoomTypeMapping(hm);
    }

}
