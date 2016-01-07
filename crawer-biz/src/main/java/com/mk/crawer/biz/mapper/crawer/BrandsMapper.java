package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.Brands;
import com.mk.crawer.biz.model.crawer.BrandsExample;

import java.util.List;

public interface BrandsMapper {
    int countByExample(BrandsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Brands record);

    int insertSelective(Brands record);

    List<Brands> selectByExample(BrandsExample example);

    Brands selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brands record);

    int updateByPrimaryKey(Brands record);
}