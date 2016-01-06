package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.SiteMapper;
import com.mk.crawer.biz.model.crawer.Site;
import com.mk.crawer.biz.model.crawer.SiteExample;
import com.mk.crawer.biz.servcie.ISiteService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class SiteService implements ISiteService {
    @Autowired
    private SiteMapper siteMapper;

    @Override
    public int countByExample(SiteExample example) {
        return siteMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return siteMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Site record) {
        return siteMapper.insert(record);
    }

    @Override
    public int insertSelective(Site record) {
        return siteMapper.insertSelective(record);
    }

    @Override
    public List<Site> selectByExample(SiteExample example) {
        return siteMapper.selectByExample(example);
    }

    @Override
    public Site selectByPrimaryKey(Long id) {
        return siteMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Site record) {
        return siteMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Site record) {
        return siteMapper.updateByPrimaryKey(record);
    }
}
