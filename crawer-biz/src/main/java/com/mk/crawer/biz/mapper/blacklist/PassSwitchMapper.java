package com.mk.crawer.biz.mapper.blacklist;

import com.mk.crawer.biz.moudle.PassSwitch;

/**
 * Created by kirinli on 15/9/10.
 */
public interface PassSwitchMapper {
    PassSwitch isClose();
    int updateSwitch(int is_close);

}
