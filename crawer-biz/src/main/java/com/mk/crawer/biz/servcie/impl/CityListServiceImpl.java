package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.CityMapper;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;
import com.mk.crawer.biz.servcie.ICityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
@Service("cityListService")
public class CityListServiceImpl implements ICityListService {
    @Autowired
    private CityMapper cityMapper;
    @Override
    public int countByExample(CityListExample example) {
        return cityMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return cityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CityList record) {
        return cityMapper.insert(record);
    }

    @Override
    public int insertSelective(CityList record) {
        return cityMapper.insertSelective(record);
    }

    @Override
    public List<CityList> selectByExample(CityListExample example) {
        return cityMapper.selectByExample(example);
    }

    @Override
    public CityList selectByPrimaryKey(Long id) {
        return cityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CityList record) {
        return cityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CityList record) {
        return cityMapper.updateByPrimaryKey(record);
    }

    @Override
    public CityList selectByName(String cityName) {
        return cityMapper.selectByName(cityName);
    }

    @Override
    public CityList selectByCityCode(String cityCode) {
        return cityMapper.selectByCityCode(cityCode);
    }

    @Override
    public List<CityList> selectByCityType(String cityType) {
        return cityMapper.selectByCityType(cityType);
    }
}
