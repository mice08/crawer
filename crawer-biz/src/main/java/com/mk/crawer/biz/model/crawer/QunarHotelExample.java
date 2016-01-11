package com.mk.crawer.biz.model.crawer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class QunarHotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public QunarHotelExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNull() {
            addCriterion("source_id is null");
            return (Criteria) this;
        }

        public Criteria andSourceIdIsNotNull() {
            addCriterion("source_id is not null");
            return (Criteria) this;
        }

        public Criteria andSourceIdEqualTo(String value) {
            addCriterion("source_id =", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotEqualTo(String value) {
            addCriterion("source_id <>", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThan(String value) {
            addCriterion("source_id >", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("source_id >=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThan(String value) {
            addCriterion("source_id <", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLessThanOrEqualTo(String value) {
            addCriterion("source_id <=", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdLike(String value) {
            addCriterion("source_id like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotLike(String value) {
            addCriterion("source_id not like", value, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdIn(List<String> values) {
            addCriterion("source_id in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotIn(List<String> values) {
            addCriterion("source_id not in", values, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdBetween(String value1, String value2) {
            addCriterion("source_id between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andSourceIdNotBetween(String value1, String value2) {
            addCriterion("source_id not between", value1, value2, "sourceId");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomIsNull() {
            addCriterion("is_lm_full_room is null");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomIsNotNull() {
            addCriterion("is_lm_full_room is not null");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomEqualTo(String value) {
            addCriterion("is_lm_full_room =", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomNotEqualTo(String value) {
            addCriterion("is_lm_full_room <>", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomGreaterThan(String value) {
            addCriterion("is_lm_full_room >", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomGreaterThanOrEqualTo(String value) {
            addCriterion("is_lm_full_room >=", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomLessThan(String value) {
            addCriterion("is_lm_full_room <", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomLessThanOrEqualTo(String value) {
            addCriterion("is_lm_full_room <=", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomLike(String value) {
            addCriterion("is_lm_full_room like", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomNotLike(String value) {
            addCriterion("is_lm_full_room not like", value, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomIn(List<String> values) {
            addCriterion("is_lm_full_room in", values, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomNotIn(List<String> values) {
            addCriterion("is_lm_full_room not in", values, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomBetween(String value1, String value2) {
            addCriterion("is_lm_full_room between", value1, value2, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andIsLmFullRoomNotBetween(String value1, String value2) {
            addCriterion("is_lm_full_room not between", value1, value2, "isLmFullRoom");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(String value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(String value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(String value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(String value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(String value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(String value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLike(String value) {
            addCriterion("distance like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotLike(String value) {
            addCriterion("distance not like", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<String> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<String> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(String value1, String value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(String value1, String value2) {
            addCriterion("distance not between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitIsNull() {
            addCriterion("special_price_bit is null");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitIsNotNull() {
            addCriterion("special_price_bit is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitEqualTo(Integer value) {
            addCriterion("special_price_bit =", value, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitNotEqualTo(Integer value) {
            addCriterion("special_price_bit <>", value, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitGreaterThan(Integer value) {
            addCriterion("special_price_bit >", value, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitGreaterThanOrEqualTo(Integer value) {
            addCriterion("special_price_bit >=", value, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitLessThan(Integer value) {
            addCriterion("special_price_bit <", value, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitLessThanOrEqualTo(Integer value) {
            addCriterion("special_price_bit <=", value, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitIn(List<Integer> values) {
            addCriterion("special_price_bit in", values, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitNotIn(List<Integer> values) {
            addCriterion("special_price_bit not in", values, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitBetween(Integer value1, Integer value2) {
            addCriterion("special_price_bit between", value1, value2, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andSpecialPriceBitNotBetween(Integer value1, Integer value2) {
            addCriterion("special_price_bit not between", value1, value2, "specialPriceBit");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoIsNull() {
            addCriterion("has_five_ftar_hongbao is null");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoIsNotNull() {
            addCriterion("has_five_ftar_hongbao is not null");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoEqualTo(String value) {
            addCriterion("has_five_ftar_hongbao =", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoNotEqualTo(String value) {
            addCriterion("has_five_ftar_hongbao <>", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoGreaterThan(String value) {
            addCriterion("has_five_ftar_hongbao >", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoGreaterThanOrEqualTo(String value) {
            addCriterion("has_five_ftar_hongbao >=", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoLessThan(String value) {
            addCriterion("has_five_ftar_hongbao <", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoLessThanOrEqualTo(String value) {
            addCriterion("has_five_ftar_hongbao <=", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoLike(String value) {
            addCriterion("has_five_ftar_hongbao like", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoNotLike(String value) {
            addCriterion("has_five_ftar_hongbao not like", value, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoIn(List<String> values) {
            addCriterion("has_five_ftar_hongbao in", values, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoNotIn(List<String> values) {
            addCriterion("has_five_ftar_hongbao not in", values, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoBetween(String value1, String value2) {
            addCriterion("has_five_ftar_hongbao between", value1, value2, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasFiveFtarHongbaoNotBetween(String value1, String value2) {
            addCriterion("has_five_ftar_hongbao not between", value1, value2, "hasFiveFtarHongbao");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedIsNull() {
            addCriterion("has_signIn_red is null");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedIsNotNull() {
            addCriterion("has_signIn_red is not null");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedEqualTo(String value) {
            addCriterion("has_signIn_red =", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedNotEqualTo(String value) {
            addCriterion("has_signIn_red <>", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedGreaterThan(String value) {
            addCriterion("has_signIn_red >", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedGreaterThanOrEqualTo(String value) {
            addCriterion("has_signIn_red >=", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedLessThan(String value) {
            addCriterion("has_signIn_red <", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedLessThanOrEqualTo(String value) {
            addCriterion("has_signIn_red <=", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedLike(String value) {
            addCriterion("has_signIn_red like", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedNotLike(String value) {
            addCriterion("has_signIn_red not like", value, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedIn(List<String> values) {
            addCriterion("has_signIn_red in", values, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedNotIn(List<String> values) {
            addCriterion("has_signIn_red not in", values, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedBetween(String value1, String value2) {
            addCriterion("has_signIn_red between", value1, value2, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andHasSigninRedNotBetween(String value1, String value2) {
            addCriterion("has_signIn_red not between", value1, value2, "hasSigninRed");
            return (Criteria) this;
        }

        public Criteria andShowRedPackIsNull() {
            addCriterion("show_red_pack is null");
            return (Criteria) this;
        }

        public Criteria andShowRedPackIsNotNull() {
            addCriterion("show_red_pack is not null");
            return (Criteria) this;
        }

        public Criteria andShowRedPackEqualTo(String value) {
            addCriterion("show_red_pack =", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackNotEqualTo(String value) {
            addCriterion("show_red_pack <>", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackGreaterThan(String value) {
            addCriterion("show_red_pack >", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackGreaterThanOrEqualTo(String value) {
            addCriterion("show_red_pack >=", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackLessThan(String value) {
            addCriterion("show_red_pack <", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackLessThanOrEqualTo(String value) {
            addCriterion("show_red_pack <=", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackLike(String value) {
            addCriterion("show_red_pack like", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackNotLike(String value) {
            addCriterion("show_red_pack not like", value, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackIn(List<String> values) {
            addCriterion("show_red_pack in", values, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackNotIn(List<String> values) {
            addCriterion("show_red_pack not in", values, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackBetween(String value1, String value2) {
            addCriterion("show_red_pack between", value1, value2, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andShowRedPackNotBetween(String value1, String value2) {
            addCriterion("show_red_pack not between", value1, value2, "showRedPack");
            return (Criteria) this;
        }

        public Criteria andWapInfoIsNull() {
            addCriterion("wap_info is null");
            return (Criteria) this;
        }

        public Criteria andWapInfoIsNotNull() {
            addCriterion("wap_info is not null");
            return (Criteria) this;
        }

        public Criteria andWapInfoEqualTo(Integer value) {
            addCriterion("wap_info =", value, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoNotEqualTo(Integer value) {
            addCriterion("wap_info <>", value, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoGreaterThan(Integer value) {
            addCriterion("wap_info >", value, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("wap_info >=", value, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoLessThan(Integer value) {
            addCriterion("wap_info <", value, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoLessThanOrEqualTo(Integer value) {
            addCriterion("wap_info <=", value, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoIn(List<Integer> values) {
            addCriterion("wap_info in", values, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoNotIn(List<Integer> values) {
            addCriterion("wap_info not in", values, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoBetween(Integer value1, Integer value2) {
            addCriterion("wap_info between", value1, value2, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andWapInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("wap_info not between", value1, value2, "wapInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoIsNull() {
            addCriterion("hour_result_info is null");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoIsNotNull() {
            addCriterion("hour_result_info is not null");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoEqualTo(Integer value) {
            addCriterion("hour_result_info =", value, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoNotEqualTo(Integer value) {
            addCriterion("hour_result_info <>", value, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoGreaterThan(Integer value) {
            addCriterion("hour_result_info >", value, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoGreaterThanOrEqualTo(Integer value) {
            addCriterion("hour_result_info >=", value, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoLessThan(Integer value) {
            addCriterion("hour_result_info <", value, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoLessThanOrEqualTo(Integer value) {
            addCriterion("hour_result_info <=", value, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoIn(List<Integer> values) {
            addCriterion("hour_result_info in", values, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoNotIn(List<Integer> values) {
            addCriterion("hour_result_info not in", values, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoBetween(Integer value1, Integer value2) {
            addCriterion("hour_result_info between", value1, value2, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andHourResultInfoNotBetween(Integer value1, Integer value2) {
            addCriterion("hour_result_info not between", value1, value2, "hourResultInfo");
            return (Criteria) this;
        }

        public Criteria andWapTypeIsNull() {
            addCriterion("wap_type is null");
            return (Criteria) this;
        }

        public Criteria andWapTypeIsNotNull() {
            addCriterion("wap_type is not null");
            return (Criteria) this;
        }

        public Criteria andWapTypeEqualTo(Integer value) {
            addCriterion("wap_type =", value, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeNotEqualTo(Integer value) {
            addCriterion("wap_type <>", value, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeGreaterThan(Integer value) {
            addCriterion("wap_type >", value, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("wap_type >=", value, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeLessThan(Integer value) {
            addCriterion("wap_type <", value, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeLessThanOrEqualTo(Integer value) {
            addCriterion("wap_type <=", value, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeIn(List<Integer> values) {
            addCriterion("wap_type in", values, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeNotIn(List<Integer> values) {
            addCriterion("wap_type not in", values, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeBetween(Integer value1, Integer value2) {
            addCriterion("wap_type between", value1, value2, "wapType");
            return (Criteria) this;
        }

        public Criteria andWapTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("wap_type not between", value1, value2, "wapType");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoIsNull() {
            addCriterion("has_bnb_hongbao is null");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoIsNotNull() {
            addCriterion("has_bnb_hongbao is not null");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoEqualTo(String value) {
            addCriterion("has_bnb_hongbao =", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoNotEqualTo(String value) {
            addCriterion("has_bnb_hongbao <>", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoGreaterThan(String value) {
            addCriterion("has_bnb_hongbao >", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoGreaterThanOrEqualTo(String value) {
            addCriterion("has_bnb_hongbao >=", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoLessThan(String value) {
            addCriterion("has_bnb_hongbao <", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoLessThanOrEqualTo(String value) {
            addCriterion("has_bnb_hongbao <=", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoLike(String value) {
            addCriterion("has_bnb_hongbao like", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoNotLike(String value) {
            addCriterion("has_bnb_hongbao not like", value, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoIn(List<String> values) {
            addCriterion("has_bnb_hongbao in", values, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoNotIn(List<String> values) {
            addCriterion("has_bnb_hongbao not in", values, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoBetween(String value1, String value2) {
            addCriterion("has_bnb_hongbao between", value1, value2, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnbHongbaoNotBetween(String value1, String value2) {
            addCriterion("has_bnb_hongbao not between", value1, value2, "hasBnbHongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoIsNull() {
            addCriterion("has_bnb9_hongbao is null");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoIsNotNull() {
            addCriterion("has_bnb9_hongbao is not null");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoEqualTo(String value) {
            addCriterion("has_bnb9_hongbao =", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoNotEqualTo(String value) {
            addCriterion("has_bnb9_hongbao <>", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoGreaterThan(String value) {
            addCriterion("has_bnb9_hongbao >", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoGreaterThanOrEqualTo(String value) {
            addCriterion("has_bnb9_hongbao >=", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoLessThan(String value) {
            addCriterion("has_bnb9_hongbao <", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoLessThanOrEqualTo(String value) {
            addCriterion("has_bnb9_hongbao <=", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoLike(String value) {
            addCriterion("has_bnb9_hongbao like", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoNotLike(String value) {
            addCriterion("has_bnb9_hongbao not like", value, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoIn(List<String> values) {
            addCriterion("has_bnb9_hongbao in", values, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoNotIn(List<String> values) {
            addCriterion("has_bnb9_hongbao not in", values, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoBetween(String value1, String value2) {
            addCriterion("has_bnb9_hongbao between", value1, value2, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andHasBnb9HongbaoNotBetween(String value1, String value2) {
            addCriterion("has_bnb9_hongbao not between", value1, value2, "hasBnb9Hongbao");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlIsNull() {
            addCriterion("ppcImg_url is null");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlIsNotNull() {
            addCriterion("ppcImg_url is not null");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlEqualTo(String value) {
            addCriterion("ppcImg_url =", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlNotEqualTo(String value) {
            addCriterion("ppcImg_url <>", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlGreaterThan(String value) {
            addCriterion("ppcImg_url >", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ppcImg_url >=", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlLessThan(String value) {
            addCriterion("ppcImg_url <", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlLessThanOrEqualTo(String value) {
            addCriterion("ppcImg_url <=", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlLike(String value) {
            addCriterion("ppcImg_url like", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlNotLike(String value) {
            addCriterion("ppcImg_url not like", value, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlIn(List<String> values) {
            addCriterion("ppcImg_url in", values, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlNotIn(List<String> values) {
            addCriterion("ppcImg_url not in", values, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlBetween(String value1, String value2) {
            addCriterion("ppcImg_url between", value1, value2, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andPpcimgUrlNotBetween(String value1, String value2) {
            addCriterion("ppcImg_url not between", value1, value2, "ppcimgUrl");
            return (Criteria) this;
        }

        public Criteria andJpMIsNull() {
            addCriterion("jp_m is null");
            return (Criteria) this;
        }

        public Criteria andJpMIsNotNull() {
            addCriterion("jp_m is not null");
            return (Criteria) this;
        }

        public Criteria andJpMEqualTo(Integer value) {
            addCriterion("jp_m =", value, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMNotEqualTo(Integer value) {
            addCriterion("jp_m <>", value, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMGreaterThan(Integer value) {
            addCriterion("jp_m >", value, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMGreaterThanOrEqualTo(Integer value) {
            addCriterion("jp_m >=", value, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMLessThan(Integer value) {
            addCriterion("jp_m <", value, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMLessThanOrEqualTo(Integer value) {
            addCriterion("jp_m <=", value, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMIn(List<Integer> values) {
            addCriterion("jp_m in", values, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMNotIn(List<Integer> values) {
            addCriterion("jp_m not in", values, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMBetween(Integer value1, Integer value2) {
            addCriterion("jp_m between", value1, value2, "jpM");
            return (Criteria) this;
        }

        public Criteria andJpMNotBetween(Integer value1, Integer value2) {
            addCriterion("jp_m not between", value1, value2, "jpM");
            return (Criteria) this;
        }

        public Criteria andCorrDistIsNull() {
            addCriterion("corr_dist is null");
            return (Criteria) this;
        }

        public Criteria andCorrDistIsNotNull() {
            addCriterion("corr_dist is not null");
            return (Criteria) this;
        }

        public Criteria andCorrDistEqualTo(String value) {
            addCriterion("corr_dist =", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistNotEqualTo(String value) {
            addCriterion("corr_dist <>", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistGreaterThan(String value) {
            addCriterion("corr_dist >", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistGreaterThanOrEqualTo(String value) {
            addCriterion("corr_dist >=", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistLessThan(String value) {
            addCriterion("corr_dist <", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistLessThanOrEqualTo(String value) {
            addCriterion("corr_dist <=", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistLike(String value) {
            addCriterion("corr_dist like", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistNotLike(String value) {
            addCriterion("corr_dist not like", value, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistIn(List<String> values) {
            addCriterion("corr_dist in", values, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistNotIn(List<String> values) {
            addCriterion("corr_dist not in", values, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistBetween(String value1, String value2) {
            addCriterion("corr_dist between", value1, value2, "corrDist");
            return (Criteria) this;
        }

        public Criteria andCorrDistNotBetween(String value1, String value2) {
            addCriterion("corr_dist not between", value1, value2, "corrDist");
            return (Criteria) this;
        }

        public Criteria andIsLmIsNull() {
            addCriterion("is_lm is null");
            return (Criteria) this;
        }

        public Criteria andIsLmIsNotNull() {
            addCriterion("is_lm is not null");
            return (Criteria) this;
        }

        public Criteria andIsLmEqualTo(Integer value) {
            addCriterion("is_lm =", value, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmNotEqualTo(Integer value) {
            addCriterion("is_lm <>", value, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmGreaterThan(Integer value) {
            addCriterion("is_lm >", value, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_lm >=", value, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmLessThan(Integer value) {
            addCriterion("is_lm <", value, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmLessThanOrEqualTo(Integer value) {
            addCriterion("is_lm <=", value, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmIn(List<Integer> values) {
            addCriterion("is_lm in", values, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmNotIn(List<Integer> values) {
            addCriterion("is_lm not in", values, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmBetween(Integer value1, Integer value2) {
            addCriterion("is_lm between", value1, value2, "isLm");
            return (Criteria) this;
        }

        public Criteria andIsLmNotBetween(Integer value1, Integer value2) {
            addCriterion("is_lm not between", value1, value2, "isLm");
            return (Criteria) this;
        }

        public Criteria andLmPriceIsNull() {
            addCriterion("lm_price is null");
            return (Criteria) this;
        }

        public Criteria andLmPriceIsNotNull() {
            addCriterion("lm_price is not null");
            return (Criteria) this;
        }

        public Criteria andLmPriceEqualTo(String value) {
            addCriterion("lm_price =", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceNotEqualTo(String value) {
            addCriterion("lm_price <>", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceGreaterThan(String value) {
            addCriterion("lm_price >", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceGreaterThanOrEqualTo(String value) {
            addCriterion("lm_price >=", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceLessThan(String value) {
            addCriterion("lm_price <", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceLessThanOrEqualTo(String value) {
            addCriterion("lm_price <=", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceLike(String value) {
            addCriterion("lm_price like", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceNotLike(String value) {
            addCriterion("lm_price not like", value, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceIn(List<String> values) {
            addCriterion("lm_price in", values, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceNotIn(List<String> values) {
            addCriterion("lm_price not in", values, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceBetween(String value1, String value2) {
            addCriterion("lm_price between", value1, value2, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmPriceNotBetween(String value1, String value2) {
            addCriterion("lm_price not between", value1, value2, "lmPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceIsNull() {
            addCriterion("lm_old_price is null");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceIsNotNull() {
            addCriterion("lm_old_price is not null");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceEqualTo(String value) {
            addCriterion("lm_old_price =", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceNotEqualTo(String value) {
            addCriterion("lm_old_price <>", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceGreaterThan(String value) {
            addCriterion("lm_old_price >", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceGreaterThanOrEqualTo(String value) {
            addCriterion("lm_old_price >=", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceLessThan(String value) {
            addCriterion("lm_old_price <", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceLessThanOrEqualTo(String value) {
            addCriterion("lm_old_price <=", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceLike(String value) {
            addCriterion("lm_old_price like", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceNotLike(String value) {
            addCriterion("lm_old_price not like", value, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceIn(List<String> values) {
            addCriterion("lm_old_price in", values, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceNotIn(List<String> values) {
            addCriterion("lm_old_price not in", values, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceBetween(String value1, String value2) {
            addCriterion("lm_old_price between", value1, value2, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmOldPriceNotBetween(String value1, String value2) {
            addCriterion("lm_old_price not between", value1, value2, "lmOldPrice");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomIsNull() {
            addCriterion("lm_full_room is null");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomIsNotNull() {
            addCriterion("lm_full_room is not null");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomEqualTo(String value) {
            addCriterion("lm_full_room =", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomNotEqualTo(String value) {
            addCriterion("lm_full_room <>", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomGreaterThan(String value) {
            addCriterion("lm_full_room >", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomGreaterThanOrEqualTo(String value) {
            addCriterion("lm_full_room >=", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomLessThan(String value) {
            addCriterion("lm_full_room <", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomLessThanOrEqualTo(String value) {
            addCriterion("lm_full_room <=", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomLike(String value) {
            addCriterion("lm_full_room like", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomNotLike(String value) {
            addCriterion("lm_full_room not like", value, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomIn(List<String> values) {
            addCriterion("lm_full_room in", values, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomNotIn(List<String> values) {
            addCriterion("lm_full_room not in", values, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomBetween(String value1, String value2) {
            addCriterion("lm_full_room between", value1, value2, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andLmFullRoomNotBetween(String value1, String value2) {
            addCriterion("lm_full_room not between", value1, value2, "lmFullRoom");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIsNull() {
            addCriterion("avg_price is null");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIsNotNull() {
            addCriterion("avg_price is not null");
            return (Criteria) this;
        }

        public Criteria andAvgPriceEqualTo(String value) {
            addCriterion("avg_price =", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotEqualTo(String value) {
            addCriterion("avg_price <>", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceGreaterThan(String value) {
            addCriterion("avg_price >", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceGreaterThanOrEqualTo(String value) {
            addCriterion("avg_price >=", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLessThan(String value) {
            addCriterion("avg_price <", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLessThanOrEqualTo(String value) {
            addCriterion("avg_price <=", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceLike(String value) {
            addCriterion("avg_price like", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotLike(String value) {
            addCriterion("avg_price not like", value, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceIn(List<String> values) {
            addCriterion("avg_price in", values, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotIn(List<String> values) {
            addCriterion("avg_price not in", values, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceBetween(String value1, String value2) {
            addCriterion("avg_price between", value1, value2, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andAvgPriceNotBetween(String value1, String value2) {
            addCriterion("avg_price not between", value1, value2, "avgPrice");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyIsNull() {
            addCriterion("has_group_buy is null");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyIsNotNull() {
            addCriterion("has_group_buy is not null");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyEqualTo(String value) {
            addCriterion("has_group_buy =", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyNotEqualTo(String value) {
            addCriterion("has_group_buy <>", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyGreaterThan(String value) {
            addCriterion("has_group_buy >", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyGreaterThanOrEqualTo(String value) {
            addCriterion("has_group_buy >=", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyLessThan(String value) {
            addCriterion("has_group_buy <", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyLessThanOrEqualTo(String value) {
            addCriterion("has_group_buy <=", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyLike(String value) {
            addCriterion("has_group_buy like", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyNotLike(String value) {
            addCriterion("has_group_buy not like", value, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyIn(List<String> values) {
            addCriterion("has_group_buy in", values, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyNotIn(List<String> values) {
            addCriterion("has_group_buy not in", values, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyBetween(String value1, String value2) {
            addCriterion("has_group_buy between", value1, value2, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasGroupBuyNotBetween(String value1, String value2) {
            addCriterion("has_group_buy not between", value1, value2, "hasGroupBuy");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiIsNull() {
            addCriterion("has_te_hui is null");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiIsNotNull() {
            addCriterion("has_te_hui is not null");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiEqualTo(String value) {
            addCriterion("has_te_hui =", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiNotEqualTo(String value) {
            addCriterion("has_te_hui <>", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiGreaterThan(String value) {
            addCriterion("has_te_hui >", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiGreaterThanOrEqualTo(String value) {
            addCriterion("has_te_hui >=", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiLessThan(String value) {
            addCriterion("has_te_hui <", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiLessThanOrEqualTo(String value) {
            addCriterion("has_te_hui <=", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiLike(String value) {
            addCriterion("has_te_hui like", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiNotLike(String value) {
            addCriterion("has_te_hui not like", value, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiIn(List<String> values) {
            addCriterion("has_te_hui in", values, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiNotIn(List<String> values) {
            addCriterion("has_te_hui not in", values, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiBetween(String value1, String value2) {
            addCriterion("has_te_hui between", value1, value2, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasTeHuiNotBetween(String value1, String value2) {
            addCriterion("has_te_hui not between", value1, value2, "hasTeHui");
            return (Criteria) this;
        }

        public Criteria andHasDay7IsNull() {
            addCriterion("has_day7 is null");
            return (Criteria) this;
        }

        public Criteria andHasDay7IsNotNull() {
            addCriterion("has_day7 is not null");
            return (Criteria) this;
        }

        public Criteria andHasDay7EqualTo(String value) {
            addCriterion("has_day7 =", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7NotEqualTo(String value) {
            addCriterion("has_day7 <>", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7GreaterThan(String value) {
            addCriterion("has_day7 >", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7GreaterThanOrEqualTo(String value) {
            addCriterion("has_day7 >=", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7LessThan(String value) {
            addCriterion("has_day7 <", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7LessThanOrEqualTo(String value) {
            addCriterion("has_day7 <=", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7Like(String value) {
            addCriterion("has_day7 like", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7NotLike(String value) {
            addCriterion("has_day7 not like", value, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7In(List<String> values) {
            addCriterion("has_day7 in", values, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7NotIn(List<String> values) {
            addCriterion("has_day7 not in", values, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7Between(String value1, String value2) {
            addCriterion("has_day7 between", value1, value2, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasDay7NotBetween(String value1, String value2) {
            addCriterion("has_day7 not between", value1, value2, "hasDay7");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceIsNull() {
            addCriterion("has_chain_price is null");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceIsNotNull() {
            addCriterion("has_chain_price is not null");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceEqualTo(String value) {
            addCriterion("has_chain_price =", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceNotEqualTo(String value) {
            addCriterion("has_chain_price <>", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceGreaterThan(String value) {
            addCriterion("has_chain_price >", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceGreaterThanOrEqualTo(String value) {
            addCriterion("has_chain_price >=", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceLessThan(String value) {
            addCriterion("has_chain_price <", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceLessThanOrEqualTo(String value) {
            addCriterion("has_chain_price <=", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceLike(String value) {
            addCriterion("has_chain_price like", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceNotLike(String value) {
            addCriterion("has_chain_price not like", value, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceIn(List<String> values) {
            addCriterion("has_chain_price in", values, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceNotIn(List<String> values) {
            addCriterion("has_chain_price not in", values, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceBetween(String value1, String value2) {
            addCriterion("has_chain_price between", value1, value2, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andHasChainPriceNotBetween(String value1, String value2) {
            addCriterion("has_chain_price not between", value1, value2, "hasChainPrice");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoIsNull() {
            addCriterion("support_hong_bao is null");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoIsNotNull() {
            addCriterion("support_hong_bao is not null");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoEqualTo(String value) {
            addCriterion("support_hong_bao =", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoNotEqualTo(String value) {
            addCriterion("support_hong_bao <>", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoGreaterThan(String value) {
            addCriterion("support_hong_bao >", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoGreaterThanOrEqualTo(String value) {
            addCriterion("support_hong_bao >=", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoLessThan(String value) {
            addCriterion("support_hong_bao <", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoLessThanOrEqualTo(String value) {
            addCriterion("support_hong_bao <=", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoLike(String value) {
            addCriterion("support_hong_bao like", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoNotLike(String value) {
            addCriterion("support_hong_bao not like", value, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoIn(List<String> values) {
            addCriterion("support_hong_bao in", values, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoNotIn(List<String> values) {
            addCriterion("support_hong_bao not in", values, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoBetween(String value1, String value2) {
            addCriterion("support_hong_bao between", value1, value2, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andSupportHongBaoNotBetween(String value1, String value2) {
            addCriterion("support_hong_bao not between", value1, value2, "supportHongBao");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveIsNull() {
            addCriterion("has_exclusive is null");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveIsNotNull() {
            addCriterion("has_exclusive is not null");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveEqualTo(String value) {
            addCriterion("has_exclusive =", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveNotEqualTo(String value) {
            addCriterion("has_exclusive <>", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveGreaterThan(String value) {
            addCriterion("has_exclusive >", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveGreaterThanOrEqualTo(String value) {
            addCriterion("has_exclusive >=", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveLessThan(String value) {
            addCriterion("has_exclusive <", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveLessThanOrEqualTo(String value) {
            addCriterion("has_exclusive <=", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveLike(String value) {
            addCriterion("has_exclusive like", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveNotLike(String value) {
            addCriterion("has_exclusive not like", value, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveIn(List<String> values) {
            addCriterion("has_exclusive in", values, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveNotIn(List<String> values) {
            addCriterion("has_exclusive not in", values, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveBetween(String value1, String value2) {
            addCriterion("has_exclusive between", value1, value2, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasExclusiveNotBetween(String value1, String value2) {
            addCriterion("has_exclusive not between", value1, value2, "hasExclusive");
            return (Criteria) this;
        }

        public Criteria andHasGiftIsNull() {
            addCriterion("has_gift is null");
            return (Criteria) this;
        }

        public Criteria andHasGiftIsNotNull() {
            addCriterion("has_gift is not null");
            return (Criteria) this;
        }

        public Criteria andHasGiftEqualTo(String value) {
            addCriterion("has_gift =", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftNotEqualTo(String value) {
            addCriterion("has_gift <>", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftGreaterThan(String value) {
            addCriterion("has_gift >", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftGreaterThanOrEqualTo(String value) {
            addCriterion("has_gift >=", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftLessThan(String value) {
            addCriterion("has_gift <", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftLessThanOrEqualTo(String value) {
            addCriterion("has_gift <=", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftLike(String value) {
            addCriterion("has_gift like", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftNotLike(String value) {
            addCriterion("has_gift not like", value, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftIn(List<String> values) {
            addCriterion("has_gift in", values, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftNotIn(List<String> values) {
            addCriterion("has_gift not in", values, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftBetween(String value1, String value2) {
            addCriterion("has_gift between", value1, value2, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasGiftNotBetween(String value1, String value2) {
            addCriterion("has_gift not between", value1, value2, "hasGift");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashIsNull() {
            addCriterion("has_day7_crash is null");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashIsNotNull() {
            addCriterion("has_day7_crash is not null");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashEqualTo(String value) {
            addCriterion("has_day7_crash =", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashNotEqualTo(String value) {
            addCriterion("has_day7_crash <>", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashGreaterThan(String value) {
            addCriterion("has_day7_crash >", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashGreaterThanOrEqualTo(String value) {
            addCriterion("has_day7_crash >=", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashLessThan(String value) {
            addCriterion("has_day7_crash <", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashLessThanOrEqualTo(String value) {
            addCriterion("has_day7_crash <=", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashLike(String value) {
            addCriterion("has_day7_crash like", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashNotLike(String value) {
            addCriterion("has_day7_crash not like", value, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashIn(List<String> values) {
            addCriterion("has_day7_crash in", values, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashNotIn(List<String> values) {
            addCriterion("has_day7_crash not in", values, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashBetween(String value1, String value2) {
            addCriterion("has_day7_crash between", value1, value2, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasDay7CrashNotBetween(String value1, String value2) {
            addCriterion("has_day7_crash not between", value1, value2, "hasDay7Crash");
            return (Criteria) this;
        }

        public Criteria andHasQuickIsNull() {
            addCriterion("has_quick is null");
            return (Criteria) this;
        }

        public Criteria andHasQuickIsNotNull() {
            addCriterion("has_quick is not null");
            return (Criteria) this;
        }

        public Criteria andHasQuickEqualTo(String value) {
            addCriterion("has_quick =", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickNotEqualTo(String value) {
            addCriterion("has_quick <>", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickGreaterThan(String value) {
            addCriterion("has_quick >", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickGreaterThanOrEqualTo(String value) {
            addCriterion("has_quick >=", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickLessThan(String value) {
            addCriterion("has_quick <", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickLessThanOrEqualTo(String value) {
            addCriterion("has_quick <=", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickLike(String value) {
            addCriterion("has_quick like", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickNotLike(String value) {
            addCriterion("has_quick not like", value, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickIn(List<String> values) {
            addCriterion("has_quick in", values, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickNotIn(List<String> values) {
            addCriterion("has_quick not in", values, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickBetween(String value1, String value2) {
            addCriterion("has_quick between", value1, value2, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andHasQuickNotBetween(String value1, String value2) {
            addCriterion("has_quick not between", value1, value2, "hasQuick");
            return (Criteria) this;
        }

        public Criteria andServicePicsIsNull() {
            addCriterion("service_pics is null");
            return (Criteria) this;
        }

        public Criteria andServicePicsIsNotNull() {
            addCriterion("service_pics is not null");
            return (Criteria) this;
        }

        public Criteria andServicePicsEqualTo(String value) {
            addCriterion("service_pics =", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsNotEqualTo(String value) {
            addCriterion("service_pics <>", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsGreaterThan(String value) {
            addCriterion("service_pics >", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsGreaterThanOrEqualTo(String value) {
            addCriterion("service_pics >=", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsLessThan(String value) {
            addCriterion("service_pics <", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsLessThanOrEqualTo(String value) {
            addCriterion("service_pics <=", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsLike(String value) {
            addCriterion("service_pics like", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsNotLike(String value) {
            addCriterion("service_pics not like", value, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsIn(List<String> values) {
            addCriterion("service_pics in", values, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsNotIn(List<String> values) {
            addCriterion("service_pics not in", values, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsBetween(String value1, String value2) {
            addCriterion("service_pics between", value1, value2, "servicePics");
            return (Criteria) this;
        }

        public Criteria andServicePicsNotBetween(String value1, String value2) {
            addCriterion("service_pics not between", value1, value2, "servicePics");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuIsNull() {
            addCriterion("has_five_star_dacu is null");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuIsNotNull() {
            addCriterion("has_five_star_dacu is not null");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuEqualTo(String value) {
            addCriterion("has_five_star_dacu =", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuNotEqualTo(String value) {
            addCriterion("has_five_star_dacu <>", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuGreaterThan(String value) {
            addCriterion("has_five_star_dacu >", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuGreaterThanOrEqualTo(String value) {
            addCriterion("has_five_star_dacu >=", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuLessThan(String value) {
            addCriterion("has_five_star_dacu <", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuLessThanOrEqualTo(String value) {
            addCriterion("has_five_star_dacu <=", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuLike(String value) {
            addCriterion("has_five_star_dacu like", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuNotLike(String value) {
            addCriterion("has_five_star_dacu not like", value, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuIn(List<String> values) {
            addCriterion("has_five_star_dacu in", values, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuNotIn(List<String> values) {
            addCriterion("has_five_star_dacu not in", values, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuBetween(String value1, String value2) {
            addCriterion("has_five_star_dacu between", value1, value2, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasFiveStarDacuNotBetween(String value1, String value2) {
            addCriterion("has_five_star_dacu not between", value1, value2, "hasFiveStarDacu");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceIsNull() {
            addCriterion("has_distance_preference is null");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceIsNotNull() {
            addCriterion("has_distance_preference is not null");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceEqualTo(String value) {
            addCriterion("has_distance_preference =", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceNotEqualTo(String value) {
            addCriterion("has_distance_preference <>", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceGreaterThan(String value) {
            addCriterion("has_distance_preference >", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceGreaterThanOrEqualTo(String value) {
            addCriterion("has_distance_preference >=", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceLessThan(String value) {
            addCriterion("has_distance_preference <", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceLessThanOrEqualTo(String value) {
            addCriterion("has_distance_preference <=", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceLike(String value) {
            addCriterion("has_distance_preference like", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceNotLike(String value) {
            addCriterion("has_distance_preference not like", value, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceIn(List<String> values) {
            addCriterion("has_distance_preference in", values, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceNotIn(List<String> values) {
            addCriterion("has_distance_preference not in", values, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceBetween(String value1, String value2) {
            addCriterion("has_distance_preference between", value1, value2, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andHasDistancePreferenceNotBetween(String value1, String value2) {
            addCriterion("has_distance_preference not between", value1, value2, "hasDistancePreference");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceIsNull() {
            addCriterion("lm_lowest_price is null");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceIsNotNull() {
            addCriterion("lm_lowest_price is not null");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceEqualTo(String value) {
            addCriterion("lm_lowest_price =", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceNotEqualTo(String value) {
            addCriterion("lm_lowest_price <>", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceGreaterThan(String value) {
            addCriterion("lm_lowest_price >", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceGreaterThanOrEqualTo(String value) {
            addCriterion("lm_lowest_price >=", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceLessThan(String value) {
            addCriterion("lm_lowest_price <", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceLessThanOrEqualTo(String value) {
            addCriterion("lm_lowest_price <=", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceLike(String value) {
            addCriterion("lm_lowest_price like", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceNotLike(String value) {
            addCriterion("lm_lowest_price not like", value, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceIn(List<String> values) {
            addCriterion("lm_lowest_price in", values, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceNotIn(List<String> values) {
            addCriterion("lm_lowest_price not in", values, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceBetween(String value1, String value2) {
            addCriterion("lm_lowest_price between", value1, value2, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andLmLowestPriceNotBetween(String value1, String value2) {
            addCriterion("lm_lowest_price not between", value1, value2, "lmLowestPrice");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountIsNull() {
            addCriterion("has_five_discount is null");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountIsNotNull() {
            addCriterion("has_five_discount is not null");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountEqualTo(String value) {
            addCriterion("has_five_discount =", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountNotEqualTo(String value) {
            addCriterion("has_five_discount <>", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountGreaterThan(String value) {
            addCriterion("has_five_discount >", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountGreaterThanOrEqualTo(String value) {
            addCriterion("has_five_discount >=", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountLessThan(String value) {
            addCriterion("has_five_discount <", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountLessThanOrEqualTo(String value) {
            addCriterion("has_five_discount <=", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountLike(String value) {
            addCriterion("has_five_discount like", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountNotLike(String value) {
            addCriterion("has_five_discount not like", value, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountIn(List<String> values) {
            addCriterion("has_five_discount in", values, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountNotIn(List<String> values) {
            addCriterion("has_five_discount not in", values, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountBetween(String value1, String value2) {
            addCriterion("has_five_discount between", value1, value2, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andHasFiveDiscountNotBetween(String value1, String value2) {
            addCriterion("has_five_discount not between", value1, value2, "hasFiveDiscount");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldIsNull() {
            addCriterion("show_can_user_gold is null");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldIsNotNull() {
            addCriterion("show_can_user_gold is not null");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldEqualTo(String value) {
            addCriterion("show_can_user_gold =", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldNotEqualTo(String value) {
            addCriterion("show_can_user_gold <>", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldGreaterThan(String value) {
            addCriterion("show_can_user_gold >", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldGreaterThanOrEqualTo(String value) {
            addCriterion("show_can_user_gold >=", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldLessThan(String value) {
            addCriterion("show_can_user_gold <", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldLessThanOrEqualTo(String value) {
            addCriterion("show_can_user_gold <=", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldLike(String value) {
            addCriterion("show_can_user_gold like", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldNotLike(String value) {
            addCriterion("show_can_user_gold not like", value, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldIn(List<String> values) {
            addCriterion("show_can_user_gold in", values, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldNotIn(List<String> values) {
            addCriterion("show_can_user_gold not in", values, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldBetween(String value1, String value2) {
            addCriterion("show_can_user_gold between", value1, value2, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowCanUserGoldNotBetween(String value1, String value2) {
            addCriterion("show_can_user_gold not between", value1, value2, "showCanUserGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldIsNull() {
            addCriterion("show_reture_gold is null");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldIsNotNull() {
            addCriterion("show_reture_gold is not null");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldEqualTo(String value) {
            addCriterion("show_reture_gold =", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldNotEqualTo(String value) {
            addCriterion("show_reture_gold <>", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldGreaterThan(String value) {
            addCriterion("show_reture_gold >", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldGreaterThanOrEqualTo(String value) {
            addCriterion("show_reture_gold >=", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldLessThan(String value) {
            addCriterion("show_reture_gold <", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldLessThanOrEqualTo(String value) {
            addCriterion("show_reture_gold <=", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldLike(String value) {
            addCriterion("show_reture_gold like", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldNotLike(String value) {
            addCriterion("show_reture_gold not like", value, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldIn(List<String> values) {
            addCriterion("show_reture_gold in", values, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldNotIn(List<String> values) {
            addCriterion("show_reture_gold not in", values, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldBetween(String value1, String value2) {
            addCriterion("show_reture_gold between", value1, value2, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andShowRetureGoldNotBetween(String value1, String value2) {
            addCriterion("show_reture_gold not between", value1, value2, "showRetureGold");
            return (Criteria) this;
        }

        public Criteria andBundlingRateIsNull() {
            addCriterion("bundling_rate is null");
            return (Criteria) this;
        }

        public Criteria andBundlingRateIsNotNull() {
            addCriterion("bundling_rate is not null");
            return (Criteria) this;
        }

        public Criteria andBundlingRateEqualTo(Integer value) {
            addCriterion("bundling_rate =", value, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateNotEqualTo(Integer value) {
            addCriterion("bundling_rate <>", value, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateGreaterThan(Integer value) {
            addCriterion("bundling_rate >", value, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateGreaterThanOrEqualTo(Integer value) {
            addCriterion("bundling_rate >=", value, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateLessThan(Integer value) {
            addCriterion("bundling_rate <", value, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateLessThanOrEqualTo(Integer value) {
            addCriterion("bundling_rate <=", value, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateIn(List<Integer> values) {
            addCriterion("bundling_rate in", values, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateNotIn(List<Integer> values) {
            addCriterion("bundling_rate not in", values, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateBetween(Integer value1, Integer value2) {
            addCriterion("bundling_rate between", value1, value2, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andBundlingRateNotBetween(Integer value1, Integer value2) {
            addCriterion("bundling_rate not between", value1, value2, "bundlingRate");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceIsNull() {
            addCriterion("time_limit_price is null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceIsNotNull() {
            addCriterion("time_limit_price is not null");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceEqualTo(BigDecimal value) {
            addCriterion("time_limit_price =", value, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceNotEqualTo(BigDecimal value) {
            addCriterion("time_limit_price <>", value, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceGreaterThan(BigDecimal value) {
            addCriterion("time_limit_price >", value, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("time_limit_price >=", value, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceLessThan(BigDecimal value) {
            addCriterion("time_limit_price <", value, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("time_limit_price <=", value, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceIn(List<BigDecimal> values) {
            addCriterion("time_limit_price in", values, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceNotIn(List<BigDecimal> values) {
            addCriterion("time_limit_price not in", values, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("time_limit_price between", value1, value2, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTimeLimitPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("time_limit_price not between", value1, value2, "timeLimitPrice");
            return (Criteria) this;
        }

        public Criteria andTopListIsNull() {
            addCriterion("top_list is null");
            return (Criteria) this;
        }

        public Criteria andTopListIsNotNull() {
            addCriterion("top_list is not null");
            return (Criteria) this;
        }

        public Criteria andTopListEqualTo(Integer value) {
            addCriterion("top_list =", value, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListNotEqualTo(Integer value) {
            addCriterion("top_list <>", value, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListGreaterThan(Integer value) {
            addCriterion("top_list >", value, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListGreaterThanOrEqualTo(Integer value) {
            addCriterion("top_list >=", value, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListLessThan(Integer value) {
            addCriterion("top_list <", value, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListLessThanOrEqualTo(Integer value) {
            addCriterion("top_list <=", value, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListIn(List<Integer> values) {
            addCriterion("top_list in", values, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListNotIn(List<Integer> values) {
            addCriterion("top_list not in", values, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListBetween(Integer value1, Integer value2) {
            addCriterion("top_list between", value1, value2, "topList");
            return (Criteria) this;
        }

        public Criteria andTopListNotBetween(Integer value1, Integer value2) {
            addCriterion("top_list not between", value1, value2, "topList");
            return (Criteria) this;
        }

        public Criteria andRecommendDescIsNull() {
            addCriterion("recommend_desc is null");
            return (Criteria) this;
        }

        public Criteria andRecommendDescIsNotNull() {
            addCriterion("recommend_desc is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendDescEqualTo(String value) {
            addCriterion("recommend_desc =", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescNotEqualTo(String value) {
            addCriterion("recommend_desc <>", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescGreaterThan(String value) {
            addCriterion("recommend_desc >", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_desc >=", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescLessThan(String value) {
            addCriterion("recommend_desc <", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescLessThanOrEqualTo(String value) {
            addCriterion("recommend_desc <=", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescLike(String value) {
            addCriterion("recommend_desc like", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescNotLike(String value) {
            addCriterion("recommend_desc not like", value, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescIn(List<String> values) {
            addCriterion("recommend_desc in", values, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescNotIn(List<String> values) {
            addCriterion("recommend_desc not in", values, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescBetween(String value1, String value2) {
            addCriterion("recommend_desc between", value1, value2, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andRecommendDescNotBetween(String value1, String value2) {
            addCriterion("recommend_desc not between", value1, value2, "recommendDesc");
            return (Criteria) this;
        }

        public Criteria andHotelLabelIsNull() {
            addCriterion("hotel_label is null");
            return (Criteria) this;
        }

        public Criteria andHotelLabelIsNotNull() {
            addCriterion("hotel_label is not null");
            return (Criteria) this;
        }

        public Criteria andHotelLabelEqualTo(String value) {
            addCriterion("hotel_label =", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelNotEqualTo(String value) {
            addCriterion("hotel_label <>", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelGreaterThan(String value) {
            addCriterion("hotel_label >", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_label >=", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelLessThan(String value) {
            addCriterion("hotel_label <", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelLessThanOrEqualTo(String value) {
            addCriterion("hotel_label <=", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelLike(String value) {
            addCriterion("hotel_label like", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelNotLike(String value) {
            addCriterion("hotel_label not like", value, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelIn(List<String> values) {
            addCriterion("hotel_label in", values, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelNotIn(List<String> values) {
            addCriterion("hotel_label not in", values, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelBetween(String value1, String value2) {
            addCriterion("hotel_label between", value1, value2, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andHotelLabelNotBetween(String value1, String value2) {
            addCriterion("hotel_label not between", value1, value2, "hotelLabel");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListIsNull() {
            addCriterion("quality_label_list is null");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListIsNotNull() {
            addCriterion("quality_label_list is not null");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListEqualTo(String value) {
            addCriterion("quality_label_list =", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListNotEqualTo(String value) {
            addCriterion("quality_label_list <>", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListGreaterThan(String value) {
            addCriterion("quality_label_list >", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListGreaterThanOrEqualTo(String value) {
            addCriterion("quality_label_list >=", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListLessThan(String value) {
            addCriterion("quality_label_list <", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListLessThanOrEqualTo(String value) {
            addCriterion("quality_label_list <=", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListLike(String value) {
            addCriterion("quality_label_list like", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListNotLike(String value) {
            addCriterion("quality_label_list not like", value, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListIn(List<String> values) {
            addCriterion("quality_label_list in", values, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListNotIn(List<String> values) {
            addCriterion("quality_label_list not in", values, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListBetween(String value1, String value2) {
            addCriterion("quality_label_list between", value1, value2, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andQualityLabelListNotBetween(String value1, String value2) {
            addCriterion("quality_label_list not between", value1, value2, "qualityLabelList");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeIsNull() {
            addCriterion("pack_operate_type is null");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeIsNotNull() {
            addCriterion("pack_operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeEqualTo(Integer value) {
            addCriterion("pack_operate_type =", value, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeNotEqualTo(Integer value) {
            addCriterion("pack_operate_type <>", value, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeGreaterThan(Integer value) {
            addCriterion("pack_operate_type >", value, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("pack_operate_type >=", value, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeLessThan(Integer value) {
            addCriterion("pack_operate_type <", value, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("pack_operate_type <=", value, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeIn(List<Integer> values) {
            addCriterion("pack_operate_type in", values, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeNotIn(List<Integer> values) {
            addCriterion("pack_operate_type not in", values, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeBetween(Integer value1, Integer value2) {
            addCriterion("pack_operate_type between", value1, value2, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andPackOperateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("pack_operate_type not between", value1, value2, "packOperateType");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthIsNull() {
            addCriterion("browse_month is null");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthIsNotNull() {
            addCriterion("browse_month is not null");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthEqualTo(Integer value) {
            addCriterion("browse_month =", value, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthNotEqualTo(Integer value) {
            addCriterion("browse_month <>", value, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthGreaterThan(Integer value) {
            addCriterion("browse_month >", value, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthGreaterThanOrEqualTo(Integer value) {
            addCriterion("browse_month >=", value, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthLessThan(Integer value) {
            addCriterion("browse_month <", value, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthLessThanOrEqualTo(Integer value) {
            addCriterion("browse_month <=", value, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthIn(List<Integer> values) {
            addCriterion("browse_month in", values, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthNotIn(List<Integer> values) {
            addCriterion("browse_month not in", values, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthBetween(Integer value1, Integer value2) {
            addCriterion("browse_month between", value1, value2, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andBrowseMonthNotBetween(Integer value1, Integer value2) {
            addCriterion("browse_month not between", value1, value2, "browseMonth");
            return (Criteria) this;
        }

        public Criteria andSpecialRecIsNull() {
            addCriterion("special_rec is null");
            return (Criteria) this;
        }

        public Criteria andSpecialRecIsNotNull() {
            addCriterion("special_rec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialRecEqualTo(Integer value) {
            addCriterion("special_rec =", value, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecNotEqualTo(Integer value) {
            addCriterion("special_rec <>", value, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecGreaterThan(Integer value) {
            addCriterion("special_rec >", value, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecGreaterThanOrEqualTo(Integer value) {
            addCriterion("special_rec >=", value, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecLessThan(Integer value) {
            addCriterion("special_rec <", value, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecLessThanOrEqualTo(Integer value) {
            addCriterion("special_rec <=", value, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecIn(List<Integer> values) {
            addCriterion("special_rec in", values, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecNotIn(List<Integer> values) {
            addCriterion("special_rec not in", values, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecBetween(Integer value1, Integer value2) {
            addCriterion("special_rec between", value1, value2, "specialRec");
            return (Criteria) this;
        }

        public Criteria andSpecialRecNotBetween(Integer value1, Integer value2) {
            addCriterion("special_rec not between", value1, value2, "specialRec");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmIsNull() {
            addCriterion("hour_room_rec_lm is null");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmIsNotNull() {
            addCriterion("hour_room_rec_lm is not null");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmEqualTo(String value) {
            addCriterion("hour_room_rec_lm =", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmNotEqualTo(String value) {
            addCriterion("hour_room_rec_lm <>", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmGreaterThan(String value) {
            addCriterion("hour_room_rec_lm >", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmGreaterThanOrEqualTo(String value) {
            addCriterion("hour_room_rec_lm >=", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmLessThan(String value) {
            addCriterion("hour_room_rec_lm <", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmLessThanOrEqualTo(String value) {
            addCriterion("hour_room_rec_lm <=", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmLike(String value) {
            addCriterion("hour_room_rec_lm like", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmNotLike(String value) {
            addCriterion("hour_room_rec_lm not like", value, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmIn(List<String> values) {
            addCriterion("hour_room_rec_lm in", values, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmNotIn(List<String> values) {
            addCriterion("hour_room_rec_lm not in", values, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmBetween(String value1, String value2) {
            addCriterion("hour_room_rec_lm between", value1, value2, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andHourRoomRecLmNotBetween(String value1, String value2) {
            addCriterion("hour_room_rec_lm not between", value1, value2, "hourRoomRecLm");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNull() {
            addCriterion("city_name is null");
            return (Criteria) this;
        }

        public Criteria andCityNameIsNotNull() {
            addCriterion("city_name is not null");
            return (Criteria) this;
        }

        public Criteria andCityNameEqualTo(String value) {
            addCriterion("city_name =", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotEqualTo(String value) {
            addCriterion("city_name <>", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThan(String value) {
            addCriterion("city_name >", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameGreaterThanOrEqualTo(String value) {
            addCriterion("city_name >=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThan(String value) {
            addCriterion("city_name <", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLessThanOrEqualTo(String value) {
            addCriterion("city_name <=", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameLike(String value) {
            addCriterion("city_name like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotLike(String value) {
            addCriterion("city_name not like", value, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameIn(List<String> values) {
            addCriterion("city_name in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotIn(List<String> values) {
            addCriterion("city_name not in", values, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameBetween(String value1, String value2) {
            addCriterion("city_name between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andCityNameNotBetween(String value1, String value2) {
            addCriterion("city_name not between", value1, value2, "cityName");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltIsNull() {
            addCriterion("when_built is null");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltIsNotNull() {
            addCriterion("when_built is not null");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltEqualTo(String value) {
            addCriterion("when_built =", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltNotEqualTo(String value) {
            addCriterion("when_built <>", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltGreaterThan(String value) {
            addCriterion("when_built >", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltGreaterThanOrEqualTo(String value) {
            addCriterion("when_built >=", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltLessThan(String value) {
            addCriterion("when_built <", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltLessThanOrEqualTo(String value) {
            addCriterion("when_built <=", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltLike(String value) {
            addCriterion("when_built like", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltNotLike(String value) {
            addCriterion("when_built not like", value, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltIn(List<String> values) {
            addCriterion("when_built in", values, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltNotIn(List<String> values) {
            addCriterion("when_built not in", values, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltBetween(String value1, String value2) {
            addCriterion("when_built between", value1, value2, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andWhenBuiltNotBetween(String value1, String value2) {
            addCriterion("when_built not between", value1, value2, "whenBuilt");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIsNull() {
            addCriterion("comment_score is null");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIsNotNull() {
            addCriterion("comment_score is not null");
            return (Criteria) this;
        }

        public Criteria andCommentScoreEqualTo(BigDecimal value) {
            addCriterion("comment_score =", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotEqualTo(BigDecimal value) {
            addCriterion("comment_score <>", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreGreaterThan(BigDecimal value) {
            addCriterion("comment_score >", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("comment_score >=", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreLessThan(BigDecimal value) {
            addCriterion("comment_score <", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("comment_score <=", value, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreIn(List<BigDecimal> values) {
            addCriterion("comment_score in", values, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotIn(List<BigDecimal> values) {
            addCriterion("comment_score not in", values, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comment_score between", value1, value2, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("comment_score not between", value1, value2, "commentScore");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andHotelAreaIsNull() {
            addCriterion("hotel_area is null");
            return (Criteria) this;
        }

        public Criteria andHotelAreaIsNotNull() {
            addCriterion("hotel_area is not null");
            return (Criteria) this;
        }

        public Criteria andHotelAreaEqualTo(String value) {
            addCriterion("hotel_area =", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaNotEqualTo(String value) {
            addCriterion("hotel_area <>", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaGreaterThan(String value) {
            addCriterion("hotel_area >", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_area >=", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaLessThan(String value) {
            addCriterion("hotel_area <", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaLessThanOrEqualTo(String value) {
            addCriterion("hotel_area <=", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaLike(String value) {
            addCriterion("hotel_area like", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaNotLike(String value) {
            addCriterion("hotel_area not like", value, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaIn(List<String> values) {
            addCriterion("hotel_area in", values, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaNotIn(List<String> values) {
            addCriterion("hotel_area not in", values, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaBetween(String value1, String value2) {
            addCriterion("hotel_area between", value1, value2, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andHotelAreaNotBetween(String value1, String value2) {
            addCriterion("hotel_area not between", value1, value2, "hotelArea");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoIsNull() {
            addCriterion("policy_info is null");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoIsNotNull() {
            addCriterion("policy_info is not null");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoEqualTo(String value) {
            addCriterion("policy_info =", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoNotEqualTo(String value) {
            addCriterion("policy_info <>", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoGreaterThan(String value) {
            addCriterion("policy_info >", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoGreaterThanOrEqualTo(String value) {
            addCriterion("policy_info >=", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoLessThan(String value) {
            addCriterion("policy_info <", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoLessThanOrEqualTo(String value) {
            addCriterion("policy_info <=", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoLike(String value) {
            addCriterion("policy_info like", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoNotLike(String value) {
            addCriterion("policy_info not like", value, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoIn(List<String> values) {
            addCriterion("policy_info in", values, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoNotIn(List<String> values) {
            addCriterion("policy_info not in", values, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoBetween(String value1, String value2) {
            addCriterion("policy_info between", value1, value2, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andPolicyInfoNotBetween(String value1, String value2) {
            addCriterion("policy_info not between", value1, value2, "policyInfo");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceIsNull() {
            addCriterion("mini_retail_price is null");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceIsNotNull() {
            addCriterion("mini_retail_price is not null");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceEqualTo(BigDecimal value) {
            addCriterion("mini_retail_price =", value, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceNotEqualTo(BigDecimal value) {
            addCriterion("mini_retail_price <>", value, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceGreaterThan(BigDecimal value) {
            addCriterion("mini_retail_price >", value, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mini_retail_price >=", value, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceLessThan(BigDecimal value) {
            addCriterion("mini_retail_price <", value, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mini_retail_price <=", value, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceIn(List<BigDecimal> values) {
            addCriterion("mini_retail_price in", values, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceNotIn(List<BigDecimal> values) {
            addCriterion("mini_retail_price not in", values, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mini_retail_price between", value1, value2, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andMiniRetailPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mini_retail_price not between", value1, value2, "miniRetailPrice");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessIsNull() {
            addCriterion("has_internet_access is null");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessIsNotNull() {
            addCriterion("has_internet_access is not null");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessEqualTo(String value) {
            addCriterion("has_internet_access =", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessNotEqualTo(String value) {
            addCriterion("has_internet_access <>", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessGreaterThan(String value) {
            addCriterion("has_internet_access >", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessGreaterThanOrEqualTo(String value) {
            addCriterion("has_internet_access >=", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessLessThan(String value) {
            addCriterion("has_internet_access <", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessLessThanOrEqualTo(String value) {
            addCriterion("has_internet_access <=", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessLike(String value) {
            addCriterion("has_internet_access like", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessNotLike(String value) {
            addCriterion("has_internet_access not like", value, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessIn(List<String> values) {
            addCriterion("has_internet_access in", values, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessNotIn(List<String> values) {
            addCriterion("has_internet_access not in", values, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessBetween(String value1, String value2) {
            addCriterion("has_internet_access between", value1, value2, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andHasInternetAccessNotBetween(String value1, String value2) {
            addCriterion("has_internet_access not between", value1, value2, "hasInternetAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessIsNull() {
            addCriterion("wifi_access is null");
            return (Criteria) this;
        }

        public Criteria andWifiAccessIsNotNull() {
            addCriterion("wifi_access is not null");
            return (Criteria) this;
        }

        public Criteria andWifiAccessEqualTo(String value) {
            addCriterion("wifi_access =", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessNotEqualTo(String value) {
            addCriterion("wifi_access <>", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessGreaterThan(String value) {
            addCriterion("wifi_access >", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessGreaterThanOrEqualTo(String value) {
            addCriterion("wifi_access >=", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessLessThan(String value) {
            addCriterion("wifi_access <", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessLessThanOrEqualTo(String value) {
            addCriterion("wifi_access <=", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessLike(String value) {
            addCriterion("wifi_access like", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessNotLike(String value) {
            addCriterion("wifi_access not like", value, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessIn(List<String> values) {
            addCriterion("wifi_access in", values, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessNotIn(List<String> values) {
            addCriterion("wifi_access not in", values, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessBetween(String value1, String value2) {
            addCriterion("wifi_access between", value1, value2, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andWifiAccessNotBetween(String value1, String value2) {
            addCriterion("wifi_access not between", value1, value2, "wifiAccess");
            return (Criteria) this;
        }

        public Criteria andTradingAreaIsNull() {
            addCriterion("trading_area is null");
            return (Criteria) this;
        }

        public Criteria andTradingAreaIsNotNull() {
            addCriterion("trading_area is not null");
            return (Criteria) this;
        }

        public Criteria andTradingAreaEqualTo(String value) {
            addCriterion("trading_area =", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaNotEqualTo(String value) {
            addCriterion("trading_area <>", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaGreaterThan(String value) {
            addCriterion("trading_area >", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaGreaterThanOrEqualTo(String value) {
            addCriterion("trading_area >=", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaLessThan(String value) {
            addCriterion("trading_area <", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaLessThanOrEqualTo(String value) {
            addCriterion("trading_area <=", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaLike(String value) {
            addCriterion("trading_area like", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaNotLike(String value) {
            addCriterion("trading_area not like", value, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaIn(List<String> values) {
            addCriterion("trading_area in", values, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaNotIn(List<String> values) {
            addCriterion("trading_area not in", values, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaBetween(String value1, String value2) {
            addCriterion("trading_area between", value1, value2, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andTradingAreaNotBetween(String value1, String value2) {
            addCriterion("trading_area not between", value1, value2, "tradingArea");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(String value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(String value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(String value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(String value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(String value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(String value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLike(String value) {
            addCriterion("image_id like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotLike(String value) {
            addCriterion("image_id not like", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<String> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<String> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(String value1, String value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(String value1, String value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentIsNull() {
            addCriterion("when_fitment is null");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentIsNotNull() {
            addCriterion("when_fitment is not null");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentEqualTo(String value) {
            addCriterion("when_fitment =", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentNotEqualTo(String value) {
            addCriterion("when_fitment <>", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentGreaterThan(String value) {
            addCriterion("when_fitment >", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentGreaterThanOrEqualTo(String value) {
            addCriterion("when_fitment >=", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentLessThan(String value) {
            addCriterion("when_fitment <", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentLessThanOrEqualTo(String value) {
            addCriterion("when_fitment <=", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentLike(String value) {
            addCriterion("when_fitment like", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentNotLike(String value) {
            addCriterion("when_fitment not like", value, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentIn(List<String> values) {
            addCriterion("when_fitment in", values, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentNotIn(List<String> values) {
            addCriterion("when_fitment not in", values, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentBetween(String value1, String value2) {
            addCriterion("when_fitment between", value1, value2, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andWhenFitmentNotBetween(String value1, String value2) {
            addCriterion("when_fitment not between", value1, value2, "whenFitment");
            return (Criteria) this;
        }

        public Criteria andNearAddressIsNull() {
            addCriterion("near_address is null");
            return (Criteria) this;
        }

        public Criteria andNearAddressIsNotNull() {
            addCriterion("near_address is not null");
            return (Criteria) this;
        }

        public Criteria andNearAddressEqualTo(String value) {
            addCriterion("near_address =", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressNotEqualTo(String value) {
            addCriterion("near_address <>", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressGreaterThan(String value) {
            addCriterion("near_address >", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressGreaterThanOrEqualTo(String value) {
            addCriterion("near_address >=", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressLessThan(String value) {
            addCriterion("near_address <", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressLessThanOrEqualTo(String value) {
            addCriterion("near_address <=", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressLike(String value) {
            addCriterion("near_address like", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressNotLike(String value) {
            addCriterion("near_address not like", value, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressIn(List<String> values) {
            addCriterion("near_address in", values, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressNotIn(List<String> values) {
            addCriterion("near_address not in", values, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressBetween(String value1, String value2) {
            addCriterion("near_address between", value1, value2, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andNearAddressNotBetween(String value1, String value2) {
            addCriterion("near_address not between", value1, value2, "nearAddress");
            return (Criteria) this;
        }

        public Criteria andIsLpIsNull() {
            addCriterion("is_lp is null");
            return (Criteria) this;
        }

        public Criteria andIsLpIsNotNull() {
            addCriterion("is_lp is not null");
            return (Criteria) this;
        }

        public Criteria andIsLpEqualTo(String value) {
            addCriterion("is_lp =", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpNotEqualTo(String value) {
            addCriterion("is_lp <>", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpGreaterThan(String value) {
            addCriterion("is_lp >", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpGreaterThanOrEqualTo(String value) {
            addCriterion("is_lp >=", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpLessThan(String value) {
            addCriterion("is_lp <", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpLessThanOrEqualTo(String value) {
            addCriterion("is_lp <=", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpLike(String value) {
            addCriterion("is_lp like", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpNotLike(String value) {
            addCriterion("is_lp not like", value, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpIn(List<String> values) {
            addCriterion("is_lp in", values, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpNotIn(List<String> values) {
            addCriterion("is_lp not in", values, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpBetween(String value1, String value2) {
            addCriterion("is_lp between", value1, value2, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsLpNotBetween(String value1, String value2) {
            addCriterion("is_lp not between", value1, value2, "isLp");
            return (Criteria) this;
        }

        public Criteria andIsTop500IsNull() {
            addCriterion("is_top500 is null");
            return (Criteria) this;
        }

        public Criteria andIsTop500IsNotNull() {
            addCriterion("is_top500 is not null");
            return (Criteria) this;
        }

        public Criteria andIsTop500EqualTo(String value) {
            addCriterion("is_top500 =", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500NotEqualTo(String value) {
            addCriterion("is_top500 <>", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500GreaterThan(String value) {
            addCriterion("is_top500 >", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500GreaterThanOrEqualTo(String value) {
            addCriterion("is_top500 >=", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500LessThan(String value) {
            addCriterion("is_top500 <", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500LessThanOrEqualTo(String value) {
            addCriterion("is_top500 <=", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500Like(String value) {
            addCriterion("is_top500 like", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500NotLike(String value) {
            addCriterion("is_top500 not like", value, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500In(List<String> values) {
            addCriterion("is_top500 in", values, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500NotIn(List<String> values) {
            addCriterion("is_top500 not in", values, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500Between(String value1, String value2) {
            addCriterion("is_top500 between", value1, value2, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsTop500NotBetween(String value1, String value2) {
            addCriterion("is_top500 not between", value1, value2, "isTop500");
            return (Criteria) this;
        }

        public Criteria andIsCwtIsNull() {
            addCriterion("is_cwt is null");
            return (Criteria) this;
        }

        public Criteria andIsCwtIsNotNull() {
            addCriterion("is_cwt is not null");
            return (Criteria) this;
        }

        public Criteria andIsCwtEqualTo(String value) {
            addCriterion("is_cwt =", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtNotEqualTo(String value) {
            addCriterion("is_cwt <>", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtGreaterThan(String value) {
            addCriterion("is_cwt >", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtGreaterThanOrEqualTo(String value) {
            addCriterion("is_cwt >=", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtLessThan(String value) {
            addCriterion("is_cwt <", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtLessThanOrEqualTo(String value) {
            addCriterion("is_cwt <=", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtLike(String value) {
            addCriterion("is_cwt like", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtNotLike(String value) {
            addCriterion("is_cwt not like", value, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtIn(List<String> values) {
            addCriterion("is_cwt in", values, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtNotIn(List<String> values) {
            addCriterion("is_cwt not in", values, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtBetween(String value1, String value2) {
            addCriterion("is_cwt between", value1, value2, "isCwt");
            return (Criteria) this;
        }

        public Criteria andIsCwtNotBetween(String value1, String value2) {
            addCriterion("is_cwt not between", value1, value2, "isCwt");
            return (Criteria) this;
        }

        public Criteria andThemeIsNull() {
            addCriterion("theme is null");
            return (Criteria) this;
        }

        public Criteria andThemeIsNotNull() {
            addCriterion("theme is not null");
            return (Criteria) this;
        }

        public Criteria andThemeEqualTo(String value) {
            addCriterion("theme =", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotEqualTo(String value) {
            addCriterion("theme <>", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThan(String value) {
            addCriterion("theme >", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeGreaterThanOrEqualTo(String value) {
            addCriterion("theme >=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThan(String value) {
            addCriterion("theme <", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLessThanOrEqualTo(String value) {
            addCriterion("theme <=", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeLike(String value) {
            addCriterion("theme like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotLike(String value) {
            addCriterion("theme not like", value, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeIn(List<String> values) {
            addCriterion("theme in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotIn(List<String> values) {
            addCriterion("theme not in", values, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeBetween(String value1, String value2) {
            addCriterion("theme between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andThemeNotBetween(String value1, String value2) {
            addCriterion("theme not between", value1, value2, "theme");
            return (Criteria) this;
        }

        public Criteria andHotelStarsIsNull() {
            addCriterion("hotel_stars is null");
            return (Criteria) this;
        }

        public Criteria andHotelStarsIsNotNull() {
            addCriterion("hotel_stars is not null");
            return (Criteria) this;
        }

        public Criteria andHotelStarsEqualTo(BigDecimal value) {
            addCriterion("hotel_stars =", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsNotEqualTo(BigDecimal value) {
            addCriterion("hotel_stars <>", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsGreaterThan(BigDecimal value) {
            addCriterion("hotel_stars >", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("hotel_stars >=", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsLessThan(BigDecimal value) {
            addCriterion("hotel_stars <", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsLessThanOrEqualTo(BigDecimal value) {
            addCriterion("hotel_stars <=", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsIn(List<BigDecimal> values) {
            addCriterion("hotel_stars in", values, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsNotIn(List<BigDecimal> values) {
            addCriterion("hotel_stars not in", values, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hotel_stars between", value1, value2, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("hotel_stars not between", value1, value2, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeIsNull() {
            addCriterion("is_web_free is null");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeIsNotNull() {
            addCriterion("is_web_free is not null");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeEqualTo(String value) {
            addCriterion("is_web_free =", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeNotEqualTo(String value) {
            addCriterion("is_web_free <>", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeGreaterThan(String value) {
            addCriterion("is_web_free >", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeGreaterThanOrEqualTo(String value) {
            addCriterion("is_web_free >=", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeLessThan(String value) {
            addCriterion("is_web_free <", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeLessThanOrEqualTo(String value) {
            addCriterion("is_web_free <=", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeLike(String value) {
            addCriterion("is_web_free like", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeNotLike(String value) {
            addCriterion("is_web_free not like", value, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeIn(List<String> values) {
            addCriterion("is_web_free in", values, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeNotIn(List<String> values) {
            addCriterion("is_web_free not in", values, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeBetween(String value1, String value2) {
            addCriterion("is_web_free between", value1, value2, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andIsWebFreeNotBetween(String value1, String value2) {
            addCriterion("is_web_free not between", value1, value2, "isWebFree");
            return (Criteria) this;
        }

        public Criteria andDangciIsNull() {
            addCriterion("dangci is null");
            return (Criteria) this;
        }

        public Criteria andDangciIsNotNull() {
            addCriterion("dangci is not null");
            return (Criteria) this;
        }

        public Criteria andDangciEqualTo(Integer value) {
            addCriterion("dangci =", value, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciNotEqualTo(Integer value) {
            addCriterion("dangci <>", value, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciGreaterThan(Integer value) {
            addCriterion("dangci >", value, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciGreaterThanOrEqualTo(Integer value) {
            addCriterion("dangci >=", value, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciLessThan(Integer value) {
            addCriterion("dangci <", value, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciLessThanOrEqualTo(Integer value) {
            addCriterion("dangci <=", value, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciIn(List<Integer> values) {
            addCriterion("dangci in", values, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciNotIn(List<Integer> values) {
            addCriterion("dangci not in", values, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciBetween(Integer value1, Integer value2) {
            addCriterion("dangci between", value1, value2, "dangci");
            return (Criteria) this;
        }

        public Criteria andDangciNotBetween(Integer value1, Integer value2) {
            addCriterion("dangci not between", value1, value2, "dangci");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomIsNull() {
            addCriterion("has_wifiIn_room is null");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomIsNotNull() {
            addCriterion("has_wifiIn_room is not null");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomEqualTo(Integer value) {
            addCriterion("has_wifiIn_room =", value, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomNotEqualTo(Integer value) {
            addCriterion("has_wifiIn_room <>", value, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomGreaterThan(Integer value) {
            addCriterion("has_wifiIn_room >", value, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomGreaterThanOrEqualTo(Integer value) {
            addCriterion("has_wifiIn_room >=", value, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomLessThan(Integer value) {
            addCriterion("has_wifiIn_room <", value, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomLessThanOrEqualTo(Integer value) {
            addCriterion("has_wifiIn_room <=", value, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomIn(List<Integer> values) {
            addCriterion("has_wifiIn_room in", values, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomNotIn(List<Integer> values) {
            addCriterion("has_wifiIn_room not in", values, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomBetween(Integer value1, Integer value2) {
            addCriterion("has_wifiIn_room between", value1, value2, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasWifiinRoomNotBetween(Integer value1, Integer value2) {
            addCriterion("has_wifiIn_room not between", value1, value2, "hasWifiinRoom");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2IsNull() {
            addCriterion("has_parking_area2 is null");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2IsNotNull() {
            addCriterion("has_parking_area2 is not null");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2EqualTo(Integer value) {
            addCriterion("has_parking_area2 =", value, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2NotEqualTo(Integer value) {
            addCriterion("has_parking_area2 <>", value, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2GreaterThan(Integer value) {
            addCriterion("has_parking_area2 >", value, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2GreaterThanOrEqualTo(Integer value) {
            addCriterion("has_parking_area2 >=", value, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2LessThan(Integer value) {
            addCriterion("has_parking_area2 <", value, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2LessThanOrEqualTo(Integer value) {
            addCriterion("has_parking_area2 <=", value, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2In(List<Integer> values) {
            addCriterion("has_parking_area2 in", values, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2NotIn(List<Integer> values) {
            addCriterion("has_parking_area2 not in", values, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2Between(Integer value1, Integer value2) {
            addCriterion("has_parking_area2 between", value1, value2, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHasParkingArea2NotBetween(Integer value1, Integer value2) {
            addCriterion("has_parking_area2 not between", value1, value2, "hasParkingArea2");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNull() {
            addCriterion("hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andHotelNameIsNotNull() {
            addCriterion("hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andHotelNameEqualTo(String value) {
            addCriterion("hotel_name =", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotEqualTo(String value) {
            addCriterion("hotel_name <>", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThan(String value) {
            addCriterion("hotel_name >", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_name >=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThan(String value) {
            addCriterion("hotel_name <", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLessThanOrEqualTo(String value) {
            addCriterion("hotel_name <=", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameLike(String value) {
            addCriterion("hotel_name like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotLike(String value) {
            addCriterion("hotel_name not like", value, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameIn(List<String> values) {
            addCriterion("hotel_name in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotIn(List<String> values) {
            addCriterion("hotel_name not in", values, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameBetween(String value1, String value2) {
            addCriterion("hotel_name between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelNameNotBetween(String value1, String value2) {
            addCriterion("hotel_name not between", value1, value2, "hotelName");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIsNull() {
            addCriterion("hotel_address is null");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIsNotNull() {
            addCriterion("hotel_address is not null");
            return (Criteria) this;
        }

        public Criteria andHotelAddressEqualTo(String value) {
            addCriterion("hotel_address =", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotEqualTo(String value) {
            addCriterion("hotel_address <>", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressGreaterThan(String value) {
            addCriterion("hotel_address >", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_address >=", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLessThan(String value) {
            addCriterion("hotel_address <", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLessThanOrEqualTo(String value) {
            addCriterion("hotel_address <=", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressLike(String value) {
            addCriterion("hotel_address like", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotLike(String value) {
            addCriterion("hotel_address not like", value, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressIn(List<String> values) {
            addCriterion("hotel_address in", values, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotIn(List<String> values) {
            addCriterion("hotel_address not in", values, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressBetween(String value1, String value2) {
            addCriterion("hotel_address between", value1, value2, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andHotelAddressNotBetween(String value1, String value2) {
            addCriterion("hotel_address not between", value1, value2, "hotelAddress");
            return (Criteria) this;
        }

        public Criteria andGpointIsNull() {
            addCriterion("gpoint is null");
            return (Criteria) this;
        }

        public Criteria andGpointIsNotNull() {
            addCriterion("gpoint is not null");
            return (Criteria) this;
        }

        public Criteria andGpointEqualTo(String value) {
            addCriterion("gpoint =", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointNotEqualTo(String value) {
            addCriterion("gpoint <>", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointGreaterThan(String value) {
            addCriterion("gpoint >", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointGreaterThanOrEqualTo(String value) {
            addCriterion("gpoint >=", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointLessThan(String value) {
            addCriterion("gpoint <", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointLessThanOrEqualTo(String value) {
            addCriterion("gpoint <=", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointLike(String value) {
            addCriterion("gpoint like", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointNotLike(String value) {
            addCriterion("gpoint not like", value, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointIn(List<String> values) {
            addCriterion("gpoint in", values, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointNotIn(List<String> values) {
            addCriterion("gpoint not in", values, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointBetween(String value1, String value2) {
            addCriterion("gpoint between", value1, value2, "gpoint");
            return (Criteria) this;
        }

        public Criteria andGpointNotBetween(String value1, String value2) {
            addCriterion("gpoint not between", value1, value2, "gpoint");
            return (Criteria) this;
        }

        public Criteria andRankInfoIsNull() {
            addCriterion("rank_info is null");
            return (Criteria) this;
        }

        public Criteria andRankInfoIsNotNull() {
            addCriterion("rank_info is not null");
            return (Criteria) this;
        }

        public Criteria andRankInfoEqualTo(String value) {
            addCriterion("rank_info =", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotEqualTo(String value) {
            addCriterion("rank_info <>", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoGreaterThan(String value) {
            addCriterion("rank_info >", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoGreaterThanOrEqualTo(String value) {
            addCriterion("rank_info >=", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoLessThan(String value) {
            addCriterion("rank_info <", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoLessThanOrEqualTo(String value) {
            addCriterion("rank_info <=", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoLike(String value) {
            addCriterion("rank_info like", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotLike(String value) {
            addCriterion("rank_info not like", value, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoIn(List<String> values) {
            addCriterion("rank_info in", values, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotIn(List<String> values) {
            addCriterion("rank_info not in", values, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoBetween(String value1, String value2) {
            addCriterion("rank_info between", value1, value2, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andRankInfoNotBetween(String value1, String value2) {
            addCriterion("rank_info not between", value1, value2, "rankInfo");
            return (Criteria) this;
        }

        public Criteria andLogicBitIsNull() {
            addCriterion("logic_bit is null");
            return (Criteria) this;
        }

        public Criteria andLogicBitIsNotNull() {
            addCriterion("logic_bit is not null");
            return (Criteria) this;
        }

        public Criteria andLogicBitEqualTo(String value) {
            addCriterion("logic_bit =", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitNotEqualTo(String value) {
            addCriterion("logic_bit <>", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitGreaterThan(String value) {
            addCriterion("logic_bit >", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitGreaterThanOrEqualTo(String value) {
            addCriterion("logic_bit >=", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitLessThan(String value) {
            addCriterion("logic_bit <", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitLessThanOrEqualTo(String value) {
            addCriterion("logic_bit <=", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitLike(String value) {
            addCriterion("logic_bit like", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitNotLike(String value) {
            addCriterion("logic_bit not like", value, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitIn(List<String> values) {
            addCriterion("logic_bit in", values, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitNotIn(List<String> values) {
            addCriterion("logic_bit not in", values, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitBetween(String value1, String value2) {
            addCriterion("logic_bit between", value1, value2, "logicBit");
            return (Criteria) this;
        }

        public Criteria andLogicBitNotBetween(String value1, String value2) {
            addCriterion("logic_bit not between", value1, value2, "logicBit");
            return (Criteria) this;
        }

        public Criteria andMobilePriceIsNull() {
            addCriterion("mobile_price is null");
            return (Criteria) this;
        }

        public Criteria andMobilePriceIsNotNull() {
            addCriterion("mobile_price is not null");
            return (Criteria) this;
        }

        public Criteria andMobilePriceEqualTo(BigDecimal value) {
            addCriterion("mobile_price =", value, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceNotEqualTo(BigDecimal value) {
            addCriterion("mobile_price <>", value, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceGreaterThan(BigDecimal value) {
            addCriterion("mobile_price >", value, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mobile_price >=", value, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceLessThan(BigDecimal value) {
            addCriterion("mobile_price <", value, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mobile_price <=", value, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceIn(List<BigDecimal> values) {
            addCriterion("mobile_price in", values, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceNotIn(List<BigDecimal> values) {
            addCriterion("mobile_price not in", values, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mobile_price between", value1, value2, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobilePriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mobile_price not between", value1, value2, "mobilePrice");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusIsNull() {
            addCriterion("mobile_room_status is null");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusIsNotNull() {
            addCriterion("mobile_room_status is not null");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusEqualTo(Integer value) {
            addCriterion("mobile_room_status =", value, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusNotEqualTo(Integer value) {
            addCriterion("mobile_room_status <>", value, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusGreaterThan(Integer value) {
            addCriterion("mobile_room_status >", value, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("mobile_room_status >=", value, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusLessThan(Integer value) {
            addCriterion("mobile_room_status <", value, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusLessThanOrEqualTo(Integer value) {
            addCriterion("mobile_room_status <=", value, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusIn(List<Integer> values) {
            addCriterion("mobile_room_status in", values, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusNotIn(List<Integer> values) {
            addCriterion("mobile_room_status not in", values, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusBetween(Integer value1, Integer value2) {
            addCriterion("mobile_room_status between", value1, value2, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andMobileRoomStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("mobile_room_status not between", value1, value2, "mobileRoomStatus");
            return (Criteria) this;
        }

        public Criteria andActivityIsNull() {
            addCriterion("activity is null");
            return (Criteria) this;
        }

        public Criteria andActivityIsNotNull() {
            addCriterion("activity is not null");
            return (Criteria) this;
        }

        public Criteria andActivityEqualTo(String value) {
            addCriterion("activity =", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotEqualTo(String value) {
            addCriterion("activity <>", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThan(String value) {
            addCriterion("activity >", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityGreaterThanOrEqualTo(String value) {
            addCriterion("activity >=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThan(String value) {
            addCriterion("activity <", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLessThanOrEqualTo(String value) {
            addCriterion("activity <=", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityLike(String value) {
            addCriterion("activity like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotLike(String value) {
            addCriterion("activity not like", value, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityIn(List<String> values) {
            addCriterion("activity in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotIn(List<String> values) {
            addCriterion("activity not in", values, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityBetween(String value1, String value2) {
            addCriterion("activity between", value1, value2, "activity");
            return (Criteria) this;
        }

        public Criteria andActivityNotBetween(String value1, String value2) {
            addCriterion("activity not between", value1, value2, "activity");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(BigDecimal value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(BigDecimal value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(BigDecimal value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(BigDecimal value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<BigDecimal> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<BigDecimal> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNull() {
            addCriterion("discount is null");
            return (Criteria) this;
        }

        public Criteria andDiscountIsNotNull() {
            addCriterion("discount is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountEqualTo(BigDecimal value) {
            addCriterion("discount =", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotEqualTo(BigDecimal value) {
            addCriterion("discount <>", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThan(BigDecimal value) {
            addCriterion("discount >", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount >=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThan(BigDecimal value) {
            addCriterion("discount <", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount <=", value, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountIn(List<BigDecimal> values) {
            addCriterion("discount in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotIn(List<BigDecimal> values) {
            addCriterion("discount not in", values, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andDiscountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount not between", value1, value2, "discount");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNull() {
            addCriterion("tag_name is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("tag_name =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("tag_name <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("tag_name >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_name >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("tag_name <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("tag_name <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("tag_name like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("tag_name not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("tag_name in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("tag_name not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("tag_name between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("tag_name not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andBpointIsNull() {
            addCriterion("bpoint is null");
            return (Criteria) this;
        }

        public Criteria andBpointIsNotNull() {
            addCriterion("bpoint is not null");
            return (Criteria) this;
        }

        public Criteria andBpointEqualTo(String value) {
            addCriterion("bpoint =", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointNotEqualTo(String value) {
            addCriterion("bpoint <>", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointGreaterThan(String value) {
            addCriterion("bpoint >", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointGreaterThanOrEqualTo(String value) {
            addCriterion("bpoint >=", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointLessThan(String value) {
            addCriterion("bpoint <", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointLessThanOrEqualTo(String value) {
            addCriterion("bpoint <=", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointLike(String value) {
            addCriterion("bpoint like", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointNotLike(String value) {
            addCriterion("bpoint not like", value, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointIn(List<String> values) {
            addCriterion("bpoint in", values, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointNotIn(List<String> values) {
            addCriterion("bpoint not in", values, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointBetween(String value1, String value2) {
            addCriterion("bpoint between", value1, value2, "bpoint");
            return (Criteria) this;
        }

        public Criteria andBpointNotBetween(String value1, String value2) {
            addCriterion("bpoint not between", value1, value2, "bpoint");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNull() {
            addCriterion("phone_number is null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIsNotNull() {
            addCriterion("phone_number is not null");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberEqualTo(String value) {
            addCriterion("phone_number =", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotEqualTo(String value) {
            addCriterion("phone_number <>", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThan(String value) {
            addCriterion("phone_number >", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberGreaterThanOrEqualTo(String value) {
            addCriterion("phone_number >=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThan(String value) {
            addCriterion("phone_number <", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLessThanOrEqualTo(String value) {
            addCriterion("phone_number <=", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberLike(String value) {
            addCriterion("phone_number like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotLike(String value) {
            addCriterion("phone_number not like", value, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberIn(List<String> values) {
            addCriterion("phone_number in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotIn(List<String> values) {
            addCriterion("phone_number not in", values, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberBetween(String value1, String value2) {
            addCriterion("phone_number between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andPhoneNumberNotBetween(String value1, String value2) {
            addCriterion("phone_number not between", value1, value2, "phoneNumber");
            return (Criteria) this;
        }

        public Criteria andHotelBrandIsNull() {
            addCriterion("hotel_brand is null");
            return (Criteria) this;
        }

        public Criteria andHotelBrandIsNotNull() {
            addCriterion("hotel_brand is not null");
            return (Criteria) this;
        }

        public Criteria andHotelBrandEqualTo(String value) {
            addCriterion("hotel_brand =", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandNotEqualTo(String value) {
            addCriterion("hotel_brand <>", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandGreaterThan(String value) {
            addCriterion("hotel_brand >", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_brand >=", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandLessThan(String value) {
            addCriterion("hotel_brand <", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandLessThanOrEqualTo(String value) {
            addCriterion("hotel_brand <=", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandLike(String value) {
            addCriterion("hotel_brand like", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandNotLike(String value) {
            addCriterion("hotel_brand not like", value, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandIn(List<String> values) {
            addCriterion("hotel_brand in", values, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandNotIn(List<String> values) {
            addCriterion("hotel_brand not in", values, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandBetween(String value1, String value2) {
            addCriterion("hotel_brand between", value1, value2, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andHotelBrandNotBetween(String value1, String value2) {
            addCriterion("hotel_brand not between", value1, value2, "hotelBrand");
            return (Criteria) this;
        }

        public Criteria andOneSentenceIsNull() {
            addCriterion("one_sentence is null");
            return (Criteria) this;
        }

        public Criteria andOneSentenceIsNotNull() {
            addCriterion("one_sentence is not null");
            return (Criteria) this;
        }

        public Criteria andOneSentenceEqualTo(String value) {
            addCriterion("one_sentence =", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceNotEqualTo(String value) {
            addCriterion("one_sentence <>", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceGreaterThan(String value) {
            addCriterion("one_sentence >", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceGreaterThanOrEqualTo(String value) {
            addCriterion("one_sentence >=", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceLessThan(String value) {
            addCriterion("one_sentence <", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceLessThanOrEqualTo(String value) {
            addCriterion("one_sentence <=", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceLike(String value) {
            addCriterion("one_sentence like", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceNotLike(String value) {
            addCriterion("one_sentence not like", value, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceIn(List<String> values) {
            addCriterion("one_sentence in", values, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceNotIn(List<String> values) {
            addCriterion("one_sentence not in", values, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceBetween(String value1, String value2) {
            addCriterion("one_sentence between", value1, value2, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andOneSentenceNotBetween(String value1, String value2) {
            addCriterion("one_sentence not between", value1, value2, "oneSentence");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("short_name is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("short_name is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("short_name =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("short_name <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("short_name >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("short_name >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("short_name <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("short_name <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("short_name like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("short_name not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("short_name in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("short_name not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("short_name between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("short_name not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}