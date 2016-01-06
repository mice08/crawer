package com.mk.crawer.biz.model;

import java.math.BigDecimal;
import java.util.Date;

public class Hotel {
    private Long id;

    private String cityName;

    private Long distance;

    private BigDecimal price;

    private String hasBreakfast;

    private Long imageCount;

    private String hasFitnessRoom;

    private BigDecimal commentScore;

    private String hasBusinessCenter;

    private String hasRestaurant;

    private Long hotelStars;

    private String bpoint;

    private String gpoint;

    private String phoneNumber;

    private String hotelBrand;

    private String tradingArea;

    private String isWebFree;

    private String dangCi;

    private String hotelName;

    private String hotelAddress;

    private String imageId;

    private String hasMeetingOrBanquetSpace;

    private String hasIndoorPool;

    private String hasNonSmokingAvailable;

    private String oneSentence;

    private Long commentCount;

    private String hotelArea;

    private String shortName;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public Long getDistance() {
        return distance;
    }

    public void setDistance(Long distance) {
        this.distance = distance;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getHasBreakfast() {
        return hasBreakfast;
    }

    public void setHasBreakfast(String hasBreakfast) {
        this.hasBreakfast = hasBreakfast == null ? null : hasBreakfast.trim();
    }

    public Long getImageCount() {
        return imageCount;
    }

    public void setImageCount(Long imageCount) {
        this.imageCount = imageCount;
    }

    public String getHasFitnessRoom() {
        return hasFitnessRoom;
    }

    public void setHasFitnessRoom(String hasFitnessRoom) {
        this.hasFitnessRoom = hasFitnessRoom == null ? null : hasFitnessRoom.trim();
    }

    public BigDecimal getCommentScore() {
        return commentScore;
    }

    public void setCommentScore(BigDecimal commentScore) {
        this.commentScore = commentScore;
    }

    public String getHasBusinessCenter() {
        return hasBusinessCenter;
    }

    public void setHasBusinessCenter(String hasBusinessCenter) {
        this.hasBusinessCenter = hasBusinessCenter == null ? null : hasBusinessCenter.trim();
    }

    public String getHasRestaurant() {
        return hasRestaurant;
    }

    public void setHasRestaurant(String hasRestaurant) {
        this.hasRestaurant = hasRestaurant == null ? null : hasRestaurant.trim();
    }

    public Long getHotelStars() {
        return hotelStars;
    }

    public void setHotelStars(Long hotelStars) {
        this.hotelStars = hotelStars;
    }

    public String getBpoint() {
        return bpoint;
    }

    public void setBpoint(String bpoint) {
        this.bpoint = bpoint == null ? null : bpoint.trim();
    }

    public String getGpoint() {
        return gpoint;
    }

    public void setGpoint(String gpoint) {
        this.gpoint = gpoint == null ? null : gpoint.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getHotelBrand() {
        return hotelBrand;
    }

    public void setHotelBrand(String hotelBrand) {
        this.hotelBrand = hotelBrand == null ? null : hotelBrand.trim();
    }

    public String getTradingArea() {
        return tradingArea;
    }

    public void setTradingArea(String tradingArea) {
        this.tradingArea = tradingArea == null ? null : tradingArea.trim();
    }

    public String getIsWebFree() {
        return isWebFree;
    }

    public void setIsWebFree(String isWebFree) {
        this.isWebFree = isWebFree == null ? null : isWebFree.trim();
    }

    public String getDangCi() {
        return dangCi;
    }

    public void setDangCi(String dangCi) {
        this.dangCi = dangCi == null ? null : dangCi.trim();
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName == null ? null : hotelName.trim();
    }

    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress == null ? null : hotelAddress.trim();
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId == null ? null : imageId.trim();
    }

    public String getHasMeetingOrBanquetSpace() {
        return hasMeetingOrBanquetSpace;
    }

    public void setHasMeetingOrBanquetSpace(String hasMeetingOrBanquetSpace) {
        this.hasMeetingOrBanquetSpace = hasMeetingOrBanquetSpace == null ? null : hasMeetingOrBanquetSpace.trim();
    }

    public String getHasIndoorPool() {
        return hasIndoorPool;
    }

    public void setHasIndoorPool(String hasIndoorPool) {
        this.hasIndoorPool = hasIndoorPool == null ? null : hasIndoorPool.trim();
    }

    public String getHasNonSmokingAvailable() {
        return hasNonSmokingAvailable;
    }

    public void setHasNonSmokingAvailable(String hasNonSmokingAvailable) {
        this.hasNonSmokingAvailable = hasNonSmokingAvailable == null ? null : hasNonSmokingAvailable.trim();
    }

    public String getOneSentence() {
        return oneSentence;
    }

    public void setOneSentence(String oneSentence) {
        this.oneSentence = oneSentence == null ? null : oneSentence.trim();
    }

    public Long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Long commentCount) {
        this.commentCount = commentCount;
    }

    public String getHotelArea() {
        return hotelArea;
    }

    public void setHotelArea(String hotelArea) {
        this.hotelArea = hotelArea == null ? null : hotelArea.trim();
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
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