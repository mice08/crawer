package com.mk.bypass.biz.servcie;

import com.mk.bypass.biz.mapper.blacklist.BlackListMapper;
import com.mk.bypass.biz.moudle.BlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by kirinli on 15/9/9.
 */
@Service
public class BlackListService implements BlackListMapper{
    @Autowired
    private BlackListMapper blackListMapper;

    @Override
    public ArrayList<BlackList> query() {
        return blackListMapper.query();
    }

    @Override
    public Integer saveBlackList(BlackList model) {
        return null;
    }

    @Override
    public Boolean deleteBlackList(Integer id) {
        return null;
    }

    @Override
    public Integer updateBlackList(BlackList model) {
        return null;
    }

    @Override
    public int countBlacklist() {
        return 0;
    }
}
