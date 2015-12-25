package com.mk.whotel.wechat.web;

import com.mk.whotel.wechat.web.bean.*;

/**
 * 微信OAuth2.0授权登录目前支持authorization_code模式，适用于拥有server端的应用授权。该模式整体流程为：
 *  1. 第三方发起微信授权登录请求，微信用户允许授权第三方应用后，微信会拉起应用或重定向到第三方网站，并且带上授权临时票据code参数；
 *  2. 通过code参数加上AppID和AppSecret等，通过API换取access_token；
 *  3. 通过access_token进行接口调用，获取用户基本数据资源或帮助用户实现基本操作。
 * Created by 振涛 on 2015/12/23.
 */
public interface IOAuthApi {

    /**
     * 获取微信授权页面的地址
     * @param weChatAuthUrlRequest
     * @return
     */
    public String weChatAuthUrl(WeChatAuthUrlRequest weChatAuthUrlRequest);

    /**
     * 通过code获取access_token
     * @param accessTokenRequest
     * @return
     */
    public AccessTokenResponse accessToken(AccessTokenRequest accessTokenRequest);

    /**
     * access_token是调用授权关系接口的调用凭证，由于access_token有效期（目前为2个小时）较短，
     * 当access_token超时后，可以使用refresh_token进行刷新，access_token刷新结果有两种：
     *  1. 若access_token已超时，那么进行refresh_token会获取一个新的access_token，新的超时时间；
     *  2.若access_token未超时，那么进行refresh_token不会改变access_token，但超时时间会刷新，相当于续期access_token。
     *
     *  refresh_token拥有较长的有效期（30天），当refresh_token失效的后，需要用户重新授权。
     * @param refreshTokenRequest
     * @return
     */
    public RefreshTokenResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

    /**
     * 检验授权凭证（access_token）是否有效
     * @param authRequest
     * @return
     */
    public AuthResponse auth(AuthRequest authRequest);

    /**
     * 此接口用于获取用户个人信息。
     * 开发者可通过OpenID来获取用户基本信息。
     *
     * 特别需要注意的是，如果开发者拥有多个移动应用、网站应用和公众帐号，
     * 可通过获取用户基本信息中的unionid来区分用户的唯一性，
     * 因为只要是同一个微信开放平台帐号下的移动应用、网站应用和公众帐号，用户的unionid是唯一的。
     *
     * 换句话说，同一用户，对同一个微信开放平台下的不同应用，unionid是相同的。
     *
     * 请注意，在用户修改微信头像后，旧的微信头像URL将会失效，因此开发者应该自己在获取用户信息后，
     * 将头像图片保存下来，避免微信头像URL失效后的异常情况。
     * @param userInfoRequest
     * @return
     */
    public UserInfoResponse userInfo(UserInfoRequest userInfoRequest);

}
