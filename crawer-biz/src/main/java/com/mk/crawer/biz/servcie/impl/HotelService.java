package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.HotelMapper;
import com.mk.crawer.biz.model.crawer.Hotel;
import com.mk.crawer.biz.model.crawer.HotelExample;
import com.mk.crawer.biz.servcie.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class HotelService implements IHotelService{
    @Autowired
    private HotelMapper hotelMapper;

    @Override
    public int countByExample(HotelExample example) {
        return hotelMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return hotelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Hotel record) {
        return hotelMapper.insert(record);
    }

    @Override
    public int insertSelective(Hotel record) {
        return hotelMapper.insertSelective(record);
    }

    @Override
    public List<Hotel> selectByExample(HotelExample example) {
        return hotelMapper.selectByExample(example);
    }

    @Override
    public Hotel selectByPrimaryKey(Long id) {
        return hotelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Hotel record) {
        return hotelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Hotel record) {
        return hotelMapper.updateByPrimaryKey(record);
    }
}
