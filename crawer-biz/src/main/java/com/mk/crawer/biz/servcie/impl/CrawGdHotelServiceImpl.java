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
                logger.info(String.format("\n====================types={}&cityCode={}&count={}====================\n"),type,cityBean.getCode(),count);
                if (count==0){
                    continue;
                }
                for (int i=1;i<=count/offset+1;i++){
                    String data1= getRemoteDate(cityBean.getCode(),offset,i,type);
                    if(StringUtils.isEmpty(data1)){
                        logger.info(String.format("\n====================i={} data1 is empty====================\n"),i);
                        continue;
                    }
                    HotelInfo hotelInfo = JsonUtils.formatJson(data1,HotelInfo.class);
                    for (final Pois dto:hotelInfo.getPois()){
                        pool.execute(new Runnable() {
                            @Override
                            public void run() {
                            logger.info(String.format("\n====================hotelSourceId={}====================\n"),dto.getSourceId());
                            GdHotel gdHotel =copyBean(dto);
                            GdHotel gdHotelCheck = new GdHotel();
                            gdHotelCheck.setSourceId(dto.getSourceId());
                            gdHotelCheck=hotelMapper.getByPramas(gdHotelCheck);
                            if (gdHotelCheck==null||gdHotelCheck.getId()==null){
                                hotelMapper.save(gdHotel);
                            }else {
                                gdHotel.setId(gdHotelCheck.getId());
                                gdHotel.setUpdateTime(new Date());
                                hotelMapper.updateById(gdHotel);
                            }
                            for (Photos photo:dto.getPhotos()){
                                GdHotelPhotos hotelPhotos = new GdHotelPhotos();
                                BeanUtils.copyProperties(photo, hotelPhotos);
                                hotelPhotos.setHotelSourceId(dto.getSourceId());
                                GdHotelPhotos hotelPhotosCheck = hotelPhotosMapper.getByPramas(hotelPhotos);
                                if (hotelPhotosCheck==null||hotelPhotosCheck.getId()==null) {
                                    hotelPhotosMapper.save(hotelPhotos);
                                }
                            }
                            }
                        });
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
    private GdHotel copyBean(Pois bean) {
        GdHotel gdHotel = new GdHotel();
        BeanUtils.copyProperties(bean, gdHotel);
        if (bean.getMatch()!=null){
            gdHotel.setMatch(Integer.valueOf(bean.getMatch()));
        }
        if (bean.getRecommend()!=null){
            gdHotel.setRecommend(Integer.valueOf(bean.getRecommend()));
        }
        if (bean.getIndoorMap()!=null){
            gdHotel.setIndoorMap(Integer.valueOf(bean.getIndoorMap()));
        }
        if (bean.getGroupbuyNum()!=null){
            gdHotel.setGroupBuyNum(Integer.valueOf(bean.getGroupbuyNum()));
        }
        if (bean.getDiscountNum()!=null){
            gdHotel.setDiscountNum(Integer.valueOf(bean.getDiscountNum()));
        }
        if (bean.getBizExt()!=null){
            gdHotel.setRating(bean.getBizExt().getRating());
            gdHotel.setStar(bean.getBizExt().getStar());
            gdHotel.setCost(bean.getBizExt().getCost());
            if (bean.getBizExt().getHotelOrdering()!=null){
                gdHotel.setHotelOrdering(Integer.valueOf(bean.getBizExt().getHotelOrdering()));
            }
            gdHotel.setLowestPrice(bean.getBizExt().getLowestPrice());

        }
        if (bean.getIndoorData()!=null){
            gdHotel.setCpId(bean.getIndoorData().getCpId());
            if (bean.getIndoorData().getFloor()!=null){
                gdHotel.setFloor(Integer.valueOf(bean.getIndoorData().getFloor()));
            }
            gdHotel.setTrueFloor(bean.getIndoorData().getTrueFloor());
        }
        return gdHotel;
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
