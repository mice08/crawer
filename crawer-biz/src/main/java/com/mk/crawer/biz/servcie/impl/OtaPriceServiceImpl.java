package com.mk.crawer.biz.servcie.impl;

import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.api.QunarHotelSyncService;
import com.mk.crawer.biz.mapper.crawer.OtaPriceMapper;
import com.mk.crawer.biz.model.crawer.*;
import com.mk.crawer.biz.servcie.*;
import com.mk.crawer.biz.utils.Constant;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.JsonUtils;
import com.mk.crawer.biz.utils.RedisUtil;
import com.mk.framework.AppUtils;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.manager.RedisCacheName;
import com.mk.framework.proxy.http.HttpUtil;
import com.mk.framework.proxy.http.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by kangxiaolong on 2016-01-12.
 */
@Service
public class OtaPriceServiceImpl implements OtaPriceService {
    private static Logger logger = LoggerFactory.getLogger(OtaPriceServiceImpl.class);
    @Autowired
    private OtaPriceMapper otaPriceMapper;

    @Autowired
    private HotelMappingService hotelMappingService;

    public Map<String,Object> getOtaPrice(OtaPrice record){
        Map<String, Object> result = new HashMap<String, Object>();
        if (record==null||(record.getExHotelId()==null&&record.getExRoomTypeId()==null
                &&record.getHotelId()==null&&record.getHotelSourceId()==null&&record.getOtsHotelId()==null
                && record.getOtsRoomTypeId()==null)){
            result.put("message","请求参数不正确");
            result.put("SUCCESS", false);
            return result;
        }
        OtaPrice otaPrice =otaPriceMapper.getValidDate(record);
        if (otaPrice==null||otaPrice.getCreateTime()==null){
            logger.info("=====otaPrice is null=====");
            result.put("message","数据为空");
            result.put("SUCCESS", false);
            return result;
        }
        logger.info("=====hotelSourceId={}&roomTypeKey={}&createTime={}=====",otaPrice.getHotelSourceId(),otaPrice.getRoomTypeKey(),otaPrice.getCreateTime());
        Calendar calendar=DateUtils.getCalendar(otaPrice.getCreateTime().substring(0,10));
        String validDate=DateUtils.formatDate(calendar.getTime());
        record.setCreateTime(validDate);
        List<OtaPrice> otaPriceList = otaPriceMapper.getOtaPrice(record);
        result.put("info",otaPriceList);
        result.put("SUCCESS", true);
        return result;
    }
    public Map<String,Object> catheOtaPrice(HotelMapping record){
        Map<String, Object> result = new HashMap<String, Object>();
        HotelMappingExample example = new HotelMappingExample();
        if (!StringUtils.isEmpty(record.getExHotelId())){
            example.createCriteria().andExHotelIdEqualTo(record.getExHotelId());
        }
        if (!StringUtils.isEmpty(record.getOtsHotelId())){
            example.createCriteria().andOtsHotelIdEqualTo(record.getOtsHotelId());
        }
        if (!StringUtils.isEmpty(record.getSite())){
            example.createCriteria().andSiteEqualTo(record.getSite());
        }
        example.createCriteria().andValidEqualTo("T");
        int  hotelCount= hotelMappingService.countByExample(example);
        int pageSize=1000;
        int count=hotelCount/pageSize;
        for (int i=0;i<=count;i++){
            example.setPageSize(pageSize);
            example.setPageIndex(i*pageSize);
            List<HotelMapping> hotelMappingList =hotelMappingService.selectByExample(example);
            if (CollectionUtils.isEmpty(hotelMappingList)){
                logger.info("=====hotelMappingList is empty=====");
                result.put("message","hotelMappingList is empty");
                result.put("SUCCESS", false);
                return result;
            }
            for (HotelMapping hotelMapping:hotelMappingList){
                if(hotelMapping.getExHotelId()==null){
                    continue;
                }
                OtaPrice priceBean = new OtaPrice();
                priceBean.setExHotelId(hotelMapping.getExHotelId());
                OtaPrice otaPrice =otaPriceMapper.getValidDate(priceBean);
                if (otaPrice==null||otaPrice.getCreateTime()==null){
                    logger.info("=====otaPrice is null=====");
                    continue;
                }
                logger.info("=====hotelSourceId={}&roomTypeKey={}&createTime={}=====",otaPrice.getHotelSourceId(),otaPrice.getRoomTypeKey(),otaPrice.getCreateTime());
                Calendar calendar=DateUtils.getCalendar(otaPrice.getCreateTime().substring(0,10));
                String validDate=DateUtils.formatDate(calendar.getTime());
                priceBean.setCreateTime(validDate);
                List<OtaPrice> otaPriceList = otaPriceMapper.getOtaPrice(priceBean);
                for (OtaPrice roomPrice:otaPriceList){
                    logger.info("=====hotelSourceId={}&roomTypeKey={}=====",roomPrice.getHotelSourceId(),roomPrice.getRoomTypeKey());
                    init2redis(
                            String.format("%s:%s:%s", RedisCacheName.CRAWER_OTAPRICE,
                                    roomPrice.getOtsHotelId(),roomPrice.getOtsRoomTypeId()),
                            roomPrice.getPrice().toString());
                }
            }
        }


        result.put("message","完成");
        result.put("SUCCESS", true);
        return result;
    }

    final private void init2redis(String key, String value) {
        Jedis jedis = RedisUtil.getJedis();
        try {
            jedis.set(key, value);
        } catch (Exception e) {
            throw e;
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
    }
}
