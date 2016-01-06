package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.HotelServicesMapper;
import com.mk.crawer.biz.model.crawer.HotelServices;
import com.mk.crawer.biz.model.crawer.HotelServicesExample;
import com.mk.crawer.biz.servcie.IHotelServicesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class HotelServicesService implements IHotelServicesService {
    @Autowired
    private HotelServicesMapper hotelServicesMapper;

    @Override
    public int countByExample(HotelServicesExample example) {
        return hotelServicesMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return hotelServicesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HotelServices record) {
        return hotelServicesMapper.insert(record);
    }

    @Override
    public int insertSelective(HotelServices record) {
        return hotelServicesMapper.insertSelective(record);
    }

    @Override
    public List<HotelServices> selectByExample(HotelServicesExample example) {
        return hotelServicesMapper.selectByExample(example);
    }

    @Override
    public HotelServices selectByPrimaryKey(Long id) {
        return hotelServicesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HotelServices record) {
        return hotelServicesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HotelServices record) {
        return hotelServicesMapper.updateByPrimaryKey(record);
    }
}
