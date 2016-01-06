package com.mk.crawer.biz.model;

import java.math.BigDecimal;
import java.util.Date;

public class RoomType {
    private Long id;

    private Long hotelId;

    private String bedType;

    private String roomName;

    private String roomType;

    private String area;

    private BigDecimal networkPrice;

    private String roomCategory;

    private String rtArea;

    private String rtFloor;

    private String rtBroadband;

    private String rtBedtype;

    private String rtAddbed;

    private String bath;

    private String window;

    private String wifi;

    private Long maxCustomers;

    private Long addBedPrice;

    private String currencySign;

    private String extraBed;

    private String orderAll;

    private BigDecimal mprice;

    private String hasQuickCheckIn;

    private String haveCoupons;

    private String outerShow;

    private String districtName;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType == null ? null : bedType.trim();
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName == null ? null : roomName.trim();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType == null ? null : roomType.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    public BigDecimal getNetworkPrice() {
        return networkPrice;
    }

    public void setNetworkPrice(BigDecimal networkPrice) {
        this.networkPrice = networkPrice;
    }

    public String getRoomCategory() {
        return roomCategory;
    }

    public void setRoomCategory(String roomCategory) {
        this.roomCategory = roomCategory == null ? null : roomCategory.trim();
    }

    public String getRtArea() {
        return rtArea;
    }

    public void setRtArea(String rtArea) {
        this.rtArea = rtArea == null ? null : rtArea.trim();
    }

    public String getRtFloor() {
        return rtFloor;
    }

    public void setRtFloor(String rtFloor) {
        this.rtFloor = rtFloor == null ? null : rtFloor.trim();
    }

    public String getRtBroadband() {
        return rtBroadband;
    }

    public void setRtBroadband(String rtBroadband) {
        this.rtBroadband = rtBroadband == null ? null : rtBroadband.trim();
    }

    public String getRtBedtype() {
        return rtBedtype;
    }

    public void setRtBedtype(String rtBedtype) {
        this.rtBedtype = rtBedtype == null ? null : rtBedtype.trim();
    }

    public String getRtAddbed() {
        return rtAddbed;
    }

    public void setRtAddbed(String rtAddbed) {
        this.rtAddbed = rtAddbed == null ? null : rtAddbed.trim();
    }

    public String getBath() {
        return bath;
    }

    public void setBath(String bath) {
        this.bath = bath == null ? null : bath.trim();
    }

    public String getWindow() {
        return window;
    }

    public void setWindow(String window) {
        this.window = window == null ? null : window.trim();
    }

    public String getWifi() {
        return wifi;
    }

    public void setWifi(String wifi) {
        this.wifi = wifi == null ? null : wifi.trim();
    }

    public Long getMaxCustomers() {
        return maxCustomers;
    }

    public void setMaxCustomers(Long maxCustomers) {
        this.maxCustomers = maxCustomers;
    }

    public Long getAddBedPrice() {
        return addBedPrice;
    }

    public void setAddBedPrice(Long addBedPrice) {
        this.addBedPrice = addBedPrice;
    }

    public String getCurrencySign() {
        return currencySign;
    }

    public void setCurrencySign(String currencySign) {
        this.currencySign = currencySign == null ? null : currencySign.trim();
    }

    public String getExtraBed() {
        return extraBed;
    }

    public void setExtraBed(String extraBed) {
        this.extraBed = extraBed == null ? null : extraBed.trim();
    }

    public String getOrderAll() {
        return orderAll;
    }

    public void setOrderAll(String orderAll) {
        this.orderAll = orderAll == null ? null : orderAll.trim();
    }

    public BigDecimal getMprice() {
        return mprice;
    }

    public void setMprice(BigDecimal mprice) {
        this.mprice = mprice;
    }

    public String getHasQuickCheckIn() {
        return hasQuickCheckIn;
    }

    public void setHasQuickCheckIn(String hasQuickCheckIn) {
        this.hasQuickCheckIn = hasQuickCheckIn == null ? null : hasQuickCheckIn.trim();
    }

    public String getHaveCoupons() {
        return haveCoupons;
    }

    public void setHaveCoupons(String haveCoupons) {
        this.haveCoupons = haveCoupons == null ? null : haveCoupons.trim();
    }

    public String getOuterShow() {
        return outerShow;
    }

    public void setOuterShow(String outerShow) {
        this.outerShow = outerShow == null ? null : outerShow.trim();
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}