package com.mk.crawer.biz.model;

import java.math.BigDecimal;
import java.util.Date;

public class RoomTypePrice {
    private Long id;

    private Long roomTypeId;

    private String roomTypeKey;
    
    private Long hotelId;
    
    private String hotelSourceId;

    private BigDecimal price;

    private BigDecimal realPrice;

    private BigDecimal originPrice;

    private BigDecimal showPrice;

    private BigDecimal otaShowPrice;

    private String wrapperName;

    private String wrapperId;

    private Integer allRoomCount;

    private Integer availableRoomcount;

    private Date createTime;

    private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomTypeKey() {
		return roomTypeKey;
	}

	public void setRoomTypeKey(String roomTypeKey) {
		this.roomTypeKey = roomTypeKey;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelSourceId() {
		return hotelSourceId;
	}

	public void setHotelSourceId(String hotelSourceId) {
		this.hotelSourceId = hotelSourceId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(BigDecimal realPrice) {
		this.realPrice = realPrice;
	}

	public BigDecimal getOriginPrice() {
		return originPrice;
	}

	public void setOriginPrice(BigDecimal originPrice) {
		this.originPrice = originPrice;
	}

	public BigDecimal getShowPrice() {
		return showPrice;
	}

	public void setShowPrice(BigDecimal showPrice) {
		this.showPrice = showPrice;
	}

	public BigDecimal getOtaShowPrice() {
		return otaShowPrice;
	}

	public void setOtaShowPrice(BigDecimal otaShowPrice) {
		this.otaShowPrice = otaShowPrice;
	}

	public String getWrapperName() {
		return wrapperName;
	}

	public void setWrapperName(String wrapperName) {
		this.wrapperName = wrapperName;
	}

	public String getWrapperId() {
		return wrapperId;
	}

	public void setWrapperId(String wrapperId) {
		this.wrapperId = wrapperId;
	}

	public Integer getAllRoomCount() {
		return allRoomCount;
	}

	public void setAllRoomCount(Integer allRoomCount) {
		this.allRoomCount = allRoomCount;
	}

	public Integer getAvailableRoomcount() {
		return availableRoomcount;
	}

	public void setAvailableRoomcount(Integer availableRoomcount) {
		this.availableRoomcount = availableRoomcount;
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