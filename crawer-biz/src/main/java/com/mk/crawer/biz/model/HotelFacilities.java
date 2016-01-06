package com.mk.crawer.biz.model;

import java.util.Date;

public class HotelFacilities {
    private Long id;

    private Long hotelId;
    
    private String hotelSourceId;

    private String shortName;

    private String type;

    private String field;

    private Long lowStarSort;

    private Long highStarSort;

    private Long overseaSort;

    private Long color;

    private String iconUrl;

    private String display;

    private String item;

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

    
    public String getHotelSourceId() {
		return hotelSourceId;
	}

	public void setHotelSourceId(String hotelSourceId) {
		this.hotelSourceId = hotelSourceId;
	}

	public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName == null ? null : shortName.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field == null ? null : field.trim();
    }

    public Long getLowStarSort() {
        return lowStarSort;
    }

    public void setLowStarSort(Long lowStarSort) {
        this.lowStarSort = lowStarSort;
    }

    public Long getHighStarSort() {
        return highStarSort;
    }

    public void setHighStarSort(Long highStarSort) {
        this.highStarSort = highStarSort;
    }

    public Long getOverseaSort() {
        return overseaSort;
    }

    public void setOverseaSort(Long overseaSort) {
        this.overseaSort = overseaSort;
    }

    public Long getColor() {
        return color;
    }

    public void setColor(Long color) {
        this.color = color;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl == null ? null : iconUrl.trim();
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display == null ? null : display.trim();
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item == null ? null : item.trim();
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