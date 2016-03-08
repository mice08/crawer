package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.IpProxy;

import java.util.List;

/**
 * Created by jeashi on 16/3/8.
 */
public interface IpProxyMapper {

    int   addIpProxyBatch(List<IpProxy> list);

    int   addSelective(IpProxy  ipProxy);

    int   updateByPrimaryKeySelective(IpProxy  ipProxy);

}
