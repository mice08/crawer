package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.RoomTypeMappingMapper;
import com.mk.crawer.biz.model.crawer.RoomTypeMapping;
import com.mk.crawer.biz.model.crawer.RoomTypeMappingExample;
import com.mk.crawer.biz.servcie.RoomTypeMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeashi on 16/1/7.
 */

@Service
public class RoomTypeMappingServiceImpl implements RoomTypeMappingService {

    @Autowired
    private RoomTypeMappingMapper roomTypeMappingMapper;

    public int countByExample(RoomTypeMappingExample example){
        return roomTypeMappingMapper.countByExample(example);
    }

    public int deleteByPrimaryKey(Long id){
        return roomTypeMappingMapper.deleteByPrimaryKey(id);
    }

    public int insert(RoomTypeMapping record){
        return roomTypeMappingMapper.insert(record);
    }

    public int insertSelective(RoomTypeMapping record){
        return roomTypeMappingMapper.insertSelective(record);
    }

    public List<RoomTypeMapping> selectByExample(RoomTypeMappingExample example){
        return roomTypeMappingMapper.selectByExample(example);
    }

    public RoomTypeMapping selectByPrimaryKey(Long id){
        return roomTypeMappingMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(RoomTypeMapping record){
        return roomTypeMappingMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(RoomTypeMapping record){
        return roomTypeMappingMapper.updateByPrimaryKey(record);
    }
}
