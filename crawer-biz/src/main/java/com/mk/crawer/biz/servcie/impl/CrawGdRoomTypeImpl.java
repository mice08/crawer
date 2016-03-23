package com.mk.crawer.biz.servcie.impl;

import com.alibaba.fastjson.JSON;
import com.mk.crawer.biz.bean.Multilist;
import com.mk.crawer.biz.bean.PicInfo;
import com.mk.crawer.biz.bean.RoomTypeInfo;
import com.mk.crawer.biz.bean.Roomlist;
import com.mk.crawer.biz.mapper.crawer.GdPlatformRoomTypeMapper;
import com.mk.crawer.biz.mapper.crawer.GdRoomPicMapper;
import com.mk.crawer.biz.mapper.crawer.GdRoomTypeMapper;
import com.mk.crawer.biz.model.crawer.GdPlatformRoomType;
import com.mk.crawer.biz.model.crawer.GdRoomPic;
import com.mk.crawer.biz.model.crawer.GdRoomType;
import com.mk.crawer.biz.servcie.CrawGdRoomType;
import com.mk.crawer.biz.utils.Constant;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.HttpUtils;
import com.mk.framework.AppUtils;
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
    private static ExecutorService pool = Executors.newFixedThreadPool(64);

    @Override
    public void executeRoomTypeToDb(LinkedBlockingQueue queue){
        pool.execute(new ExecuteRoomTypeToDb(queue));
    }

    @Override
    public void crawGdRoomType(LinkedBlockingQueue queue){
        Date now = new Date();
        String toDayStr = DateUtils.formatDateTime(now, DateUtils.FORMAT_DATE);
        String tomorrowStr = DateUtils.formatDateTime(DateUtils.addDays(now, 1), DateUtils.FORMAT_DATE);
        String json = HttpUtils.get_data(String.format(GD_HOTEL_SEARCH_URL, "B000A7O2PV", toDayStr, tomorrowStr), "GET");
        pool.execute(new CrawGdRoomTypeThread(queue, json));
    }

    private class CrawGdRoomTypeThread implements Runnable{
        private LinkedBlockingQueue queue;
        private String json;
        CrawGdRoomTypeThread(LinkedBlockingQueue queue, String json){
            this.queue = queue;
            this.json = json;
        }

        @Override
        public void run() {
            RoomTypeInfo roomTypeInfo = JSON.parseObject(json, RoomTypeInfo.class);
            for(Roomlist room: roomTypeInfo.getRoomlist()){
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
                prt.setRoomId(Long.valueOf(mu.getRoomid()));
                prt.setRoomTypeId(Long.valueOf(mu.getRoomtypeid()));
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
            if(CollectionUtils.isEmpty(room.getRoomInfo().getPicInfo())){
                return;
            }
            for(PicInfo picInfo : room.getRoomInfo().getPicInfo()){
                Date now = new Date();
                GdRoomPic gdRoomPic = new GdRoomPic();
                gdRoomPic.setIsVaild("T");
                gdRoomPic.setRoomId(Long.valueOf(room.getMultilist().get(0).getRoomid()));
                gdRoomPic.setRoomTypeId(Long.valueOf(room.getMultilist().get(0).getRoomtypeid()));
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
            roomType.setArea(room.getRoomInfo().getArea());
            roomType.setBed(room.getRoomInfo().getBed());
            roomType.setFloor(room.getRoomInfo().getFloor());
            roomType.setHotelId(Long.valueOf(room.getMultilist().get(0).getHotelid()));
            roomType.setIsVaild("T");
            roomType.setNetwork(room.getRoomInfo().getNetwork());
            roomType.setPriceLowest(new BigDecimal(room.getPriceLowest()));
            roomType.setRoomGroupId(Long.valueOf(room.getRoomgroupId()));
            roomType.setRoomId(Long.valueOf(room.getMultilist().get(0).getRoomid()));
            roomType.setRoomTypeId(Long.valueOf(room.getMultilist().get(0).getRoomtypeid()));
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
            List<GdRoomType> gdRoomTypeVector =  new Vector<>();
            List<GdPlatformRoomType> gdPlatformRoomTypeVector =  new Vector<>();
            List<GdRoomPic> gdRoomPicVector =  new Vector<>();
            GdRoomTypeMapper gdRoomTypeMapper = AppUtils.getBean(GdRoomTypeMapper.class);
            GdPlatformRoomTypeMapper gdPlatformRoomTypeMapper = AppUtils.getBean(GdPlatformRoomTypeMapper.class);
            GdRoomPicMapper gdRoomPicMapper = AppUtils.getBean(GdRoomPicMapper.class);
            while (true){
                try {
                    Object obj = queue.take();
                    if(obj == null){
                        Thread.sleep(10 * 1000);
                        continue;
                    }
                    if(obj instanceof GdRoomType){
                        /*if( gdRoomPicVector.size() > 1000){
                            gdRoomTypeMapper.batchInsert(gdRoomPicVector);
                            gdRoomPicVector.clear();
                        }
                        gdRoomTypeVector.add((GdRoomType)obj);*/
                        gdRoomTypeMapper.insert((GdRoomType)obj);
                    }
                    if(obj instanceof GdPlatformRoomType){
                        /*if(gdPlatformRoomTypeVector.size() > 1000){
                            gdPlatformRoomTypeMapper.batchInsert(gdPlatformRoomTypeVector);
                            gdPlatformRoomTypeVector.clear();
                        }
                        gdPlatformRoomTypeVector.add((GdPlatformRoomType)obj);*/
                        gdPlatformRoomTypeMapper.insert((GdPlatformRoomType)obj);
                    }
                    if(obj instanceof GdRoomPic){
                        /*if(gdRoomPicVector.size() > 1000){
                            gdRoomPicMapper.batchInsert(gdRoomPicVector);
                            gdRoomPicVector.clear();
                        }
                        gdRoomPicVector.add((GdRoomPic)obj);*/
                        gdRoomPicMapper.insert((GdRoomPic)obj);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String args[]){
        Date now = new Date();
        String toDayStr = DateUtils.formatDateTime(now, DateUtils.FORMAT_DATE);
        String tomorrowStr = DateUtils.formatDateTime(DateUtils.addDays(now, 1), DateUtils.FORMAT_DATE);
        String json = HttpUtils.get_data(String.format(GD_HOTEL_SEARCH_URL, "B000A7O2PV", toDayStr, tomorrowStr), "GET");
        System.out.println(json);
        RoomTypeInfo roomTypeInfo = JSON.parseObject(json, RoomTypeInfo.class);
        Roomlist room = roomTypeInfo.getRoomlist().get(0);
        GdRoomType roomType = new GdRoomType();
        roomType.setRoomTypeName(room.getMultilist().get(0).getRoomtypename());
        roomType.setArea(room.getRoomInfo().getArea());
        roomType.setBed(room.getRoomInfo().getBed());
        roomType.setFloor(room.getRoomInfo().getFloor());
        roomType.setHotelId(Long.valueOf(room.getMultilist().get(0).getHotelid()));
        roomType.setIsVaild("T");
        roomType.setNetwork(room.getRoomInfo().getNetwork());
        roomType.setPriceLowest(new BigDecimal(room.getPriceLowest()));
        roomType.setRoomGroupId(Long.valueOf(room.getRoomgroupId()));
        roomType.setRoomId(Long.valueOf(room.getMultilist().get(0).getRoomid()));
        roomType.setRoomTypeId(Long.valueOf(room.getMultilist().get(0).getRoomtypeid()));
        roomType.setRoomStatus(Boolean.valueOf(room.getRoomStatus()) ? "T" : "F");
        roomType.setCreateBy(Constant.sysUser);
        roomType.setCreateTime(now);
        roomType.setUpdateTime(now);
        roomType.setUpdateBy(Constant.sysUser);
        Boolean.valueOf("true");
    }
}
