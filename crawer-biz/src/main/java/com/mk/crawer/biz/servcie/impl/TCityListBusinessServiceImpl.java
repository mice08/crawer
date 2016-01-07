package com.mk.crawer.biz.servcie.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mk.crawer.biz.enums.CityTypeEnum;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.servcie.ICityListService;
import com.mk.crawer.biz.servcie.ITCityListBusinessService;
import com.mk.framework.proxy.http.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * Created by jeashi on 2016/1/6.
 */

@Service
public class TCityListBusinessServiceImpl implements ITCityListBusinessService {

     @Autowired
     @Qualifier("cityListService")
     public ICityListService cityListService;

        public  boolean saveCityList(String   url, String siteName) {
            if(StringUtils.isEmpty(url)){
                return false;
            }
            String getStr = null;
            getStr = HttpUtil.doGet(url);
            if(StringUtils.isEmpty(getStr)){
                return false;
            }
            JSONObject  jsonCity = JSON.parseObject(getStr);

            boolean bl = false;
            String[]  strTemplet = {"en","gj"};
            String[] alphabetMap = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
                                    "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                    "U", "V", "W", "X", "Y", "Z"};
            String[] zoneMap = {"亚洲", "欧洲", "东南亚", "热门城市","海岛", "大洋洲","美洲"};
            for(int i=0;i<strTemplet.length;i++){
                JSONObject jso =  jsonCity.getJSONObject(strTemplet[i]);

                if (null != jso) {
                    if ("en".equals(strTemplet[i])){
                        initCity(alphabetMap,jso,siteName);
                    }else if ("gj".equals(strTemplet[i])){
                        initCity(zoneMap,jso,siteName);
                    }


                    //TODO  保存tl;
                }

            }
           return bl;
        }

    final private void initCity(String[] alphabetMap, JSONObject jso, String siteName ){
        for (int j = 0; j <alphabetMap.length ; j++) {
            CityTypeEnum cityTypeEnum = CityTypeEnum.getByName(alphabetMap[j]);
            String cityType = cityTypeEnum.DEAFULT.getType();
            if (cityTypeEnum.getType() != cityTypeEnum.DEAFULT.getType()){
                cityType = cityTypeEnum.getType();
            }
            JSONArray cityJsonArray = jso.getJSONArray(alphabetMap[j]);

            if (cityJsonArray != null && cityJsonArray.size()>0){
                for (int i = 0; i < cityJsonArray.size(); i++) {
                    JSONObject o = cityJsonArray.getJSONObject(i);

                    CityList  tl = getCityByJSONObj(o);
                    CityList tmpCity = cityListService.selectByName(tl.getCityName());
                    if (null == tmpCity){
                        tl.setCityType(cityType);
                        tl.setSiteId(siteName);
                        cityListService.insert(tl);
                    }
                }
            }
        }
    }

        private CityList getCityByJSONObj(JSONObject  jsoCity){

            String cityName =  jsoCity.getString("city");
            String cityUrl = jsoCity.getString("cityUrl");
            CityList  tl = new CityList();
            tl.setCityName(cityName);
            tl.setCityUrl(cityUrl);
            tl.setCreateTime(new Date());
            return tl;

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
