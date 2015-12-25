package com.mk.whotel.wechat.web.impl;

import com.mk.whotel.framework.AppUtils;
import com.mk.whotel.framework.MkJedisConnectionFactory;
import com.mk.whotel.framework.manager.RedisCacheName;
import com.mk.whotel.wechat.web.IOAuthApi;
import com.mk.whotel.wechat.web.IWeChatFacade;
import com.mk.whotel.wechat.web.bean.*;
import com.mk.whotel.wechat.web.utils.JSONUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created by 振涛 on 2015/12/23.
 */
@Service
public class WeChatFacadeImpl implements IWeChatFacade {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WeChatFacadeImpl.class);

    private static MkJedisConnectionFactory connectionFactory = null;

    @Autowired
    private IOAuthApi applicationApi;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Long currentTimeMillis = System.currentTimeMillis();

        LoginResponse loginResponse = new LoginResponse();

        AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
        accessTokenRequest.setCode(loginRequest.getCode());
        AccessTokenResponse accessTokenResponse = applicationApi.accessToken(accessTokenRequest);

        if (accessTokenResponse.getErrcode() == 0) {
            Authorization authorization = new Authorization();
            authorization.setOpenId(accessTokenResponse.getOpenid());
            authorization.setUnionId(accessTokenResponse.getUnionid());
            authorization.setAccessToken(accessTokenResponse.getAccess_token());
            authorization.setAccessTokenExpirationTime(currentTimeMillis + accessTokenResponse.getExpires_in() * 1000);
            authorization.setRefreshToken(accessTokenResponse.getRefresh_token());
            authorization.setRefreshTokenExpirationTime(currentTimeMillis + 30 * 24 * 60 * 60 * 1000);
            authorization.setwHotelToken(UUID.randomUUID().toString());

            //todo 需要用获取到的用户微信相关账号信息去数据库中查询用户以前绑定的userMark，如果用户已经绑定过了返回原来的userMark
            String userMark = loginRequest.getUserMark();
            //通过openId或者unionId在数据库中查找userMark，如果找到相关记录，就替换userMark，没有的话就使用原有userMark
            //同时合并原userMark产生的数据

            String json = JSONUtil.toJson(authorization);
            Jedis jedis = getJedis();
            jedis.hset(RedisCacheName.W_HOTEL_WE_CHAT_AUTHORIZATION_MAP, userMark, json);

            loginResponse.setUserMark(userMark);
            loginResponse.setToken(authorization.getwHotelToken());
        } else {
            loginResponse.setErrcode(accessTokenResponse.getErrcode());
            loginResponse.setErrmsg(accessTokenResponse.getErrmsg());
        }

        return loginResponse;
    }

    @Override
    public boolean isLogin(String userMark, String token) {
        Jedis jedis = getJedis();
        String json = jedis.hget(RedisCacheName.W_HOTEL_WE_CHAT_AUTHORIZATION_MAP, userMark);

        if (StringUtils.isEmpty(json)) {
            return false;
        } else {
            Authorization authorization = JSONUtil.fromJson(json, Authorization.class);
            return authorization.getwHotelToken().equals(token);
        }
    }

    @Override
    public void logout(String userMark, String token) {
        Jedis jedis = getJedis();
        String json = jedis.hget(RedisCacheName.W_HOTEL_WE_CHAT_AUTHORIZATION_MAP, userMark);

        if (!StringUtils.isEmpty(json)) {
            Authorization authorization = JSONUtil.fromJson(json, Authorization.class);
            if (authorization.getwHotelToken().equals(token)) {
                jedis.hdel(RedisCacheName.W_HOTEL_WE_CHAT_AUTHORIZATION_MAP, userMark);
            }
        }
    }

    private static Jedis getJedis() {
        return WeChatFacadeImpl.getConnectionFactory().getJedis();
    }

    private static MkJedisConnectionFactory getConnectionFactory() {
        if (WeChatFacadeImpl.connectionFactory == null) {
            synchronized (WeChatFacadeImpl.class) {
                if (WeChatFacadeImpl.connectionFactory == null) {
                    WeChatFacadeImpl.connectionFactory = AppUtils.getBean(MkJedisConnectionFactory.class);
                }
            }
        }
        return WeChatFacadeImpl.connectionFactory;
    }
}
