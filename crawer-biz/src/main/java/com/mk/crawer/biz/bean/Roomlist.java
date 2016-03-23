package com.mk.crawer.biz.bean;
import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;


public class Roomlist {

    @JSONField(name ="room_info")
    private RoomInfo roomInfo;
    private List<Multilist> multilist;
    @JSONField(name ="src_count")
    private String srcCount;
    @JSONField(name ="roomgroup_id")
    private String roomgroupId;
    @JSONField(name ="price_lowest_currency")
    private String priceLowestCurrency;
    @JSONField(name ="RoomTypeName")
    private String roomtypename;
    @JSONField(name ="price_lowest")
    private int priceLowest;
    @JSONField(name ="room_status")
    private String roomStatus;
    @JSONField(name ="is_pic")
    private String isPic;
    @JSONField(name ="Upperlimit")
    private String upperlimit;


    public void setRoomInfo(RoomInfo roomInfo) {
        this.roomInfo = roomInfo;
    }
    public RoomInfo getRoomInfo() {
        return roomInfo;
    }


    public void setMultilist(List<Multilist> multilist) {
        this.multilist = multilist;
    }
    public List<Multilist> getMultilist() {
        return multilist;
    }


    public void setSrcCount(String srcCount) {
        this.srcCount = srcCount;
    }
    public String getSrcCount() {
        return srcCount;
    }


    public void setRoomgroupId(String roomgroupId) {
        this.roomgroupId = roomgroupId;
    }
    public String getRoomgroupId() {
        return roomgroupId;
    }


    public void setPriceLowestCurrency(String priceLowestCurrency) {
        this.priceLowestCurrency = priceLowestCurrency;
    }
    public String getPriceLowestCurrency() {
        return priceLowestCurrency;
    }


    public void setRoomtypename(String roomtypename) {
        this.roomtypename = roomtypename;
    }
    public String getRoomtypename() {
        return roomtypename;
    }


    public void setPriceLowest(int priceLowest) {
        this.priceLowest = priceLowest;
    }
    public int getPriceLowest() {
        return priceLowest;
    }


    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
    public String getRoomStatus() {
        return roomStatus;
    }


    public void setIsPic(String isPic) {
        this.isPic = isPic;
    }
    public String getIsPic() {
        return isPic;
    }


    public void setUpperlimit(String upperlimit) {
        this.upperlimit = upperlimit;
    }
    public String getUpperlimit() {
        return upperlimit;
    }

}