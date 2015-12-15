package com.mk.bypass.biz.mapper.blacklist;

import com.mk.bypass.biz.moudle.PassSwitch;

/**
 * Created by kirinli on 15/9/10.
 */
public interface PassSwitchMapper {
    PassSwitch isClose();
    int updateSwitch(int is_close);

}
