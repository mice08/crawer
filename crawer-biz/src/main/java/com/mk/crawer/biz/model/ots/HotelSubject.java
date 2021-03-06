package com.mk.crawer.biz.model.ots;

import java.math.BigDecimal;

public class HotelSubject {
	private Long id = 0L;
	
	private Long hotelId;
	
	private BigDecimal score;

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

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public HotelSubject(Long hotelId, BigDecimal score) {
		super();
		this.hotelId = hotelId;
		this.score = score;
	}
}
