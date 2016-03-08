package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.crawer.biz.model.crawer.IpProxy;
import com.mk.crawer.biz.model.crawer.OtaPrice;

import java.util.List;
import java.util.Map;

/**
 * Created by liujinxin 2016-01-05
 */
public interface IIpService {

    int   insertIpProxyBatch(List<IpProxy> list);

    int   insertSelective(IpProxy  ipProxy);

    int   updateByPrimaryKeySelective(IpProxy  ipProxy);

}
