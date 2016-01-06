package com.mk.crawer.biz.servcie.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mk.crawer.api.TCityListService;
import com.mk.crawer.biz.enums.CityTypeEnum;
import com.mk.crawer.biz.mapper.crawer.CityListMapper;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.servcie.ICityListService;
import com.mk.crawer.biz.servcie.ITCityListBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import com.mk.framework.proxy.http.HttpUtil;
import java.util.Date;

/**
 * Created by jeashi on 2016/1/6.
 */

@Service
public class TCityListBusinessServiceImpl implements ITCityListBusinessService {

     @Autowired
     public ICityListService cityListService;

        public  boolean saveCityList(String   url) {
            if(StringUtils.isEmpty(url)){
                return false;
            }
            String getStr = HttpUtil.doGet(url);
            if(StringUtils.isEmpty(getStr)){
                return false;
            }
            JSONObject  jsonCity = JSON.parseObject(getStr);

            boolean bl = false;
            String[]  strTemplet = {"en","gj"};
            for(int i=0;i<strTemplet.length;i++){
                JSONArray jsa =  jsonCity.getJSONArray(strTemplet[i]);
                if (null != jsa && jsa.size() > 0) {
                    for (int j = 0; j < jsa.size(); j++) {
                        JSONObject jso = jsa.getJSONObject(j);
                        if (null != jso) {
                            bl = true;
                            CityList  tl = getCityByJSONObj(jso,i);
                            cityListService.insert(tl);
                            //TODO  保存tl;
                        }
                    }
                }
            }
           return bl;
        }


        private CityList getCityByJSONObj(JSONObject  jso,int k){
            String key = this.getKey(jso,k);
            if(null!=key){
               JSONArray  jsonArray = jso.getJSONArray(key);
                //获取类型
               String  cityType = CityTypeEnum.getTypeByName(key);
               if(null!=jsonArray&&jsonArray.size()>0){
                    for(int  i=0;i<jsonArray.size();i++){
                        JSONObject  jsoCity = jsonArray.getJSONObject(i);
                        String cityName =  jsoCity.getString("city");
                        String cityUrl = jsoCity.getString("cityUrl");
                        CityList  tl = new CityList();
                        tl.setCityName(cityName);
                        tl.setCityUrl(cityUrl);
                        tl.setCityType(cityType);
                        tl.setSiteId(key);
                        tl.setCreateTime(new Date());
                        return tl;
                    }
               }
            }
            return null;
        }

        //解析当前JSONObject的key
        private  String  getKey(JSONObject  jsonO,int k){
            String[]  strTemplet = {"A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z",
                            "东南亚,亚洲,大洋洲,欧洲,海岛,热门城市,美洲"
                            };
            if(k>strTemplet.length){
                return null;
            }
            String str = strTemplet[k];
            String[] strSplit =str.split(",");
            for(int l=0;l<strSplit.length;l++){
                 if(jsonO.containsKey(strSplit[l])){
                     return  strSplit[l];
                 }
            }
            return null;
        }

}
