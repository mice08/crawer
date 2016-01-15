package com.mk.crawer.job.hotel.price;

import com.google.common.collect.ImmutableSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 振涛 on 2016/1/15.
 */
public class ScoreUtil {

    /**
     * 路由规则1
     */
    private static final ImmutableSet<String> RULE_0_CITY_SET = ImmutableSet.of(
            "重庆",
            "成都",
            "安庆",
            "洛阳",
            "长沙",
            "上海"
    );
    /**
     * 路由规则2
     */
    private static final ImmutableSet<String> RULE_1_CITY_SET = ImmutableSet.of(
            "阿坝",
            "阿勒泰",
            "安康",
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
     * 路由规则3
     */
    private static final ImmutableSet<String> RULE_2_CITY_SET = ImmutableSet.of(
            "3"
    );
    /**
     * 路由规则4
     */
    private static final ImmutableSet<String> RULE_3_CITY_SET = ImmutableSet.of(
            "4"
    );
    /**
     * 路由规则5
     */
    private static final ImmutableSet<String> RULE_4_CITY_SET = ImmutableSet.of(
            "5"
    );

    private static List<Rule> rules = new ArrayList<>();

    private static class Rule {
        private Double score;
        private ImmutableSet<String> cities;

        static Rule create(Double score, ImmutableSet<String> cities) {
            Rule rule = new Rule();
            rule.score = score;
            rule.cities = cities;
            return rule;
        }

        boolean contains(String city) {
            return cities.contains(city);
        }

        Double getScore() {
            return this.score;
        }
    }

    static {
        init();
    }

    private static void init() {
        rules.add(Rule.create(0.0, RULE_0_CITY_SET));
        rules.add(Rule.create(1.0, RULE_1_CITY_SET));
        rules.add(Rule.create(2.0, RULE_2_CITY_SET));
        rules.add(Rule.create(3.0, RULE_3_CITY_SET));
        rules.add(Rule.create(4.0, RULE_4_CITY_SET));
    }

    public static Double getScore(String cityName) {
        Double score = Double.MAX_VALUE;

        for (Rule rule : rules) {
            if ( rule.contains(cityName) ) {
                score = rule.getScore();
                break;
            }
        }

        return score;
    }

}
