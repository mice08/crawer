package com.mk.crawer.biz.model.crawer;

public class RoomTypeMapping {
    private Long id;

    private String hotelSourceId;

    private Long otsRoomTypeId;

    private String exRoomTypeId;

    private String valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHotelSourceId() {
        return hotelSourceId;
    }

    public void setHotelSourceId(String hotelSourceId) {
        this.hotelSourceId = hotelSourceId == null ? null : hotelSourceId.trim();
    }

    public Long getOtsRoomTypeId() {
        return otsRoomTypeId;
    }

    public void setOtsRoomTypeId(Long otsRoomTypeId) {
        this.otsRoomTypeId = otsRoomTypeId;
    }

    public String getExRoomTypeId() {
        return exRoomTypeId;
    }

    public void setExRoomTypeId(String exRoomTypeId) {
        this.exRoomTypeId = exRoomTypeId == null ? null : exRoomTypeId.trim();
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }
}