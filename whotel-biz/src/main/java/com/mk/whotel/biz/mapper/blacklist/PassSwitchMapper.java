package com.mk.whotel.biz.mapper.blacklist;

import com.mk.whotel.biz.moudle.PassSwitch;

/**
 * Created by kirinli on 15/9/10.
 */
public interface PassSwitchMapper {
    PassSwitch isClose();
    int updateSwitch(int is_close);

}
