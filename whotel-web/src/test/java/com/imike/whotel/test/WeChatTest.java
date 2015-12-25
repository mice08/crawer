package com.imike.whotel.test;

import com.mk.whotel.wechat.web.IOAuthApi;
import com.mk.whotel.wechat.web.IWeChatFacade;
import com.mk.whotel.wechat.web.bean.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 振涛 on 2015/12/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:db-context.xml",
        "classpath:root-context.xml",
        "classpath:servlet-context.xml"})
public class WeChatTest {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(WeChatTest.class);

    @Autowired
    private IOAuthApi api;
    @Autowired
    private IWeChatFacade weChatFacade;

    @Test
    public void weChatAuthUrl() {
        WeChatAuthUrlRequest weChatAuthUrlRequest = new WeChatAuthUrlRequest();

        String weChatAuthUrl = api.weChatAuthUrl(weChatAuthUrlRequest);
        LOGGER.info(weChatAuthUrl);
    }

    @Test
    public void accessToken() {
        AccessTokenRequest accessTokenRequest = new AccessTokenRequest();
        accessTokenRequest.setCode("01110a4e89e3809991eee0f8f882f601");
        AccessTokenResponse accessTokenResponse = api.accessToken(accessTokenRequest);
        LOGGER.info(accessTokenResponse.toJSONStr());
    }

    @Test
    public void refreshToken() {
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
        refreshTokenRequest.setRefresh_token("OezXcEiiBSKSxW0eoylIeBgZhZiKHhNY8xdCY9OX3ypUjRqa-ZA6PuJBE_FK0syq2EYZNXKzMip5GOMlbdmCNfaksLGTFN7YVkBaGNu7HJ7CyL3B8aP0tP9gGnASPvotq56ezuLPPG8IZXGNjYj8Ug");
        RefreshTokenResponse refreshTokenResponse = api.refreshToken(refreshTokenRequest);
        LOGGER.info(refreshTokenResponse.toJSONStr());
    }

    @Test
    public void auth() {
        AuthRequest authRequest = new AuthRequest();
        authRequest.setOpenid("o1zq6s3bMk80wqkI1UdzdO0NNdIA");
        authRequest.setAccess_token("OezXcEiiBSKSxW0eoylIeBgZhZiKHhNY8xdCY9OX3ypUjRqa-ZA6PuJBE_FK0syq3DsK1uaLjYP-BICc9JCRVetqdkyBpAxCYfgIbtQXo6DUPoE491sx9Nrm97suIvdhZKN56V_JBgPQCWgEEzNXFg");
        AuthResponse authResponse = api.auth(authRequest);
        LOGGER.info(authResponse.toJSONStr());
    }

    @Test
    public void userInfo() {
        UserInfoRequest userInfoRequest = new UserInfoRequest();
        userInfoRequest.setOpenid("o1zq6s3bMk80wqkI1UdzdO0NNdIA");
        userInfoRequest.setAccess_token("OezXcEiiBSKSxW0eoylIeBgZhZiKHhNY8xdCY9OX3ypUjRqa-ZA6PuJBE_FK0syq3DsK1uaLjYP-BICc9JCRVetqdkyBpAxCYfgIbtQXo6DUPoE491sx9Nrm97suIvdhZKN56V_JBgPQCWgEEzNXFg");
        userInfoRequest.setLang("zh_CN");
        UserInfoResponse accessTokenResponse = api.userInfo(userInfoRequest);
        LOGGER.info(accessTokenResponse.toJSONStr());
    }

    @Test
    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserMark("zetas");
        loginRequest.setCode("04118290eaa6d269b916e0ea8d1fc47C");
        LoginResponse loginResponse = weChatFacade.login(loginRequest);
        LOGGER.info(loginResponse.toJSONStr());
    }

    @Test
    public void isLogin() {
        String userMark = "zetas";
        String token = "82e6a4e3-5a18-4ff8-883c-4e72b6508566";
        boolean isLogin = weChatFacade.isLogin(userMark, token);
        LOGGER.info("login status is {}", isLogin);
    }

    @Test
    public void logout() {
        String userMark = "zetas";
        String token = "82e6a4e3-5a18-4ff8-883c-4e72b6508566";
        weChatFacade.logout(userMark, token);
        LOGGER.info("logout success");
    }

}
