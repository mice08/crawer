package com.mk.crawer.web.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.crawer.biz.mapper.crawer.CommentSumMapper;
import com.mk.crawer.biz.mapper.ots.HotelSubjectMapper;
import com.mk.crawer.biz.model.ots.HotelSubject;

@Controller
public class HotelScoreController {
	private final Logger logger = Logger.getLogger(HotelScoreController.class);

	@Autowired
	private HotelSubjectMapper subjectMapper;

	@Autowired
	private CommentSumMapper commentSumMapper;

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

	private void processHotelScore(String hotelId) {

		if (logger.isInfoEnabled()) {
			logger.info(String.format("about to process comments for %s hotels", hotelId));
		}

		BigDecimal scoreVal = null;
		try {
			List<Map<String, Object>> scores = commentSumMapper.selectScoreByOtsId(hotelId);

			if (scores != null && scores.size() > 0) {
				Map<String, Object> score = scores.get(0);
				scoreVal = (BigDecimal) score.get("score");
			}
		} catch (Exception e) {
			logger.error(String.format("failed to commentSumMapper.selectScoreByOtsId by id:%s", hotelId), e);
		}

		try {
			if (scoreVal != null) {
				subjectMapper.updateByHotelId(new HotelSubject(0L, Long.valueOf(hotelId), scoreVal));
			} else {
				logger.warn(String.format("empty score for hotelId:%s", hotelId));
			}
		} catch (Exception e) {
			logger.error(String.format("processHotelScore by hotelId:%s; scoreVal:%s", hotelId, scoreVal),
					e);
		}
	}

	@RequestMapping(value = "/comments/loadscore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> loadScore(Integer maxHotels, String hotelId) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		if (StringUtils.isNotBlank(hotelId)) {
			processHotelScore(hotelId);
		} else {
			try {
				List<Map<String, Object>> allIds = subjectMapper.selectAllIds();

				if (allIds == null) {
					result.put("success", false);
					result.put("message", "no hotels have been selected...");

					return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
				}

				if (logger.isInfoEnabled()) {
					logger.info(String.format("about to process comments for %s hotels", allIds.size()));
				}

				Integer size = maxHotels != null ? maxHotels : allIds.size();

				for (int i = 0; i < size; i++) {
					Map<String, Object> allId = allIds.get(i);

					Long hotelIdLong = (Long) allId.get("id");

					BigDecimal scoreVal = null;
					try {
						List<Map<String, Object>> scores = commentSumMapper
								.selectScoreByOtsId(String.valueOf(hotelIdLong));

						if (scores != null && scores.size() > 0) {
							Map<String, Object> score = scores.get(0);
							scoreVal = (BigDecimal) score.get("score");
						}
					} catch (Exception e) {
						logger.error(
								String.format("failed to commentSumMapper.selectScoreByOtsId by id:%s", hotelIdLong),
								e);
						continue;
					}

					try {
						if (scoreVal != null) {
							subjectMapper.updateByHotelId(new HotelSubject(0L, Long.valueOf(hotelId), scoreVal));
						}
					} catch (Exception e) {
						logger.error(String.format("subjectMapper.updateByHotelId by hotelId:%s; scoreVal:%s", hotelId,
								scoreVal), e);
						continue;
					}

					logger.info(String.format("load score completed for %s hotels", size));
				}
			} catch (Exception ex) {
				logger.error("failed to process loadscore...", ex);

				result.put("success", false);
				return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
			}
		}

		result.put("success", true);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
}
