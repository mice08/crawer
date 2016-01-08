package com.mk.framework.proxy.http;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by 振涛 on 2016/1/6.
 */
public class HttpUtil {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(HttpUtil.class);

    public static String doGet(String url) {
        return doGet(url, 1);
    }

    static String doGet(String url, int count) {
        if ( count <= Config.FETCH_RETRY_TIMES ) {

            LOGGER.info("开始第{}次请求。", count);

            ProxyServer proxyServer = ProxyServerManager.random();
            try {
                String result = HttpUtil.doGet(url, proxyServer);

                if ( StringUtils.isEmpty(result) || result.length() < 100 ) {
                    throw new IOException("响应内容为：" + result);
                }

                return result;
            } catch (IOException e) {
                ProxyServerManager.addBadServer(proxyServer);
                ProxyServerManager.remove(proxyServer);
                LOGGER.warn("代理失效：{}, 可用代理{}个，失效代理{}个", JSONUtil.toJson(proxyServer), ProxyServerManager.count(), ProxyServerManager.countBadServer());
                return doGet(url, ++count);
            }
        } else {
            LOGGER.info("共进行了{}次请求，请求结束。", Config.FETCH_RETRY_TIMES);
            return null;
        }
    }

    public static String doGetNoProxy(String url)  {
        String resp = null;
        try {
            resp = doGet(url, null);
        } catch (IOException e) {
            LOGGER.error("请求出错：", e);

            e.printStackTrace();
        }
        return resp;
    }

    static String doGet(String urlStr, ProxyServer proxyServer) throws IOException {
        ThreadUtil.sleep(3000);

        LOGGER.info("发送请求：{}", urlStr);

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        HttpGet httpGet = new HttpGet(urlStr);

        httpGet.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        httpGet.addHeader("Accept-Encoding", "gzip, deflate, sdch");
        httpGet.addHeader("Accept-Language", "zh-CN,zh;q=0.8");
        httpGet.addHeader("Cache-Control", "max-age=0");
        httpGet.addHeader("Connection", "keep-alive");
        httpGet.addHeader("DNT", "1");
        httpGet.addHeader("Host", "pad.qunar.com");
        httpGet.addHeader("Upgrade-Insecure-Requests", "1");
        httpGet.addHeader("User-Agent", "Mozilla/5.0 (iPad; CPU OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");

        RequestConfig config;
        if (proxyServer != null) {
            LOGGER.info("使用代理：{}", JSONUtil.toJson(proxyServer));
            HttpHost httpHost = new HttpHost(proxyServer.getIp(), proxyServer.getPort());
            config = RequestConfig
                    .custom()
                    .setProxy(httpHost)
                    .setConnectTimeout(Config.READ_TIMEOUT)
                    .build();
        } else {
            config = RequestConfig
                    .custom()
                    .setConnectTimeout(Config.READ_TIMEOUT)
                    .build();
        }
        httpGet.setConfig(config);


        CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

        HttpEntity httpEntity = closeableHttpResponse.getEntity();

        String contentType= httpEntity.getContentType().getValue();

        String result;

        if ( contentType.contains("GBK") ) {
            result = EntityUtils.toString(httpEntity, "GBK");
        } else if ( contentType.contains("GB2312") ) {
            result = EntityUtils.toString(httpEntity, "GB2312");
        } else if ( contentType.contains("UTF-8") ) {
            result = EntityUtils.toString(httpEntity, "UTF-8");
        } else {
            result = EntityUtils.toString(httpEntity, "GBK");
        }

        LOGGER.info("获得响应：{}", result);
        return result;
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
//        LOGGER.info(doGet("http://1212.ip138.com/ic.asp"));
        LOGGER.info(doGet("http://pad.qunar.com/api/hotel/hotellist?city=%E8%8A%92%E5%B8%82&fromDate=2016-01-09&toDate=2016-01-10"));
    }

}
