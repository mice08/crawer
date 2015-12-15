package com.mk.whotel.web.controller;

import com.dianping.cat.Cat;
import com.mk.whotel.api.dtos.UserCheckDto;
import com.mk.whotel.api.enums.BlackUserEnum;
import com.mk.whotel.biz.mapper.blacklist.PassSwitchMapper;
import com.mk.whotel.biz.utils.ServiceOutput;
import com.mk.whotel.task.ReFreshBlackListTask;
import com.mk.whotel.web.service.CheckUser;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirinli on 15/9/9.
 */
@Controller
public class CheckContorller {


    @Autowired
    private PassSwitchMapper passSwitchMapper;

    public static Logger log = org.slf4j.LoggerFactory.getLogger(CheckUser.class);

    @ResponseBody
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> check(HttpSession httpSession, UserCheckDto userCheckDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        if (StringUtils.isBlank(userCheckDto.getCardid())
                && StringUtils.isBlank(userCheckDto.getPhone())
                && null == userCheckDto.getMid()) {

            result.put(ServiceOutput.STR_MSG_SUCCESS, false);
            result.put(ServiceOutput.STR_MSG_ERRCODE, "-1");
            result.put(ServiceOutput.STR_MSG_ERRMSG, "参数phone不为空.");

            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
        }


        if (ReFreshBlackListTask.passSwitchMap != null &&
                ReFreshBlackListTask.passSwitchMap.get("isClose") != null &&
                ReFreshBlackListTask.passSwitchMap.get("isClose") == 0) {

            BlackUserEnum resultEnum = CheckUser.check(userCheckDto);
            result.put("check", resultEnum.getName());

            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
        } else {
            result.put("check", "F");
            Cat.logEvent("BlackListAccess", userCheckDto.getPhone());

            log.info("\n=============== BlackListAccess {} ================\n", userCheckDto.getPhone());

            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
        }


    }

    @ResponseBody
    @RequestMapping(value = "/isclose", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> isclose(HttpSession httpSession) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        if (ReFreshBlackListTask.passSwitchMap != null
                && ReFreshBlackListTask.passSwitchMap.get("isClose") != null
                && ReFreshBlackListTask.passSwitchMap.get("isClose") == 0) {

            result.put("status", "黑名单开启");
        } else {
            result.put("status", "黑名单关闭");
        }


        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/close_pass", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> close(HttpSession httpSession, Integer is_close) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        if (is_close == null) {
            result.put(ServiceOutput.STR_MSG_SUCCESS, false);
            result.put(ServiceOutput.STR_MSG_ERRCODE, "-1");
            result.put(ServiceOutput.STR_MSG_ERRMSG, "参数is_close不为空.");

            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
        }

        if (is_close == 1) {
            ReFreshBlackListTask.passSwitchMap.clear();
            Cat.logEvent("swithClose", "黑名单功能关闭");
            passSwitchMapper.updateSwitch(1);
        } else {
            ReFreshBlackListTask.passSwitchMap.put("isClose", 0);
            Cat.logEvent("swithClose", "黑名单功能开启");
            passSwitchMapper.updateSwitch(0);
        }


        if (ReFreshBlackListTask.passSwitchMap != null
                && ReFreshBlackListTask.passSwitchMap.get("isClose") != null
                && ReFreshBlackListTask.passSwitchMap.get("isClose") == 0) {
            result.put("status", "黑名单开启");
        } else {
            result.put("status", "黑名单关闭");
        }


        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }



}
