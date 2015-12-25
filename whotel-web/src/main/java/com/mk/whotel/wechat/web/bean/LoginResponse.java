package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/24.
 */
public class LoginResponse extends BaseResponse {

    private String userMark;

    private String token;

    public String getUserMark() {
        return userMark;
    }

    public void setUserMark(String userMark) {
        this.userMark = userMark;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
