package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.CityListMapper;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;
import com.mk.crawer.biz.servcie.ICityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
@Service
public class CityListService implements ICityListService {
    @Autowired
    private CityListMapper cityListMapper;
    @Override
    public int countByExample(CityListExample example) {
        return cityListMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return cityListMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CityList record) {
        return cityListMapper.insert(record);
    }

    @Override
    public int insertSelective(CityList record) {
        return cityListMapper.insertSelective(record);
    }

    @Override
    public List<CityList> selectByExample(CityListExample example) {
        return cityListMapper.selectByExample(example);
    }

    @Override
    public CityList selectByPrimaryKey(Long id) {
        return cityListMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CityList record) {
        return cityListMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CityList record) {
        return cityListMapper.updateByPrimaryKey(record);
    }
}
