package com.mk.whotel.biz.mapper.blacklist;

import com.mk.whotel.biz.moudle.BlackList;

import java.util.ArrayList;

/**
 * Created by kirinli on 15/9/9.
 */
public interface BlackListMapper  {
    ArrayList<BlackList> query();
    public Integer saveBlackList(BlackList model);
    public Boolean deleteBlackList(Integer id);
    public Integer updateBlackList(BlackList model);

    public int countBlacklist();
}
