package com.mk.crawer.biz.bean;
import java.util.Date;
import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;


public class RoomInfo {

    private Date floor;
    @JSONField(name ="pic_info")
    private List<PicInfo> picInfo;
    private String network;
    private String bed;
    private String area;


    public void setFloor(Date floor) {
        this.floor = floor;
    }
    public Date getFloor() {
        return floor;
    }


    public void setPicInfo(List<PicInfo> picInfo) {
        this.picInfo = picInfo;
    }
    public List<PicInfo> getPicInfo() {
        return picInfo;
    }


    public void setNetwork(String network) {
        this.network = network;
    }
    public String getNetwork() {
        return network;
    }


    public void setBed(String bed) {
        this.bed = bed;
    }
    public String getBed() {
        return bed;
    }


    public void setArea(String area) {
        this.area = area;
    }
    public String getArea() {
        return area;
    }

}