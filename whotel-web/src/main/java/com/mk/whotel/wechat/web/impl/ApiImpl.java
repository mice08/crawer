package com.mk.whotel.wechat.web.impl;

import com.mk.whotel.wechat.web.IOAuthApi;
import com.mk.whotel.wechat.web.bean.*;
import com.mk.whotel.wechat.web.utils.HttpSender;
import com.mk.whotel.wechat.web.utils.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 振涛 on 2015/12/23.
 */
@Service
public class ApiImpl implements IOAuthApi {

    @Autowired
    private WeChatConfiguration weChatConfiguration;

    @Override
    public String weChatAuthUrl(WeChatAuthUrlRequest weChatAuthUrlRequest) {
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append("https://open.weixin.qq.com/connect/qrconnect")
        .append("?appid=").append(weChatConfiguration.getAppid());
        stringBuffer.append("&redirect_uri=").append(HttpUtil.urlEncoder(weChatConfiguration.getRedirect_uri()));
        stringBuffer.append("&response_type=code");
        stringBuffer.append("&scope=").append(weChatConfiguration.getScope());
        stringBuffer.append("&state=").append(weChatAuthUrlRequest.getState());

        return stringBuffer.toString();
    }

    @Override
    public AccessTokenResponse accessToken(AccessTokenRequest accessTokenRequest) {
        return HttpSender.getInstance()
                .setUrl("https://api.weixin.qq.com/sns/oauth2/access_token")
                .addParam("appid", weChatConfiguration.getAppid())
                .addParam("secret", weChatConfiguration.getSecret())
                .addParam("code", accessTokenRequest.getCode())
                .addParam("grant_type", "authorization_code")
                .send(AccessTokenResponse.class);
    }

    @Override
    public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        return HttpSender.getInstance()
                .setUrl("https://api.weixin.qq.com/sns/oauth2/refresh_token")
                .addParam("appid", weChatConfiguration.getAppid())
                .addParam("grant_type", "refresh_token")
                .addParam("refresh_token", refreshTokenRequest.getRefresh_token())
                .send(RefreshTokenResponse.class);
    }


    @Override
    public AuthResponse auth(AuthRequest authRequest) {
        return HttpSender.getInstance()
                .setUrl("https://api.weixin.qq.com/sns/auth")
                .addParam("access_token", authRequest.getAccess_token())
                .addParam("openid", authRequest.getOpenid())
                .send(AuthResponse.class);
    }

    @Override
    public UserInfoResponse userInfo(UserInfoRequest userInfoRequest) {
        return HttpSender.getInstance()
                .setUrl("https://api.weixin.qq.com/sns/userinfo")
                .addParam("access_token", userInfoRequest.getAccess_token())
                .addParam("openid", userInfoRequest.getOpenid())
                .addParam("lang", "zh_CN")
                .send(UserInfoResponse.class);
    }
}
