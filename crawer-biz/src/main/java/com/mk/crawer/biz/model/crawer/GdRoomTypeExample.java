package com.mk.crawer.biz.model.crawer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GdRoomTypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GdRoomTypeExample() {
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

        public Criteria andRoomIdIsNull() {
            addCriterion("room_Id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_Id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Long value) {
            addCriterion("room_Id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Long value) {
            addCriterion("room_Id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Long value) {
            addCriterion("room_Id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_Id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Long value) {
            addCriterion("room_Id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Long value) {
            addCriterion("room_Id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Long> values) {
            addCriterion("room_Id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Long> values) {
            addCriterion("room_Id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Long value1, Long value2) {
            addCriterion("room_Id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Long value1, Long value2) {
            addCriterion("room_Id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIsNull() {
            addCriterion("room_type_Id is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIsNotNull() {
            addCriterion("room_type_Id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdEqualTo(Long value) {
            addCriterion("room_type_Id =", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotEqualTo(Long value) {
            addCriterion("room_type_Id <>", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdGreaterThan(Long value) {
            addCriterion("room_type_Id >", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_type_Id >=", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdLessThan(Long value) {
            addCriterion("room_type_Id <", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("room_type_Id <=", value, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdIn(List<Long> values) {
            addCriterion("room_type_Id in", values, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotIn(List<Long> values) {
            addCriterion("room_type_Id not in", values, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdBetween(Long value1, Long value2) {
            addCriterion("room_type_Id between", value1, value2, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("room_type_Id not between", value1, value2, "roomTypeId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdIsNull() {
            addCriterion("room_group_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdIsNotNull() {
            addCriterion("room_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdEqualTo(Long value) {
            addCriterion("room_group_id =", value, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdNotEqualTo(Long value) {
            addCriterion("room_group_id <>", value, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdGreaterThan(Long value) {
            addCriterion("room_group_id >", value, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdGreaterThanOrEqualTo(Long value) {
            addCriterion("room_group_id >=", value, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdLessThan(Long value) {
            addCriterion("room_group_id <", value, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdLessThanOrEqualTo(Long value) {
            addCriterion("room_group_id <=", value, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdIn(List<Long> values) {
            addCriterion("room_group_id in", values, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdNotIn(List<Long> values) {
            addCriterion("room_group_id not in", values, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdBetween(Long value1, Long value2) {
            addCriterion("room_group_id between", value1, value2, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomGroupIdNotBetween(Long value1, Long value2) {
            addCriterion("room_group_id not between", value1, value2, "roomGroupId");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameIsNull() {
            addCriterion("Room_type_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameIsNotNull() {
            addCriterion("Room_type_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameEqualTo(String value) {
            addCriterion("Room_type_name =", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotEqualTo(String value) {
            addCriterion("Room_type_name <>", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameGreaterThan(String value) {
            addCriterion("Room_type_name >", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("Room_type_name >=", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameLessThan(String value) {
            addCriterion("Room_type_name <", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameLessThanOrEqualTo(String value) {
            addCriterion("Room_type_name <=", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameLike(String value) {
            addCriterion("Room_type_name like", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotLike(String value) {
            addCriterion("Room_type_name not like", value, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameIn(List<String> values) {
            addCriterion("Room_type_name in", values, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotIn(List<String> values) {
            addCriterion("Room_type_name not in", values, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameBetween(String value1, String value2) {
            addCriterion("Room_type_name between", value1, value2, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andRoomTypeNameNotBetween(String value1, String value2) {
            addCriterion("Room_type_name not between", value1, value2, "roomTypeName");
            return (Criteria) this;
        }

        public Criteria andPriceLowestIsNull() {
            addCriterion("price_lowest is null");
            return (Criteria) this;
        }

        public Criteria andPriceLowestIsNotNull() {
            addCriterion("price_lowest is not null");
            return (Criteria) this;
        }

        public Criteria andPriceLowestEqualTo(BigDecimal value) {
            addCriterion("price_lowest =", value, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestNotEqualTo(BigDecimal value) {
            addCriterion("price_lowest <>", value, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestGreaterThan(BigDecimal value) {
            addCriterion("price_lowest >", value, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_lowest >=", value, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestLessThan(BigDecimal value) {
            addCriterion("price_lowest <", value, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_lowest <=", value, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestIn(List<BigDecimal> values) {
            addCriterion("price_lowest in", values, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestNotIn(List<BigDecimal> values) {
            addCriterion("price_lowest not in", values, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_lowest between", value1, value2, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andPriceLowestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_lowest not between", value1, value2, "priceLowest");
            return (Criteria) this;
        }

        public Criteria andFloorIsNull() {
            addCriterion("floor is null");
            return (Criteria) this;
        }

        public Criteria andFloorIsNotNull() {
            addCriterion("floor is not null");
            return (Criteria) this;
        }

        public Criteria andFloorEqualTo(String value) {
            addCriterion("floor =", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotEqualTo(String value) {
            addCriterion("floor <>", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThan(String value) {
            addCriterion("floor >", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorGreaterThanOrEqualTo(String value) {
            addCriterion("floor >=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThan(String value) {
            addCriterion("floor <", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLessThanOrEqualTo(String value) {
            addCriterion("floor <=", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorLike(String value) {
            addCriterion("floor like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotLike(String value) {
            addCriterion("floor not like", value, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorIn(List<String> values) {
            addCriterion("floor in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotIn(List<String> values) {
            addCriterion("floor not in", values, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorBetween(String value1, String value2) {
            addCriterion("floor between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andFloorNotBetween(String value1, String value2) {
            addCriterion("floor not between", value1, value2, "floor");
            return (Criteria) this;
        }

        public Criteria andNetworkIsNull() {
            addCriterion("network is null");
            return (Criteria) this;
        }

        public Criteria andNetworkIsNotNull() {
            addCriterion("network is not null");
            return (Criteria) this;
        }

        public Criteria andNetworkEqualTo(String value) {
            addCriterion("network =", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkNotEqualTo(String value) {
            addCriterion("network <>", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkGreaterThan(String value) {
            addCriterion("network >", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkGreaterThanOrEqualTo(String value) {
            addCriterion("network >=", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkLessThan(String value) {
            addCriterion("network <", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkLessThanOrEqualTo(String value) {
            addCriterion("network <=", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkLike(String value) {
            addCriterion("network like", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkNotLike(String value) {
            addCriterion("network not like", value, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkIn(List<String> values) {
            addCriterion("network in", values, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkNotIn(List<String> values) {
            addCriterion("network not in", values, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkBetween(String value1, String value2) {
            addCriterion("network between", value1, value2, "network");
            return (Criteria) this;
        }

        public Criteria andNetworkNotBetween(String value1, String value2) {
            addCriterion("network not between", value1, value2, "network");
            return (Criteria) this;
        }

        public Criteria andBedIsNull() {
            addCriterion("bed is null");
            return (Criteria) this;
        }

        public Criteria andBedIsNotNull() {
            addCriterion("bed is not null");
            return (Criteria) this;
        }

        public Criteria andBedEqualTo(String value) {
            addCriterion("bed =", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotEqualTo(String value) {
            addCriterion("bed <>", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThan(String value) {
            addCriterion("bed >", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThanOrEqualTo(String value) {
            addCriterion("bed >=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThan(String value) {
            addCriterion("bed <", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThanOrEqualTo(String value) {
            addCriterion("bed <=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLike(String value) {
            addCriterion("bed like", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotLike(String value) {
            addCriterion("bed not like", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedIn(List<String> values) {
            addCriterion("bed in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotIn(List<String> values) {
            addCriterion("bed not in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedBetween(String value1, String value2) {
            addCriterion("bed between", value1, value2, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotBetween(String value1, String value2) {
            addCriterion("bed not between", value1, value2, "bed");
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

        public Criteria andRoomStatusIsNull() {
            addCriterion("room_status is null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIsNotNull() {
            addCriterion("room_status is not null");
            return (Criteria) this;
        }

        public Criteria andRoomStatusEqualTo(String value) {
            addCriterion("room_status =", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotEqualTo(String value) {
            addCriterion("room_status <>", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThan(String value) {
            addCriterion("room_status >", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusGreaterThanOrEqualTo(String value) {
            addCriterion("room_status >=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThan(String value) {
            addCriterion("room_status <", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLessThanOrEqualTo(String value) {
            addCriterion("room_status <=", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusLike(String value) {
            addCriterion("room_status like", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotLike(String value) {
            addCriterion("room_status not like", value, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusIn(List<String> values) {
            addCriterion("room_status in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotIn(List<String> values) {
            addCriterion("room_status not in", values, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusBetween(String value1, String value2) {
            addCriterion("room_status between", value1, value2, "roomStatus");
            return (Criteria) this;
        }

        public Criteria andRoomStatusNotBetween(String value1, String value2) {
            addCriterion("room_status not between", value1, value2, "roomStatus");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andIsVaildIsNull() {
            addCriterion("is_vaild is null");
            return (Criteria) this;
        }

        public Criteria andIsVaildIsNotNull() {
            addCriterion("is_vaild is not null");
            return (Criteria) this;
        }

        public Criteria andIsVaildEqualTo(String value) {
            addCriterion("is_vaild =", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildNotEqualTo(String value) {
            addCriterion("is_vaild <>", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildGreaterThan(String value) {
            addCriterion("is_vaild >", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildGreaterThanOrEqualTo(String value) {
            addCriterion("is_vaild >=", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildLessThan(String value) {
            addCriterion("is_vaild <", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildLessThanOrEqualTo(String value) {
            addCriterion("is_vaild <=", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildLike(String value) {
            addCriterion("is_vaild like", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildNotLike(String value) {
            addCriterion("is_vaild not like", value, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildIn(List<String> values) {
            addCriterion("is_vaild in", values, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildNotIn(List<String> values) {
            addCriterion("is_vaild not in", values, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildBetween(String value1, String value2) {
            addCriterion("is_vaild between", value1, value2, "isVaild");
            return (Criteria) this;
        }

        public Criteria andIsVaildNotBetween(String value1, String value2) {
            addCriterion("is_vaild not between", value1, value2, "isVaild");
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