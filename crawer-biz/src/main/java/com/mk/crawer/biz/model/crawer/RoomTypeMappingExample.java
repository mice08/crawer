package com.mk.crawer.biz.model.crawer;

import java.util.ArrayList;
import java.util.List;

public class RoomTypeMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RoomTypeMappingExample() {
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

        public Criteria andHotelSourceIdIsNull() {
            addCriterion("hotel_source_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdIsNotNull() {
            addCriterion("hotel_source_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdEqualTo(String value) {
            addCriterion("hotel_source_id =", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdNotEqualTo(String value) {
            addCriterion("hotel_source_id <>", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdGreaterThan(String value) {
            addCriterion("hotel_source_id >", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdGreaterThanOrEqualTo(String value) {
            addCriterion("hotel_source_id >=", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdLessThan(String value) {
            addCriterion("hotel_source_id <", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdLessThanOrEqualTo(String value) {
            addCriterion("hotel_source_id <=", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdLike(String value) {
            addCriterion("hotel_source_id like", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdNotLike(String value) {
            addCriterion("hotel_source_id not like", value, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdIn(List<String> values) {
            addCriterion("hotel_source_id in", values, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdNotIn(List<String> values) {
            addCriterion("hotel_source_id not in", values, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdBetween(String value1, String value2) {
            addCriterion("hotel_source_id between", value1, value2, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andHotelSourceIdNotBetween(String value1, String value2) {
            addCriterion("hotel_source_id not between", value1, value2, "hotelSourceId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdIsNull() {
            addCriterion("ots_room_type_id is null");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdIsNotNull() {
            addCriterion("ots_room_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdEqualTo(Long value) {
            addCriterion("ots_room_type_id =", value, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdNotEqualTo(Long value) {
            addCriterion("ots_room_type_id <>", value, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdGreaterThan(Long value) {
            addCriterion("ots_room_type_id >", value, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ots_room_type_id >=", value, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdLessThan(Long value) {
            addCriterion("ots_room_type_id <", value, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdLessThanOrEqualTo(Long value) {
            addCriterion("ots_room_type_id <=", value, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdIn(List<Long> values) {
            addCriterion("ots_room_type_id in", values, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdNotIn(List<Long> values) {
            addCriterion("ots_room_type_id not in", values, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdBetween(Long value1, Long value2) {
            addCriterion("ots_room_type_id between", value1, value2, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andOtsRoomTypeIdNotBetween(Long value1, Long value2) {
            addCriterion("ots_room_type_id not between", value1, value2, "otsRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdIsNull() {
            addCriterion("ex_room_type_id is null");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdIsNotNull() {
            addCriterion("ex_room_type_id is not null");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdEqualTo(String value) {
            addCriterion("ex_room_type_id =", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdNotEqualTo(String value) {
            addCriterion("ex_room_type_id <>", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdGreaterThan(String value) {
            addCriterion("ex_room_type_id >", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdGreaterThanOrEqualTo(String value) {
            addCriterion("ex_room_type_id >=", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdLessThan(String value) {
            addCriterion("ex_room_type_id <", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdLessThanOrEqualTo(String value) {
            addCriterion("ex_room_type_id <=", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdLike(String value) {
            addCriterion("ex_room_type_id like", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdNotLike(String value) {
            addCriterion("ex_room_type_id not like", value, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdIn(List<String> values) {
            addCriterion("ex_room_type_id in", values, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdNotIn(List<String> values) {
            addCriterion("ex_room_type_id not in", values, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdBetween(String value1, String value2) {
            addCriterion("ex_room_type_id between", value1, value2, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andExRoomTypeIdNotBetween(String value1, String value2) {
            addCriterion("ex_room_type_id not between", value1, value2, "exRoomTypeId");
            return (Criteria) this;
        }

        public Criteria andValidIsNull() {
            addCriterion("valid is null");
            return (Criteria) this;
        }

        public Criteria andValidIsNotNull() {
            addCriterion("valid is not null");
            return (Criteria) this;
        }

        public Criteria andValidEqualTo(String value) {
            addCriterion("valid =", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotEqualTo(String value) {
            addCriterion("valid <>", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThan(String value) {
            addCriterion("valid >", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidGreaterThanOrEqualTo(String value) {
            addCriterion("valid >=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThan(String value) {
            addCriterion("valid <", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLessThanOrEqualTo(String value) {
            addCriterion("valid <=", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidLike(String value) {
            addCriterion("valid like", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotLike(String value) {
            addCriterion("valid not like", value, "valid");
            return (Criteria) this;
        }

        public Criteria andValidIn(List<String> values) {
            addCriterion("valid in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotIn(List<String> values) {
            addCriterion("valid not in", values, "valid");
            return (Criteria) this;
        }

        public Criteria andValidBetween(String value1, String value2) {
            addCriterion("valid between", value1, value2, "valid");
            return (Criteria) this;
        }

        public Criteria andValidNotBetween(String value1, String value2) {
            addCriterion("valid not between", value1, value2, "valid");
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