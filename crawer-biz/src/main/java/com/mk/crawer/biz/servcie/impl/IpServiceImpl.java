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

   public int   insertIpProxyBatch(List<IpProxy> list){
        return  ipProxyMapper.insertIpProxyBatch(list);
    }

    public  int   insertSelective(IpProxy  ipProxy){
        return  ipProxyMapper.insertSelective(ipProxy);
    }

    public  int   updateByPrimaryKeySelective(IpProxy  ipProxy){
        return  ipProxyMapper.updateByPrimaryKeySelective(ipProxy);
    }

}
