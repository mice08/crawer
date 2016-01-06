package com.mk.crawer.web.controller;

import com.mk.crawer.wechat.web.IOAuthApi;
import com.mk.crawer.wechat.web.bean.WeChatAuthUrlRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by 振涛 on 2015/12/23.
 */
@Controller
public class WeChatContorller {

    @Autowired
    private IOAuthApi applicationApi;

    @RequestMapping(value = "/wechat/login", method = RequestMethod.GET)
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String userMark = request.getParameter("userMark");

        WeChatAuthUrlRequest weChatAuthUrlRequest = new WeChatAuthUrlRequest();
        weChatAuthUrlRequest.setState(userMark);
        String weChatAuthUrl = applicationApi.weChatAuthUrl(weChatAuthUrlRequest);

        response.sendRedirect(weChatAuthUrl);
        response.setStatus(HttpServletResponse.SC_FOUND);
    }



}
