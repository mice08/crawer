package com.mk.crawer.api.dtos;

import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.util.StringUtils;


public class Pois {
    @JSONField(name ="id")
    private String sourceId;
    private String name;
    private String tag;
    private String type;
    @JSONField(name ="typecode")
    private String typeCode;
    @JSONField(name ="biz_type")
    private String bizType;
    private String address;
    private String location;
    private String tel;
    @JSONField(name ="postcode")
    private String postCode;
    private String website;
    private String email;
    private String pcode;
    private String pname;
    @JSONField(name ="citycode")
    private String cityCode;
    @JSONField(name ="cityname")
    private String cityName;
    @JSONField(name ="adcode")
    private String adCode;
    @JSONField(name ="adname")
    private String adName;
    @JSONField(name ="gridcode")
    private String gridCode;
    private String distance;
    private String alias;
    @JSONField(name ="navi_poiid")
    private String naviPoiId;
    @JSONField(name ="entr_location")
    private String entrLocation;
    @JSONField(name ="exit_location")
    private String exitLocation;
    private String match;
    private String recommend;
    @JSONField(name ="timestamp")
    private String timeStamp;
    @JSONField(name ="indoor_map")
    private String indoorMap;
    @JSONField(name ="groupbuy_num")
    private String groupbuyNum;
    @JSONField(name ="business_area")
    private String businessArea;
    @JSONField(name ="discount_num")
    private String discountNum;
    private String event;
    private List<Photos> photos;
    @JSONField(name ="biz_ext")
    private BizExt bizExt;
    @JSONField(name ="indoor_data")
    private IndoorData indoorData;
    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        if (!StringUtils.isEmpty(sourceId)&&!sourceId.equals("[]")){
            this.sourceId = sourceId;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!StringUtils.isEmpty(name)&&!name.equals("[]")){
            this.name = name;
        }
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        if (!StringUtils.isEmpty(tag)&&!tag.equals("[]")){
            this.tag = tag;
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (!StringUtils.isEmpty(type)&&!type.equals("[]")){
            this.type = type;
        }
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        if (!StringUtils.isEmpty(typeCode)&&!typeCode.equals("[]")){
            this.typeCode = typeCode;
        }
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        if (!StringUtils.isEmpty(bizType)&&!bizType.equals("[]")){
            this.bizType = bizType;
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (!StringUtils.isEmpty(address)&&!address.equals("[]")){
            this.address = address;
        }
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        if (!StringUtils.isEmpty(location)&&!location.equals("[]")){
            this.location = location;
        }
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        if (!StringUtils.isEmpty(tel)&&!tel.equals("[]")){
            this.tel = tel;
        }
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        if (!StringUtils.isEmpty(postCode)&&!postCode.equals("[]")){
            this.postCode = postCode;
        }
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        if (!StringUtils.isEmpty(website)&&!website.equals("[]")){
            this.website = website;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (!StringUtils.isEmpty(email)&&!email.equals("[]")){
            this.email = email;
        }
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        if (!StringUtils.isEmpty(pcode)&&!pcode.equals("[]")){
            this.pcode = pcode;
        }
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        if (!StringUtils.isEmpty(pname)&&!pname.equals("[]")){
            this.pname = pname;
        }
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        if (!StringUtils.isEmpty(cityCode)&&!cityCode.equals("[]")){
            this.cityCode = cityCode;
        }
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        if (!StringUtils.isEmpty(cityName)&&!cityName.equals("[]")){
            this.cityName = cityName;
        }
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        if (!StringUtils.isEmpty(adCode)&&!adCode.equals("[]")){
            this.adCode = adCode;
        }
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        if (!StringUtils.isEmpty(adName)&&!adName.equals("[]")){
            this.adName = adName;
        }
    }

    public String getGridCode() {
        return gridCode;
    }

    public void setGridCode(String gridCode) {
        if (!StringUtils.isEmpty(gridCode)&&!gridCode.equals("[]")){
            this.gridCode = gridCode;
        }
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        if (!StringUtils.isEmpty(distance)&&!distance.equals("[]")){
            this.distance = distance;
        }
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        if (!StringUtils.isEmpty(alias)&&!alias.equals("[]")){
            this.alias = alias;
        }
    }

    public String getNaviPoiId() {
        return naviPoiId;
    }

    public void setNaviPoiId(String naviPoiId) {
        if (!StringUtils.isEmpty(naviPoiId)&&!naviPoiId.equals("[]")){
            this.naviPoiId = naviPoiId;
        }
    }

    public String getEntrLocation() {
        return entrLocation;
    }

    public void setEntrLocation(String entrLocation) {
        if (!StringUtils.isEmpty(entrLocation)&&!entrLocation.equals("[]")){
            this.entrLocation = entrLocation;
        }
    }

    public String getExitLocation() {
        return exitLocation;
    }

    public void setExitLocation(String exitLocation) {
        if (!StringUtils.isEmpty(exitLocation)&&!exitLocation.equals("[]")){
            this.exitLocation = exitLocation;
        }
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        if (!StringUtils.isEmpty(match)&&!match.equals("[]")){
            this.match = match;
        }
    }

    public String getRecommend() {
        return recommend;
    }

    public void setRecommend(String recommend) {
        if (!StringUtils.isEmpty(recommend)&&!recommend.equals("[]")){
            this.recommend = recommend;
        }
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        if (!StringUtils.isEmpty(timeStamp)&&!timeStamp.equals("[]")){
            this.timeStamp = timeStamp;
        }
    }

    public String getIndoorMap() {
        return indoorMap;
    }

    public void setIndoorMap(String indoorMap) {
        if (!StringUtils.isEmpty(indoorMap)&&!indoorMap.equals("[]")){
            this.indoorMap = indoorMap;
        }
    }

    public String getGroupbuyNum() {
        return groupbuyNum;
    }

    public void setGroupbuyNum(String groupbuyNum) {
        if (!StringUtils.isEmpty(groupbuyNum)&&!groupbuyNum.equals("[]")){
            this.groupbuyNum = groupbuyNum;
        }
    }

    public String getBusinessArea() {
        return businessArea;
    }

    public void setBusinessArea(String businessArea) {
        if (!StringUtils.isEmpty(businessArea)&&!businessArea.equals("[]")){
            this.businessArea = businessArea;
        }
    }

    public String getDiscountNum() {
        return discountNum;
    }

    public void setDiscountNum(String discountNum) {
        if (!StringUtils.isEmpty(discountNum)&&!discountNum.equals("[]")){
            this.discountNum = discountNum;
        }
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        if (!StringUtils.isEmpty(event)&&!event.equals("[]")){
            this.event = event;
        }
    }

    public List<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photos> photos) {
        this.photos = photos;
    }

    public BizExt getBizExt() {
        return bizExt;
    }

    public void setBizExt(BizExt bizExt) {
        this.bizExt = bizExt;
    }

    public IndoorData getIndoorData() {
        return indoorData;
    }

    public void setIndoorData(IndoorData indoorData) {
        this.indoorData = indoorData;
    }
}
