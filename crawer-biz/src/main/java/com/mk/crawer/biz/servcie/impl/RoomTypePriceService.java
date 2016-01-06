package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.RoomTypePriceMapper;
import com.mk.crawer.biz.model.crawer.RoomTypePrice;
import com.mk.crawer.biz.model.crawer.RoomTypePriceExample;
import com.mk.crawer.biz.servcie.IRoomTypePriceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class RoomTypePriceService implements IRoomTypePriceService {
    @Autowired
    private RoomTypePriceMapper roomTypePriceMapper;

    @Override
    public int countByExample(RoomTypePriceExample example) {
        return roomTypePriceMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return roomTypePriceMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(RoomTypePrice record) {
        return roomTypePriceMapper.insert(record);
    }

    @Override
    public int insertSelective(RoomTypePrice record) {
        return roomTypePriceMapper.insertSelective(record);
    }

    @Override
    public List<RoomTypePrice> selectByExample(RoomTypePriceExample example) {
        return roomTypePriceMapper.selectByExample(example);
    }

    @Override
    public RoomTypePrice selectByPrimaryKey(Long id) {
        return roomTypePriceMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(RoomTypePrice record) {
        return roomTypePriceMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(RoomTypePrice record) {
        return roomTypePriceMapper.updateByPrimaryKey(record);
    }
}
