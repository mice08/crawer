package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.CityMapper;
import com.mk.crawer.biz.mapper.crawer.QunarHotelMapper;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.model.crawer.CityListExample;
import com.mk.crawer.biz.model.crawer.QunarHotel;
import com.mk.crawer.biz.model.crawer.QunarHotelExample;
import com.mk.crawer.biz.servcie.ICityListService;
import com.mk.crawer.biz.servcie.QunarHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by kirinli on 16/1/6.
 */
@Service
public class QunarHotelServiceImpl implements QunarHotelService {
    @Autowired
    private QunarHotelMapper qunarHotelMapper;
    @Override
    public int countByExample(QunarHotelExample example) {
        return qunarHotelMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return qunarHotelMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(QunarHotel record) {
        return qunarHotelMapper.insert(record);
    }

    @Override
    public int insertSelective(QunarHotel record) {
        return qunarHotelMapper.insertSelective(record);
    }

    @Override
    public List<QunarHotel> selectByExample(QunarHotelExample example) {
        return qunarHotelMapper.selectByExample(example);
    }

    @Override
    public QunarHotel selectByPrimaryKey(Long id) {
        return qunarHotelMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(QunarHotel record) {
        return qunarHotelMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(QunarHotel record) {
        return qunarHotelMapper.updateByPrimaryKey(record);
    }
    @Override
    public List<String>  seletAllHotelCity(){
        List<String> cityList = new ArrayList<>();
        List<Map<String, String>> result = qunarHotelMapper.seletAllHotelCity();
        for (Map<String, String> stringMap : result) {
            cityList.add(stringMap.get("city_name"));
        }
        return cityList;
    }

    public List<QunarHotel>  seletHotelByCity(String city){

        return qunarHotelMapper.selectHotelByCity(city);
    }

}
