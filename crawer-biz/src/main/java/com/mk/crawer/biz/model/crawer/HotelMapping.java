package com.mk.crawer.biz.model.crawer;

public class HotelMapping {
    private Long id;

    private Long otsHotelId;

    private String otsHotelName;

    private Long exHotelId;

    private String exHotelName;

    private String valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOtsHotelId() {
        return otsHotelId;
    }

    public void setOtsHotelId(Long otsHotelId) {
        this.otsHotelId = otsHotelId;
    }

    public String getOtsHotelName() {
        return otsHotelName;
    }

    public void setOtsHotelName(String otsHotelName) {
        this.otsHotelName = otsHotelName == null ? null : otsHotelName.trim();
    }

    public Long getExHotelId() {
        return exHotelId;
    }

    public void setExHotelId(Long exHotelId) {
        this.exHotelId = exHotelId;
    }

    public String getExHotelName() {
        return exHotelName;
    }

    public void setExHotelName(String exHotelName) {
        this.exHotelName = exHotelName == null ? null : exHotelName.trim();
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }
}