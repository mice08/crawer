package com.mk.crawer.utils;

import com.mk.framework.UrlUtils;
import com.mk.framework.proxy.http.ProxyServer;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * Created by kirinli on 16/1/8.
 */
public class CrawerUtils {
    public  static String downloadChallageCode(ProxyServer proxyServer){

        URLConnection con = null;
        String fileName = null;
        try {
            String urlString = UrlUtils.getUrl("qunar.codeapi");
            URL url = new URL(urlString);
            // 打开连接
            con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5*1000);
            Properties prop = System.getProperties();
            if (proxyServer != null) {
                prop.put("http.proxyHost", proxyServer.getIp());
                prop.put("http.proxyPort", "" + proxyServer.getPort());
            }
            // 输入流
            InputStream is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            ;
            Random random =new Random(47);
            fileName = "challagecode/"+"code"+random.nextInt(1000000) + new Date().getTime();
            OutputStream os = new FileOutputStream(fileName);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();

            if (proxyServer != null) {
                prop.remove("http.proxyHost");
                prop.remove("http.proxyPort");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
