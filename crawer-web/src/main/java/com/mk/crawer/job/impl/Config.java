package com.mk.crawer.job.impl;

import com.google.common.collect.ImmutableSet;

/**
 * Created by 振涛 on 2016/1/7.
 */
public class Config {

    /**
     * 中国热门城市100个集合
     */
    public static final ImmutableSet<String> HOT_CITY_100_SET = ImmutableSet.of(
            "阿坝",
            "阿勒泰",
            "安康",
            "安庆",
            "安顺",
            "安阳",
            "鞍山",
            "阿克苏",
            "北京",
            "北海",
            "保定",
            "保山",
            "宝鸡",
            "包头",
            "蚌埠",
            "百色",
            "本溪",
            "白山",
            "滨州",
            "成都",
            "重庆",
            "长沙",
            "常州",
            "长春",
            "承德",
            "常德",
            "郴州",
            "沧州",
            "池州",
            "大连",
            "大理",
            "东莞",
            "丹东",
            "大同",
            "迪庆",
            "德州",
            "东营",
            "德阳",
            "大庆",
            "鄂尔多斯",
            "鄂州",
            "恩施自治州",
            "福州",
            "佛山",
            "防城港",
            "抚顺",
            "阜阳",
            "阜新",
            "抚州",
            "广州",
            "桂林",
            "贵阳",
            "赣州",
            "鼓浪屿",
            "甘孜",
            "广元",
            "甘南",
            "固原",
            "贵港",
            "杭州",
            "哈尔滨",
            "黄山",
            "惠州",
            "合肥",
            "海口",
            "湖州",
            "呼和浩特",
            "衡阳",
            "葫芦岛",
            "呼伦贝尔",
            "邯郸",
            "汉中",
            "衡水",
            "怀化",
            "吉林",
            "嘉兴",
            "济南",
            "晋中",
            "金华",
            "九江",
            "江门",
            "焦作",
            "济宁",
            "酒泉",
            "锦州",
            "景德镇",
            "吉安",
            "昆明",
            "开封",
            "喀什",
            "克拉玛依",
            "丽江",
            "洛阳",
            "乐山",
            "拉萨",
            "兰州",
            "凉山",
            "廊坊",
            "连云港",
            "柳州",
            "临沂",
            "绵阳",
            "茂名",
            "梅州",
            "眉山",
            "牡丹江",
            "马鞍山",
            "南京",
            "宁波",
            "南宁",
            "南昌"
    );
    /**
     * 中国热门城市1000个集合
     */
    public static final ImmutableSet<String> HOT_CITY_1000_SET = ImmutableSet.of(
            "长沙",
            "成都",
            "西安"
    );



    /**
     * 中国热门城市100个集合的线程池并发数
     */
    public static final Integer HOT_CITY_100_CONCURRENCY_THREAD_COUNT = 100;
    /**
     * 中国热门城市1000个集合的线程池并发数
     */
    public static final Integer HOT_CITY_1000_CONCURRENCY_THREAD_COUNT = 5;
    /**
     * 中国非热门城市的线程池并发数
     */
    public static final Integer NO_HOT_CITY_CONCURRENCY_THREAD_COUNT = 5;


}
