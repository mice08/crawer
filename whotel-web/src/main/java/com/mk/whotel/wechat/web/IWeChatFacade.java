package com.mk.whotel.wechat.web;

import com.mk.whotel.wechat.web.bean.LoginRequest;
import com.mk.whotel.wechat.web.bean.LoginResponse;

/**
 * 对外提供的登录相关接口
 * Created by 振涛 on 2015/12/23.
 */
public interface IWeChatFacade {

    /**
     * 单点登录
     * @param loginRequest
     * @return
     */
    public LoginResponse login(LoginRequest loginRequest);

    /**
     * 检测登录状态是否有效
     * @param userMark
     * @param token
     * @return
     */
    public boolean isLogin(String userMark, String token);

    /**
     * 退出登录，删除相关授权信息
     * @param userMark
     * @param token
     */
    public void logout(String userMark, String token);

}
