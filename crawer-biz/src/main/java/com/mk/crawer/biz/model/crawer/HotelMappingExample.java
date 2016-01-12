package com.mk.crawer.biz.model.crawer;

import java.util.ArrayList;
import java.util.List;

public class HotelMappingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelMappingExample() {
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

        public Criteria andOtsHotelIdIsNull() {
            addCriterion("ots_hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdIsNotNull() {
            addCriterion("ots_hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdEqualTo(Long value) {
            addCriterion("ots_hotel_id =", value, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdNotEqualTo(Long value) {
            addCriterion("ots_hotel_id <>", value, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdGreaterThan(Long value) {
            addCriterion("ots_hotel_id >", value, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdGreaterThanOrEqualTo(Long value) {
            addCriterion("ots_hotel_id >=", value, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdLessThan(Long value) {
            addCriterion("ots_hotel_id <", value, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdLessThanOrEqualTo(Long value) {
            addCriterion("ots_hotel_id <=", value, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdIn(List<Long> values) {
            addCriterion("ots_hotel_id in", values, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdNotIn(List<Long> values) {
            addCriterion("ots_hotel_id not in", values, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdBetween(Long value1, Long value2) {
            addCriterion("ots_hotel_id between", value1, value2, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelIdNotBetween(Long value1, Long value2) {
            addCriterion("ots_hotel_id not between", value1, value2, "otsHotelId");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameIsNull() {
            addCriterion("ots_hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameIsNotNull() {
            addCriterion("ots_hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameEqualTo(String value) {
            addCriterion("ots_hotel_name =", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameNotEqualTo(String value) {
            addCriterion("ots_hotel_name <>", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameGreaterThan(String value) {
            addCriterion("ots_hotel_name >", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("ots_hotel_name >=", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameLessThan(String value) {
            addCriterion("ots_hotel_name <", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameLessThanOrEqualTo(String value) {
            addCriterion("ots_hotel_name <=", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameLike(String value) {
            addCriterion("ots_hotel_name like", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameNotLike(String value) {
            addCriterion("ots_hotel_name not like", value, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameIn(List<String> values) {
            addCriterion("ots_hotel_name in", values, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameNotIn(List<String> values) {
            addCriterion("ots_hotel_name not in", values, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameBetween(String value1, String value2) {
            addCriterion("ots_hotel_name between", value1, value2, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andOtsHotelNameNotBetween(String value1, String value2) {
            addCriterion("ots_hotel_name not between", value1, value2, "otsHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelIdIsNull() {
            addCriterion("ex_hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andExHotelIdIsNotNull() {
            addCriterion("ex_hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andExHotelIdEqualTo(String value) {
            addCriterion("ex_hotel_id =", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdNotEqualTo(String value) {
            addCriterion("ex_hotel_id <>", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdGreaterThan(String value) {
            addCriterion("ex_hotel_id >", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdGreaterThanOrEqualTo(String value) {
            addCriterion("ex_hotel_id >=", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdLessThan(String value) {
            addCriterion("ex_hotel_id <", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdLessThanOrEqualTo(String value) {
            addCriterion("ex_hotel_id <=", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdLike(String value) {
            addCriterion("ex_hotel_id like", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdNotLike(String value) {
            addCriterion("ex_hotel_id not like", value, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdIn(List<String> values) {
            addCriterion("ex_hotel_id in", values, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdNotIn(List<String> values) {
            addCriterion("ex_hotel_id not in", values, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdBetween(String value1, String value2) {
            addCriterion("ex_hotel_id between", value1, value2, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelIdNotBetween(String value1, String value2) {
            addCriterion("ex_hotel_id not between", value1, value2, "exHotelId");
            return (Criteria) this;
        }

        public Criteria andExHotelNameIsNull() {
            addCriterion("ex_hotel_name is null");
            return (Criteria) this;
        }

        public Criteria andExHotelNameIsNotNull() {
            addCriterion("ex_hotel_name is not null");
            return (Criteria) this;
        }

        public Criteria andExHotelNameEqualTo(String value) {
            addCriterion("ex_hotel_name =", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameNotEqualTo(String value) {
            addCriterion("ex_hotel_name <>", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameGreaterThan(String value) {
            addCriterion("ex_hotel_name >", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameGreaterThanOrEqualTo(String value) {
            addCriterion("ex_hotel_name >=", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameLessThan(String value) {
            addCriterion("ex_hotel_name <", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameLessThanOrEqualTo(String value) {
            addCriterion("ex_hotel_name <=", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameLike(String value) {
            addCriterion("ex_hotel_name like", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameNotLike(String value) {
            addCriterion("ex_hotel_name not like", value, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameIn(List<String> values) {
            addCriterion("ex_hotel_name in", values, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameNotIn(List<String> values) {
            addCriterion("ex_hotel_name not in", values, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameBetween(String value1, String value2) {
            addCriterion("ex_hotel_name between", value1, value2, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andExHotelNameNotBetween(String value1, String value2) {
            addCriterion("ex_hotel_name not between", value1, value2, "exHotelName");
            return (Criteria) this;
        }

        public Criteria andSiteIsNull() {
            addCriterion("site is null");
            return (Criteria) this;
        }

        public Criteria andSiteIsNotNull() {
            addCriterion("site is not null");
            return (Criteria) this;
        }

        public Criteria andSiteEqualTo(String value) {
            addCriterion("site =", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotEqualTo(String value) {
            addCriterion("site <>", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThan(String value) {
            addCriterion("site >", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteGreaterThanOrEqualTo(String value) {
            addCriterion("site >=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThan(String value) {
            addCriterion("site <", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLessThanOrEqualTo(String value) {
            addCriterion("site <=", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteLike(String value) {
            addCriterion("site like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotLike(String value) {
            addCriterion("site not like", value, "site");
            return (Criteria) this;
        }

        public Criteria andSiteIn(List<String> values) {
            addCriterion("site in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotIn(List<String> values) {
            addCriterion("site not in", values, "site");
            return (Criteria) this;
        }

        public Criteria andSiteBetween(String value1, String value2) {
            addCriterion("site between", value1, value2, "site");
            return (Criteria) this;
        }

        public Criteria andSiteNotBetween(String value1, String value2) {
            addCriterion("site not between", value1, value2, "site");
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