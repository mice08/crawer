package com.mk.crawer.biz.model.crawer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public HotelExample() {
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

        public Criteria andDistanceIsNull() {
            addCriterion("distance is null");
            return (Criteria) this;
        }

        public Criteria andDistanceIsNotNull() {
            addCriterion("distance is not null");
            return (Criteria) this;
        }

        public Criteria andDistanceEqualTo(Long value) {
            addCriterion("distance =", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotEqualTo(Long value) {
            addCriterion("distance <>", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThan(Long value) {
            addCriterion("distance >", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceGreaterThanOrEqualTo(Long value) {
            addCriterion("distance >=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThan(Long value) {
            addCriterion("distance <", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceLessThanOrEqualTo(Long value) {
            addCriterion("distance <=", value, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceIn(List<Long> values) {
            addCriterion("distance in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotIn(List<Long> values) {
            addCriterion("distance not in", values, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceBetween(Long value1, Long value2) {
            addCriterion("distance between", value1, value2, "distance");
            return (Criteria) this;
        }

        public Criteria andDistanceNotBetween(Long value1, Long value2) {
            addCriterion("distance not between", value1, value2, "distance");
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

        public Criteria andHasBreakfastIsNull() {
            addCriterion("has_breakfast is null");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastIsNotNull() {
            addCriterion("has_breakfast is not null");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastEqualTo(String value) {
            addCriterion("has_breakfast =", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastNotEqualTo(String value) {
            addCriterion("has_breakfast <>", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastGreaterThan(String value) {
            addCriterion("has_breakfast >", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastGreaterThanOrEqualTo(String value) {
            addCriterion("has_breakfast >=", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastLessThan(String value) {
            addCriterion("has_breakfast <", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastLessThanOrEqualTo(String value) {
            addCriterion("has_breakfast <=", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastLike(String value) {
            addCriterion("has_breakfast like", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastNotLike(String value) {
            addCriterion("has_breakfast not like", value, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastIn(List<String> values) {
            addCriterion("has_breakfast in", values, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastNotIn(List<String> values) {
            addCriterion("has_breakfast not in", values, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastBetween(String value1, String value2) {
            addCriterion("has_breakfast between", value1, value2, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andHasBreakfastNotBetween(String value1, String value2) {
            addCriterion("has_breakfast not between", value1, value2, "hasBreakfast");
            return (Criteria) this;
        }

        public Criteria andImageCountIsNull() {
            addCriterion("image_count is null");
            return (Criteria) this;
        }

        public Criteria andImageCountIsNotNull() {
            addCriterion("image_count is not null");
            return (Criteria) this;
        }

        public Criteria andImageCountEqualTo(Long value) {
            addCriterion("image_count =", value, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountNotEqualTo(Long value) {
            addCriterion("image_count <>", value, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountGreaterThan(Long value) {
            addCriterion("image_count >", value, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountGreaterThanOrEqualTo(Long value) {
            addCriterion("image_count >=", value, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountLessThan(Long value) {
            addCriterion("image_count <", value, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountLessThanOrEqualTo(Long value) {
            addCriterion("image_count <=", value, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountIn(List<Long> values) {
            addCriterion("image_count in", values, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountNotIn(List<Long> values) {
            addCriterion("image_count not in", values, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountBetween(Long value1, Long value2) {
            addCriterion("image_count between", value1, value2, "imageCount");
            return (Criteria) this;
        }

        public Criteria andImageCountNotBetween(Long value1, Long value2) {
            addCriterion("image_count not between", value1, value2, "imageCount");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomIsNull() {
            addCriterion("has_fitness_room is null");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomIsNotNull() {
            addCriterion("has_fitness_room is not null");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomEqualTo(String value) {
            addCriterion("has_fitness_room =", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomNotEqualTo(String value) {
            addCriterion("has_fitness_room <>", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomGreaterThan(String value) {
            addCriterion("has_fitness_room >", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomGreaterThanOrEqualTo(String value) {
            addCriterion("has_fitness_room >=", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomLessThan(String value) {
            addCriterion("has_fitness_room <", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomLessThanOrEqualTo(String value) {
            addCriterion("has_fitness_room <=", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomLike(String value) {
            addCriterion("has_fitness_room like", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomNotLike(String value) {
            addCriterion("has_fitness_room not like", value, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomIn(List<String> values) {
            addCriterion("has_fitness_room in", values, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomNotIn(List<String> values) {
            addCriterion("has_fitness_room not in", values, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomBetween(String value1, String value2) {
            addCriterion("has_fitness_room between", value1, value2, "hasFitnessRoom");
            return (Criteria) this;
        }

        public Criteria andHasFitnessRoomNotBetween(String value1, String value2) {
            addCriterion("has_fitness_room not between", value1, value2, "hasFitnessRoom");
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

        public Criteria andHasBusinessCenterIsNull() {
            addCriterion("has_business_center is null");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterIsNotNull() {
            addCriterion("has_business_center is not null");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterEqualTo(String value) {
            addCriterion("has_business_center =", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterNotEqualTo(String value) {
            addCriterion("has_business_center <>", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterGreaterThan(String value) {
            addCriterion("has_business_center >", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterGreaterThanOrEqualTo(String value) {
            addCriterion("has_business_center >=", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterLessThan(String value) {
            addCriterion("has_business_center <", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterLessThanOrEqualTo(String value) {
            addCriterion("has_business_center <=", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterLike(String value) {
            addCriterion("has_business_center like", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterNotLike(String value) {
            addCriterion("has_business_center not like", value, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterIn(List<String> values) {
            addCriterion("has_business_center in", values, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterNotIn(List<String> values) {
            addCriterion("has_business_center not in", values, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterBetween(String value1, String value2) {
            addCriterion("has_business_center between", value1, value2, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasBusinessCenterNotBetween(String value1, String value2) {
            addCriterion("has_business_center not between", value1, value2, "hasBusinessCenter");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantIsNull() {
            addCriterion("has_restaurant is null");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantIsNotNull() {
            addCriterion("has_restaurant is not null");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantEqualTo(String value) {
            addCriterion("has_restaurant =", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantNotEqualTo(String value) {
            addCriterion("has_restaurant <>", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantGreaterThan(String value) {
            addCriterion("has_restaurant >", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantGreaterThanOrEqualTo(String value) {
            addCriterion("has_restaurant >=", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantLessThan(String value) {
            addCriterion("has_restaurant <", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantLessThanOrEqualTo(String value) {
            addCriterion("has_restaurant <=", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantLike(String value) {
            addCriterion("has_restaurant like", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantNotLike(String value) {
            addCriterion("has_restaurant not like", value, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantIn(List<String> values) {
            addCriterion("has_restaurant in", values, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantNotIn(List<String> values) {
            addCriterion("has_restaurant not in", values, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantBetween(String value1, String value2) {
            addCriterion("has_restaurant between", value1, value2, "hasRestaurant");
            return (Criteria) this;
        }

        public Criteria andHasRestaurantNotBetween(String value1, String value2) {
            addCriterion("has_restaurant not between", value1, value2, "hasRestaurant");
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

        public Criteria andHotelStarsEqualTo(Long value) {
            addCriterion("hotel_stars =", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsNotEqualTo(Long value) {
            addCriterion("hotel_stars <>", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsGreaterThan(Long value) {
            addCriterion("hotel_stars >", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsGreaterThanOrEqualTo(Long value) {
            addCriterion("hotel_stars >=", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsLessThan(Long value) {
            addCriterion("hotel_stars <", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsLessThanOrEqualTo(Long value) {
            addCriterion("hotel_stars <=", value, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsIn(List<Long> values) {
            addCriterion("hotel_stars in", values, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsNotIn(List<Long> values) {
            addCriterion("hotel_stars not in", values, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsBetween(Long value1, Long value2) {
            addCriterion("hotel_stars between", value1, value2, "hotelStars");
            return (Criteria) this;
        }

        public Criteria andHotelStarsNotBetween(Long value1, Long value2) {
            addCriterion("hotel_stars not between", value1, value2, "hotelStars");
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

        public Criteria andDangCiIsNull() {
            addCriterion("dang_ci is null");
            return (Criteria) this;
        }

        public Criteria andDangCiIsNotNull() {
            addCriterion("dang_ci is not null");
            return (Criteria) this;
        }

        public Criteria andDangCiEqualTo(String value) {
            addCriterion("dang_ci =", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiNotEqualTo(String value) {
            addCriterion("dang_ci <>", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiGreaterThan(String value) {
            addCriterion("dang_ci >", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiGreaterThanOrEqualTo(String value) {
            addCriterion("dang_ci >=", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiLessThan(String value) {
            addCriterion("dang_ci <", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiLessThanOrEqualTo(String value) {
            addCriterion("dang_ci <=", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiLike(String value) {
            addCriterion("dang_ci like", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiNotLike(String value) {
            addCriterion("dang_ci not like", value, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiIn(List<String> values) {
            addCriterion("dang_ci in", values, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiNotIn(List<String> values) {
            addCriterion("dang_ci not in", values, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiBetween(String value1, String value2) {
            addCriterion("dang_ci between", value1, value2, "dangCi");
            return (Criteria) this;
        }

        public Criteria andDangCiNotBetween(String value1, String value2) {
            addCriterion("dang_ci not between", value1, value2, "dangCi");
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

        public Criteria andHasMeetingOrBanquetSpaceIsNull() {
            addCriterion("has_meeting_or_banquet_space is null");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceIsNotNull() {
            addCriterion("has_meeting_or_banquet_space is not null");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceEqualTo(String value) {
            addCriterion("has_meeting_or_banquet_space =", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceNotEqualTo(String value) {
            addCriterion("has_meeting_or_banquet_space <>", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceGreaterThan(String value) {
            addCriterion("has_meeting_or_banquet_space >", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceGreaterThanOrEqualTo(String value) {
            addCriterion("has_meeting_or_banquet_space >=", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceLessThan(String value) {
            addCriterion("has_meeting_or_banquet_space <", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceLessThanOrEqualTo(String value) {
            addCriterion("has_meeting_or_banquet_space <=", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceLike(String value) {
            addCriterion("has_meeting_or_banquet_space like", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceNotLike(String value) {
            addCriterion("has_meeting_or_banquet_space not like", value, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceIn(List<String> values) {
            addCriterion("has_meeting_or_banquet_space in", values, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceNotIn(List<String> values) {
            addCriterion("has_meeting_or_banquet_space not in", values, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceBetween(String value1, String value2) {
            addCriterion("has_meeting_or_banquet_space between", value1, value2, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasMeetingOrBanquetSpaceNotBetween(String value1, String value2) {
            addCriterion("has_meeting_or_banquet_space not between", value1, value2, "hasMeetingOrBanquetSpace");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolIsNull() {
            addCriterion("has_indoor_pool is null");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolIsNotNull() {
            addCriterion("has_indoor_pool is not null");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolEqualTo(String value) {
            addCriterion("has_indoor_pool =", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolNotEqualTo(String value) {
            addCriterion("has_indoor_pool <>", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolGreaterThan(String value) {
            addCriterion("has_indoor_pool >", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolGreaterThanOrEqualTo(String value) {
            addCriterion("has_indoor_pool >=", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolLessThan(String value) {
            addCriterion("has_indoor_pool <", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolLessThanOrEqualTo(String value) {
            addCriterion("has_indoor_pool <=", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolLike(String value) {
            addCriterion("has_indoor_pool like", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolNotLike(String value) {
            addCriterion("has_indoor_pool not like", value, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolIn(List<String> values) {
            addCriterion("has_indoor_pool in", values, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolNotIn(List<String> values) {
            addCriterion("has_indoor_pool not in", values, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolBetween(String value1, String value2) {
            addCriterion("has_indoor_pool between", value1, value2, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasIndoorPoolNotBetween(String value1, String value2) {
            addCriterion("has_indoor_pool not between", value1, value2, "hasIndoorPool");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableIsNull() {
            addCriterion("has_non_smoking_available is null");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableIsNotNull() {
            addCriterion("has_non_smoking_available is not null");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableEqualTo(String value) {
            addCriterion("has_non_smoking_available =", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableNotEqualTo(String value) {
            addCriterion("has_non_smoking_available <>", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableGreaterThan(String value) {
            addCriterion("has_non_smoking_available >", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableGreaterThanOrEqualTo(String value) {
            addCriterion("has_non_smoking_available >=", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableLessThan(String value) {
            addCriterion("has_non_smoking_available <", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableLessThanOrEqualTo(String value) {
            addCriterion("has_non_smoking_available <=", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableLike(String value) {
            addCriterion("has_non_smoking_available like", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableNotLike(String value) {
            addCriterion("has_non_smoking_available not like", value, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableIn(List<String> values) {
            addCriterion("has_non_smoking_available in", values, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableNotIn(List<String> values) {
            addCriterion("has_non_smoking_available not in", values, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableBetween(String value1, String value2) {
            addCriterion("has_non_smoking_available between", value1, value2, "hasNonSmokingAvailable");
            return (Criteria) this;
        }

        public Criteria andHasNonSmokingAvailableNotBetween(String value1, String value2) {
            addCriterion("has_non_smoking_available not between", value1, value2, "hasNonSmokingAvailable");
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

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Long value) {
            addCriterion("comment_count =", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Long value) {
            addCriterion("comment_count <>", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Long value) {
            addCriterion("comment_count >", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Long value) {
            addCriterion("comment_count >=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Long value) {
            addCriterion("comment_count <", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Long value) {
            addCriterion("comment_count <=", value, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Long> values) {
            addCriterion("comment_count in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Long> values) {
            addCriterion("comment_count not in", values, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Long value1, Long value2) {
            addCriterion("comment_count between", value1, value2, "commentCount");
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Long value1, Long value2) {
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