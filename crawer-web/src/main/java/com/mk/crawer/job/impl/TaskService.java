package com.mk.crawer.job.impl;

import com.mk.crawer.biz.enums.CityTypeEnum;
import com.mk.crawer.biz.mapper.crawer.CityMapper;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.framework.AppUtils;
import com.mk.framework.proxy.http.JSONUtil;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kirin on 2016/1/6.
 */
@Component
public class TaskService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TaskService.class);


    public static void removeCityList() {
        List<CityList> cityLists = TaskServiceManager.listAllCity();
        for (CityList cityList : cityLists) {
            TaskServiceManager.remove(cityList);
            LOGGER.info("移除城市：{}，还有{}个城市。", JSONUtil.toJson(cityList), TaskServiceManager.count());
        }
    }

    public  void reFreshCityList() {
        CityMapper cityMapper = AppUtils.getBean(CityMapper.class);
        List<CityList> cityLists = cityMapper.selectByCityType(CityTypeEnum.DEAFULT.getType());
        for (CityList cityList : cityLists) {
            TaskServiceManager.add(cityList);
            LOGGER.info("添加城市：{}，已经有{}个城市了。", JSONUtil.toJson(cityList),  TaskServiceManager.count());
        }
    }

    public List<CityList> allCityList(){
        return TaskServiceManager.listAllCity();
    }




}
