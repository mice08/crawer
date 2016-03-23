package com.mk.crawer.biz.bean;
import com.alibaba.fastjson.annotation.JSONField;


public class PicInfo {

    private String url;
    @JSONField(name ="src_type")
    private String srcType;
    private String title;


    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl() {
        return url;
    }


    public void setSrcType(String srcType) {
        this.srcType = srcType;
    }
    public String getSrcType() {
        return srcType;
    }


    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

}