package com.mk.whotel.wechat.web.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class HttpUtil {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HttpUtil.class);

    public static String doGet(String url) {
        String responseBodyStr = null;

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpGet httpGet = new HttpGet(url);

        try {
            //执行get请求
            HttpResponse httpResponse = closeableHttpClient.execute(httpGet);

            //获取响应消息实体
            HttpEntity entity = httpResponse.getEntity();

            //判断响应实体是否为空
            if (entity == null) {
                LOGGER.warn("没有获取到请求数据。");
            } else {
                responseBodyStr = EntityUtils.toString(entity);
            }
        } catch (IOException e) {
            LOGGER.error("请求出错：", e);
        } finally {
            try {
                //关闭流并释放资源
                closeableHttpClient.close();
            } catch (IOException e) {
                LOGGER.error("关闭流并释放资源出错：", e);
            }
        }


        return responseBodyStr;
    }

    public static String urlEncoder(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            LOGGER.error("使用UTF-8编码无法成功对：{}进行编码", url);
        }

        return null;
    }

    public static void main(String[] args) {
        HttpUtil.doGet("https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&id=open1419316505&token=&lang=zh_CN");
    }

}
