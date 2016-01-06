package com.mk.crawer.biz.enums;

import org.springframework.util.StringUtils;

/**
 * Created by jeashi on 2016/1/6.
 */
public enum CityTypeEnum {
    DONGNANYA("东南亚","1"),
    YAZHOU("亚洲","1"),
    DAXIYANG("大洋洲","1"),
    OUZZHOU("欧洲","1"),
    HAIDAO("海岛","2"),
    REMENCS("热门城市","3"),
    MEIZHOU("美洲","1"),
    DEAFULT("默认","1");

    private final String name;
    private final String type;

    private CityTypeEnum(String name, String type){
        this.name=name;
        this.type=type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }


    public static CityTypeEnum getByName(String name){
        if(StringUtils.isEmpty(name)){
            return  DEAFULT;
        }
        for (CityTypeEnum temp : CityTypeEnum.values()) {
            if(temp.getName().equals(name)){
                return temp;
            }
        }
        return DEAFULT;
    }

    public static String getTypeByName(String name){
        if(StringUtils.isEmpty(name)){
            return  DEAFULT.getType();
        }
        for (CityTypeEnum temp : CityTypeEnum.values()) {
            if(temp.getName().equals(name)){
              return temp.getType();
            }
        }
        return  DEAFULT.getType();
    }
}
