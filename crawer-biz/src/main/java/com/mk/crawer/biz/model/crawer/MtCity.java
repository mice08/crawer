package com.mk.crawer.biz.model.crawer;

import java.util.List;

/**
 * Created by BurizaDo on 2/18/16.
 */
public class MtCity {
    public int id;
    public String rank;
    public String acronym;
    public long onlineTime;
    public String divisionStr;
    public String name;
    public String locationId;
    public double lng;
    public double lat;
    public String pinyin;
    public boolean isOpen;

    public static class MtCityList{
        public List<MtCity> data;
    }
}
