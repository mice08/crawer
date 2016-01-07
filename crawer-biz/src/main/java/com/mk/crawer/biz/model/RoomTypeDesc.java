package com.mk.crawer.biz.model;

import java.util.Date;

public class RoomTypeDesc {
	private Long id;

	private Long hotelId;
	private String hotelSourceId;

	private Long roomTypeId;

	private String roomTypeKey;

	private String content;

	private String title;

	private String type;

	private Date createTime;

	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomTypeKey() {
		return roomTypeKey;
	}

	public void setRoomTypeKey(String roomTypeKey) {
		this.roomTypeKey = roomTypeKey;
	}

	public String getHotelSourceId() {
		return hotelSourceId;
	}

	public void setHotelSourceId(String hotelSourceId) {
		this.hotelSourceId = hotelSourceId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public Long getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type == null ? null : type.trim();
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