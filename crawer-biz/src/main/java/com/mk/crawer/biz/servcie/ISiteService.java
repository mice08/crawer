package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.Site;
import com.mk.crawer.biz.model.crawer.SiteExample;

import java.util.List;

public interface ISiteService {
    int countByExample(SiteExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Site record);

    int insertSelective(Site record);

    List<Site> selectByExample(SiteExample example);

    Site selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);
}