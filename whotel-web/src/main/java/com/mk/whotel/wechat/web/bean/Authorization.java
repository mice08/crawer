package com.mk.whotel.wechat.web.bean;

/**
 * Created by 振涛 on 2015/12/25.
 */
public class Authorization {

    private String openId;

    private String unionId;

    private String accessToken;

    private Long accessTokenExpirationTime;

    private String refreshToken;

    private Long refreshTokenExpirationTime;

    private String wHotelToken;

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getAccessTokenExpirationTime() {
        return accessTokenExpirationTime;
    }

    public void setAccessTokenExpirationTime(Long accessTokenExpirationTime) {
        this.accessTokenExpirationTime = accessTokenExpirationTime;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getRefreshTokenExpirationTime() {
        return refreshTokenExpirationTime;
    }

    public void setRefreshTokenExpirationTime(Long refreshTokenExpirationTime) {
        this.refreshTokenExpirationTime = refreshTokenExpirationTime;
    }

    public String getwHotelToken() {
        return wHotelToken;
    }

    public void setwHotelToken(String wHotelToken) {
        this.wHotelToken = wHotelToken;
    }
}
