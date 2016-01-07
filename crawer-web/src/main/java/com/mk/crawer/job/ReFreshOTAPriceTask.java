package com.mk.crawer.job;

import com.mk.crawer.biz.servcie.ICityListService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReFreshOTAPriceTask {
   public static Logger log = org.slf4j.LoggerFactory.getLogger(ReFreshOTAPriceTask.class);
    @Autowired
    private ICityListService blackListMapper;

/*
    public void run() {
        reFlashBlackListData();
    }

    public void reFlashBlackListData() {


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
    */


}