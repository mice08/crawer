package com.mk.crawer.job;

import com.mk.crawer.biz.enums.CityTypeEnum;
import com.mk.crawer.biz.model.crawer.CityList;
import com.mk.crawer.biz.servcie.ICityListService;
import com.mk.framework.proxy.http.JSONUtil;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kirin on 2016/1/6.
 */
@Service
public class TaskService {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(TaskService.class);

    @Autowired
    public ICityListService cityListService;
    public static void removeCityList() {
        List<CityList> cityLists = TaskServiceManager.listAllCity();
        for (CityList cityList : cityLists) {
            TaskServiceManager.remove(cityList);
            LOGGER.info("移除城市：{}，还有{}个城市。", JSONUtil.toJson(cityList), TaskServiceManager.count());
        }
    }

    public  void reFreshCityList() {

        List<CityList> cityLists = cityListService.selectByCityType(CityTypeEnum.DEAFULT.getType());
        for (CityList cityList : cityLists) {
            TaskServiceManager.add(cityList);
            LOGGER.info("添加城市：{}，已经有{}个城市了。", JSONUtil.toJson(cityList),  TaskServiceManager.count());
        }
    }

    public List<CityList> allCityList(){
        return TaskServiceManager.listAllCity();
    }




}
