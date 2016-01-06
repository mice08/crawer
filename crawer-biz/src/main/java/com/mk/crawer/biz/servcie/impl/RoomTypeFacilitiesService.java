package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.RoomTypeFacilitiesMapper;
import com.mk.crawer.biz.model.crawer.RoomTypeFacilities;
import com.mk.crawer.biz.model.crawer.RoomTypeFacilitiesExample;
import com.mk.crawer.biz.servcie.IRoomTypeFacilitiesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class RoomTypeFacilitiesService implements IRoomTypeFacilitiesService {
    @Autowired
    private RoomTypeFacilitiesMapper roomTypeFacilitiesMapper;

    @Override
    public int countByExample(RoomTypeFacilitiesExample example) {
        return roomTypeFacilitiesMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roomTypeFacilitiesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoomTypeFacilities record) {
        return roomTypeFacilitiesMapper.insert(record);
    }

    @Override
    public int insertSelective(RoomTypeFacilities record) {
        return roomTypeFacilitiesMapper.insertSelective(record);
    }

    @Override
    public List<RoomTypeFacilities> selectByExample(RoomTypeFacilitiesExample example) {
        return roomTypeFacilitiesMapper.selectByExample(example);
    }

    @Override
    public RoomTypeFacilities selectByPrimaryKey(Long id) {
        return roomTypeFacilitiesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoomTypeFacilities record) {
        return roomTypeFacilitiesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoomTypeFacilities record) {
        return roomTypeFacilitiesMapper.updateByPrimaryKey(record);
    }
}
