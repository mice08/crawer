package com.mk.crawer.web.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private final Logger logger = LoggerFactory.getLogger(HotelDetailController.class);

	@Autowired
	private HotelSubjectMapper subjectMapper;

	@Autowired
	private CommentSumMapper commentSumMapper;

	@RequestMapping(value = "/comments/updatescore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> hoteldetail(String hotelId, String score) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			HotelSubject hotelSubject = new HotelSubject(Long.valueOf(hotelId), new BigDecimal(score));
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

	private void processHotelScore(String hotelId) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(String.format("about to process comments for %s hotel", hotelId));
		}

		BigDecimal scoreVal = null;
		try {
			List<Map<String, Object>> scores = commentSumMapper.selectScoreByOtsId(hotelId);

			if (scores != null && scores.size() > 0) {
				Map<String, Object> score = scores.get(0);
				scoreVal = (BigDecimal) score.get("score");
			}
		} catch (Exception e) {
			throw new Exception(String.format("failed to commentSumMapper.selectScoreByOtsId by id:%s", hotelId), e);
		}

		try {
			if (scoreVal != null) {
				if (logger.isInfoEnabled()) {
					logger.info(String.format("about to updateByHotelId hotelid:%s; scoreVal:%s", hotelId, scoreVal));
				}

				subjectMapper.updateByHotelId(new HotelSubject(Long.valueOf(hotelId), scoreVal));
			} else {
				logger.warn(String.format("empty score for hotelId:%s", hotelId));
			}
		} catch (Exception e) {
			throw new Exception(String.format("processHotelScore by hotelId:%s; scoreVal:%s", hotelId, scoreVal), e);
		}
	}

	private List<Long> convertIds(List<Map<String, Object>> allIds) {
		List<Long> allIdConverted = new ArrayList<Long>();

		for (Map<String, Object> allId : allIds) {
			Long id = (Long) allId.get("id");
			if (id != null) {
				allIdConverted.add(id);
			}
		}

		return allIdConverted;
	}
	
	@RequestMapping(value = "/comments/loadscore", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> loadScore(Integer maxHotels, String hotelId) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		if (logger.isInfoEnabled()) {
			logger.info(String.format("about to loadscore for maxHotels:%s; hotelId:%s", maxHotels, hotelId));
		}

		if (StringUtils.isNotBlank(hotelId)) {
			try {
				processHotelScore(hotelId);
			} catch (Exception ex) {
				logger.error("failed to processHotelScore...", ex);

				result.put("success", false);
				result.put("errorMessage", "failed to processHotelScore...");
				return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
			}
		} else {
			try {
				List<Long> allOtsHotelIds = convertIds(commentSumMapper.selectOtsHotelId());

				List<Long> allHotelIds = convertIds(subjectMapper.selectAllIds());

				if (allHotelIds == null || allHotelIds.size() == 0) {
					result.put("success", false);
					result.put("message", "no hotels have been selected for allOtsHotelIds...");

					return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
				}

				if (allOtsHotelIds == null || allOtsHotelIds.size() == 0) {
					result.put("success", false);
					result.put("message", "no hotels have been selected for allOtsHotelIds...");

					return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
				}

				if (logger.isInfoEnabled()) {
					logger.info(String.format("about to process comments for %s hotels", allHotelIds.size()));
				}

				Integer size = maxHotels != null ? maxHotels : allOtsHotelIds.size();

				for (int i = 0; i < size; i++) {
					Long otsId = allOtsHotelIds.get(i);

					BigDecimal scoreVal = null;
					try {
						List<Map<String, Object>> scores = commentSumMapper.selectScoreByOtsId(String.valueOf(otsId));

						if (scores != null && scores.size() > 0) {
							Map<String, Object> score = scores.get(0);
							scoreVal = (BigDecimal) score.get("score");
						}
					} catch (Exception e) {
						logger.error(String.format("failed to commentSumMapper.selectScoreByOtsId by id:%s", otsId), e);
						continue;
					}

					try {
						if (scoreVal != null) {
							if (allHotelIds.contains(otsId)) {
								if (logger.isInfoEnabled()) {
									logger.info(String.format("about to updateByHotelId otsId:%s scoreVal:%s", otsId,
											scoreVal));
								}

								subjectMapper.updateByHotelId(new HotelSubject(Long.valueOf(otsId), scoreVal));
							} else {
								if (logger.isInfoEnabled()) {
									logger.info(String.format("about to insert otsId:%s scoreVal:%s", otsId, scoreVal));
								}

								subjectMapper.insert(new HotelSubject(Long.valueOf(otsId), scoreVal));
							}
						}
					} catch (Exception e) {
						logger.error(String.format("subjectMapper.updateByHotelId by hotelId:%s; scoreVal:%s", hotelId,
								scoreVal), e);
						continue;
					}
				}

				logger.info(String.format("load score completed for %s hotels", size));
			} catch (Exception ex) {
				logger.error("failed to process loadscore...", ex);

				result.put("success", false);
				result.put("errorMessage", "failed to process loadscore...");
				return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
			}
		}

		result.put("success", true);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
}
