package com.mk.crawer.biz.bean;
import java.util.List;
import com.alibaba.fastjson.annotation.JSONField;


public class RoomtypeInfo {

    private String status;
    private String code;
    private List<Roomlist> roomlist;
    @JSONField(name ="promotion_content")
    private String promotionContent;
    private String timestamp;
    @JSONField(name ="show_src_name")
    private String showSrcName;
    private String version;
    private String result;
    private String message;


    public void setStatus(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }


    public void setCode(String code) {
        this.code = code;
    }
    public String getCode() {
        return code;
    }


    public void setRoomlist(List<Roomlist> roomlist) {
        this.roomlist = roomlist;
    }
    public List<Roomlist> getRoomlist() {
        return roomlist;
    }


    public void setPromotionContent(String promotionContent) {
        this.promotionContent = promotionContent;
    }
    public String getPromotionContent() {
        return promotionContent;
    }


    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
    public String getTimestamp() {
        return timestamp;
    }


    public void setShowSrcName(String showSrcName) {
        this.showSrcName = showSrcName;
    }
    public String getShowSrcName() {
        return showSrcName;
    }


    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion() {
        return version;
    }


    public void setResult(String result) {
        this.result = result;
    }
    public String getResult() {
        return result;
    }


    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}