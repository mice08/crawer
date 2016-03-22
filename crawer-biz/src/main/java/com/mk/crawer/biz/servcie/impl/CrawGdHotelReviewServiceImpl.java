package com.mk.crawer.biz.servcie.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.api.dtos.HotelInfo;
import com.mk.crawer.api.dtos.Photos;
import com.mk.crawer.api.dtos.Pois;
import com.mk.crawer.api.dtos.ReviewList;
import com.mk.crawer.biz.mapper.crawer.GdCommentDetailMapper;
import com.mk.crawer.biz.mapper.crawer.GdHotelMapper;
import com.mk.crawer.biz.mapper.crawer.GdHotelPhotosMapper;
import com.mk.crawer.biz.mapper.ots.TCityListMapper;
import com.mk.crawer.biz.mapper.ots.TDistrictMapper;
import com.mk.crawer.biz.model.crawer.GdCommentDetail;
import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.crawer.GdHotelPhotos;
import com.mk.crawer.biz.model.ots.TCityList;
import com.mk.crawer.biz.model.ots.TDistrict;
import com.mk.crawer.biz.servcie.CrawGdHotelReviewService;
import com.mk.crawer.biz.servcie.CrawGdHotelService;
import com.mk.crawer.biz.utils.*;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by kirinli on 16/1/6.
 */
@Service
public class CrawGdHotelReviewServiceImpl implements CrawGdHotelReviewService {
    private static Logger logger = LoggerFactory.getLogger(CrawGdHotelReviewServiceImpl.class);
    private static ExecutorService pool = Executors.newFixedThreadPool(64);
    @Autowired
    GdHotelMapper hotelMapper;
    @Autowired
    GdCommentDetailMapper commentDetailMapper;
    public Map<String,Object> gdHotelCommetSync(GdHotel bean){
        Map<String,Object> resultMap=new HashMap<String,Object>();
        Cat.logEvent("gdHotelCommetSync","gdHotelCommetSync Crawler GAODE HOTEL Review", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime());
        logger.info(String.format("\n====================gdHotelCommetSync begin time={}====================\n"),DateUtils.getDatetime());
        int count = hotelMapper.count(bean);
        if (count<=0){
            resultMap.put("message","GD_HOTEL count is 0");
            resultMap.put("SUCCESS", false);
            return resultMap;
        }
        int pageSize=1000;
        int pageCount=count/pageSize;
        logger.info(String.format("\n====================size={}&pageSize={}&pageCount={}====================\n")
                ,count,pageSize,pageCount);
        for (int i=0;i<=pageCount;i++){
            logger.info(String.format("\n====================pageIndex={}====================\n")
                    ,i*pageSize);
            bean.setPageSize(pageSize);
            bean.setPageIndex(i*pageSize);
            List<GdHotel> hotelList = hotelMapper.qureyByPramas(bean);
            if (CollectionUtils.isEmpty(hotelList)){
                logger.info(String.format("\n====================hotelList is empty====================\n"));
                continue;
            }
            for(GdHotel hotel:hotelList){
                saveReview(hotel);
            }
        }
        Cat.logEvent("gdHotelCommetSync", "gdHotelCommetSync Crawler GAODE HOTEL Review", Event.SUCCESS,
                "endTime=" + DateUtils.getDatetime()
        );
        logger.info(String.format("\n====================gdHotelCommetSync  endTime={}====================\n")
                , DateUtils.getDatetime());
        resultMap.put("message","执行结束");
        resultMap.put("SUCCESS", true);
        return resultMap;
    }

    public String getRemoteDate(String hotelId,int pagesize,int pagenum){
        String uuid="cfcb5db3-6560-4af4-955c-4946e8d496e9";
        String classType="0";
        String pramas="pguid="+hotelId
                +"&pagesize="+pagesize
                +"&pagenum="+pagenum
                +"&output=json"
                +"&uid="+uuid;
        String url= Constant.gd_hotelReview+"?"+pramas;
        return HttpUtils.get_data(url,"GET");
    }
    private void saveReview(GdHotel hotel) {
        int pagesize=100;
        String data= getRemoteDate(hotel.getSourceId(),pagesize,1);
        if(StringUtils.isEmpty(data)){
            return;
        }
        Map<String,String> dataJson = JsonUtils.jsonToMap(data);
        Integer totalCount = dataJson.get("total_comments_num")==null?0:Integer.valueOf(dataJson.get("total_comments_num"));
        logger.info(String.format("\n====================id={}&sourceId={}&totalCount={}====================\n"),hotel.getId(),hotel.getSourceId(),totalCount);
        if (totalCount==0){
            return;
        }
        final  String hotelId = hotel.getSourceId();
        for (int i=1;i<=totalCount/pagesize+1;i++){
            String data1= getRemoteDate(hotel.getSourceId(),pagesize,i);
            if(StringUtils.isEmpty(data1)){
                logger.info(String.format("\n====================i={} data1 is empty====================\n"),i);
                continue;
            }
            ReviewList reviewList = JsonUtils.formatJson(data1,ReviewList.class);
            for (final ReviewList dto:reviewList.getReviewList()){
                pool.execute(new Runnable() {
                    @Override
                    public void run() {
                        GdCommentDetail commentDetail = new GdCommentDetail();
                        commentDetail.setHotelSourceId(hotelId);
                        commentDetail.setSrcType(dto.getSrcType());
                        commentDetail.setAuthor(dto.getAuthor());
                        commentDetail=commentDetailMapper.getByPramas(commentDetail);
                        if (commentDetail==null||commentDetail.getId()==null){
                            commentDetail=new GdCommentDetail();
                            BeanUtils.copyProperties(dto, commentDetail);
                            commentDetail.setHotelSourceId(hotelId);
                            commentDetailMapper.save(commentDetail);
                        }

                    }
                });
            }
        }
    }
}
