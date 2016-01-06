package com.mk.crawer.biz.model.crawer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RoomTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomTypeExample() {
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

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Long value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Long value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Long value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Long value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Long> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Long> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Long value1, Long value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andBedTypeIsNull() {
            addCriterion("bed_type is null");
            return (Criteria) this;
        }

        public Criteria andBedTypeIsNotNull() {
            addCriterion("bed_type is not null");
            return (Criteria) this;
        }

        public Criteria andBedTypeEqualTo(String value) {
            addCriterion("bed_type =", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeNotEqualTo(String value) {
            addCriterion("bed_type <>", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeGreaterThan(String value) {
            addCriterion("bed_type >", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeGreaterThanOrEqualTo(String value) {
            addCriterion("bed_type >=", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeLessThan(String value) {
            addCriterion("bed_type <", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeLessThanOrEqualTo(String value) {
            addCriterion("bed_type <=", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeLike(String value) {
            addCriterion("bed_type like", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeNotLike(String value) {
            addCriterion("bed_type not like", value, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeIn(List<String> values) {
            addCriterion("bed_type in", values, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeNotIn(List<String> values) {
            addCriterion("bed_type not in", values, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeBetween(String value1, String value2) {
            addCriterion("bed_type between", value1, value2, "bedType");
            return (Criteria) this;
        }

        public Criteria andBedTypeNotBetween(String value1, String value2) {
            addCriterion("bed_type not between", value1, value2, "bedType");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNull() {
            addCriterion("room_type is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIsNotNull() {
            addCriterion("room_type is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeEqualTo(String value) {
            addCriterion("room_type =", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotEqualTo(String value) {
            addCriterion("room_type <>", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThan(String value) {
            addCriterion("room_type >", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeGreaterThanOrEqualTo(String value) {
            addCriterion("room_type >=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThan(String value) {
            addCriterion("room_type <", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLessThanOrEqualTo(String value) {
            addCriterion("room_type <=", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeLike(String value) {
            addCriterion("room_type like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotLike(String value) {
            addCriterion("room_type not like", value, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIn(List<String> values) {
            addCriterion("room_type in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotIn(List<String> values) {
            addCriterion("room_type not in", values, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeBetween(String value1, String value2) {
            addCriterion("room_type between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNotBetween(String value1, String value2) {
            addCriterion("room_type not between", value1, value2, "roomType");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceIsNull() {
            addCriterion("network_price is null");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceIsNotNull() {
            addCriterion("network_price is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceEqualTo(BigDecimal value) {
            addCriterion("network_price =", value, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceNotEqualTo(BigDecimal value) {
            addCriterion("network_price <>", value, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceGreaterThan(BigDecimal value) {
            addCriterion("network_price >", value, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("network_price >=", value, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceLessThan(BigDecimal value) {
            addCriterion("network_price <", value, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("network_price <=", value, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceIn(List<BigDecimal> values) {
            addCriterion("network_price in", values, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceNotIn(List<BigDecimal> values) {
            addCriterion("network_price not in", values, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("network_price between", value1, value2, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andNetworkPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("network_price not between", value1, value2, "networkPrice");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryIsNull() {
            addCriterion("room_category is null");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryIsNotNull() {
            addCriterion("room_category is not null");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryEqualTo(String value) {
            addCriterion("room_category =", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryNotEqualTo(String value) {
            addCriterion("room_category <>", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryGreaterThan(String value) {
            addCriterion("room_category >", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("room_category >=", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryLessThan(String value) {
            addCriterion("room_category <", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryLessThanOrEqualTo(String value) {
            addCriterion("room_category <=", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryLike(String value) {
            addCriterion("room_category like", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryNotLike(String value) {
            addCriterion("room_category not like", value, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryIn(List<String> values) {
            addCriterion("room_category in", values, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryNotIn(List<String> values) {
            addCriterion("room_category not in", values, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryBetween(String value1, String value2) {
            addCriterion("room_category between", value1, value2, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRoomCategoryNotBetween(String value1, String value2) {
            addCriterion("room_category not between", value1, value2, "roomCategory");
            return (Criteria) this;
        }

        public Criteria andRtAreaIsNull() {
            addCriterion("rt_area is null");
            return (Criteria) this;
        }

        public Criteria andRtAreaIsNotNull() {
            addCriterion("rt_area is not null");
            return (Criteria) this;
        }

        public Criteria andRtAreaEqualTo(String value) {
            addCriterion("rt_area =", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaNotEqualTo(String value) {
            addCriterion("rt_area <>", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaGreaterThan(String value) {
            addCriterion("rt_area >", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaGreaterThanOrEqualTo(String value) {
            addCriterion("rt_area >=", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaLessThan(String value) {
            addCriterion("rt_area <", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaLessThanOrEqualTo(String value) {
            addCriterion("rt_area <=", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaLike(String value) {
            addCriterion("rt_area like", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaNotLike(String value) {
            addCriterion("rt_area not like", value, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaIn(List<String> values) {
            addCriterion("rt_area in", values, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaNotIn(List<String> values) {
            addCriterion("rt_area not in", values, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaBetween(String value1, String value2) {
            addCriterion("rt_area between", value1, value2, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtAreaNotBetween(String value1, String value2) {
            addCriterion("rt_area not between", value1, value2, "rtArea");
            return (Criteria) this;
        }

        public Criteria andRtFloorIsNull() {
            addCriterion("rt_floor is null");
            return (Criteria) this;
        }

        public Criteria andRtFloorIsNotNull() {
            addCriterion("rt_floor is not null");
            return (Criteria) this;
        }

        public Criteria andRtFloorEqualTo(String value) {
            addCriterion("rt_floor =", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorNotEqualTo(String value) {
            addCriterion("rt_floor <>", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorGreaterThan(String value) {
            addCriterion("rt_floor >", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorGreaterThanOrEqualTo(String value) {
            addCriterion("rt_floor >=", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorLessThan(String value) {
            addCriterion("rt_floor <", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorLessThanOrEqualTo(String value) {
            addCriterion("rt_floor <=", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorLike(String value) {
            addCriterion("rt_floor like", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorNotLike(String value) {
            addCriterion("rt_floor not like", value, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorIn(List<String> values) {
            addCriterion("rt_floor in", values, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorNotIn(List<String> values) {
            addCriterion("rt_floor not in", values, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorBetween(String value1, String value2) {
            addCriterion("rt_floor between", value1, value2, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtFloorNotBetween(String value1, String value2) {
            addCriterion("rt_floor not between", value1, value2, "rtFloor");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandIsNull() {
            addCriterion("rt_broadband is null");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandIsNotNull() {
            addCriterion("rt_broadband is not null");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandEqualTo(String value) {
            addCriterion("rt_broadband =", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandNotEqualTo(String value) {
            addCriterion("rt_broadband <>", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandGreaterThan(String value) {
            addCriterion("rt_broadband >", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandGreaterThanOrEqualTo(String value) {
            addCriterion("rt_broadband >=", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandLessThan(String value) {
            addCriterion("rt_broadband <", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandLessThanOrEqualTo(String value) {
            addCriterion("rt_broadband <=", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandLike(String value) {
            addCriterion("rt_broadband like", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandNotLike(String value) {
            addCriterion("rt_broadband not like", value, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandIn(List<String> values) {
            addCriterion("rt_broadband in", values, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandNotIn(List<String> values) {
            addCriterion("rt_broadband not in", values, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandBetween(String value1, String value2) {
            addCriterion("rt_broadband between", value1, value2, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBroadbandNotBetween(String value1, String value2) {
            addCriterion("rt_broadband not between", value1, value2, "rtBroadband");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeIsNull() {
            addCriterion("rt_bedtype is null");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeIsNotNull() {
            addCriterion("rt_bedtype is not null");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeEqualTo(String value) {
            addCriterion("rt_bedtype =", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeNotEqualTo(String value) {
            addCriterion("rt_bedtype <>", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeGreaterThan(String value) {
            addCriterion("rt_bedtype >", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeGreaterThanOrEqualTo(String value) {
            addCriterion("rt_bedtype >=", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeLessThan(String value) {
            addCriterion("rt_bedtype <", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeLessThanOrEqualTo(String value) {
            addCriterion("rt_bedtype <=", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeLike(String value) {
            addCriterion("rt_bedtype like", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeNotLike(String value) {
            addCriterion("rt_bedtype not like", value, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeIn(List<String> values) {
            addCriterion("rt_bedtype in", values, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeNotIn(List<String> values) {
            addCriterion("rt_bedtype not in", values, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeBetween(String value1, String value2) {
            addCriterion("rt_bedtype between", value1, value2, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtBedtypeNotBetween(String value1, String value2) {
            addCriterion("rt_bedtype not between", value1, value2, "rtBedtype");
            return (Criteria) this;
        }

        public Criteria andRtAddbedIsNull() {
            addCriterion("rt_addbed is null");
            return (Criteria) this;
        }

        public Criteria andRtAddbedIsNotNull() {
            addCriterion("rt_addbed is not null");
            return (Criteria) this;
        }

        public Criteria andRtAddbedEqualTo(String value) {
            addCriterion("rt_addbed =", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedNotEqualTo(String value) {
            addCriterion("rt_addbed <>", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedGreaterThan(String value) {
            addCriterion("rt_addbed >", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedGreaterThanOrEqualTo(String value) {
            addCriterion("rt_addbed >=", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedLessThan(String value) {
            addCriterion("rt_addbed <", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedLessThanOrEqualTo(String value) {
            addCriterion("rt_addbed <=", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedLike(String value) {
            addCriterion("rt_addbed like", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedNotLike(String value) {
            addCriterion("rt_addbed not like", value, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedIn(List<String> values) {
            addCriterion("rt_addbed in", values, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedNotIn(List<String> values) {
            addCriterion("rt_addbed not in", values, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedBetween(String value1, String value2) {
            addCriterion("rt_addbed between", value1, value2, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andRtAddbedNotBetween(String value1, String value2) {
            addCriterion("rt_addbed not between", value1, value2, "rtAddbed");
            return (Criteria) this;
        }

        public Criteria andBathIsNull() {
            addCriterion("bath is null");
            return (Criteria) this;
        }

        public Criteria andBathIsNotNull() {
            addCriterion("bath is not null");
            return (Criteria) this;
        }

        public Criteria andBathEqualTo(String value) {
            addCriterion("bath =", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathNotEqualTo(String value) {
            addCriterion("bath <>", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathGreaterThan(String value) {
            addCriterion("bath >", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathGreaterThanOrEqualTo(String value) {
            addCriterion("bath >=", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathLessThan(String value) {
            addCriterion("bath <", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathLessThanOrEqualTo(String value) {
            addCriterion("bath <=", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathLike(String value) {
            addCriterion("bath like", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathNotLike(String value) {
            addCriterion("bath not like", value, "bath");
            return (Criteria) this;
        }

        public Criteria andBathIn(List<String> values) {
            addCriterion("bath in", values, "bath");
            return (Criteria) this;
        }

        public Criteria andBathNotIn(List<String> values) {
            addCriterion("bath not in", values, "bath");
            return (Criteria) this;
        }

        public Criteria andBathBetween(String value1, String value2) {
            addCriterion("bath between", value1, value2, "bath");
            return (Criteria) this;
        }

        public Criteria andBathNotBetween(String value1, String value2) {
            addCriterion("bath not between", value1, value2, "bath");
            return (Criteria) this;
        }

        public Criteria andWindowIsNull() {
            addCriterion("window is null");
            return (Criteria) this;
        }

        public Criteria andWindowIsNotNull() {
            addCriterion("window is not null");
            return (Criteria) this;
        }

        public Criteria andWindowEqualTo(String value) {
            addCriterion("window =", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotEqualTo(String value) {
            addCriterion("window <>", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowGreaterThan(String value) {
            addCriterion("window >", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowGreaterThanOrEqualTo(String value) {
            addCriterion("window >=", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLessThan(String value) {
            addCriterion("window <", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLessThanOrEqualTo(String value) {
            addCriterion("window <=", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowLike(String value) {
            addCriterion("window like", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotLike(String value) {
            addCriterion("window not like", value, "window");
            return (Criteria) this;
        }

        public Criteria andWindowIn(List<String> values) {
            addCriterion("window in", values, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotIn(List<String> values) {
            addCriterion("window not in", values, "window");
            return (Criteria) this;
        }

        public Criteria andWindowBetween(String value1, String value2) {
            addCriterion("window between", value1, value2, "window");
            return (Criteria) this;
        }

        public Criteria andWindowNotBetween(String value1, String value2) {
            addCriterion("window not between", value1, value2, "window");
            return (Criteria) this;
        }

        public Criteria andWifiIsNull() {
            addCriterion("wifi is null");
            return (Criteria) this;
        }

        public Criteria andWifiIsNotNull() {
            addCriterion("wifi is not null");
            return (Criteria) this;
        }

        public Criteria andWifiEqualTo(String value) {
            addCriterion("wifi =", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiNotEqualTo(String value) {
            addCriterion("wifi <>", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiGreaterThan(String value) {
            addCriterion("wifi >", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiGreaterThanOrEqualTo(String value) {
            addCriterion("wifi >=", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiLessThan(String value) {
            addCriterion("wifi <", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiLessThanOrEqualTo(String value) {
            addCriterion("wifi <=", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiLike(String value) {
            addCriterion("wifi like", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiNotLike(String value) {
            addCriterion("wifi not like", value, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiIn(List<String> values) {
            addCriterion("wifi in", values, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiNotIn(List<String> values) {
            addCriterion("wifi not in", values, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiBetween(String value1, String value2) {
            addCriterion("wifi between", value1, value2, "wifi");
            return (Criteria) this;
        }

        public Criteria andWifiNotBetween(String value1, String value2) {
            addCriterion("wifi not between", value1, value2, "wifi");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersIsNull() {
            addCriterion("max_customers is null");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersIsNotNull() {
            addCriterion("max_customers is not null");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersEqualTo(Long value) {
            addCriterion("max_customers =", value, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersNotEqualTo(Long value) {
            addCriterion("max_customers <>", value, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersGreaterThan(Long value) {
            addCriterion("max_customers >", value, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersGreaterThanOrEqualTo(Long value) {
            addCriterion("max_customers >=", value, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersLessThan(Long value) {
            addCriterion("max_customers <", value, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersLessThanOrEqualTo(Long value) {
            addCriterion("max_customers <=", value, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersIn(List<Long> values) {
            addCriterion("max_customers in", values, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersNotIn(List<Long> values) {
            addCriterion("max_customers not in", values, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersBetween(Long value1, Long value2) {
            addCriterion("max_customers between", value1, value2, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andMaxCustomersNotBetween(Long value1, Long value2) {
            addCriterion("max_customers not between", value1, value2, "maxCustomers");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceIsNull() {
            addCriterion("add_bed_price is null");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceIsNotNull() {
            addCriterion("add_bed_price is not null");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceEqualTo(Long value) {
            addCriterion("add_bed_price =", value, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceNotEqualTo(Long value) {
            addCriterion("add_bed_price <>", value, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceGreaterThan(Long value) {
            addCriterion("add_bed_price >", value, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("add_bed_price >=", value, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceLessThan(Long value) {
            addCriterion("add_bed_price <", value, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceLessThanOrEqualTo(Long value) {
            addCriterion("add_bed_price <=", value, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceIn(List<Long> values) {
            addCriterion("add_bed_price in", values, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceNotIn(List<Long> values) {
            addCriterion("add_bed_price not in", values, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceBetween(Long value1, Long value2) {
            addCriterion("add_bed_price between", value1, value2, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andAddBedPriceNotBetween(Long value1, Long value2) {
            addCriterion("add_bed_price not between", value1, value2, "addBedPrice");
            return (Criteria) this;
        }

        public Criteria andCurrencySignIsNull() {
            addCriterion("currency_sign is null");
            return (Criteria) this;
        }

        public Criteria andCurrencySignIsNotNull() {
            addCriterion("currency_sign is not null");
            return (Criteria) this;
        }

        public Criteria andCurrencySignEqualTo(String value) {
            addCriterion("currency_sign =", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignNotEqualTo(String value) {
            addCriterion("currency_sign <>", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignGreaterThan(String value) {
            addCriterion("currency_sign >", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignGreaterThanOrEqualTo(String value) {
            addCriterion("currency_sign >=", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignLessThan(String value) {
            addCriterion("currency_sign <", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignLessThanOrEqualTo(String value) {
            addCriterion("currency_sign <=", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignLike(String value) {
            addCriterion("currency_sign like", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignNotLike(String value) {
            addCriterion("currency_sign not like", value, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignIn(List<String> values) {
            addCriterion("currency_sign in", values, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignNotIn(List<String> values) {
            addCriterion("currency_sign not in", values, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignBetween(String value1, String value2) {
            addCriterion("currency_sign between", value1, value2, "currencySign");
            return (Criteria) this;
        }

        public Criteria andCurrencySignNotBetween(String value1, String value2) {
            addCriterion("currency_sign not between", value1, value2, "currencySign");
            return (Criteria) this;
        }

        public Criteria andExtraBedIsNull() {
            addCriterion("extra_bed is null");
            return (Criteria) this;
        }

        public Criteria andExtraBedIsNotNull() {
            addCriterion("extra_bed is not null");
            return (Criteria) this;
        }

        public Criteria andExtraBedEqualTo(String value) {
            addCriterion("extra_bed =", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedNotEqualTo(String value) {
            addCriterion("extra_bed <>", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedGreaterThan(String value) {
            addCriterion("extra_bed >", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedGreaterThanOrEqualTo(String value) {
            addCriterion("extra_bed >=", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedLessThan(String value) {
            addCriterion("extra_bed <", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedLessThanOrEqualTo(String value) {
            addCriterion("extra_bed <=", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedLike(String value) {
            addCriterion("extra_bed like", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedNotLike(String value) {
            addCriterion("extra_bed not like", value, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedIn(List<String> values) {
            addCriterion("extra_bed in", values, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedNotIn(List<String> values) {
            addCriterion("extra_bed not in", values, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedBetween(String value1, String value2) {
            addCriterion("extra_bed between", value1, value2, "extraBed");
            return (Criteria) this;
        }

        public Criteria andExtraBedNotBetween(String value1, String value2) {
            addCriterion("extra_bed not between", value1, value2, "extraBed");
            return (Criteria) this;
        }

        public Criteria andOrderAllIsNull() {
            addCriterion("order_all is null");
            return (Criteria) this;
        }

        public Criteria andOrderAllIsNotNull() {
            addCriterion("order_all is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAllEqualTo(String value) {
            addCriterion("order_all =", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllNotEqualTo(String value) {
            addCriterion("order_all <>", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllGreaterThan(String value) {
            addCriterion("order_all >", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllGreaterThanOrEqualTo(String value) {
            addCriterion("order_all >=", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllLessThan(String value) {
            addCriterion("order_all <", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllLessThanOrEqualTo(String value) {
            addCriterion("order_all <=", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllLike(String value) {
            addCriterion("order_all like", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllNotLike(String value) {
            addCriterion("order_all not like", value, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllIn(List<String> values) {
            addCriterion("order_all in", values, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllNotIn(List<String> values) {
            addCriterion("order_all not in", values, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllBetween(String value1, String value2) {
            addCriterion("order_all between", value1, value2, "orderAll");
            return (Criteria) this;
        }

        public Criteria andOrderAllNotBetween(String value1, String value2) {
            addCriterion("order_all not between", value1, value2, "orderAll");
            return (Criteria) this;
        }

        public Criteria andMpriceIsNull() {
            addCriterion("mprice is null");
            return (Criteria) this;
        }

        public Criteria andMpriceIsNotNull() {
            addCriterion("mprice is not null");
            return (Criteria) this;
        }

        public Criteria andMpriceEqualTo(BigDecimal value) {
            addCriterion("mprice =", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceNotEqualTo(BigDecimal value) {
            addCriterion("mprice <>", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceGreaterThan(BigDecimal value) {
            addCriterion("mprice >", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("mprice >=", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceLessThan(BigDecimal value) {
            addCriterion("mprice <", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("mprice <=", value, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceIn(List<BigDecimal> values) {
            addCriterion("mprice in", values, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceNotIn(List<BigDecimal> values) {
            addCriterion("mprice not in", values, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mprice between", value1, value2, "mprice");
            return (Criteria) this;
        }

        public Criteria andMpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("mprice not between", value1, value2, "mprice");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInIsNull() {
            addCriterion("has_quick_check_in is null");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInIsNotNull() {
            addCriterion("has_quick_check_in is not null");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInEqualTo(String value) {
            addCriterion("has_quick_check_in =", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInNotEqualTo(String value) {
            addCriterion("has_quick_check_in <>", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInGreaterThan(String value) {
            addCriterion("has_quick_check_in >", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInGreaterThanOrEqualTo(String value) {
            addCriterion("has_quick_check_in >=", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInLessThan(String value) {
            addCriterion("has_quick_check_in <", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInLessThanOrEqualTo(String value) {
            addCriterion("has_quick_check_in <=", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInLike(String value) {
            addCriterion("has_quick_check_in like", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInNotLike(String value) {
            addCriterion("has_quick_check_in not like", value, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInIn(List<String> values) {
            addCriterion("has_quick_check_in in", values, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInNotIn(List<String> values) {
            addCriterion("has_quick_check_in not in", values, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInBetween(String value1, String value2) {
            addCriterion("has_quick_check_in between", value1, value2, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHasQuickCheckInNotBetween(String value1, String value2) {
            addCriterion("has_quick_check_in not between", value1, value2, "hasQuickCheckIn");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsIsNull() {
            addCriterion("have_coupons is null");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsIsNotNull() {
            addCriterion("have_coupons is not null");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsEqualTo(String value) {
            addCriterion("have_coupons =", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsNotEqualTo(String value) {
            addCriterion("have_coupons <>", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsGreaterThan(String value) {
            addCriterion("have_coupons >", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsGreaterThanOrEqualTo(String value) {
            addCriterion("have_coupons >=", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsLessThan(String value) {
            addCriterion("have_coupons <", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsLessThanOrEqualTo(String value) {
            addCriterion("have_coupons <=", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsLike(String value) {
            addCriterion("have_coupons like", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsNotLike(String value) {
            addCriterion("have_coupons not like", value, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsIn(List<String> values) {
            addCriterion("have_coupons in", values, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsNotIn(List<String> values) {
            addCriterion("have_coupons not in", values, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsBetween(String value1, String value2) {
            addCriterion("have_coupons between", value1, value2, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andHaveCouponsNotBetween(String value1, String value2) {
            addCriterion("have_coupons not between", value1, value2, "haveCoupons");
            return (Criteria) this;
        }

        public Criteria andOuterShowIsNull() {
            addCriterion("outer_show is null");
            return (Criteria) this;
        }

        public Criteria andOuterShowIsNotNull() {
            addCriterion("outer_show is not null");
            return (Criteria) this;
        }

        public Criteria andOuterShowEqualTo(String value) {
            addCriterion("outer_show =", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowNotEqualTo(String value) {
            addCriterion("outer_show <>", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowGreaterThan(String value) {
            addCriterion("outer_show >", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowGreaterThanOrEqualTo(String value) {
            addCriterion("outer_show >=", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowLessThan(String value) {
            addCriterion("outer_show <", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowLessThanOrEqualTo(String value) {
            addCriterion("outer_show <=", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowLike(String value) {
            addCriterion("outer_show like", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowNotLike(String value) {
            addCriterion("outer_show not like", value, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowIn(List<String> values) {
            addCriterion("outer_show in", values, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowNotIn(List<String> values) {
            addCriterion("outer_show not in", values, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowBetween(String value1, String value2) {
            addCriterion("outer_show between", value1, value2, "outerShow");
            return (Criteria) this;
        }

        public Criteria andOuterShowNotBetween(String value1, String value2) {
            addCriterion("outer_show not between", value1, value2, "outerShow");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNull() {
            addCriterion("district_name is null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIsNotNull() {
            addCriterion("district_name is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictNameEqualTo(String value) {
            addCriterion("district_name =", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotEqualTo(String value) {
            addCriterion("district_name <>", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThan(String value) {
            addCriterion("district_name >", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameGreaterThanOrEqualTo(String value) {
            addCriterion("district_name >=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThan(String value) {
            addCriterion("district_name <", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLessThanOrEqualTo(String value) {
            addCriterion("district_name <=", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameLike(String value) {
            addCriterion("district_name like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotLike(String value) {
            addCriterion("district_name not like", value, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameIn(List<String> values) {
            addCriterion("district_name in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotIn(List<String> values) {
            addCriterion("district_name not in", values, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameBetween(String value1, String value2) {
            addCriterion("district_name between", value1, value2, "districtName");
            return (Criteria) this;
        }

        public Criteria andDistrictNameNotBetween(String value1, String value2) {
            addCriterion("district_name not between", value1, value2, "districtName");
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