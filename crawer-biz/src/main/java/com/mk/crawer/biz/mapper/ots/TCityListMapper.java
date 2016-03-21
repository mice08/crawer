package com.mk.crawer.biz.mapper.ots;



import com.mk.crawer.biz.model.ots.TCityList;

import java.util.List;

public interface TCityListMapper {
    public List<TCityList> qureyByPramas(TCityList bean);
    public TCityList getByPramas(TCityList bean);
    public Integer save(TCityList bean);
    public Integer delete(Integer id);
    public Integer updateById(TCityList bean);
    public Integer count(TCityList bean);
}