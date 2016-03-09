package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.IpProxyMapper;
import com.mk.crawer.biz.model.crawer.IpProxy;
import com.mk.crawer.biz.servcie.IIpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 16/3/7.
 */
@Service
public class IpServiceImpl implements IIpService {

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


    public  List<IpProxy>  selectIpProxyList(int pageSize,int pageIndex,String  checkStatus){
        HashMap  parmeMap = new HashMap();
        parmeMap.put("pageSize",pageSize);
        parmeMap.put("pageIndex",pageIndex);
        parmeMap.put("checkStatus",checkStatus);

        List<IpProxy>  ipProxyList = ipProxyMapper.selectIpProxyList(parmeMap);

        return   ipProxyList;
    }

    public void  updateIpProxyStatus(){
        int  pageIndex = 0;
        int  pageSize = 30;
        String  checkStatus = "1";
        boolean endbl = true;
        while(endbl){
            List<IpProxy>  ipProxyList = this.selectIpProxyList(pageSize,pageIndex,checkStatus);

            if(CollectionUtils.isEmpty(ipProxyList)){
                endbl = false;
            }else{
                for(int  i=0;i<ipProxyList.size();i++){
                    IpProxy  ipProxyInit = ipProxyList.get(i);
                    String  ip = ipProxyInit.getIpAddress();
                    String  port = ipProxyInit.getPort();
                    Long result = checkIpAddressCanUser(ip,port);
                    if(result>0){
                        ipProxyInit.setIpLevel(result);
                        ipProxyInit.setCheckStatus("2");
                    }else{
                        ipProxyInit.setCheckStatus("3");
                    }
                    ipProxyInit.setCheckTime(new Date());
                    ipProxyMapper.updateIpProxyCheckStatus(ipProxyInit);
                }
            }
            pageIndex++;
        }
    }

    public  static  void main(String[] args){



        String ip = "9999.28.14.14";
        String  port ="1234";

        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", ip);
        System.setProperty("http.proxyPort", port);
        try{
            URL url = new URL("http://www.baidu.com");
            URLConnection con = url.openConnection();
            con.setConnectTimeout(5*1000);
            InputStreamReader isr = new InputStreamReader(con.getInputStream());
            char[] cs = new char[1024];
            int i = 0;
            while ((i = isr.read(cs)) > 0) {
                System.out.println(new String(cs, 0, i));
            }
            isr.close();
        }catch (MalformedURLException mle){

        }catch (IOException ioe){

        }

/*
        String ip = "119.28.14.14";
        String  port ="81";

        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", ip);
        System.setProperty("http.proxyPort", port);
        Boolean bl = false;
        try{
            URL url = new URL("http://www.baidu.com");
            long startl = System.currentTimeMillis();
            URLConnection con = url.openConnection();
            con.setConnectTimeout(5*1000);
            InputStreamReader isr = new InputStreamReader(con.getInputStream());

            char[] cs = new char[1024];
            if(isr.read(cs)>0){
                bl = true;
            }
            long endl = System.currentTimeMillis();

            System.out.println("endl:"+endl+"  startl:  "+startl+"   结果:  "+ (endl-startl));
            System.out.println("bl"+bl +"   aaaaa   "+isr.read(cs));

            isr.close();

//            int i = 0;
//            while ((i = isr.read(cs)) > 0) {
//                System.out.println(new String(cs, 0, i));
//            }
        }catch (MalformedURLException mle){

        }catch (IOException ioe){

        }
        */
    }

    public  Long    checkIpAddressCanUser(String ip,String port){
        System.setProperty("http.proxySet", "true");
        System.setProperty("http.proxyHost", ip);
        System.setProperty("http.proxyPort", port);
        Long  result = new Long(-1);
        try{
            URL url = new URL("http://www.baidu.com");
           long startl = System.currentTimeMillis();
            URLConnection con = url.openConnection();
            con.setConnectTimeout(5*1000);
            con.setReadTimeout(5*1000);
            InputStreamReader isr = new InputStreamReader(con.getInputStream());

            char[] cs = new char[1024];
            if(isr.read(cs)>0){
                long endl = System.currentTimeMillis();
                result = endl - startl;
            }

            isr.close();
        }catch (MalformedURLException mle){
            mle.printStackTrace();
            result = new Long(-1);
        }catch (IOException ioe){
            ioe.printStackTrace();
            result = new Long(-1);
        }finally {
            return result;
        }
    }
}
