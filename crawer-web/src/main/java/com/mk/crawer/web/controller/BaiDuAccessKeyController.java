package com.mk.crawer.web.controller;

import com.mk.crawer.biz.model.crawer.HotelMapping;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import org.apache.http.HttpResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by jeashi on 16/3/23.
 */
@Controller
@RequestMapping(value = "/bdaccesskey")
public class BaiDuAccessKeyController {

    @RequestMapping(value = "/writeredis", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> writeToRedis() {
        Map<String, Object> result = new HashMap<String, Object>();
        try{
            String path = this.getClass().getResource("/").getPath()+"baiDuAccessKey.property";
            File file = new File(path);
            //读取文件
            List<String>  listStr = this.produceList(file);
            //写入redis
            this.listToredis(listStr);

        }catch (Exception e){
            e.printStackTrace();
        }
        result.put("success","true");

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    private  List  produceList(File  file){
        if(null==file||!file.exists()){
            return  null;
        }
        List<String> listStr = new ArrayList<String>();
        FileInputStream  fis = null;
        InputStreamReader read = null;
        try{
            fis = new FileInputStream(file);
            read = new InputStreamReader(fis,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(read);
            String lineTxt = null;
            while((lineTxt = bufferedReader.readLine()) != null){
                if(StringUtils.isEmpty(lineTxt)){
                    continue;
                }
                lineTxt = lineTxt.trim();
                listStr.add(lineTxt);
            }
            read.close();
        }catch(IOException  ioe){
            ioe.printStackTrace();
        }finally{
            return  listStr;
        }
    }

    private  void  listToredis(List<String> list){
        if(CollectionUtils.isEmpty(list)){
            return;
        }
        MkJedisConnectionFactory jedisFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
        Jedis jedis = null;
        try{
            jedis =  jedisFactory.getJedis();
            for(String  accessKey:list){
                jedis.lpush("BAIDUAPIACCESS",accessKey);
//                jedis.publish("BAIDUAPIACCESS",accessKey);
            }
        }catch (Exception e) {
            System.out.println("写入redis失败");
            e.printStackTrace();
        }finally {
            if(null!=jedis){
                jedis.close();
            }
        }

    }
}
