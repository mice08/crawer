package com.mk.framework.proxy.http;

import com.mk.framework.proxy.Config;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.ThreadUtil;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
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

    public static String doGet(String url) throws Exception {
        ProxyServer proxyServer = ProxyServerManager.random();

        String result;
        try {
            result = HttpUtil.doGet(url, proxyServer);
        } catch (Exception e) {
            ProxyServerManager.remove(proxyServer);
            throw e;
        }

        if ( StringUtils.isEmpty(result)  ) {
            ProxyServerManager.remove(proxyServer);
            throw new Exception("响应内容为空");
        } else if ( result.length() < 100 ) {
            ProxyServerManager.remove(proxyServer);
            throw new Exception(result);
        }

        return result;
    }

    public static String doGetNoProxy(String url)  {
        String resp = null;
        try {
            resp = doGet(url, null);
        } catch (IOException e) {
            LOGGER.error("请求出错：", e);
        }
        return resp;
    }

    public static String doGet(String urlStr, ProxyServer proxyServer) throws IOException {
        LOGGER.info("发送请求：{}", urlStr);

        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();

        CloseableHttpClient closeableHttpClient = httpClientBuilder.build();

        try {
            HttpGet httpGet = new HttpGet(urlStr);

            RequestConfig config;
            if (proxyServer != null) {
                LOGGER.info("使用代理：{}", JSONUtil.toJson(proxyServer));
                HttpHost httpHost = new HttpHost(proxyServer.getIp(), proxyServer.getPort());
                config = RequestConfig
                        .custom()
                        .setProxy(httpHost)
                        .setSocketTimeout(Config.READ_TIMEOUT)
                        .setConnectionRequestTimeout(Config.READ_TIMEOUT)
                        .setConnectTimeout(Config.READ_TIMEOUT)
                        .build();
            } else {
                LOGGER.info("未使用代理");
                config = RequestConfig
                        .custom()
                        .setSocketTimeout(Config.READ_TIMEOUT)
                        .setConnectionRequestTimeout(Config.READ_TIMEOUT)
                        .setConnectTimeout(Config.READ_TIMEOUT)
                        .build();
            }
            httpGet.setConfig(config);


            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

            LOGGER.info("响应码为：{}", closeableHttpResponse.getStatusLine().getStatusCode());

            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            byte[] bytes = EntityUtils.toByteArray(httpEntity);

            String charset = CharsetDetector.guessEncoding(bytes);

            String result = new String(bytes, charset);

            return result;
        } finally {
            if ( closeableHttpClient != null ) {
                closeableHttpClient.close();
            }
        }
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
        while ( true ) {
            LOGGER.info(doGetNoProxy("http://pad.qunar.com/api/hotel/hoteldetail?checkInDate=20160112&checkOutDate=20160113&keywords=&location=&seq=chongqing_city_10958&clickNum=0&isLM=0&type=0"));
            ThreadUtil.sleep(60000);
        }
//        LOGGER.info(doGetNoProxy("http://1212.ip138.com/ic.asp"));
//        LOGGER.info(doGetNoProxy("http://pad.qunar.com/api/hotel/hotellist?city=%E8%8A%92%E5%B8%82&fromDate=2016-01-09&toDate=2016-01-10"));
//        LOGGER.info(doGetNoProxy("http://www.xueshandai.com/"));
    }

}
