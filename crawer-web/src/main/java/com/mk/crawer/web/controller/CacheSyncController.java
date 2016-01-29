package com.mk.crawer.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.crawer.biz.servcie.CacheSyncService;

@Controller
public class CacheSyncController {
	@Autowired
	private CacheSyncService cacheSyncService;

	@RequestMapping(value = "/cache/sync", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> sync(String fromHostAndPort, String fromMasterName, String hostAndPort,
			String masterName) {
		HashMap<String, Object> result = new HashMap<String, Object>();

		try {
			cacheSyncService.sync(fromHostAndPort, fromMasterName, hostAndPort, masterName);
		} catch (Exception ex) {
			String errorMessage = String.format("failed to do cacheSyncService.sync...message:%s", ex.getMessage());
			
			result.put("success", false);
			result.put("errormessage", errorMessage);
			return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);			
		}

		result.put("success", true);
		result.put("errormessage", "");
		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
}
