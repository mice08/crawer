package com.mk.crawer.task;

import com.mk.crawer.api.enums.BlackUserEnum;
import com.mk.crawer.biz.mapper.blacklist.BlackListMapper;
import com.mk.crawer.biz.mapper.blacklist.PassSwitchMapper;
import com.mk.crawer.biz.moudle.BlackList;
import com.mk.crawer.biz.moudle.PassSwitch;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kirinli on 15/9/9.
 */
@Service
public class ReFreshBlackListTask {
    public static Logger log = org.slf4j.LoggerFactory.getLogger(ReFreshBlackListTask.class);
    @Autowired
    private BlackListMapper blackListMapper;

    @Autowired
    private PassSwitchMapper passSwitchMapper;

    public static ConcurrentHashMap<Integer, BlackUserEnum> midBlackMap = new ConcurrentHashMap<Integer, BlackUserEnum>();
    public static ConcurrentHashMap<String, BlackUserEnum> phoneBlackMap = new ConcurrentHashMap<String, BlackUserEnum>();
    public static ConcurrentHashMap<String, BlackUserEnum> cardIdBlackMap = new ConcurrentHashMap<String, BlackUserEnum>();
    public static ConcurrentHashMap<String, Integer> passSwitchMap = new ConcurrentHashMap<String, Integer>();


    public void run() {
        reFlashBlackListData();
    }

    public void reFlashBlackListData() {
        phoneBlackMap.clear();
        midBlackMap.clear();
        cardIdBlackMap.clear();
        passSwitchMap.clear();

        ArrayList<BlackList> blackListArrayList = blackListMapper.query();

        PassSwitch passSwitch = passSwitchMapper.isClose();

        initCache(blackListArrayList, passSwitch);
    }


    public void initCache(ArrayList<BlackList> blackListArrayList, PassSwitch passSwitch) {

        passSwitchMap.put("isClose", passSwitch.getIsClose());

        log.info("\n++++++++++++++++++++++ pass switch refresh {} ++++++++++++++++++++++\n",passSwitch.getIsClose() );

        for (BlackList blackList : blackListArrayList) {
            if (StringUtils.isNotBlank(blackList.getPhone())){
                phoneBlackMap.put(blackList.getPhone(), BlackUserEnum.INVALID);
            }
            if (blackList.getMid() != null){
                midBlackMap.put(blackList.getMid(), BlackUserEnum.INVALID);
            }


            if (StringUtils.isNotBlank(blackList.getIdcard())) {
                cardIdBlackMap.put(blackList.getIdcard(), BlackUserEnum.INVALID);
            }

        }
    }


}
