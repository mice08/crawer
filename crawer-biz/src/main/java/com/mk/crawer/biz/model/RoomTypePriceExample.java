package com.mk.crawer.biz.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomTypePriceExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomTypePriceExample() {
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

        public Criteria andRoomTypeIdIsNull() {
            addCriterion("room_type_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIsNotNull() {
            addCriterion("room_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdEqualTo(Long value) {
            addCriterion("room_type_id =", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotEqualTo(Long value) {
            addCriterion("room_type_id <>", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdGreaterThan(Long value) {
            addCriterion("room_type_id >", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_type_id >=", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdLessThan(Long value) {
            addCriterion("room_type_id <", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("room_type_id <=", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIn(List<Long> values) {
            addCriterion("room_type_id in", values, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotIn(List<Long> values) {
            addCriterion("room_type_id not in", values, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdBetween(Long value1, Long value2) {
            addCriterion("room_type_id between", value1, value2, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("room_type_id not between", value1, value2, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Long value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Long value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Long value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Long value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Long> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Long> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Long value1, Long value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
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

        public Criteria andRealPriceIsNull() {
            addCriterion("real_price is null");
            return (Criteria) this;
        }

        public Criteria andRealPriceIsNotNull() {
            addCriterion("real_price is not null");
            return (Criteria) this;
        }

        public Criteria andRealPriceEqualTo(BigDecimal value) {
            addCriterion("real_price =", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceNotEqualTo(BigDecimal value) {
            addCriterion("real_price <>", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceGreaterThan(BigDecimal value) {
            addCriterion("real_price >", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("real_price >=", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceLessThan(BigDecimal value) {
            addCriterion("real_price <", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("real_price <=", value, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceIn(List<BigDecimal> values) {
            addCriterion("real_price in", values, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceNotIn(List<BigDecimal> values) {
            addCriterion("real_price not in", values, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_price between", value1, value2, "realPrice");
            return (Criteria) this;
        }

        public Criteria andRealPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("real_price not between", value1, value2, "realPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNull() {
            addCriterion("origin_price is null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIsNotNull() {
            addCriterion("origin_price is not null");
            return (Criteria) this;
        }

        public Criteria andOriginPriceEqualTo(BigDecimal value) {
            addCriterion("origin_price =", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotEqualTo(BigDecimal value) {
            addCriterion("origin_price <>", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThan(BigDecimal value) {
            addCriterion("origin_price >", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("origin_price >=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThan(BigDecimal value) {
            addCriterion("origin_price <", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("origin_price <=", value, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceIn(List<BigDecimal> values) {
            addCriterion("origin_price in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotIn(List<BigDecimal> values) {
            addCriterion("origin_price not in", values, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("origin_price between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andOriginPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("origin_price not between", value1, value2, "originPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceIsNull() {
            addCriterion("show_price is null");
            return (Criteria) this;
        }

        public Criteria andShowPriceIsNotNull() {
            addCriterion("show_price is not null");
            return (Criteria) this;
        }

        public Criteria andShowPriceEqualTo(BigDecimal value) {
            addCriterion("show_price =", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceNotEqualTo(BigDecimal value) {
            addCriterion("show_price <>", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceGreaterThan(BigDecimal value) {
            addCriterion("show_price >", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("show_price >=", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceLessThan(BigDecimal value) {
            addCriterion("show_price <", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("show_price <=", value, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceIn(List<BigDecimal> values) {
            addCriterion("show_price in", values, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceNotIn(List<BigDecimal> values) {
            addCriterion("show_price not in", values, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("show_price between", value1, value2, "showPrice");
            return (Criteria) this;
        }

        public Criteria andShowPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("show_price not between", value1, value2, "showPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceIsNull() {
            addCriterion("ota_show_price is null");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceIsNotNull() {
            addCriterion("ota_show_price is not null");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceEqualTo(BigDecimal value) {
            addCriterion("ota_show_price =", value, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceNotEqualTo(BigDecimal value) {
            addCriterion("ota_show_price <>", value, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceGreaterThan(BigDecimal value) {
            addCriterion("ota_show_price >", value, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("ota_show_price >=", value, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceLessThan(BigDecimal value) {
            addCriterion("ota_show_price <", value, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("ota_show_price <=", value, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceIn(List<BigDecimal> values) {
            addCriterion("ota_show_price in", values, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceNotIn(List<BigDecimal> values) {
            addCriterion("ota_show_price not in", values, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ota_show_price between", value1, value2, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andOtaShowPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("ota_show_price not between", value1, value2, "otaShowPrice");
            return (Criteria) this;
        }

        public Criteria andWrapperNameIsNull() {
            addCriterion("wrapper_name is null");
            return (Criteria) this;
        }

        public Criteria andWrapperNameIsNotNull() {
            addCriterion("wrapper_name is not null");
            return (Criteria) this;
        }

        public Criteria andWrapperNameEqualTo(String value) {
            addCriterion("wrapper_name =", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameNotEqualTo(String value) {
            addCriterion("wrapper_name <>", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameGreaterThan(String value) {
            addCriterion("wrapper_name >", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameGreaterThanOrEqualTo(String value) {
            addCriterion("wrapper_name >=", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameLessThan(String value) {
            addCriterion("wrapper_name <", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameLessThanOrEqualTo(String value) {
            addCriterion("wrapper_name <=", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameLike(String value) {
            addCriterion("wrapper_name like", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameNotLike(String value) {
            addCriterion("wrapper_name not like", value, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameIn(List<String> values) {
            addCriterion("wrapper_name in", values, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameNotIn(List<String> values) {
            addCriterion("wrapper_name not in", values, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameBetween(String value1, String value2) {
            addCriterion("wrapper_name between", value1, value2, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperNameNotBetween(String value1, String value2) {
            addCriterion("wrapper_name not between", value1, value2, "wrapperName");
            return (Criteria) this;
        }

        public Criteria andWrapperIdIsNull() {
            addCriterion("wrapper_id is null");
            return (Criteria) this;
        }

        public Criteria andWrapperIdIsNotNull() {
            addCriterion("wrapper_id is not null");
            return (Criteria) this;
        }

        public Criteria andWrapperIdEqualTo(String value) {
            addCriterion("wrapper_id =", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdNotEqualTo(String value) {
            addCriterion("wrapper_id <>", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdGreaterThan(String value) {
            addCriterion("wrapper_id >", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdGreaterThanOrEqualTo(String value) {
            addCriterion("wrapper_id >=", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdLessThan(String value) {
            addCriterion("wrapper_id <", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdLessThanOrEqualTo(String value) {
            addCriterion("wrapper_id <=", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdLike(String value) {
            addCriterion("wrapper_id like", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdNotLike(String value) {
            addCriterion("wrapper_id not like", value, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdIn(List<String> values) {
            addCriterion("wrapper_id in", values, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdNotIn(List<String> values) {
            addCriterion("wrapper_id not in", values, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdBetween(String value1, String value2) {
            addCriterion("wrapper_id between", value1, value2, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andWrapperIdNotBetween(String value1, String value2) {
            addCriterion("wrapper_id not between", value1, value2, "wrapperId");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountIsNull() {
            addCriterion("all_room_count is null");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountIsNotNull() {
            addCriterion("all_room_count is not null");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountEqualTo(Integer value) {
            addCriterion("all_room_count =", value, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountNotEqualTo(Integer value) {
            addCriterion("all_room_count <>", value, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountGreaterThan(Integer value) {
            addCriterion("all_room_count >", value, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("all_room_count >=", value, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountLessThan(Integer value) {
            addCriterion("all_room_count <", value, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountLessThanOrEqualTo(Integer value) {
            addCriterion("all_room_count <=", value, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountIn(List<Integer> values) {
            addCriterion("all_room_count in", values, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountNotIn(List<Integer> values) {
            addCriterion("all_room_count not in", values, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountBetween(Integer value1, Integer value2) {
            addCriterion("all_room_count between", value1, value2, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAllRoomCountNotBetween(Integer value1, Integer value2) {
            addCriterion("all_room_count not between", value1, value2, "allRoomCount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountIsNull() {
            addCriterion("available_roomcount is null");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountIsNotNull() {
            addCriterion("available_roomcount is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountEqualTo(Integer value) {
            addCriterion("available_roomcount =", value, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountNotEqualTo(Integer value) {
            addCriterion("available_roomcount <>", value, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountGreaterThan(Integer value) {
            addCriterion("available_roomcount >", value, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountGreaterThanOrEqualTo(Integer value) {
            addCriterion("available_roomcount >=", value, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountLessThan(Integer value) {
            addCriterion("available_roomcount <", value, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountLessThanOrEqualTo(Integer value) {
            addCriterion("available_roomcount <=", value, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountIn(List<Integer> values) {
            addCriterion("available_roomcount in", values, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountNotIn(List<Integer> values) {
            addCriterion("available_roomcount not in", values, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountBetween(Integer value1, Integer value2) {
            addCriterion("available_roomcount between", value1, value2, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andAvailableRoomcountNotBetween(Integer value1, Integer value2) {
            addCriterion("available_roomcount not between", value1, value2, "availableRoomcount");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeIsNull() {
            addCriterion("crawer_time is null");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeIsNotNull() {
            addCriterion("crawer_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeEqualTo(Date value) {
            addCriterion("crawer_time =", value, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeNotEqualTo(Date value) {
            addCriterion("crawer_time <>", value, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeGreaterThan(Date value) {
            addCriterion("crawer_time >", value, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("crawer_time >=", value, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeLessThan(Date value) {
            addCriterion("crawer_time <", value, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeLessThanOrEqualTo(Date value) {
            addCriterion("crawer_time <=", value, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeIn(List<Date> values) {
            addCriterion("crawer_time in", values, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeNotIn(List<Date> values) {
            addCriterion("crawer_time not in", values, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeBetween(Date value1, Date value2) {
            addCriterion("crawer_time between", value1, value2, "crawerTime");
            return (Criteria) this;
        }

        public Criteria andCrawerTimeNotBetween(Date value1, Date value2) {
            addCriterion("crawer_time not between", value1, value2, "crawerTime");
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