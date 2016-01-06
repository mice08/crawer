package com.mk.crawer.web.controller;

import com.dianping.cat.Cat;
import com.mk.crawer.api.dtos.UserCheckDto;
import com.mk.crawer.api.enums.BlackUserEnum;
import com.mk.crawer.biz.mapper.blacklist.BlackListMapper;
import com.mk.crawer.biz.mapper.blacklist.PassSwitchMapper;
import com.mk.crawer.biz.moudle.BlackList;
import com.mk.crawer.biz.moudle.PassSwitch;
import com.mk.crawer.biz.utils.ServiceOutput;
import com.mk.crawer.task.ReFreshBlackListTask;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirinli on 15/9/9.
 */
@Controller
public class CacheContorller {

    @Autowired
    private BlackListMapper blackListMapper;

    @Autowired
    private PassSwitchMapper passSwitchMapper;

    public static Logger log = org.slf4j.LoggerFactory.getLogger(CacheContorller.class);


    @ResponseBody
    @RequestMapping(value = "/cache/delete", method = RequestMethod.DELETE)
    public ResponseEntity<Map<String, Object>> close(HttpSession httpSession, UserCheckDto userCheckDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        if (StringUtils.isBlank(userCheckDto.getCardid())
                && StringUtils.isBlank(userCheckDto.getPhone())
                && null == userCheckDto.getMid()) {

            result.put(ServiceOutput.STR_MSG_SUCCESS, false);
            result.put(ServiceOutput.STR_MSG_ERRCODE, "-1");
            result.put(ServiceOutput.STR_MSG_ERRMSG, "参数phone不为空.");

            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
        }

        if (StringUtils.isNotBlank(userCheckDto.getPhone())) {
            ReFreshBlackListTask.phoneBlackMap.remove(userCheckDto.getPhone());
        }

        result.put(ServiceOutput.STR_MSG_SUCCESS, true);
        result.put(ServiceOutput.STR_MSG_ERRCODE, "1");
        result.put(ServiceOutput.STR_MSG_ERRMSG, "删除黑名单成功");
        Cat.logEvent("DeleteCache ", userCheckDto.getPhone());
        log.info("\n---------------- Delete Cache {} -----------------\n", userCheckDto.getPhone());

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "cache/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> add(HttpSession httpSession, UserCheckDto userCheckDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        if (StringUtils.isBlank(userCheckDto.getCardid())
                && StringUtils.isBlank(userCheckDto.getPhone())
                && null == userCheckDto.getMid()) {

            result.put(ServiceOutput.STR_MSG_SUCCESS, false);
            result.put(ServiceOutput.STR_MSG_ERRCODE, "-1");
            result.put(ServiceOutput.STR_MSG_ERRMSG, "参数phone不为空.");

            return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
        }

        if (StringUtils.isNotBlank(userCheckDto.getPhone())) {
            ReFreshBlackListTask.phoneBlackMap.put(userCheckDto.getPhone(), BlackUserEnum.INVALID);
        }

        result.put(ServiceOutput.STR_MSG_SUCCESS, true);
        result.put(ServiceOutput.STR_MSG_ERRCODE, "1");
        result.put(ServiceOutput.STR_MSG, "添加黑名单成功");
        Cat.logEvent("ADDCache ", userCheckDto.getPhone());
        log.info("\n++++++++++++++++++ ADD Cache {} ++++++++++++++++\n", userCheckDto.getPhone());

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }


    @RequestMapping(value = "cache/refresh", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Map<String, Object>> refresh(HttpSession httpSession, UserCheckDto userCheckDto) {
        HashMap<String, Object> result = new HashMap<String, Object>();

        ReFreshBlackListTask reFreshBlackListTask = new ReFreshBlackListTask();
        ArrayList<BlackList> blackListArrayList = blackListMapper.query();
        ReFreshBlackListTask.phoneBlackMap.clear();
        ReFreshBlackListTask.midBlackMap.clear();
        ReFreshBlackListTask.cardIdBlackMap.clear();
        reFreshBlackListTask.passSwitchMap.clear();

        PassSwitch passSwitch = passSwitchMapper.isClose();
        reFreshBlackListTask.initCache(blackListArrayList, passSwitch);

        result.put(ServiceOutput.STR_MSG_SUCCESS, true);
        result.put(ServiceOutput.STR_MSG_ERRCODE, ReFreshBlackListTask.phoneBlackMap.size());
        result.put(ServiceOutput.STR_MSG, "刷新黑名单成功");
        Cat.logEvent("ReFreshCache ", "刷新黑名单成功");
        log.info("\n++++++++++++++++++ ReFresh Cache  ++++++++++++++++\n");

        return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
    }


}
