package com.mk.crawer.biz.model.crawer;

import java.math.BigDecimal;
import java.util.Date;

public class CommentSum {
	private Long id;

	private Long hotelId;

	private String hotelName;

	private String hotelSourceId;

	private BigDecimal score;

	private Long goodTotal;

	private Long badTotal;

	private Long mediumTotal;

	private Long allTotal;

	private Long imageCount;

	private String hotTitles;

	private String tags;

	private String sentenceCmt;

	private String scoreShopMsg;

	private String scoreShopUrl;

	private String msg;

	private String valid;

	private Date createTime;

	private Date updateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getHotelId() {
		return hotelId;
	}

	public void setHotelId(Long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelSourceId() {
		return hotelSourceId;
	}

	public void setHotelSourceId(String hotelSourceId) {
		this.hotelSourceId = hotelSourceId;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public Long getGoodTotal() {
		return goodTotal;
	}

	public void setGoodTotal(Long goodTotal) {
		this.goodTotal = goodTotal;
	}

	public Long getBadTotal() {
		return badTotal;
	}

	public void setBadTotal(Long badTotal) {
		this.badTotal = badTotal;
	}

	public Long getMediumTotal() {
		return mediumTotal;
	}

	public void setMediumTotal(Long mediumTotal) {
		this.mediumTotal = mediumTotal;
	}

	public Long getAllTotal() {
		return allTotal;
	}

	public void setAllTotal(Long allTotal) {
		this.allTotal = allTotal;
	}

	public Long getImageCount() {
		return imageCount;
	}

	public void setImageCount(Long imageCount) {
		this.imageCount = imageCount;
	}

	public String getHotTitles() {
		return hotTitles;
	}

	public void setHotTitles(String hotTitles) {
		this.hotTitles = hotTitles;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getSentenceCmt() {
		return sentenceCmt;
	}

	public void setSentenceCmt(String sentenceCmt) {
		this.sentenceCmt = sentenceCmt;
	}

	public String getScoreShopMsg() {
		return scoreShopMsg;
	}

	public void setScoreShopMsg(String scoreShopMsg) {
		this.scoreShopMsg = scoreShopMsg;
	}

	public String getScoreShopUrl() {
		return scoreShopUrl;
	}

	public void setScoreShopUrl(String scoreShopUrl) {
		this.scoreShopUrl = scoreShopUrl;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

}