package com.mk.crawer.biz.model.crawer;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by BurizaDo on 2/18/16.
 */
public class MtHotel {
    public int id;
    @Expose
    public String phone;
    @Expose
    public int latestWeekCoupon;
    @Expose
    public JsonObject payInfo;//jsonobject
    public String payInfoString;
    @Expose
    public int cityId;
    @Expose
    public String addr;
    @Expose
    public int ktvAppointStatus;
    @Expose
    public String brandName;
    @Expose
    public int brandId;
    @Expose
    public String poiid;
    @Expose
    public JsonArray fodderInfo;//jsonarray
    public String fodderInfoString;
    @Expose
    public int groupInfo;
    @Expose
    public String showType;
    @Expose
    public int bizloginid;
    @Expose
    public String parkingInfo;
    @Expose
    public String useTime;
    @Expose
    public String chacDesc;
    @Expose
    public String brandLogo;
    @Expose
    public JsonObject extra;//jsonobject
    public String extraString;
    @Expose
    public JsonArray preTags;//jsonarray
    public String preTagsString;
    @Expose
    public String discount;
    @Expose
    public JsonArray innImages;//jsonarray
    public String innImagesString;
    @Expose
    public String frontImg;
    @Expose
    public String posText;
    @Expose
    public String historySaleCount;
    @Expose
    public int historyCouponCount;
    @Expose
    public float avgPrice;
    @Expose
    public String floor;
    @Expose
    public float avgScore;
    @Expose
    public int hotelAppointmentExtType;
    @Expose
    public int payType;
    @Expose
    public String hotelStar;
    @Expose
    public int dayRoomSpan;
    @Expose
    public float lowestPrice;
    @Expose
    public String introduction;
    @Expose
    public JsonObject superVoucher;//jsonobject
    public String superVoucherString;
    @Expose
    public int markNumbers;
    @Expose
    public double lng;
    @Expose
    public boolean hasPackage;
    @Expose
    public int areaId;
    @Expose
    public String subwayStationId;
    @Expose
    public boolean preferent;
    @Expose
    public String campaignTag;
    @Expose
    public boolean isSupportAppointment;
    @Expose
    public String posdescr;
    @Expose
    public String style;
    @Expose
    public String featureMenus;
    @Expose
    public String name;
    @Expose
    public int hourRoomSpan;
    @Expose
    public int hasSales;
    @Expose
    public String notice;
    @Expose
    public JsonArray campaignTagList;//jsonarray
    public String campaignTagListString;
    @Expose
    public double lat;
    @Expose
    public int sourceType;
    @Expose
    public float ktvLowestPrice;
    @Expose
    public int mallId;
    @Expose
    public int isHot;
    @Expose
    public boolean hasGroup;
    @Expose
    public String cates;
    @Expose
    public int zlSourceType;
    @Expose
    public boolean chooseSitting;
    @Expose
    public boolean isImax;
    @Expose
    public boolean isRoomListAggregated;
    @Expose
    public boolean wifi;
    @Expose
    public JsonObject ktv;//jsonobject
    public String ktvString;
    @Expose
    public JsonObject abstracts;//jsonobject
    public String abstractsString;
    @Expose
    public String areaName;
    @Expose
    public String iUrl;
    @Expose
    public String openInfo;
    @Expose
    public int isQueuing;
    @Expose
    public JsonObject tour;//jsonobject
    public String tourString;
    @Expose
    public int cateId;
    @Expose
    public String cateName;

    public static class MtHotelList{
        @Expose
        public List<MtHotel> data;
    }
}
