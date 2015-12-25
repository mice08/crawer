package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class AuthRequest extends BaseRequest {

    private String access_token;

    private String openid;

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
}
