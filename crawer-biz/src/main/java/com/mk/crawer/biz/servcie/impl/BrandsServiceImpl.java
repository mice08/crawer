package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.BrandsMapper;
import com.mk.crawer.biz.mapper.crawer.CityListMapper;
import com.mk.crawer.biz.model.crawer.Brands;
import com.mk.crawer.biz.model.crawer.BrandsExample;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;
import com.mk.crawer.biz.servcie.BrandsService;
import com.mk.crawer.biz.servcie.ICityListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kangxiaolong on 16/1/7.
 */
@Service
public class BrandsServiceImpl implements BrandsService {
    @Autowired
    private BrandsMapper brandsMapper;
    @Override
    public int countByExample(BrandsExample example) {
        return brandsMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return brandsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Brands record) {
        return brandsMapper.insert(record);
    }

    @Override
    public int insertSelective(Brands record) {
        return brandsMapper.insertSelective(record);
    }

    @Override
    public List<Brands> selectByExample(BrandsExample example) {
        return brandsMapper.selectByExample(example);
    }

    @Override
    public Brands selectByPrimaryKey(Long id) {
        return brandsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Brands record) {
        return brandsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Brands record) {
        return brandsMapper.updateByPrimaryKey(record);
    }
}
