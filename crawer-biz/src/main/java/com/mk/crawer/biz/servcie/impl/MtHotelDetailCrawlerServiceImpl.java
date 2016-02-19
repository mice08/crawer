package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.MtCityMapper;
import com.mk.crawer.biz.model.crawer.MtCity;
import com.mk.crawer.biz.model.crawer.MtHotel;
import com.mk.crawer.biz.servcie.MtHotelDetailCrawlerService;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.http.HttpUtil;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by BurizaDo on 2/18/16.
 */
@Service
public class MtHotelDetailCrawlerServiceImpl implements MtHotelDetailCrawlerService {
    private static String DETAIL_URL =
            "http://api.meituan.com/group/v2/poi/select/hotel?__skua=9212192ead397674e579274af291b25e&__vhost=api.hotel.meituan.com&cateId=20&category=5&checkIn=1454428800&checkOut=1454515200&ci=1&client=iphone&hourRoomCheckIn=1454428800&movieBundleVersion=100&msid=FCAD174C-4895-4BCE-8B0B-7D989F36080A2016-02-03-16-47161&mypos=31.166631%2C121.391890&poiAccommodationType=1&poiType=1&sort=smart&startendday=20160203~20160203&subType=0&utm_campaign=AgroupBgroupGhomepage_category3_20__a1&utm_content=98F15AC5E7F61A1E0B79BE06ADB58F096187A6F9CC97E142BA146E10F4B637F5&utm_medium=iphone&utm_source=AppStore&utm_term=6.4&uuid=98F15AC5E7F61A1E0B79BE06ADB58F096187A6F9CC97E142BA146E10F4B637F5&version_name=6.4";
    private static String DETAIL_URL_PARAM =
            "&cityId=%s&cityName=%s&limit=%d&offset=%d";

    @Autowired
    private MtCityMapper mapper;
    @Override
    public int crawHotelList(MtCity city) {
        int offset = 0, limit = 50;
        int totalCount = 0;
        while(true){
            String url = DETAIL_URL + String.format(DETAIL_URL_PARAM, city.id, city.name, limit, offset);
            try {
                String result = HttpUtil.doGet(url);
                MtHotel.MtHotelList hotelList = JSONUtil.fromJson(result, MtHotel.MtHotelList.class);
                totalCount += hotelList.data.size();
                if(hotelList.data.size() < limit){
                    break;
                }
                offset += limit;
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        return totalCount;
    }

    @Override
    public MtCity.MtCityList crawCityList(){
        MtCity.MtCityList cityList;
        boolean isProxyError = true;
        while(true) {
            try {
                if(isProxyError) {
                    ProxyServer proxyServer = ProxyServerManager.take();
                    ThreadContext.PROXY_SERVER_THREAD_LOCAL.set(proxyServer);
                }

                isProxyError = false;
                ///currently use no proxy, use proxy in case it's steady.
                String result = HttpUtil.doGetNoProxy("http://api.meituan.com/group/v1/city/list?__vhost=api.mobile.meituan.com&ci=10&cityId=10&client=iphone&env=prod&movieBundleVersion=100&msid=FCAD174C-4895-4BCE-8B0B-7D989F36080A2016-02-04-16-20941&show=all&utm_campaign=AgroupBgroupGhomepage_category3_20__a1&utm_content=98F15AC5E7F61A1E0B79BE06ADB58F096187A6F9CC97E142BA146E10F4B637F5&utm_medium=iphone&utm_source=AppStore&utm_term=6.4&uuid=98F15AC5E7F61A1E0B79BE06ADB58F096187A6F9CC97E142BA146E10F4B637F5&version_name=6.4");
                cityList = JSONUtil.fromJson(result, MtCity.MtCityList.class);
                for (MtCity city : cityList.data) {
                    mapper.insert(city);
                }
                break;
            } catch (Exception e) {
                if(e instanceof java.net.SocketTimeoutException){
                    isProxyError = true;
                }
                e.printStackTrace();
            }
        }
        return cityList;
    }
}
