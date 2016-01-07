package com.mk.crawer.biz.model;

import java.util.Date;

public class HotelSurround {
	private Long id;

	private String type;

	private Long hotelId;

	private String hotelSourceId;

	private String surroundName;

	private String gpoint;

	private String distance;

	private Date createTime;

	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getSurroundName() {
		return surroundName;
	}

	public void setSurroundName(String surroundName) {
		this.surroundName = surroundName;
	}

	public String getGpoint() {
		return gpoint;
	}

	public void setGpoint(String gpoint) {
		this.gpoint = gpoint;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
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