package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/24.
 */
public class LoginRequest extends BaseRequest {

    private String userMark;

    private String code;

    public String getUserMark() {
        return userMark;
    }

    public void setUserMark(String userMark) {
        this.userMark = userMark;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
