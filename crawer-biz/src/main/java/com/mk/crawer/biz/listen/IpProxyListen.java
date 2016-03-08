package com.mk.crawer.biz.listen;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mk.crawer.biz.model.crawer.IpProxy;
import com.mk.crawer.biz.servcie.impl.IpServiceImpl;
import com.mk.framework.AppUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeashi on 16/3/8.
 */
public class IpProxyListen {
    public void onMessage( String message){

        JSONArray jsAry = JSONArray.parseArray(message);
        if(null==jsAry){
            return ;
        }

        int batchInsertMaxSize = 2;

        IpServiceImpl ipServiceImpl = AppUtils.getBean(IpServiceImpl.class);

        List<IpProxy> insertList = new ArrayList<IpProxy>();


        for(int i=0;i<jsAry.size();i++){
            JSONObject json = jsAry.getJSONObject(i);
            IpProxy ipProxy = new  IpProxy();

            ipProxy.setIpAddress(json.getString("ipAddress"));
            ipProxy.setPort(json.getString("port"));
            ipProxy.setType(json.getString("type"));
            ipProxy.setProxyAddress(json.getString("proxyAddress"));
            ipProxy.setCreateTime(json.getDate("createTime"));
            ipProxy.setNote(json.getString("note"));
            ipProxy.setCheckStatus(json.getString("checkStatus"));
            ipProxy.setIsVaild("T");
            ipProxy.setIpLevel(new Integer(1));
            insertList.add(ipProxy);

            if(insertList.size()>=batchInsertMaxSize){
                try{
                    ipServiceImpl.addIpProxyBatch(insertList);
                    insertList.clear();
                }catch(Exception e){
                    insertList.clear();
                    e.printStackTrace();
                }finally{
                    continue;
                }
            }
        }
        if(insertList.size()>0){
            ipServiceImpl.addIpProxyBatch(insertList);
            insertList.clear();
        }
    }
}
