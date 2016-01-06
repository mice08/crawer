package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.RoomTypeMapper;
import com.mk.crawer.biz.model.crawer.RoomType;
import com.mk.crawer.biz.model.crawer.RoomTypeExample;
import com.mk.crawer.biz.servcie.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class RoomTypeService implements IRoomTypeService {
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public int countByExample(RoomTypeExample example) {
        return roomTypeMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roomTypeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoomType record) {
        return roomTypeMapper.insert(record);
    }

    @Override
    public int insertSelective(RoomType record) {
        return roomTypeMapper.insertSelective(record);
    }

    @Override
    public List<RoomType> selectByExample(RoomTypeExample example) {
        return roomTypeMapper.selectByExample(example);
    }

    @Override
    public RoomType selectByPrimaryKey(Long id) {
        return roomTypeMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoomType record) {
        return roomTypeMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoomType record) {
        return roomTypeMapper.updateByPrimaryKey(record);
    }
}
