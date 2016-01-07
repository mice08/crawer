package com.mk.crawer.biz.enums;

import org.springframework.util.StringUtils;

/**
 * Created by jeashi on 2016/1/6.
 */
public enum CityTypeEnum {
    DEAFULT("默认","-1"),
    REMENCS("热门城市","1"),
    DONGNANYA("东南亚","2"),
    YAZHOU("亚洲","3"),
    DAXIYANG("大洋洲","4"),
    OUZZHOU("欧洲","5"),
    HAIDAO("海岛","6"),

    MEIZHOU("美洲","7");


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
