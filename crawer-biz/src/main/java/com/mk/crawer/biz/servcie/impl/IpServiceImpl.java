package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.HotelMapper;
import com.mk.crawer.biz.mapper.crawer.IpProxyMapper;
import com.mk.crawer.biz.model.crawer.IpProxy;
import com.mk.crawer.biz.servcie.IIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jeashi on 16/3/7.
 */
@Service
public class IpServiceImpl implements IIpService{

    @Autowired
    private IpProxyMapper ipProxyMapper;

   public int   addIpProxyBatch(List<IpProxy> list){
        return  ipProxyMapper.addIpProxyBatch(list);
    }

    public  int   addSelective(IpProxy  ipProxy){
        return  ipProxyMapper.addSelective(ipProxy);
    }

    public  int   updateByPrimaryKeySelective(IpProxy  ipProxy){
        return  ipProxyMapper.updateByPrimaryKeySelective(ipProxy);
    }

}
