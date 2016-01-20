package com.mk.framework.proxy.http;

import com.mk.framework.proxy.Config;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.ThreadUtil;
import com.mk.framework.proxy.server.ProxyServer;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
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

    private static ThreadLocal<HttpClientContext> contextThreadLocal = new ThreadLocal<>();

    private static HttpClientContext getContext() {
        if ( contextThreadLocal.get() == null ) {
            contextThreadLocal.set(HttpClientContext.create());
        }

        return contextThreadLocal.get();
    }

    private static void removeContext() {
        contextThreadLocal.remove();
    }

    public static String doGet(String url) throws Exception {
        ProxyServer proxyServer = ThreadContext.PROXY_SERVER_THREAD_LOCAL.get();

        if ( proxyServer == null ) {
            throw new NullPointerException("没有为该线程绑定代理服务器对象");
        }

        String result;
        try {
            result = HttpUtil.doGet(url, proxyServer);
        } catch (Exception e) {
            removeContext();
            throw e;
        }

        if ( StringUtils.isEmpty(result)  ) {
            removeContext();
            throw new Exception("响应内容为空");
        } else if ( result.length() < 100 ) {
            removeContext();
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
            httpGet.setHeaders(Device.random().getHeaders());

            RequestConfig.Builder builder  = RequestConfig.custom();
            if (proxyServer != null) {
                LOGGER.info("使用代理：{}", JSONUtil.toJson(proxyServer));
                HttpHost httpHost = new HttpHost(proxyServer.getIp(), proxyServer.getPort());
                builder.setProxy(httpHost);
            } else {
                LOGGER.info("未使用代理");
            }

            builder.setSocketTimeout(Config.READ_TIMEOUT)
                   .setConnectionRequestTimeout(Config.READ_TIMEOUT)
                   .setConnectTimeout(Config.READ_TIMEOUT);

            httpGet.setConfig(builder.build());

            CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet, getContext());

            int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();

            HttpEntity httpEntity = closeableHttpResponse.getEntity();

            byte[] bytes = EntityUtils.toByteArray(httpEntity);

            String charset = CharsetDetector.guessEncoding(bytes);

            String result = new String(bytes, charset);

            if ( result.length() < 500 ) {
                LOGGER.info("响应内容：{}", result);
            } else {
                LOGGER.info("响应内容：{}", result.substring(0, 499));
            }

            LOGGER.info("响应码为：{}", statusCode);
            if ( statusCode != 200 ) {
                throw new IOException("响应码为：" + statusCode);
            }

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
            LOGGER.info(doGetNoProxy("http://pad.qunar.com/"));
//            LOGGER.info(doGetNoProxy("http://pad.qunar.com/api/hotel/hoteldetail?checkInDate=20160112&checkOutDate=20160113&keywords=&location=&seq=chongqing_city_10958&clickNum=0&isLM=0&type=0"));
            ThreadUtil.sleep(1000);
        }
//        LOGGER.info(doGetNoProxy("http://1212.ip138.com/ic.asp"));
//        LOGGER.info(doGetNoProxy("http://pad.qunar.com/api/hotel/hotellist?city=%E8%8A%92%E5%B8%82&fromDate=2016-01-09&toDate=2016-01-10"));
//        LOGGER.info(doGetNoProxy("http://www.xueshandai.com/"));
    }

}
