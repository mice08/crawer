package com.mk.crawer.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.crawer.biz.mapper.ots.HotelSubjectMapper;
import com.mk.crawer.biz.model.ots.HotelSubject;

@Controller
public class HotelScoreController {
	private final Logger logger = Logger.getLogger(HotelScoreController.class);

	@Autowired
	private HotelSubjectMapper subjectMapper;

	@RequestMapping(value = "/comments/updatescore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> hoteldetail(String hotelId, String score) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			HotelSubject hotelSubject = new HotelSubject(0L, Long.valueOf(hotelId), new BigDecimal(score));
			subjectMapper.updateByHotelId(hotelSubject);
		} catch (Exception ex) {
			String errorMessage = String.format("failed to subjectMapper.updateByHotelId by hotelId:%s; score:%s",
					hotelId, score);
			logger.error(errorMessage, ex);

			result.put("success", false);
			result.put("errorMessage", errorMessage);
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
		}

		result.put("success", true);
		result.put("score", score);

		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/comments/loadscore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> loadScore() {
		HashMap<String, Object> result = new HashMap<String, Object>();

		result.put("success", true);

		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
}
