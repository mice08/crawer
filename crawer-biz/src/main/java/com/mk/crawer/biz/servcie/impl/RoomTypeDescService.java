package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.RoomTypeDescMapper;
import com.mk.crawer.biz.model.crawer.RoomTypeDesc;
import com.mk.crawer.biz.model.crawer.RoomTypeDescExample;
import com.mk.crawer.biz.servcie.IRoomTypeDescService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class RoomTypeDescService implements IRoomTypeDescService {
    @Autowired
    private RoomTypeDescMapper roomTypeDescMapper;

    @Override
    public int countByExample(RoomTypeDescExample example) {
        return roomTypeDescMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roomTypeDescMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoomTypeDesc record) {
        return roomTypeDescMapper.insert(record);
    }

    @Override
    public int insertSelective(RoomTypeDesc record) {
        return roomTypeDescMapper.insertSelective(record);
    }

    @Override
    public List<RoomTypeDesc> selectByExample(RoomTypeDescExample example) {
        return roomTypeDescMapper.selectByExample(example);
    }

    @Override
    public RoomTypeDesc selectByPrimaryKey(Long id) {
        return roomTypeDescMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoomTypeDesc record) {
        return roomTypeDescMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoomTypeDesc record) {
        return roomTypeDescMapper.updateByPrimaryKey(record);
    }
}
