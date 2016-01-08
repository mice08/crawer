package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.RoomTypeMapping;
import com.mk.crawer.biz.servcie.IHotelMappingService;
import com.mk.crawer.biz.servcie.IRoomTypeMappingBusinessService;
import com.mk.crawer.biz.servcie.IRoomTypeMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 2016/1/8.
 */

@Service
public class RoomTypeMappingBusinessServiceImpl implements IRoomTypeMappingBusinessService {

    @Autowired
    private IRoomTypeMappingService roomTypeMappingService;

    public  RoomTypeMapping  queryByPrimaryKey(Long  id){
        return  roomTypeMappingService.selectByPrimaryKey(id);
    }

    public  int  insert(RoomTypeMapping  roomTypeMapping){
        return   roomTypeMappingService.insert(roomTypeMapping);
    }

    public int deleteByPrimaryKey(Long id){
        return roomTypeMappingService.deleteByPrimaryKey(id);
    }

    public  int update(RoomTypeMapping record){
        return  roomTypeMappingService.updateByPrimaryKeySelective(record);
    }

    public List<RoomTypeMapping> queryHotelMapping(HashMap hm){
        return   roomTypeMappingService.queryRoomTypeMapping(hm);
    }
}
