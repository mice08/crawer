package com.mk.crawer.biz.utils;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.log4j.Logger;

public class HttpUtils {
    private static Logger log = Logger.getLogger(HttpUtils.class);
    public static final int timeout = 30 * 1000;
    private static final String charset = "UTF-8";


    public static String doPost(String reqURL, Map<String, String> params){
        return sendHttpClientPost(reqURL, params, timeout, charset);
    }

    //用apache接口实现http的post提交数据
    public static String sendHttpClientPost(String path,
                                            Map<String, String> params,int timeout, String encode) {
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        StringBuffer paramsStr = new StringBuffer();
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                list.add(new BasicNameValuePair(entry.getKey(), entry
                        .getValue()));
                paramsStr.append(entry.getKey()).append("[").append(entry.getValue()).append("]");
            }
        }
        log.info(String.format("=========remote path[%s]====params[%s]======", path, paramsStr.toString()));
        try {
            // 实现将请求的参数封装到表单中，即请求体中
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, encode);
            // 使用post方式提交数据
            HttpPost httpPost = new HttpPost(path);
            httpPost.setEntity(entity);
            // 执行post请求，并获取服务器端的响应HttpResponse
            DefaultHttpClient client = new DefaultHttpClient();
            client.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
            client.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout);
            HttpResponse httpResponse = client.execute(httpPost);
            //获取服务器端返回的状态码和输入流，将输入流转换成字符串
            String result = "";
            if (httpResponse.getStatusLine().getStatusCode() == 200) {
                InputStream inputStream = httpResponse.getEntity().getContent();
                result  = changeInputStream(inputStream, encode);
            }else{
                InputStream inputStream = httpResponse.getEntity().getContent();
                result = changeInputStream(inputStream, encode);
            }
            log.info(String.format("=========remote path[%s] result[%s]==========", path, result));
            return result;
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "";

    }

    /*
     * // 把从输入流InputStream按指定编码格式encode变成字符串String
     */
    public static String changeInputStream(InputStream inputStream,
                                           String encode) {

        // ByteArrayOutputStream 一般叫做内存流
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int len = 0;
        String result = "";
        if (inputStream != null) {

            try {
                while ((len = inputStream.read(data)) != -1) {
                    byteArrayOutputStream.write(data, 0, len);

                }
                result = new String(byteArrayOutputStream.toByteArray(), encode);

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String path = "http://smlt-ots.imike.cn/ots/roomstate/querylist";
        Map<String, String> params = new HashMap<String, String>();
        params.put("isShowAllRoom","T");
        params.put("hotelid", String.valueOf(2187));
        params.put("roomtypeid", String.valueOf(7229));
        params.put("startdateday", "20151021");
        params.put("enddateday", "20151022");
        String result = sendHttpClientPost(path, params, timeout, "utf-8");
        System.out.println("-result->>" + result);

    }

    public static String get_data(String url, String method) {
        try {
            URL httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setDoOutput(true);
            conn.setConnectTimeout(10000);
            conn.setRequestMethod(method);
            conn.connect();

            //返回
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String result = reader.readLine();
            return result.trim();
        } catch (Exception e) {
            return null;
        }
    }

}