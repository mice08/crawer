package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class RefreshTokenRequest extends BaseResponse {

    private String refresh_token;

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}
