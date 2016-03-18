package com.mk.crawer.biz.servcie.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.api.dtos.HotelInfo;
import com.mk.crawer.api.dtos.Photos;
import com.mk.crawer.api.dtos.Pois;
import com.mk.crawer.biz.mapper.crawer.GdHotelMapper;
import com.mk.crawer.biz.mapper.crawer.GdHotelPhotosMapper;
import com.mk.crawer.biz.mapper.ots.TDistrictMapper;
import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.crawer.GdHotelPhotos;
import com.mk.crawer.biz.model.ots.TDistrict;
import com.mk.crawer.biz.servcie.CrawGdHotelService;
import com.mk.crawer.biz.utils.Constant;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.JsonUtils;
import com.mk.framework.proxy.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kirinli on 16/1/6.
 */
@Service
public class CrawGdHotelServiceImpl implements CrawGdHotelService {
    private static Logger logger = LoggerFactory.getLogger(CrawGdHotelServiceImpl.class);
    private static ExecutorService pool = Executors.newFixedThreadPool(64);
    @Autowired
    TDistrictMapper districtMapper;
    @Autowired
    GdHotelMapper hotelMapper;
    @Autowired
    GdHotelPhotosMapper hotelPhotosMapper;
    public Map<String,Object> gdHotelSync(TDistrict bean){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        Cat.logEvent("onlineRoomTypeToRedis","OnlineRoomType同步到Radis", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime());
        logger.info(String.format("\n====================onlineRoomTypeToRedis begin time={}====================\n"),DateUtils.getDatetime());
        List<TDistrict> districtList = districtMapper.qureyByPramas(bean);
        for (TDistrict cityBean : districtList){
            int offset = 50;
            Set<String> types = getTypes();
            for(String type:types){
                String data= getRemoteDate(cityBean.getCode(),offset,1,type);
                if(StringUtils.isEmpty(data)){
                    continue;
                }
                Map<String,String> dataJson = JsonUtils.jsonToMap(data);
                Integer count = dataJson.get("count")==null?0:Integer.valueOf(dataJson.get("count"));
                logger.info(String.format("\n====================types={}&cityCode={}====================\n"),type,cityBean.getCode());
                if (count==0){
                    continue;
                }
                for (int i=1;i<=count/offset+1;i++){
                    String data1= getRemoteDate(cityBean.getCode(),offset,i,type);
                    if(StringUtils.isEmpty(data1)){
                        continue;
                    }
                    HotelInfo hotelInfo = JsonUtils.formatJson(data1,HotelInfo.class);
                    for (Pois dto:hotelInfo.getPois()){
                        GdHotel gdHotel = new GdHotel();
                        BeanUtils.copyProperties(dto, gdHotel);
                        gdHotel.setSourceId(dto.getId());
                        hotelMapper.save(gdHotel);
                        for (Photos photo:dto.getPhotos()){
                            GdHotelPhotos hotelPhotos = new GdHotelPhotos();
                            BeanUtils.copyProperties(photo, hotelPhotos);
                            hotelPhotos.setHotelSourceId(dto.getId());
                            hotelPhotosMapper.save(hotelPhotos);
                        }
                    }
                }
            }
        }
        Cat.logEvent("onlineRoomTypeToRedis", "OnlineRoomType同步到Radis", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info(String.format("\n====================onlineRoomTypeToRedis  endTime={}====================\n")
                , DateUtils.getDatetime());
        resultMap.put("message","执行结束");
        resultMap.put("SUCCESS", true);
        return resultMap;
    }
    public String getRemoteDate(String city,int offset,int page,String types){
        String key="df3cf793df1bd2c257483c11e7176923";
        String children="1";
        String pramas="city="+city+
                "&key="+key
                +"&children="+children
                +"&types="+types
                +"&page="+page
                +"&offset="+offset
                +"&extensions=all";
        String url= Constant.gd_hostlist+"?"+pramas;
        return HttpUtil.doGetNoProxy(url);
    }
    public Set<String> getTypes() {
        Set<String> types = new HashSet<>();
        types.add("100000");
        types.add("100100");
        types.add("100101");
        types.add("100102");
        types.add("100103");
        types.add("100104");
        types.add("100105");
        types.add("100200");
        types.add("100201");
        return types;
    }

}
