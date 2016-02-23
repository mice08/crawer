package com.mk.crawer.biz.servcie.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mk.crawer.biz.mapper.crawer.MtCityMapper;
import com.mk.crawer.biz.mapper.crawer.MtHotelImageMapper;
import com.mk.crawer.biz.mapper.crawer.MtHotelMapper;
import com.mk.crawer.biz.mapper.crawer.MtHotelServiceMapper;
import com.mk.crawer.biz.model.crawer.MtCity;
import com.mk.crawer.biz.model.crawer.MtHotel;
import com.mk.crawer.biz.model.crawer.MtHotelService;
import com.mk.crawer.biz.model.crawer.MtImage;
import com.mk.crawer.biz.servcie.MtHotelDetailCrawlerService;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.http.HttpUtil;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

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
    @Autowired
    private MtHotelMapper hotelMapper;
    @Autowired
    private MtHotelServiceMapper serviceMapper;
    @Autowired
    private MtHotelImageMapper imageMapper;
    @Override
    public int crawHotelList(MtCity city) {
        int offset = 0, limit = 50;
        int totalCount = 0;
        boolean isProxyError = true;
        while(true){
            String cityName = "";
            try {
                cityName = URLEncoder.encode(city.name, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            String url = DETAIL_URL + String.format(DETAIL_URL_PARAM, city.id, cityName, limit, offset);
            MtHotel.MtHotelList hotelList;
            try {
                if(isProxyError) {
                    ProxyServer proxyServer = ProxyServerManager.take();
                    ThreadContext.PROXY_SERVER_THREAD_LOCAL.set(proxyServer);
                }
                isProxyError = false;

                String result = HttpUtil.doGetNoProxy(url);
                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

                hotelList = gson.fromJson(result, MtHotel.MtHotelList.class);
                if(hotelList == null){
                    continue;
                }
            } catch (Exception e) {
                if(e instanceof java.net.SocketTimeoutException){
                    isProxyError = true;
                    continue;
                }

                e.printStackTrace();
                ++ offset;
                continue;
            }

            if(hotelList != null) {
                for (MtHotel hotel : hotelList.data) {
                    try {
                        hotel.abstractsString = hotel.abstracts.toString();
                        hotel.campaignTagListString = hotel.campaignTagList.toString();
                        hotel.extraString = hotel.extra.toString();
                        hotel.fodderInfoString = hotel.fodderInfo.toString();
                        hotel.innImagesString = hotel.innImages.toString();
                        hotel.ktvString = hotel.ktv.toString();
                        hotel.payInfoString = hotel.payInfo.toString();
                        hotel.preTagsString = hotel.preTags.toString();
                        hotel.superVoucherString = hotel.superVoucher.toString();
                        hotel.tourString = hotel.tour.toString();
                        hotelMapper.insert(hotel);

                        if(!TextUtils.isEmpty(hotel.parkingInfo)) {
                            MtHotelService service = new MtHotelService();
                            service.attrDesc = "parkingInfo";
                            service.attrDetail = hotel.parkingInfo;
                            service.poiId = Integer.valueOf(hotel.poiid);
                            service.md5 = service.generateMD5();
                            serviceMapper.insert(service);
                        }

                        if(hotel.wifi) {
                            MtHotelService wifi = new MtHotelService();
                            wifi.attrDesc = "wifi";
                            wifi.attrDetail = String.valueOf(hotel.wifi);
                            wifi.poiId = Integer.valueOf(hotel.poiid);
                            wifi.md5 = wifi.generateMD5();
                            serviceMapper.insert(wifi);
                        }

                        if(!TextUtils.isEmpty(hotel.frontImg)){
                            MtImage image = new MtImage();
                            image.imgDesc = "frontImage";
                            image.poiid = Integer.valueOf(hotel.poiid);
                            image.url = hotel.frontImg;
                            image.md5 = image.generateMD5();
                            imageMapper.insert(image);
                        }

                        if(hotel.innImages != null && hotel.innImages.size() > 0){
                            MtImage image = new MtImage();
                            image.imgDesc = "innImages";
                            image.poiid = Integer.valueOf(hotel.poiid);
                            image.url = hotel.innImagesString;
                            image.md5 = image.generateMD5();
                            imageMapper.insert(image);
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                totalCount += hotelList.data.size();
                if (hotelList.data.size() < limit) {
                    break;
                }
                offset += limit;
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
                if (isProxyError) {
                    ProxyServer proxyServer = ProxyServerManager.take();
                    ThreadContext.PROXY_SERVER_THREAD_LOCAL.set(proxyServer);
                }

                isProxyError = false;
                ///currently use no proxy, use proxy in case it's steady.
                String result = HttpUtil.doGetNoProxy("http://api.meituan.com/group/v1/city/list?__vhost=api.mobile.meituan.com&ci=10&cityId=10&client=iphone&env=prod&movieBundleVersion=100&msid=FCAD174C-4895-4BCE-8B0B-7D989F36080A2016-02-04-16-20941&show=all&utm_campaign=AgroupBgroupGhomepage_category3_20__a1&utm_content=98F15AC5E7F61A1E0B79BE06ADB58F096187A6F9CC97E142BA146E10F4B637F5&utm_medium=iphone&utm_source=AppStore&utm_term=6.4&uuid=98F15AC5E7F61A1E0B79BE06ADB58F096187A6F9CC97E142BA146E10F4B637F5&version_name=6.4");
                cityList = JSONUtil.fromJson(result, MtCity.MtCityList.class);
                break;
            } catch (Exception e) {
                if(e instanceof java.net.SocketTimeoutException){
                    isProxyError = true;
                }
                e.printStackTrace();
            }
        }
        for (MtCity city : cityList.data) {
            try {
                mapper.insert(city);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return cityList;
    }
}
