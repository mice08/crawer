package com.mk.whotel.web.service;

import com.dianping.cat.Cat;
import com.mk.whotel.api.dtos.UserCheckDto;
import com.mk.whotel.api.enums.BlackUserEnum;
import com.mk.whotel.task.ReFreshBlackListTask;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;

/**
 * Created by kirinli on 15/9/9.
 */
public class CheckUser {
    public static Logger log = org.slf4j.LoggerFactory.getLogger(CheckUser.class);

    public static BlackUserEnum check(UserCheckDto userCheckDto) {

        BlackUserEnum resultEnum;
        BlackUserEnum midEnum = BlackUserEnum.VALID;
        BlackUserEnum phoneEnum = BlackUserEnum.VALID;
        BlackUserEnum cardEnum = BlackUserEnum.VALID;


        if (userCheckDto.getMid() != null) {
            BlackUserEnum midTempEnum = ReFreshBlackListTask.midBlackMap.get(userCheckDto.getMid());

            if (midTempEnum != null) {
                midEnum = midTempEnum;
            }
        }

        if (StringUtils.isNotBlank(userCheckDto.getPhone())) {
            BlackUserEnum phoneTempEnum = ReFreshBlackListTask.phoneBlackMap.get(userCheckDto.getPhone());

            if (phoneTempEnum != null) {
                phoneEnum = phoneTempEnum;
            }
        }

        if (StringUtils.isNotBlank(userCheckDto.getCardid())) {
            BlackUserEnum cardTempEnum = ReFreshBlackListTask.cardIdBlackMap.get(userCheckDto.getPhone());

            if (cardTempEnum != null) {
                cardEnum = cardTempEnum;
            }
        }

        if (midEnum.getName().equals(BlackUserEnum.INVALID.getName())
                || phoneEnum.getName().equals(BlackUserEnum.INVALID.getName())
                || cardEnum.getName().equals(BlackUserEnum.INVALID.getName())) {
            resultEnum = BlackUserEnum.INVALID;
            Cat.logEvent("BlackListBlock", userCheckDto.getPhone());
            log.info("\n*************** BlackListBlock {} *****************\n", userCheckDto.getPhone());
        } else {
            resultEnum = BlackUserEnum.VALID;
            Cat.logEvent("BlackListAccess", userCheckDto.getPhone());
            log.info("\n=============== BlackListAccess {} ================\n", userCheckDto.getPhone());
        }

        return resultEnum;

    }
}
