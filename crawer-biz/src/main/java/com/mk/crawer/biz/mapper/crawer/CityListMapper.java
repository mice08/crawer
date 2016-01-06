package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;
import java.util.List;

public interface CityListMapper {
    int countByExample(CityListExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CityList record);

    int insertSelective(CityList record);

    List<CityList> selectByExample(CityListExample example);

    CityList selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CityList record);

    int updateByPrimaryKey(CityList record);
}