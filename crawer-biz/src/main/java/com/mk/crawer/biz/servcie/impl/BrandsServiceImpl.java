package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.BrandsMapper;
import com.mk.crawer.biz.model.crawer.Brands;
import com.mk.crawer.biz.model.crawer.BrandsExample;
import com.mk.crawer.biz.servcie.BrandsService;
import com.mk.framework.proxy.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public static void main(String[] args) throws Exception {
        String datas = HttpUtil.doGetNoProxy("http://restapi.amap.com/v3/place/text?key=df3cf793df1bd2c257483c11e7176923&keywords=&types=10&city&children=1&offset=20&page=10");
//        Map<String,String> dataMap= JsonUtils.jsonToMap(datas);
//        String suggestion= dataMap.get("suggestion");
//        Map<String,String> suggestionMap= JsonUtils.jsonToMap(suggestion);
//        String cities= suggestionMap.get("cities");
//        List<Object> citieList=JsonUtils.jsonToList(cities);
//        Integer sum=0;
//        Map<String,String> resultMap=new HashMap<String, String>();
//        for (Object obj:citieList){
//            Map<String,String> objMap= JsonUtils.jsonToMap(obj.toString());
//            resultMap.put(objMap.get("name"),objMap.get("num"));
//            sum+=Integer.valueOf(objMap.get("num"));
//        }
//        System.out.println("sum="+sum.toString());
        System.out.println(datas);
    }
}
