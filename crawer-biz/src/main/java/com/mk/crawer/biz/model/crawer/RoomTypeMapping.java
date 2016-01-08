package com.mk.crawer.biz.model.crawer;

public class RoomTypeMapping {
    private Long id;

    private Long otsRoomTypeId;

    private Long exRoomTypeId;

    private String valid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOtsRoomTypeId() {
        return otsRoomTypeId;
    }

    public void setOtsRoomTypeId(Long otsRoomTypeId) {
        this.otsRoomTypeId = otsRoomTypeId;
    }

    public Long getExRoomTypeId() {
        return exRoomTypeId;
    }

    public void setExRoomTypeId(Long exRoomTypeId) {
        this.exRoomTypeId = exRoomTypeId;
    }

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid == null ? null : valid.trim();
    }
}