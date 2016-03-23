package com.mk.crawer.biz.thread;

import com.mk.crawer.biz.listen.IpProxyListen;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import redis.clients.jedis.Jedis;

/**
 * Created by jeashi on 16/3/8.
 */
public class IpProxyThread extends    Thread{
    public void run() {
        MkJedisConnectionFactory jedisFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
        Jedis jedis =  jedisFactory.getJedis();
        try{
            while(true){

                IpProxyListen sll =  new IpProxyListen();
                String message =  jedis.lpop("IPPROXYLIST");
                sll.onMessage(message);
                Thread.sleep(1000L);

            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            jedis.close();
        }
    }
}
