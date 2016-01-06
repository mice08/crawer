package com.mk.crawer.biz.mapper.blacklist;

import java.util.ArrayList;

import com.mk.crawer.biz.module.BlackList;

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
