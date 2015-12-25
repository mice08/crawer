package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/24.
 */
public class WeChatAuthUrlRequest extends BaseRequest {

    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
