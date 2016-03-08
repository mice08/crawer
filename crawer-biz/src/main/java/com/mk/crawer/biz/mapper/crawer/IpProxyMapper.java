package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.IpProxy;

import java.util.List;

/**
 * Created by jeashi on 16/3/8.
 */
public interface IpProxyMapper {

    int   insertIpProxyBatch(List<IpProxy> list);

    int   insertSelective(IpProxy  ipProxy);

    int   updateByPrimaryKeySelective(IpProxy  ipProxy);

}
