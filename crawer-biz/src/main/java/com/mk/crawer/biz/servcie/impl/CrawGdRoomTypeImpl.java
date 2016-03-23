package com.mk.crawer.biz.servcie.impl;

import com.alibaba.fastjson.JSON;
import com.dianping.cat.Cat;
import com.dianping.cat.message.Event;
import com.mk.crawer.biz.bean.*;
import com.mk.crawer.biz.mapper.crawer.GdHotelMapper;
import com.mk.crawer.biz.mapper.crawer.GdPlatformRoomTypeMapper;
import com.mk.crawer.biz.mapper.crawer.GdRoomPicMapper;
import com.mk.crawer.biz.mapper.crawer.GdRoomTypeMapper;
import com.mk.crawer.biz.model.crawer.GdHotel;
import com.mk.crawer.biz.model.crawer.GdPlatformRoomType;
import com.mk.crawer.biz.model.crawer.GdRoomPic;
import com.mk.crawer.biz.model.crawer.GdRoomType;
import com.mk.crawer.biz.servcie.CrawGdRoomType;
import com.mk.crawer.biz.utils.Constant;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.HttpUtils;
import com.mk.framework.AppUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chenqi on 16/3/22.
 */
@Service
public class CrawGdRoomTypeImpl implements CrawGdRoomType {
    private static final String GD_HOTEL_SEARCH_URL = "http://m.amap.com/service/valueadded/hotelsearch.json?poiid=%s&indate=%s&outdate=%s&mode=1";
    private static ExecutorService pool = Executors.newFixedThreadPool(32);
    private static ExecutorService exePool = Executors.newFixedThreadPool(10);
    private static Logger logger = LoggerFactory.getLogger(CrawGdHotelServiceImpl.class);

    @Autowired
    private GdHotelMapper gdHotelMapper;


    @Override
    public void executeRoomTypeToDb(LinkedBlockingQueue queue){
        exePool.execute(new ExecuteRoomTypeToDb(queue));
    }

    @Override
    public void crawGdRoomType(GdHotel bean, LinkedBlockingQueue queue){
        Cat.logEvent("crawGdRoomType","crawGdRoomType Crawler GAODE Room type info", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime());
        logger.info(String.format("\n====================crawGdRoomType begin time={}====================\n"),DateUtils.getDatetime());
        int count = gdHotelMapper.count(bean);
        if (count<=0){
          return;
        }
        Date now = new Date();
        String toDayStr = DateUtils.formatDateTime(now, DateUtils.FORMAT_DATE);
        String tomorrowStr = DateUtils.formatDateTime(DateUtils.addDays(now, 1), DateUtils.FORMAT_DATE);
        int pageSize=1000;
        int pageCount=count/pageSize;
        logger.info(String.format("\n====================size={}&pageSize={}&pageCount={}====================\n")
                ,count,pageSize,pageCount);
        Integer start =0;
        if (bean.getPageIndex()!=null){
            start=bean.getPageIndex();
        }
        for (int i=start;i<=1;i++){
            logger.info(String.format("\n====================pageIndex={}====================\n")
                    ,i*pageSize);
            bean.setPageSize(pageSize);
            bean.setPageIndex(i*pageSize);
            List<GdHotel> hotelList = gdHotelMapper.qureyByPramas(bean);
            if (CollectionUtils.isEmpty(hotelList)){
                logger.info(String.format("\n====================hotelList is empty====================\n"));
                continue;
            }
            for(GdHotel hotel:hotelList){
                pool.execute(new CrawGdRoomTypeThread(queue, String.format(GD_HOTEL_SEARCH_URL, hotel.getSourceId(), toDayStr, tomorrowStr), hotel.getSourceId()));
            }
        }
        Cat.logEvent("crawGdRoomType","crawGdRoomType Crawler GAODE Room type info", Event.SUCCESS,
                "beginTime=" + DateUtils.getDatetime());

    }

    private class CrawGdRoomTypeThread implements Runnable{
        private LinkedBlockingQueue queue;
        private String address;
        private String hotelSourceId;
        CrawGdRoomTypeThread(LinkedBlockingQueue queue, String address, String hotelSourceId){
            this.queue = queue;
            this.address = address;
            this.hotelSourceId = hotelSourceId;
        }

        @Override
        public void run() {
            String json = HttpUtils.get_data(address, "GET");
            RoomTypeInfo roomTypeInfo = JSON.parseObject(json, RoomTypeInfo.class);
            if("18".equals(roomTypeInfo.getCode().trim())){
                queue.add(hotelSourceId);
                return;
            }
            for(Roomlist room : roomTypeInfo.getRoomlist()){
                putRoomTypeToQueue(room, queue);
                putPlatformRoomTypeToQueue(room, queue);
                putPlatformRoomPicToQueue(room, queue);
            }
        }

        private void putPlatformRoomTypeToQueue(Roomlist room, LinkedBlockingQueue queue) {
            if(CollectionUtils.isEmpty(room.getMultilist())){
                return;
            }
            Date now = new Date();
            for(Multilist mu : room.getMultilist()){
                GdPlatformRoomType prt = new GdPlatformRoomType();
                prt.setBed(mu.getAverageprice());
                prt.setAveragePrice(mu.getAverageprice());
                prt.setBreakFast(mu.getBreakfast());
                prt.setHotelId(Long.valueOf(mu.getHotelid()));
                prt.setIsAvailable(mu.getIsavailable());
                prt.setIsVaild("T");
                try{
                    prt.setRoomId(mu.getRoomid());
                }catch (Exception e){
                    e.printStackTrace();
                }
                prt.setHotelSourceId(hotelSourceId);
                prt.setRoomTypeId(mu.getRoomtypeid());
                prt.setRoomTypeName(mu.getRoomtypename());
                prt.setSrcName(mu.getSrcName());
                prt.setSrcType(mu.getSrcType());
                prt.setUrl(mu.getUrl());
                prt.setTotalPrice(mu.getTotalPrice());
                prt.setBreakFast(mu.getBreakfast());
                prt.setCreateBy(Constant.sysUser);
                prt.setCreateTime(now);
                prt.setUpdateBy(Constant.sysUser);
                prt.setUpdateTime(now);
                queue.add(prt);
            }
        }

        private void putPlatformRoomPicToQueue(Roomlist room, LinkedBlockingQueue queue) {
            if(room.getRoomInfo() == null){
                return;
            }
            if(CollectionUtils.isEmpty(room.getRoomInfo().getPicInfo())){
                return;
            }
            for(PicInfo picInfo : room.getRoomInfo().getPicInfo()){
                Date now = new Date();
                GdRoomPic gdRoomPic = new GdRoomPic();
                gdRoomPic.setIsVaild("T");
                gdRoomPic.setRoomId(room.getMultilist().get(0).getRoomid());
                gdRoomPic.setRoomTypeId(room.getMultilist().get(0).getRoomtypeid());
                gdRoomPic.setUrl(picInfo.getUrl());
                gdRoomPic.setUrlType(picInfo.getSrcType());
                gdRoomPic.setCreateBy(Constant.sysUser);
                gdRoomPic.setCreateTime(now);
                gdRoomPic.setUpdateTime(now);
                gdRoomPic.setUpdateBy(Constant.sysUser);
                queue.add(gdRoomPic);
            }

        }
        private void putRoomTypeToQueue(Roomlist room, LinkedBlockingQueue queue) {
            if(room.getRoomInfo() == null){
                return;
            }
            Date now = new Date();
            GdRoomType roomType = new GdRoomType();
            roomType.setRoomTypeName(room.getMultilist().get(0).getRoomtypename());
            roomType.setHotelSourceId(hotelSourceId);
            roomType.setArea(room.getRoomInfo().getArea());
            roomType.setBed(room.getRoomInfo().getBed());
            roomType.setFloor(room.getRoomInfo().getFloor());
            roomType.setHotelId(Long.valueOf(room.getMultilist().get(0).getHotelid()));
            roomType.setIsVaild("T");
            roomType.setNetwork(room.getRoomInfo().getNetwork());
            roomType.setPriceLowest(new BigDecimal(room.getPriceLowest()));
            roomType.setRoomGroupId(Long.valueOf(room.getRoomgroupId()));
            roomType.setRoomId(room.getMultilist().get(0).getRoomid());
            roomType.setRoomTypeId(room.getMultilist().get(0).getRoomtypeid());
            roomType.setRoomStatus(Boolean.valueOf(room.getRoomStatus()) ? "T" : "F");
            roomType.setCreateBy(Constant.sysUser);
            roomType.setCreateTime(now);
            roomType.setUpdateTime(now);
            roomType.setUpdateBy(Constant.sysUser);
            queue.add(roomType);
        }
    }


    private class ExecuteRoomTypeToDb implements Runnable {
        private LinkedBlockingQueue queue;
        public ExecuteRoomTypeToDb(LinkedBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            GdRoomTypeMapper gdRoomTypeMapper = AppUtils.getBean(GdRoomTypeMapper.class);
            GdPlatformRoomTypeMapper gdPlatformRoomTypeMapper = AppUtils.getBean(GdPlatformRoomTypeMapper.class);
            GdRoomPicMapper gdRoomPicMapper = AppUtils.getBean(GdRoomPicMapper.class);
            GdHotelMapper gdHotelMapper = AppUtils.getBean(GdHotelMapper.class);
            while (true){
                try {
                    Object obj = queue.take();
                    if(obj == null){
                        Thread.sleep(10 * 1000);
                        continue;
                    }
                    if(obj instanceof GdRoomType){
                        gdRoomTypeMapper.insert((GdRoomType)obj);
                    }
                    if(obj instanceof GdPlatformRoomType){
                        gdPlatformRoomTypeMapper.insert((GdPlatformRoomType)obj);
                    }
                    if(obj instanceof GdRoomPic){
                        gdRoomPicMapper.insert((GdRoomPic)obj);
                    }
                    if(obj instanceof String){
                        GdHotel gdHotel = new GdHotel();
                        gdHotel.setSourceId((String)obj);
                        gdHotel.setUpdateTime(new Date());
                        gdHotel.setOtaOnsell("F");
                        gdHotelMapper.updateBySourceId(gdHotel);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String args[]) throws InterruptedException {
        LinkedBlockingQueue qu = new LinkedBlockingQueue();
        List<RoomInfo> l = new ArrayList<>();
        l.add(new RoomInfo());
        List<String> a = new ArrayList<>();
        a.add("1");
        qu.add(l);
        qu.add(a);
        Object obj = qu.take();
        if(obj instanceof List){
            if(((List) obj).get(0) instanceof RoomInfo){
                System.out.println(1);
            }
            if(((List) obj).get(0) instanceof String){
                System.out.println(2);
            }

        }


    }
}
