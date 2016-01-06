package com.mk.crawer.biz.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CommentSumExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CommentSumExample() {
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

        public Criteria andScoreIsNull() {
            addCriterion("score is null");
            return (Criteria) this;
        }

        public Criteria andScoreIsNotNull() {
            addCriterion("score is not null");
            return (Criteria) this;
        }

        public Criteria andScoreEqualTo(BigDecimal value) {
            addCriterion("score =", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotEqualTo(BigDecimal value) {
            addCriterion("score <>", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThan(BigDecimal value) {
            addCriterion("score >", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("score >=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThan(BigDecimal value) {
            addCriterion("score <", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreLessThanOrEqualTo(BigDecimal value) {
            addCriterion("score <=", value, "score");
            return (Criteria) this;
        }

        public Criteria andScoreIn(List<BigDecimal> values) {
            addCriterion("score in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotIn(List<BigDecimal> values) {
            addCriterion("score not in", values, "score");
            return (Criteria) this;
        }

        public Criteria andScoreBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andScoreNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("score not between", value1, value2, "score");
            return (Criteria) this;
        }

        public Criteria andGoodTotalIsNull() {
            addCriterion("good_total is null");
            return (Criteria) this;
        }

        public Criteria andGoodTotalIsNotNull() {
            addCriterion("good_total is not null");
            return (Criteria) this;
        }

        public Criteria andGoodTotalEqualTo(Long value) {
            addCriterion("good_total =", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalNotEqualTo(Long value) {
            addCriterion("good_total <>", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalGreaterThan(Long value) {
            addCriterion("good_total >", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("good_total >=", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalLessThan(Long value) {
            addCriterion("good_total <", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalLessThanOrEqualTo(Long value) {
            addCriterion("good_total <=", value, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalIn(List<Long> values) {
            addCriterion("good_total in", values, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalNotIn(List<Long> values) {
            addCriterion("good_total not in", values, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalBetween(Long value1, Long value2) {
            addCriterion("good_total between", value1, value2, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andGoodTotalNotBetween(Long value1, Long value2) {
            addCriterion("good_total not between", value1, value2, "goodTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalIsNull() {
            addCriterion("bad_total is null");
            return (Criteria) this;
        }

        public Criteria andBadTotalIsNotNull() {
            addCriterion("bad_total is not null");
            return (Criteria) this;
        }

        public Criteria andBadTotalEqualTo(Long value) {
            addCriterion("bad_total =", value, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalNotEqualTo(Long value) {
            addCriterion("bad_total <>", value, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalGreaterThan(Long value) {
            addCriterion("bad_total >", value, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("bad_total >=", value, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalLessThan(Long value) {
            addCriterion("bad_total <", value, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalLessThanOrEqualTo(Long value) {
            addCriterion("bad_total <=", value, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalIn(List<Long> values) {
            addCriterion("bad_total in", values, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalNotIn(List<Long> values) {
            addCriterion("bad_total not in", values, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalBetween(Long value1, Long value2) {
            addCriterion("bad_total between", value1, value2, "badTotal");
            return (Criteria) this;
        }

        public Criteria andBadTotalNotBetween(Long value1, Long value2) {
            addCriterion("bad_total not between", value1, value2, "badTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalIsNull() {
            addCriterion("medium_total is null");
            return (Criteria) this;
        }

        public Criteria andMediumTotalIsNotNull() {
            addCriterion("medium_total is not null");
            return (Criteria) this;
        }

        public Criteria andMediumTotalEqualTo(Long value) {
            addCriterion("medium_total =", value, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalNotEqualTo(Long value) {
            addCriterion("medium_total <>", value, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalGreaterThan(Long value) {
            addCriterion("medium_total >", value, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("medium_total >=", value, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalLessThan(Long value) {
            addCriterion("medium_total <", value, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalLessThanOrEqualTo(Long value) {
            addCriterion("medium_total <=", value, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalIn(List<Long> values) {
            addCriterion("medium_total in", values, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalNotIn(List<Long> values) {
            addCriterion("medium_total not in", values, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalBetween(Long value1, Long value2) {
            addCriterion("medium_total between", value1, value2, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andMediumTotalNotBetween(Long value1, Long value2) {
            addCriterion("medium_total not between", value1, value2, "mediumTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalIsNull() {
            addCriterion("all_total is null");
            return (Criteria) this;
        }

        public Criteria andAllTotalIsNotNull() {
            addCriterion("all_total is not null");
            return (Criteria) this;
        }

        public Criteria andAllTotalEqualTo(Long value) {
            addCriterion("all_total =", value, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalNotEqualTo(Long value) {
            addCriterion("all_total <>", value, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalGreaterThan(Long value) {
            addCriterion("all_total >", value, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalGreaterThanOrEqualTo(Long value) {
            addCriterion("all_total >=", value, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalLessThan(Long value) {
            addCriterion("all_total <", value, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalLessThanOrEqualTo(Long value) {
            addCriterion("all_total <=", value, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalIn(List<Long> values) {
            addCriterion("all_total in", values, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalNotIn(List<Long> values) {
            addCriterion("all_total not in", values, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalBetween(Long value1, Long value2) {
            addCriterion("all_total between", value1, value2, "allTotal");
            return (Criteria) this;
        }

        public Criteria andAllTotalNotBetween(Long value1, Long value2) {
            addCriterion("all_total not between", value1, value2, "allTotal");
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

        public Criteria andHotTitlesIsNull() {
            addCriterion("hot_titles is null");
            return (Criteria) this;
        }

        public Criteria andHotTitlesIsNotNull() {
            addCriterion("hot_titles is not null");
            return (Criteria) this;
        }

        public Criteria andHotTitlesEqualTo(String value) {
            addCriterion("hot_titles =", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesNotEqualTo(String value) {
            addCriterion("hot_titles <>", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesGreaterThan(String value) {
            addCriterion("hot_titles >", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesGreaterThanOrEqualTo(String value) {
            addCriterion("hot_titles >=", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesLessThan(String value) {
            addCriterion("hot_titles <", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesLessThanOrEqualTo(String value) {
            addCriterion("hot_titles <=", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesLike(String value) {
            addCriterion("hot_titles like", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesNotLike(String value) {
            addCriterion("hot_titles not like", value, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesIn(List<String> values) {
            addCriterion("hot_titles in", values, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesNotIn(List<String> values) {
            addCriterion("hot_titles not in", values, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesBetween(String value1, String value2) {
            addCriterion("hot_titles between", value1, value2, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andHotTitlesNotBetween(String value1, String value2) {
            addCriterion("hot_titles not between", value1, value2, "hotTitles");
            return (Criteria) this;
        }

        public Criteria andTagsIsNull() {
            addCriterion("tags is null");
            return (Criteria) this;
        }

        public Criteria andTagsIsNotNull() {
            addCriterion("tags is not null");
            return (Criteria) this;
        }

        public Criteria andTagsEqualTo(String value) {
            addCriterion("tags =", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotEqualTo(String value) {
            addCriterion("tags <>", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThan(String value) {
            addCriterion("tags >", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsGreaterThanOrEqualTo(String value) {
            addCriterion("tags >=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThan(String value) {
            addCriterion("tags <", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLessThanOrEqualTo(String value) {
            addCriterion("tags <=", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsLike(String value) {
            addCriterion("tags like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotLike(String value) {
            addCriterion("tags not like", value, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsIn(List<String> values) {
            addCriterion("tags in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotIn(List<String> values) {
            addCriterion("tags not in", values, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsBetween(String value1, String value2) {
            addCriterion("tags between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andTagsNotBetween(String value1, String value2) {
            addCriterion("tags not between", value1, value2, "tags");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtIsNull() {
            addCriterion("sentence_cmt is null");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtIsNotNull() {
            addCriterion("sentence_cmt is not null");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtEqualTo(String value) {
            addCriterion("sentence_cmt =", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtNotEqualTo(String value) {
            addCriterion("sentence_cmt <>", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtGreaterThan(String value) {
            addCriterion("sentence_cmt >", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtGreaterThanOrEqualTo(String value) {
            addCriterion("sentence_cmt >=", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtLessThan(String value) {
            addCriterion("sentence_cmt <", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtLessThanOrEqualTo(String value) {
            addCriterion("sentence_cmt <=", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtLike(String value) {
            addCriterion("sentence_cmt like", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtNotLike(String value) {
            addCriterion("sentence_cmt not like", value, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtIn(List<String> values) {
            addCriterion("sentence_cmt in", values, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtNotIn(List<String> values) {
            addCriterion("sentence_cmt not in", values, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtBetween(String value1, String value2) {
            addCriterion("sentence_cmt between", value1, value2, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andSentenceCmtNotBetween(String value1, String value2) {
            addCriterion("sentence_cmt not between", value1, value2, "sentenceCmt");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgIsNull() {
            addCriterion("score_shop_msg is null");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgIsNotNull() {
            addCriterion("score_shop_msg is not null");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgEqualTo(String value) {
            addCriterion("score_shop_msg =", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgNotEqualTo(String value) {
            addCriterion("score_shop_msg <>", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgGreaterThan(String value) {
            addCriterion("score_shop_msg >", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgGreaterThanOrEqualTo(String value) {
            addCriterion("score_shop_msg >=", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgLessThan(String value) {
            addCriterion("score_shop_msg <", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgLessThanOrEqualTo(String value) {
            addCriterion("score_shop_msg <=", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgLike(String value) {
            addCriterion("score_shop_msg like", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgNotLike(String value) {
            addCriterion("score_shop_msg not like", value, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgIn(List<String> values) {
            addCriterion("score_shop_msg in", values, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgNotIn(List<String> values) {
            addCriterion("score_shop_msg not in", values, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgBetween(String value1, String value2) {
            addCriterion("score_shop_msg between", value1, value2, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopMsgNotBetween(String value1, String value2) {
            addCriterion("score_shop_msg not between", value1, value2, "scoreShopMsg");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlIsNull() {
            addCriterion("score_shop_url is null");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlIsNotNull() {
            addCriterion("score_shop_url is not null");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlEqualTo(String value) {
            addCriterion("score_shop_url =", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlNotEqualTo(String value) {
            addCriterion("score_shop_url <>", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlGreaterThan(String value) {
            addCriterion("score_shop_url >", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlGreaterThanOrEqualTo(String value) {
            addCriterion("score_shop_url >=", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlLessThan(String value) {
            addCriterion("score_shop_url <", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlLessThanOrEqualTo(String value) {
            addCriterion("score_shop_url <=", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlLike(String value) {
            addCriterion("score_shop_url like", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlNotLike(String value) {
            addCriterion("score_shop_url not like", value, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlIn(List<String> values) {
            addCriterion("score_shop_url in", values, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlNotIn(List<String> values) {
            addCriterion("score_shop_url not in", values, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlBetween(String value1, String value2) {
            addCriterion("score_shop_url between", value1, value2, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andScoreShopUrlNotBetween(String value1, String value2) {
            addCriterion("score_shop_url not between", value1, value2, "scoreShopUrl");
            return (Criteria) this;
        }

        public Criteria andMsgIsNull() {
            addCriterion("msg is null");
            return (Criteria) this;
        }

        public Criteria andMsgIsNotNull() {
            addCriterion("msg is not null");
            return (Criteria) this;
        }

        public Criteria andMsgEqualTo(String value) {
            addCriterion("msg =", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotEqualTo(String value) {
            addCriterion("msg <>", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThan(String value) {
            addCriterion("msg >", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgGreaterThanOrEqualTo(String value) {
            addCriterion("msg >=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThan(String value) {
            addCriterion("msg <", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLessThanOrEqualTo(String value) {
            addCriterion("msg <=", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgLike(String value) {
            addCriterion("msg like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotLike(String value) {
            addCriterion("msg not like", value, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgIn(List<String> values) {
            addCriterion("msg in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotIn(List<String> values) {
            addCriterion("msg not in", values, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgBetween(String value1, String value2) {
            addCriterion("msg between", value1, value2, "msg");
            return (Criteria) this;
        }

        public Criteria andMsgNotBetween(String value1, String value2) {
            addCriterion("msg not between", value1, value2, "msg");
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