package com.mk.crawer.biz.model.crawer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by BurizaDo on 2/18/16.
 */
public class MtHotel {
    public String phone;
    public int latestWeekCoupon;
    public JSONObject payInfo;
    public int cityId;
    public String addr;
    public int ktvAppointStatus;
    public String brandName;
    public int brandId;
    public String poiid;
    public JSONArray fodderInfo;
    public int groupInfo;
    public String showType;
    public int bizloginid;
    public String parkingInfo;
    public String useTime;
    public String chacDesc;
    public String brandLogo;
    public JSONObject extra;
    public JSONArray preTags;
    public String discount;
    public JSONArray innImages;
    public String frontImg;
    public String posText;
    public String historySaleCount;
    public int historyCouponCount;
    public int avgPrice;
    public String floor;
    public float avgScore;
    public int hotelAppointmentExtType;
    public int payType;
    public String hotelStar;
    public int dayRoomSpan;
    public int lowestPrice;
    public String introduction;
    public JSONObject superVoucher;
    public int markNumbers;
    public double lng;
    public boolean hasPackage;
    public int areaId;
    public String subwayStationId;
    public boolean preferent;
    public String campaignTag;
    public boolean isSupportAppointment;
    public String posdescr;
    public String style;
    public String featureMenus;
    public String name;
    public int hourRoomSpan;
    public int hasSales;
    public String notice;
    public JSONArray campaignTagList;
    public double lat;
    public int sourceType;
    public int ktvLowestPrice;
    public int mallId;
    public int isHot;
    public boolean hasGroup;
    public String cates;
    public int zlSourceType;
    public boolean chooseSitting;
    public boolean isImax;
    public boolean isRoomListAggregated;
    public boolean wifi;
    public JSONObject ktv;
    public JSONObject abstracts;
    public String areaName;
    public String iUrl;
    public String openInfo;
    public int isQueuing;
    public JSONObject tour;
    public int cateId;
    public String cateName;

    public static class MtHotelList{
        public List<MtHotel> data;
    }
}
