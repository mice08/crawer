package com.mk.crawer.biz.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2015/10/17.
 */
public class JsonUtils {
    public static JSONObject parseObject(String jsonString) {
        JSONObject object = JSONObject.parseObject(jsonString);
        return object;
    }
    public static JSONArray parseArray(String jsonString) {
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        return jsonArray;
    }

    public static void main(String arg[]){
        String s = "[{\"name\":\"def\",\"pic\":[{\"url\":\"https://dn-imke-pro.qbox.me/FikvzvbTN_r9mWewxelSdxtxIjnw\"}]},{\"name\":\"lobby\",\"pic\":[]},{\"name\":\"mainHousing\",\"pic\":[]}]";
        JSONArray jsonArray = JSONArray.parseArray(s);
        System.out.println(jsonArray.get(0));
        Object dd =jsonArray.get(0);
    }
    /* 将Json对象转换成Map
    *
    * @param jsonObject
    *            json对象
    * @return Map对象
    * @throws JSONException
    */
    public static Map<String,String> jsonToMap(String jsonString) throws JSONException {
        JSONObject object = JSONObject.parseObject(jsonString);
        Map<String,String> result = new HashMap<String,String>();
        for (String key:object.keySet()){
            result.put(key,object.get(key).toString());
        }
        return result;

    }
    /* 将Json对象转换成List
   *
   * @param jsonList
   *            json对象
   * @return List对象
   * @throws JSONException
   */
    public static List<Object> jsonToList(String jsonString) throws JSONException {
        JSONArray jsonArray = JSONArray.parseArray(jsonString);
        List<Object> result = new ArrayList<Object>();
        for (Object obj:jsonArray.toArray()){
            result.add(obj);
        }
        return result;

    }
    /* 将json to Class<T>
         *
         * @param object
         * @return json对象
         * @throws JSONException
         */
    public static <T>T formatJson(String json, Class<T> classOfT) throws JSONException {
        return JSON.parseObject(json,classOfT);
    }
}
