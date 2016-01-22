package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */

public interface ICityListService {
    public int countByExample(CityListExample example);

    public int deleteByPrimaryKey(Long id);

    public int insert(CityList record);

    public int insertSelective(CityList record);

    public List<CityList> selectByExample(CityListExample example);

    public CityList selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(CityList record);

    public int updateByPrimaryKey(CityList record);

    public CityList selectByName(String cityName);
    public CityList selectByCityCode(String cityCode);
    public List<CityList> selectByCityType(String cityType);
}
