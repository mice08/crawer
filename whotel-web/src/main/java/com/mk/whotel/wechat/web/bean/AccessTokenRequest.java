package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class AccessTokenRequest extends BaseResponse {

    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
