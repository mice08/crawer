package com.mk.crawer.web.controller;

import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.proxy.ThreadContext;
import com.mk.framework.proxy.server.ProxyServer;
import com.mk.framework.proxy.server.ProxyServerManager;
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

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Controller
public class HotelDetailController {
	private final Logger logger = LoggerFactory.getLogger(HotelDetailController.class);

	@Autowired
	private HotelDetailCrawlService hotelDetailService;

	@RequestMapping(value = "/hoteldetail", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> hoteldetail(String hotelId, String fileUrl) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			hotelDetailService.crawl(hotelId, new File(fileUrl));
		} catch (Exception ex) {
			logger.error("failed to do hotelDetailService.crawl", ex);
		}

		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/hoteldetail2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> hoteldetail(String hotelId) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			ProxyServer proxyServer = ProxyServerManager.take();
			ThreadContext.PROXY_SERVER_THREAD_LOCAL.set(proxyServer);
			hotelDetailService.crawl(hotelId);
		} catch (Exception ex) {
			logger.error("failed to do hotelDetailService.crawl", ex);
		}

		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
}
