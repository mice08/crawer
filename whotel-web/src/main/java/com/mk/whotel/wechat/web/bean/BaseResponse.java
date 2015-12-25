package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/23.
 */
public class BaseResponse extends Base {

    private Integer errcode = 0;

    private String errmsg = "ok";

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

}
