package com.mk.crawer.web.thread;

import com.mk.crawer.biz.servcie.IIpService;
import com.mk.framework.AppUtils;

/**
 * Created by jeashi on 16/3/15.
 */
public class IpCheckCanUseThread extends   Thread{
    private  String  orderBy;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public  IpCheckCanUseThread(String  orderBy){
        this.orderBy = orderBy;
    }

    public  void run(){
        IIpService  ipService = (IIpService)AppUtils.getBean("ipServiceImpl");
        ipService.updateIpProxyStatus(orderBy);
    }
}
