package com.mk.framework.proxy.http;

import org.slf4j.Logger;

import java.io.*;
import java.net.*;

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
            try {
                ProxyServer proxyServer = ProxyServerManager.random();
                return HttpUtil.doGet(url, proxyServer);
            } catch (IOException e) {
                LOGGER.error("请求出错：", e);

                return doGet(url, ++count);
            }
        } else {
            LOGGER.info("共进行了{}次请求，请求结束。", Config.FETCH_RETRY_TIMES);
            return null;
        }
    }

    static String doGetNoProxy(String url) throws IOException {
        return doGet(url, null);
    }

    static String doGet(String urlStr, ProxyServer proxyServer) throws IOException {
        LOGGER.info("发送请求：{}", urlStr);

        StringBuffer stringBuffer = new StringBuffer();

        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        HttpURLConnection httpUrlConn = null;

        try {
            URL url = new URL(urlStr);

            if ( proxyServer == null ) {
                httpUrlConn = (HttpURLConnection) url.openConnection();
            } else {
                Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyServer.getIp(), proxyServer.getPort()));
                httpUrlConn = (HttpURLConnection) url.openConnection(proxy);
            }

            httpUrlConn.setDoOutput(false);
            httpUrlConn.setDoInput(true);
            httpUrlConn.setUseCaches(false);

            httpUrlConn.setConnectTimeout(Config.FETCH_TIMEOUT);
            httpUrlConn.setReadTimeout(Config.FETCH_TIMEOUT);

            httpUrlConn.setRequestMethod("GET");

            httpUrlConn.connect();

            // 将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            String str;
            while ((str = bufferedReader.readLine()) != null) {
                stringBuffer.append(str);
            }
        } finally {
            if (httpUrlConn != null) httpUrlConn.disconnect();
            if (bufferedReader != null) bufferedReader.close();
            if (inputStreamReader != null) inputStreamReader.close();
            if (inputStream != null) inputStream.close();
        }

        String result = stringBuffer.toString();
        LOGGER.info("获得响应：{}", stringBuffer.toString());

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
        LOGGER.info(doGet("http://touch.qunar.com/h5/hotel/hotelcitylist"));
        LOGGER.info(doGet("http://pad.qunar.com/api/hotel/hotellist?city=%E6%AD%A6%E6%B1%89&cityUrl=wuhan_city&checkInDate=2016-01-05&checkOutDate=2016-01-06&location=&keywords=&pr=&level=&back=&page=3&tpl=hotel.hotelListTpl&_=1451997490018"));
        LOGGER.info(doGet("http://pad.qunar.com/api/hotel/hoteldetail?city=%E5%8C%97%E4%BA%AC&cityUrl=beijing_city&checkInDate=2016-01-05&checkOutDate=2016-01-06&keywords=&location=&seq=beijing_city_22493&clickNum=0&isLM=0&type=0&extra=%25257B%25257D"));
    }

}
