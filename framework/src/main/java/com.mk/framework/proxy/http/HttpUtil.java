package com.mk.framework.proxy.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class HttpUtil {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HttpUtil.class);

    public static String doGet(String url) {
        ProxyServer proxyServer = ProxyServerManager.random();
        HttpHost httpHost = new HttpHost(proxyServer.getIp(), proxyServer.getPort());
        try {
            return HttpUtil.doGet(url, httpHost);
        } catch (IOException e) {
            LOGGER.error("请求出错：", e);
            return null;
        }
    }

    static String doGetNoProxy(String url) throws IOException {
        return doGet(url, null);
    }

    static String doGet(String url, HttpHost proxy) throws IOException {
        String responseBodyStr = null;

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpGet httpGet = new HttpGet(url);

        if ( proxy != null ) {
            RequestConfig config = RequestConfig.custom().setProxy(proxy).setConnectTimeout(Config.FETCH_TIMEOUT).build();
            httpGet.setConfig(config);
        }

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

    public static void main(String[] args) throws IOException {
        doGetNoProxy("http://www.baidu.com");
    }

}
