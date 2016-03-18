package com.mk.crawer.api.dtos;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;


public class Pois {

    private String id;
    private String name;
    private String tag;
    private String type;
    private String typecode;
    @JSONField(name ="biz_type")
    private String bizType;
    private String address;
    private String location;
    private String tel;
    private String postcode;
    private String website;
    private String email;
    private String pcode;
    private String pname;
    private String citycode;
    private String cityname;
    private String adcode;
    private String adname;
    private String gridcode;
    private String distance;
    private String alias;
    @JSONField(name ="navi_poiid")
    private String naviPoiid;
    @JSONField(name ="entr_location")
    private String entrLocation;
    @JSONField(name ="exit_location")
    private String exitLocation;
    private String match;
    private String recommend;
    private String timestamp;
    @JSONField(name ="indoor_map")
    private String indoorMap;
    @JSONField(name ="groupbuy_num")
    private String groupbuyNum;
    @JSONField(name ="business_area")
    private String businessArea;
    @JSONField(name ="discount_num")
    private String discountNum;
    private List<Photos> photos;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public String getAdname() {
        return adname;
    }

    public void setAdname(String adname) {
        this.adname = adname;
    }

    public String getGridcode() {
        return gridcode;
    }

    public void setGridcode(String gridcode) {
        this.gridcode = gridcode;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getNaviPoiid() {
        return naviPoiid;
    }

    public void setNaviPoiid(String naviPoiid) {
        this.naviPoiid = naviPoiid;
    }

    public String getEntrLocation() {
        return entrLocation;
    }

    public void setEntrLocation(String entrLocation) {
        this.entrLocation = entrLocation;
    }

    public String getExitLocation() {
        return exitLocation;
    }

    public void setExitLocation(String exitLocation) {
        this.exitLocation = exitLocation;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        this.recommend = recommend;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getIndoorMap() {
        return indoorMap;
    }

    public void setIndoorMap(String indoorMap) {
        this.indoorMap = indoorMap;
    }

    public String getGroupbuyNum() {
        return groupbuyNum;
    }

    public void setGroupbuyNum(String groupbuyNum) {
        this.groupbuyNum = groupbuyNum;
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    public String getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(String discountNum) {
        this.discountNum = discountNum;
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }
}
