package com.mk.crawer.biz.servcie;

import java.util.List;

import com.mk.crawer.biz.model.crawer.Brands;
import com.mk.crawer.biz.model.crawer.BrandsExample;

public interface BrandsService {
    int countByExample(BrandsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Brands record);

    int insertSelective(Brands record);

    List<Brands> selectByExample(BrandsExample example);

    Brands selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Brands record);

    int updateByPrimaryKey(Brands record);
}