package com.mk.crawer.web.controller;

import cn.easyproject.easyocr.EasyOCR;
import cn.easyproject.easyocr.ImageType;
import com.mk.crawer.biz.model.ots.HotelDetail;
import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.framework.UrlUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

@Controller
public class HomeController {
	private final Logger logger = Logger.getLogger(HomeController.class);

	@Autowired
	private HotelDetailCrawlService hotelDetailService;

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

	@RequestMapping(value = "/getcode", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> getCode(HttpSession httpSession) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		String url = UrlUtils.getUrl("qunar.codeapi");
		String rst1 = "";
		String rst2 = "";
		try {

			String imgPath =download(url);
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

	final private String download(String urlString){

		URLConnection con = null;
		String fileName = null;
		try {
			URL url = new URL(urlString);
			// 打开连接
			con = url.openConnection();
			//设置请求超时为5s
			con.setConnectTimeout(5*1000);
			// 输入流
			InputStream is = con.getInputStream();

			// 1K的数据缓冲
			byte[] bs = new byte[1024];
			// 读取到的数据长度
			int len;
			// 输出的文件流
			;
			Random random =new Random(47);
			fileName = "/tmp/"+"code"+random.nextInt(1000000) + new Date().getTime();
			OutputStream os = new FileOutputStream(fileName);
			// 开始读取
			while ((len = is.read(bs)) != -1) {
				os.write(bs, 0, len);
			}
			// 完毕，关闭所有链接
			os.close();
			is.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
}
