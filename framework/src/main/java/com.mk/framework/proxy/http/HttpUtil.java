package com.mk.framework.proxy.http;

import org.slf4j.Logger;
import org.springframework.util.StringUtils;

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

            //获取编码
            String contentType = httpUrlConn.getHeaderField("Content-Type");
            String charSet = "UTF-8";
            if (!StringUtils.isEmpty(contentType)) {
                if (contentType.indexOf("GBK") != -1) {
                    charSet = "GBK";
                } else if (contentType.indexOf("GB2312") != -1) {
                    charSet = "GB2312";
                }
            }

            // 将返回的输入流转换成字符串
            inputStream = httpUrlConn.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, charSet);
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
        LOGGER.info(doGetNoProxy("http://bdapi.qunar.com/api/map.jsp?city=芒市&fromDate=2016-01-08&toDate=2016-01-09"));
    }

}
