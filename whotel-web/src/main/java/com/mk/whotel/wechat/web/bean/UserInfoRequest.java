package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class UserInfoRequest extends BaseRequest {

    private String access_token;

    private String openid;

    //国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语，默认为zh-CN
    private String lang;

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
