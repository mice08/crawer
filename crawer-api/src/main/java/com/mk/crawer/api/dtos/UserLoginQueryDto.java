package com.mk.crawer.api.dtos;


public class UserLoginQueryDto {

    /**
     * 登陆名称
     */
    private String loginName;
    /**
     * 登陆密码
     */
    private String password;

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
