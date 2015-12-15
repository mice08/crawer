package com.mk.bypass.api.dtos;

/**
 * Created by kirinli on 15/9/9.
 */
public class UserCheckDto {
    private  Integer mid;
    private  String phone;
    private  String cardid;

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardid() {
        return cardid;
    }

    public void setCardid(String cardid) {
        this.cardid = cardid;
    }
}
