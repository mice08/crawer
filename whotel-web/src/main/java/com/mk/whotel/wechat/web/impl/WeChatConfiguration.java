package com.mk.whotel.wechat.web.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * Created by 振涛 on 2015/12/23.
 */
@Configuration
@PropertySource("classpath:weChat.properties")
public class WeChatConfiguration {

    @Value("${weChat.web.appid}")
    private String appid;

    @Value("${weChat.web.secret}")
    private String secret;

    @Value("${weChat.web.scope}")
    private String scope;

    @Value("${weChat.web.redirect_uri}")
    private String redirect_uri;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRedirect_uri() {
        return redirect_uri;
    }

    public void setRedirect_uri(String redirect_uri) {
        this.redirect_uri = redirect_uri;
    }

    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
