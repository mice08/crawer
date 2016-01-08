package com.mk.crawer.web.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.crawer.biz.model.ots.HotelDetail;
import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.MkJedisConnectionFactory;
import com.mk.framework.UrlUtils;

import cn.easyproject.easyocr.EasyOCR;
import cn.easyproject.easyocr.ImageType;
import redis.clients.jedis.Jedis;

@Controller
public class HomeController {
	private final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private HotelDetailCrawlService hotelDetailService;

	@Autowired
	private MkJedisConnectionFactory mkFactory;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> check(HttpSession httpSession, String key) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String url = UrlUtils.getUrl(key);
		result.put("url", url);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/hoteldetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> hoteldetail(HttpServletRequest request, HotelDetail hotelDetail) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		List<String> hotelIdList = new ArrayList<String>();
		hotelIdList.add(hotelDetail.getHotelIds());

		try {
			hotelDetailService.crawl(hotelIdList);
		} catch (Exception ex) {
			logger.error("failed to do hotelDetailService.crawl", ex);
		}

		result.put("check", "123");
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/queryproxies", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> queryProxies(HttpServletRequest request) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		Jedis jedis = mkFactory.getJedis();

		try {
			String jsonStr = jedis.srandmember("crawer_proxy_server_pool_set");
			result.put("json", jsonStr);
		} catch (Exception ex) {
			logger.error(ex);
		} finally {
			if (jedis != null) {
				jedis.close();
			}
		}

		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/getcode", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getCode(HttpSession httpSession) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		String rst1 = "";
		String rst2 = "";
		try {

			String imgPath = CrawerUtils.downloadChallageCode(null);
			EasyOCR e=new EasyOCR();

			rst1 = e.discernAndAutoCleanImage(imgPath, ImageType.CAPTCHA_HOLLOW_CHAR);
			rst2 = e.discernAndAutoCleanImage(imgPath, ImageType.CAPTCHA_INTERFERENCE_LINE);
					;
		} catch (Exception e) {
			e.printStackTrace();
		}

		result.put("code1", rst1);
		result.put("code2", rst2);
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}




}
