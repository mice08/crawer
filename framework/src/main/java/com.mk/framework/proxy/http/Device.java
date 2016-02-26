package com.mk.framework.proxy.http;

import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by 振涛 on 2016/1/14.
 */
public class Device {

    static class HeaderConfig {

        private List<Header> deviceList = new ArrayList<>();

        public static HeaderConfig custom() {
            return new HeaderConfig();
        }

        public HeaderConfig add(String key, String name) {
            BasicHeader header = new BasicHeader(key, name);

            deviceList.add(header);

            return this;
        }

        public HeaderConfig add(Header[] headers) {
            if ( headers != null ) {
                for (Header header : headers) {
                    deviceList.add(header);
                }
            }

            return this;
        }

        public Header[] toArray() {
            Header[] headers = new Header[deviceList.size()];

            for (int i = 0; i < deviceList.size(); i++) {
                headers[i] = deviceList.get(i);
            }

            return headers;
        }
    }

    public static class AppleIPad implements IRequestHead {
        @Override
        public Header[] getHeaders() {
            String cookie = "QN48=pd_650ae0a633f5adbc_1531bf1c81f_159a";
            try {
                 cookie = HttpUtil.getCookies();
            } catch (IOException e) {
                cookie = "QN48=pd_650ae0a633f5adbc_1531bf1c81f_159a";
                e.printStackTrace();
            }

           return HeaderConfig
                    .custom()
                    .add("DNT", "1")
                    .add("User-Agent", "Mozilla/5.0 (iPad; CPU OS 7_0 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53")
                    .add("Referer", "http://pad.qunar.com")
                    .add("X-Requested-With", "XMLHttpRequest")
                    .add("Cookie", cookie)
                    .toArray();
        }
    }

    public static class AppleIPadMin implements IRequestHead {
        @Override
        public Header[] getHeaders() {
            String cookie = "QN48=pd_650ae0a633f5adbc_1531bf1c81f_159a";
            try {
                cookie = HttpUtil.getCookies();
            } catch (IOException e) {
                cookie = "QN48=pd_650ae0a633f5adbc_1531bf1c81f_159a";
                e.printStackTrace();
            }
            return HeaderConfig
                    .custom()
                    .add("DNT", "1")
                    .add("User-Agent", "Mozilla/5.0 (iPad; CPU OS 7_0_4 like Mac OS X) AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11B554a Safari/9537.53")
                    .add("Referer", "http://pad.qunar.com")
                    .add("X-Requested-With", "XMLHttpRequest")
                    .add("Cookie", cookie)
                    .toArray();
        }
    }

    public static class AmazonKindleFireHD implements IRequestHead {
        @Override
        public Header[] getHeaders() {
            return HeaderConfig
                    .custom()
                    .add("DNT", "1")
                    .add("User-Agent", "Mozilla/5.0 (Linux; U; en-us; KFAPWI Build/JDQ39) AppleWebKit/535.19 (KHTML, like Gecko) Silk/3.13 Safari/535.19 Silk-Accelerated=true")
                    .add("Host", "http://pad.qunar.com")
                    .add("Connection", "keep-alive")
                    .add("X-Requested-With", "XMLHttpRequest")
                    .add("Cookie", "QN48=pd_650ae0a633f5adbc_1531bf1c81f_159a")
                    .toArray();
        }
    }

    public static class GoogleNexus10 implements IRequestHead {
        @Override
        public Header[] getHeaders() {
            return HeaderConfig
                    .custom()
                    .add("DNT", "1")
                    .add("User-Agent", "Mozilla/5.0 (Linux; Android 4.3; Nexus 10 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2307.2 Safari/537.36")
                    .add("Host", "http://pad.qunar.com")
                    .add("Connection", "keep-alive")
                    .add("X-Requested-With", "XMLHttpRequest")
                    .add("Cookie", "QN48=pd_650ae0a633f5adbc_1531bf1c81f_159a")
                    .toArray();
        }
    }

    public static class GoogleNexus7 implements IRequestHead {
        @Override
        public Header[] getHeaders() {
            return HeaderConfig
                    .custom()
                    .add("DNT", "1")
                    .add("User-Agent", "Mozilla/5.0 (Linux; Android 4.3; Nexus 7 Build/JSS15Q) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2307.2 Safari/537.36")
                    .add("Host", "http://pad.qunar.com")
                    .add("Connection", "keep-alive")
                    .add("X-Requested-With", "XMLHttpRequest")
                    .add("Cookie", "QN48=pd_650ae0a633f5adbc_1531bf1c81f_159a")
                    .toArray();
        }
    }


    private static List<IRequestHead> deviceList = new ArrayList<>();

    private static Random random = new Random();

    static {
        deviceList.add(new AppleIPad());
        deviceList.add(new AppleIPadMin());
      //  deviceList.add(new AmazonKindleFireHD());
       // deviceList.add(new GoogleNexus10());
        //deviceList.add(new GoogleNexus7());
    }

    public static IRequestHead random() {
        return deviceList.get(random.nextInt(deviceList.size()));
    }

}
