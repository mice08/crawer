package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.HotelImageMapper;
import com.mk.crawer.biz.model.crawer.HotelImage;
import com.mk.crawer.biz.servcie.IHotelImageService;
import com.mk.framework.proxy.JSONUtil;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.http.HttpUtil;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 振涛 on 2016/1/21.
 */
@Service
public class HotelImageService implements IHotelImageService {

    private static final String URL = "http://pad.qunar.com/api/hotel/hotelimage?seq=%s";

    private static final String T = "T";

    private static final String F = "F";

    @Autowired
    private HotelImageMapper hotelImageMapper;

    private class HotelImageAll {
        int status = -1;
        Data data;
    }

    private class Data {
        boolean flag;
        int status;
        ResultStr resultStr;
    }

    private class ResultStr {
        String cityName;
        String cityurl;
        String hotelSEQ;
        String hotelName;
        String hotelAddress;
        List<Image> imgs;
    }

    private class Image {
        String big;
        String url;
        String tag;
        String src;
        boolean ugc;
        String osrc;
        String cre_date;
        String title;
        String author;
        int width;
        int height;
    }

    @Override
    public void crawl(String hotelId) throws Exception {
        HotelImage tmp = new HotelImage();
        tmp.setHotelSourceId(hotelId);
        HotelImage tmpHotelImage = hotelImageMapper.selectByRecord(tmp);

        if (tmpHotelImage != null && StringUtils.isNotBlank(tmpHotelImage.getHotelSourceId())){
            System.out.println("======skip crawl hotel " + hotelId +" image");
            return;
        }

        System.out.println("%%%%%%%%%%%%%%%%%%begin crawl hotel " + hotelId +"image");
        String result="";
        try{
            String url = String.format(URL, hotelId);

            result = HttpUtil.doGetNoProxy(url);

            HotelImageAll hotelImageAll = JSONUtil.fromJson(result, HotelImageAll.class);

            if ( hotelImageAll.status != 0 ) {
                throw new IllegalArgumentException("response code is "+hotelImageAll.status);
            } else if ( hotelImageAll.data == null ) {
                throw new IllegalArgumentException("response data is null");
            } else if ( hotelImageAll.data.resultStr == null ) {
                throw new IllegalArgumentException("response resultStr is null");
            } else if ( hotelImageAll.data.resultStr.imgs == null ) {
                throw new IllegalArgumentException("response imgs is null");
            }

            for (Image image : hotelImageAll.data.resultStr.imgs) {
                HotelImage hotelImage = new HotelImage();
                hotelImage.setCityName(hotelImageAll.data.resultStr.cityName);
                hotelImage.setCityUrl(hotelImageAll.data.resultStr.cityurl);
                hotelImage.setHotelSourceId(hotelId);
                hotelImage.setHotelName(hotelImageAll.data.resultStr.hotelName);
                hotelImage.setHotelAddress(hotelImageAll.data.resultStr.hotelAddress);

                hotelImage.setBig(image.big);
                hotelImage.setUrl(image.url);
                hotelImage.setTag(image.tag);
                hotelImage.setSrc(image.src);
                if (image.ugc) {
                    hotelImage.setUgc(T);
                } else {
                    hotelImage.setUgc(F);
                }
                hotelImage.setOsrc(image.osrc);
                hotelImage.setCreDate(image.cre_date);
                hotelImage.setTitle(image.title);
                hotelImage.setAuthor(image.author);
                hotelImage.setWidth((long) image.width);
                hotelImage.setHeight((long) image.height);

                hotelImage.setCreateTime(new Date());
                hotelImage.setUpdateTime(new Date());

                insert(hotelImage);
            }

        }catch (Exception e){
            System.out.println(result);
            e.printStackTrace();
        }

    }

    private int insert(HotelImage record)throws Exception {
        try{
            HotelImage hotelImage = hotelImageMapper.selectByRecord(record);

            if (hotelImage ==null || StringUtils.isNotBlank(hotelImage.getHotelSourceId())){
                return hotelImageMapper.insert(record);
            }else {
                return 0;
            }
        }catch (Exception e){
            throw e;
        }


    }

}
