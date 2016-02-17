package com.mk.crawer.biz.servcie.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mk.crawer.biz.mapper.crawer.*;
import com.mk.crawer.biz.model.crawer.*;
import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.framework.proxy.http.HttpUtil;
import org.apache.commons.io.FileUtils;
import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

@Service
public class HotelDetailCrawlServiceImpl implements HotelDetailCrawlService {

	private final String hotelDetailUrl = "http://pad.qunar.com/api/hotel/hoteldetail?checkInDate=%s&checkOutDate=%s&keywords=&location=&seq=%s&clickNum=0&isLM=0&type=0";

	private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(HotelDetailCrawlServiceImpl.class);

	private final Gson gson = new Gson();

	@Autowired
	private HotelSurroundMapper hotelSurroundMapper;

	@Autowired
	private HotelFacilitiesMapper hotelFacilitiesMapper;

	@Autowired
	private RoomTypeMapper roomtypeMapper;

	@Autowired
	private RoomTypePriceMapper roomtypePriceMapper;

	@Autowired
	private RoomTypeDescMapper roomtypeDescMapper;

	@Autowired
	private CommentSumMapper commentSumMapper;

	@Autowired
	private CommentMapper commentMapper;

	@Autowired
	private CommentImgMapper commentImgMapper;

	@Autowired
	private QunarHotelMapper qunarHotelMapper;

	@Autowired
	private HotelImageService hotelImageService;



	public void crawl(String hotelId, File hotelDetailFile) throws Exception {
		List<String> hotelIds = new ArrayList<String>();
		if (!StringUtils.isBlank(hotelId)) {
			hotelIds.add(hotelId);
		}

		String jsonData = "";

		try {
			jsonData = FileUtils.readFileToString(hotelDetailFile);
		} catch (Exception ex) {
			throw new Exception("failed to readfile from...", ex);
		}
		processResult(hotelId, jsonData);
	}

	@Override
	public void crawl(String hotelId) throws Exception {
		List<String> hotelIds = new ArrayList<String>();
		if (!StringUtils.isBlank(hotelId)) {
			hotelIds.add(hotelId);
		}

		this.crawl(hotelIds);
	}

	@Override
	public void crawl(List<String> hotelIds) throws Exception {

		Date day = new Date();
		String strCurDay = DateUtils.getStringFromDate(day, DateUtils.FORMATSHORTDATETIME);
		String strNextDay = DateUtils.getStringFromDate(DateUtils.addDays(day, 1), DateUtils.FORMATSHORTDATETIME);

		String hotelid = hotelIds.get(0);

		logger.info("++++++++++++++++++++++++bengin crawl hotel" + hotelid + " ++++++++++++++++++");
		String invokeUrl = String.format(hotelDetailUrl, strCurDay, strNextDay, hotelid);

		if (logger.isDebugEnabled()) {
			logger.debug(invokeUrl);
		}

		String jsonString = "";
		try {
			hotelImageService.crawl(hotelid, true);
			jsonString = HttpUtil.doGet(invokeUrl);
		} catch (Exception ex) {
			String errorMsg = String.format("failed to post with url %s", invokeUrl);
			logger.error(errorMsg, ex);
			throw new Exception(errorMsg, ex.getCause());
		}

		processResult(hotelid, jsonString);


	}

	private void processResult(String hotelid, String jsonString) throws Exception {
		Date beforeTime = new Date();

		HotelCombination hotelComb = this.parseJson(hotelid, jsonString);

		try {
			persistRoomtypeCombs(hotelComb.getRoomtypeCombs());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to persistRoomtypeCombs in hotelid %s", hotelid);
			logger.error(errorMsg, ex);
			throw new Exception(errorMsg, ex.getCause());
		}

		try {
			persistHotelFacilities(hotelComb.getHotelfacilities());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to persistHotelFacilities in hotelid %s", hotelid);
			logger.error(errorMsg, ex);
		}

		try {
			persistHotelInfo(hotelComb.getHotelInfo());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to persistHotelInfo in hotelid %s", hotelid);
			logger.error(errorMsg, ex);
		}

		try {
			persistHotelSurround(hotelComb.getHotelSurrounds());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to persistHotelSurround in hotelid %s", hotelid);
			logger.error(errorMsg, ex);
		}

		try {
			persistCommentComb(hotelComb.getCommentComb());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to persistCommentSum in hotelid %s", hotelid);
			logger.error(errorMsg, ex);
		}

		Date endTime = new Date();
		if (logger.isDebugEnabled()) {
			logger.debug(String.format("takes %s seconds to finish crawlling hotelid:%s",
					DateUtils.diffSecond(beforeTime, endTime), hotelid));
		}

	}

	@SuppressWarnings("unchecked")
	private HotelCombination parseJson(String hotelid, String json) throws Exception {
		Map<String, Object> jsonContent = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());
		HotelCombination hotelComb = new HotelCombination();

		for (String key : jsonContent.keySet()) {
			Object jsonNode = jsonContent.get(key);

			if ("status".equals(key)) {
				if (jsonNode == null || !Double.class.isAssignableFrom(jsonNode.getClass())
						|| ((Double) jsonNode) != 0) {
					logger.warn(String.format("invalid status %s received...", jsonNode));
				}
			}

			if ("data".equals(key)) {
				if (jsonNode != null && Map.class.isAssignableFrom(jsonNode.getClass())) {
					try {
						List<RoomTypeCombination> roomtypeCombs = parseDataNodeForRoomtype(hotelid,
								(Map<String, Object>) jsonNode);

						if (roomtypeCombs != null) {
							hotelComb.setRoomtypeCombs(roomtypeCombs);
						}
					} catch (Exception ex) {
						logger.error(String.format("failed to parse roomtypes for hotelid:%s", hotelid), ex);
					}

					try {
						CommentCombination commentComb = parseDataNodeForCommentSum(hotelid,
								(Map<String, Object>) jsonNode);

						if (commentComb != null) {
							hotelComb.setCommentComb(commentComb);
							hotelid = commentComb.getCommentSum().getHotelSourceId();
						}
					} catch (Exception ex) {
						logger.error(String.format("failed to parse hotelSurrounds for hotelid:%s", hotelid), ex);
					}

					try {
						List<HotelFacilities> hotelFacilities = parseDataNodeForHotelFacilities(hotelid,
								(Map<String, Object>) jsonNode);

						if (hotelFacilities != null) {
							hotelComb.setHotelfacilities(hotelFacilities);
						}
					} catch (Exception ex) {
						logger.error(String.format("failed to parse hotelSurrounds for hotelid:%s", hotelid), ex);
					}

					try {
						QunarHotel hotelInfo = parseDataNodeForHotelInfo(hotelid, (Map<String, Object>) jsonNode);

						if (hotelInfo != null) {
							hotelComb.setHotelInfo(hotelInfo);
						}
					} catch (Exception ex) {
						logger.error(String.format("failed to parse hotelSurrounds for hotelid:%s", hotelid), ex);
					}

					try {
						List<HotelSurround> hotelSurrounds = parseDataNodeForHotelSurrounds(hotelid,
								(Map<String, Object>) jsonNode);

						if (hotelSurrounds != null) {
							hotelComb.setHotelSurrounds(hotelSurrounds);
						}
					} catch (Exception ex) {
						logger.error(String.format("failed to parse hotelSurrounds for hotelid:%s", hotelid), ex);
					}

				} else {
					logger.warn("invalid data node received, skip...");
					continue;
				}
			}
		}

		return hotelComb;
	}

	/**
	 * with no transaction intentionally,
	 * <p>
	 * data may have integrity issue
	 * 
	 * @param hotelFacilities
	 * @throws Exception
	 */
	private void persistHotelFacilities(List<HotelFacilities> hotelFacilities) throws Exception {
		for (HotelFacilities hotelFacility : hotelFacilities) {
			try {
				hotelFacilitiesMapper.insert(hotelFacility);
			} catch (Exception ex) {
				logger.error("failed to hotelFacilitiesMapper.insert", ex);
			}
		}
	}

	private void persistHotelInfo(QunarHotel hotel) throws Exception {
		try {
			if (StringUtils.isNotBlank(hotel.getSourceId())) {
				qunarHotelMapper.updateByHotelSourceId(hotel);
			}
		} catch (Exception ex) {
			logger.error("failed to qunarHotelMapper.updateByPrimaryKeySelective", ex);
		}
	}

	/**
	 * with no transaction intentionally,
	 * <p>
	 * data may have integrity issue
	 * 
	 * @param roomtypeCombs
	 * @throws Exceptio
	 */
	private void persistHotelSurround(List<HotelSurround> hotelSurrounds) throws Exception {
		for (HotelSurround hotelSurround : hotelSurrounds) {
			try {
				hotelSurroundMapper.insert(hotelSurround);
			} catch (Exception ex) {
				logger.error("failed to hotelSurroundMapper.insert", ex);
			}
		}
	}

	private void persistCommentComb(CommentCombination commentComb) throws Exception {
		commentComb.getCommentDetails();
		CommentSum commentSum = commentComb.getCommentSum();

		try {
			commentSumMapper.insert(commentSum);
		} catch (Exception ex) {
			logger.error("failed to insert comment sum...", ex);
		}

		for (Comment comment : commentComb.getCommentDetails().keySet()) {
			try {
				commentMapper.insert(comment);

				List<CommentImg> commentImgs = commentComb.getCommentDetails().get(comment);
				for (CommentImg commentImg : commentImgs) {
					commentImgMapper.insert(commentImg);
				}
			} catch (Exception ex) {
				logger.error(
						String.format("failed to insert comment for hotel:%s, skip...", commentSum.getHotelSourceId()),
						ex.getCause());
			}
		}
	}

	/**
	 * with no transaction intentionally,
	 * <p>
	 * data may have integrity issue
	 * 
	 * @param roomtypeCombs
	 * @throws Exception
	 */
	private boolean persistRoomtypeCombs(List<RoomTypeCombination> roomtypeCombs) throws Exception {
		boolean isUpdateRequired = false;

		for (RoomTypeCombination roomtypeComb : roomtypeCombs) {
			RoomType roomtype = roomtypeComb.getRoomtype();
			List<RoomTypeDesc> roomtypeDescs = roomtypeComb.getRoomtypeDescs();
			List<RoomTypePrice> roomtypePrices = roomtypeComb.getRoomtypePrices();
			List<RoomTypeImg> roomtypeImgs = roomtypeComb.getRoomtypeImgs();

			boolean isRoomtypeUpdateRequired = false;

			try {
				Map<String, Object> parameters = new HashMap<>();
				parameters.put("roomtypeKey", roomtype.getRoomtypeKey());
				parameters.put("hotelSourceId", roomtype.getHotelSourceId());
				logger.info("_________________start crawl roomtype" + roomtype.getHotelSourceId()
						+ "______________________");

				List<RoomType> roomtypes = roomtypeMapper.selectByKeys(parameters);
				if (roomtypes != null && roomtypes.size() > 0) {
					isUpdateRequired = true;
					isRoomtypeUpdateRequired = true;
				} else {
					isUpdateRequired = false;
					isRoomtypeUpdateRequired = false;
				}
			} catch (Exception ex) {
				logger.warn(String.format("failed to detection duplication for roomtypeKey:%s; hotelSourceId:%s",
						roomtype.getRoomtypeKey(), roomtype.getHotelSourceId()), ex);

				isUpdateRequired = false;
				isRoomtypeUpdateRequired = false;
			}

			if (!isRoomtypeUpdateRequired) {
				try {
					roomtypeMapper.insert(roomtype);
				} catch (Exception ex) {
					logger.error("failed to roomtypeMapper.insert", ex);
				}

				if (roomtypeDescs != null) {
					for (RoomTypeDesc roomtypeDesc : roomtypeDescs) {
						try {
							roomtypeDescMapper.insert(roomtypeDesc);
						} catch (Exception ex) {
							logger.error("failed to roomtypeDescMapper.insert", ex);
						}
					}
				}
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug(String.format("update roomtype %s", roomtype.getRoomtypeKey()));
				}
			}

			if (roomtypeImgs != null) {
				for (RoomTypeImg roomtypeImg : roomtypeImgs) {
					Map<String, Object> roomtypeImgMap = new HashMap<String, Object>();
					roomtypeImgMap.put("title", roomtypeImg.getTitle());
					roomtypeImgMap.put("author", roomtypeImg.getAuthor());
					roomtypeImgMap.put("baseUrl", roomtypeImg.getBaseUrl());
					roomtypeImgMap.put("hotelSourceId", roomtypeImg.getHotelSourceId());
					roomtypeImgMap.put("roomtypeKey", roomtypeImg.getRoomtypeKey());

					try {
						roomtypeMapper.insertImg(roomtypeImgMap);
					} catch (Exception ex) {
						logger.error("failed to roomtypeMapper.insertImg", ex);
					}
				}
			}
			
			if (roomtypePrices != null) {
				for (RoomTypePrice roomtypePrice : roomtypePrices) {
					try {
						if (isRoomtypeUpdateRequired) {
							roomtypePrice.setUpdateTime(new Date());
						}
						roomtypePriceMapper.insert(roomtypePrice);
					} catch (Exception ex) {
						logger.error("failed to roomtypePriceMapper.insert", ex);
					}
				}
			}

		}

		return isUpdateRequired;
	}

	@SuppressWarnings("unchecked")
	private CommentCombination parseDataNodeForCommentSum(String hotelid, Map<String, Object> dataNode) {
		CommentCombination commentComb = new CommentCombination();

		CommentSum commentSum = new CommentSum();
		Map<Comment, List<CommentImg>> commentDetails = new HashMap<Comment, List<CommentImg>>();

		commentComb.setCommentSum(commentSum);
		commentComb.setCommentDetails(commentDetails);

		String hotelSourceId = "";
		if (dataNode.get("comment") != null && Map.class.isAssignableFrom(dataNode.get("comment").getClass())) {
			Map<String, Object> commentNode = (Map<String, Object>) dataNode.get("comment");

			if (commentNode.get("comment") != null
					&& List.class.isAssignableFrom(commentNode.get("comment").getClass())) {
				List<Map<String, Object>> commentsDetails = (List<Map<String, Object>>) commentNode.get("comment");

				for (Map<String, Object> commentsDetail : commentsDetails) {
					Comment comment = new Comment();

					comment.setContent(typesafeGetString(commentsDetail.get("content")));
					comment.setDate(typesafeGetString(commentsDetail.get("date")));
					comment.setGid(typesafeGetString(commentsDetail.get("gid")));

					if (StringUtils.isBlank(hotelSourceId)
							&& StringUtils.isNotBlank(typesafeGetString(commentsDetail.get("hotelSeq")))) {
						hotelSourceId = typesafeGetString(commentsDetail.get("hotelSeq"));
					}

					comment.setHotelSourceId(hotelSourceId);
					comment.setCommentId(typesafeGetString(commentsDetail.get("commentId")));
					comment.setScore(typesafeGetBigDecimal(commentsDetail.get("score")));
					comment.setTitle(typesafeGetString(commentsDetail.get("title")));
					comment.setAuthor(typesafeGetString(commentsDetail.get("author")));

					comment.setClickUsefulStatus(typesafeGetString(commentsDetail.get("clickUsefulStatus")));
					comment.setNumOfUseful(typesafeGetDouble(commentsDetail.get("numofUseful")).longValue());
					comment.setReplyNum(typesafeGetDouble(commentsDetail.get("replyNum")).longValue());
					comment.setCuid(typesafeGetString(commentsDetail.get("cuid")));
					comment.setEnc(typesafeGetString(commentsDetail.get("enc")));

					if (!commentDetails.containsKey(comment)) {
						commentDetails.put(comment, new ArrayList<CommentImg>());
					}

					List<CommentImg> commentImgs = commentDetails.get(comment);
					if (commentsDetail.get("imgs") != null
							&& List.class.isAssignableFrom(commentsDetail.get("imgs").getClass())) {
						List<Map<String, Object>> imgDetails = (List<Map<String, Object>>) commentsDetail.get("imgs");

						for (Map<String, Object> imgDetail : imgDetails) {
							CommentImg commentImg = new CommentImg();
							commentImgs.add(commentImg);

							commentImg.setCommentId(typesafeGetBigDecimal(imgDetail.get("commentId")).longValue());
							commentImg.setHotelSourceId(hotelSourceId);
							commentImg.setUrl(typesafeGetString(imgDetail.get("url")));
							commentImg.setTag(typesafeGetString(imgDetail.get("tag")));
							commentImg.setTitle(typesafeGetString(imgDetail.get("title")));
							commentImg.setSmallUrl(typesafeGetString(imgDetail.get("smallUrl")));
							commentImg.setSrc(typesafeGetString(imgDetail.get("src")));
						}
					}
				}
			}

			commentSum.setHotelName(typesafeGetString(commentNode.get("hotelName")));
			commentSum.setHotelSourceId(hotelid);
			commentSum.setScore(typesafeGetBigDecimal(commentNode.get("score")));
			commentSum.setScoreShopMsg(typesafeGetString(commentNode.get("scoreShopMsg")));
			commentSum.setScoreShopUrl(typesafeGetString(commentNode.get("scoreShopURL")));
			commentSum.setGoodTotal(typesafeGetBigDecimal(commentNode.get("goodTotal")).longValue());
			commentSum.setBadTotal(typesafeGetBigDecimal(commentNode.get("badTotal")).longValue());
			commentSum.setMediumTotal(typesafeGetBigDecimal(commentNode.get("mediumTotal")).longValue());
			commentSum.setAllTotal(typesafeGetBigDecimal(commentNode.get("allTotal")).longValue());
			commentSum.setSentenceCmt(typesafeGetString(commentNode.get("onSentenceCmt")));
			commentSum.setMsg(typesafeGetString(commentNode.get("msg")));

			if (commentNode.get("hotTitles") != null
					&& List.class.isAssignableFrom(commentNode.get("hotTitles").getClass())) {
				List<String> hotTitles = (List<String>) commentNode.get("hotTitles");
				if (hotTitles != null && hotTitles.size() > 0) {
					commentSum.setHotTitles(gson.toJson(hotTitles, new TypeToken<List<String>>() {
					}.getType()));
				}
			}

			if (commentNode.get("tagList") != null
					&& List.class.isAssignableFrom(commentNode.get("tagList").getClass())) {
				List<Map<String, Object>> tagList = (List<Map<String, Object>>) commentNode.get("tagList");
				if (tagList != null && tagList.size() > 0) {
					commentSum.setTags(gson.toJson(tagList, new TypeToken<List<Map<String, Object>>>() {
					}.getType()));
				}
			}
		}

		return commentComb;
	}

	@SuppressWarnings("unchecked")
	private List<HotelFacilities> parseDataNodeForHotelFacilities(String hotelid, Map<String, Object> dataNode)
			throws HotelDetailParseException {
		List<HotelFacilities> hotelFacilities = new ArrayList<HotelFacilities>();

		if (dataNode.get("dinfo") != null && Map.class.isAssignableFrom(dataNode.get("dinfo").getClass())) {
			Map<String, Object> dinfo = (Map<String, Object>) dataNode.get("dinfo");

			if (dinfo.get("facilities") != null && List.class.isAssignableFrom(dinfo.get("facilities").getClass())) {
				List<Map<String, Object>> facilities = (List<Map<String, Object>>) dinfo.get("facilities");

				for (Map<String, Object> facility : facilities) {
					String surroundType = typesafeGetString(facility.get("type"));

					if (facility.get("datas") != null
							&& List.class.isAssignableFrom(facility.get("datas").getClass())) {
						List<Map<String, Object>> datas = (List<Map<String, Object>>) facility.get("datas");

						for (Map<String, Object> data : datas) {
							HotelFacilities hotelFacility = new HotelFacilities();
							hotelFacility.setHotelSourceId(hotelid);
							hotelFacility.setType(surroundType);
							hotelFacility.setShortName(typesafeGetString(data.get("shortName")));
							hotelFacility.setHighStarSort(typesafeGetDouble(data.get("highStarSort")).longValue());
							hotelFacility.setIconBigUrl(typesafeGetString(data.get("iconBig")));
							hotelFacility.setLowStarSort(typesafeGetDouble(data.get("lowStartSort")).longValue());
							hotelFacility.setOverseaSort(typesafeGetDouble(data.get("overseasSort")).longValue());
							hotelFacility.setColor(typesafeGetDouble(data.get("color")).longValue());
							hotelFacility.setDisplay(typesafeGetString(data.get("display")));
							hotelFacility.setIconUrl(typesafeGetString(data.get("iconUrl")));
							hotelFacility.setItem(typesafeGetString(data.get("item")));
							hotelFacility.setField(typesafeGetString(data.get("field")));

							hotelFacilities.add(hotelFacility);
						}
					}

				}
			}
		}

		return hotelFacilities;
	}

	private QunarHotel parseDataNodeForHotelInfo(String hotelid, Map<String, Object> dataNode)
			throws HotelDetailParseException {
		QunarHotel hotelInfo = new QunarHotel();

		if (dataNode.get("dinfo") != null && Map.class.isAssignableFrom(dataNode.get("dinfo").getClass())) {
			@SuppressWarnings("unchecked")
			Map<String, Object> dinfo = (Map<String, Object>) dataNode.get("dinfo");

			String name = (String) dinfo.get("name");
			String phone = (String) dinfo.get("phone");
			String desc = (String) dinfo.get("desc");
			String city = (String) dinfo.get("city");
			String score = (String) dinfo.get("score");
			String area = (String) dinfo.get("area");
			String gpoint = (String) dinfo.get("gpoint");
			Integer dangci = Integer.valueOf((String) dinfo.get("dangci"));
			String whenFitment = (String) dinfo.get("whenFitment");
			String addr = (String) dinfo.get("add");
			String btime = (String) dinfo.get("btime");
			String hotelSeq = (String) dinfo.get("hotelSeq");
			String rnum = (String) dinfo.get("rnum");
			if (StringUtils.isNotBlank(name)) {
				hotelInfo.setHotelName(name);
			}

			if (StringUtils.isNotBlank(hotelSeq)) {
				hotelInfo.setSourceId(hotelSeq);
			}

			if (StringUtils.isNotBlank(addr)) {
				hotelInfo.setHotelAddress(addr);
			}

			if (StringUtils.isNotBlank(btime)) {
				hotelInfo.setWhenBuilt(btime);
			}

			if (StringUtils.isNotBlank(city)) {
				hotelInfo.setCityName(city);
			}

			if (dangci != null) {
				hotelInfo.setDangci(dangci);

			}

			if (StringUtils.isNotBlank(gpoint)) {
				hotelInfo.setGpoint(gpoint);
			}

			if (StringUtils.isNotBlank(phone)) {
				hotelInfo.setPhoneNumber(phone);
			}

			if (StringUtils.isNotBlank(desc)) {
				hotelInfo.setDesc(desc);
			}

			if (StringUtils.isNotBlank(score)) {
				hotelInfo.setCommentScore(new BigDecimal(score));
			}
			if (StringUtils.isNotBlank(whenFitment)) {
				hotelInfo.setWhenFitment(whenFitment);
			}

			if (StringUtils.isNotBlank(area)) {
				hotelInfo.setHotelArea(area);
			}

			if (StringUtils.isNotBlank(rnum)){
				hotelInfo.setRnum(rnum);
			}

		}

		return hotelInfo;
	}

	@SuppressWarnings("unchecked")
	private List<HotelSurround> parseDataNodeForHotelSurrounds(String hotelid, Map<String, Object> dataNode)
			throws HotelDetailParseException {
		List<HotelSurround> hotelSurrounds = new ArrayList<HotelSurround>();

		if (dataNode.get("traffic") != null && List.class.isAssignableFrom(dataNode.get("traffic").getClass())) {
			List<Map<String, Object>> traffics = (List<Map<String, Object>>) dataNode.get("traffic");

			for (Map<String, Object> traffic : traffics) {
				HotelSurround hotelSurround = new HotelSurround();

				hotelSurround.setType("traffic");
				hotelSurround.setDistance(typesafeGetString(traffic.get("distance")));
				hotelSurround.setGpoint(typesafeGetString(traffic.get("gpoint")));
				hotelSurround.setSurroundName(typesafeGetString(traffic.get("name")));
				hotelSurround.setHotelSourceId(hotelid);
				hotelSurrounds.add(hotelSurround);
			}
		}

		if (dataNode.get("park") != null && List.class.isAssignableFrom(dataNode.get("park").getClass())) {
			List<Map<String, Object>> parks = (List<Map<String, Object>>) dataNode.get("park");

			for (Map<String, Object> park : parks) {
				HotelSurround hotelSurround = new HotelSurround();

				hotelSurround.setType("park");
				hotelSurround.setDistance(typesafeGetString(park.get("distance")));
				hotelSurround.setGpoint(typesafeGetString(park.get("gpoint")));
				hotelSurround.setSurroundName(typesafeGetString(park.get("name")));
				hotelSurround.setHotelSourceId(hotelid);
				hotelSurrounds.add(hotelSurround);
			}
		}

		if (dataNode.get("restaurant") != null && List.class.isAssignableFrom(dataNode.get("restaurant").getClass())) {
			List<Map<String, Object>> restaurants = (List<Map<String, Object>>) dataNode.get("restaurant");

			for (Map<String, Object> restaurant : restaurants) {
				HotelSurround hotelSurround = new HotelSurround();

				hotelSurround.setType("restaurant");
				hotelSurround.setDistance(typesafeGetString(restaurant.get("distance")));
				hotelSurround.setGpoint(typesafeGetString(restaurant.get("gpoint")));
				hotelSurround.setSurroundName(typesafeGetString(restaurant.get("name")));
				hotelSurround.setHotelSourceId(hotelid);
				hotelSurrounds.add(hotelSurround);
			}
		}

		if (dataNode.get("ent") != null && List.class.isAssignableFrom(dataNode.get("ent").getClass())) {
			List<Map<String, Object>> ents = (List<Map<String, Object>>) dataNode.get("ent");

			for (Map<String, Object> ent : ents) {
				HotelSurround hotelSurround = new HotelSurround();

				hotelSurround.setType("ent");
				hotelSurround.setDistance(typesafeGetString(ent.get("distance")));
				hotelSurround.setGpoint(typesafeGetString(ent.get("gpoint")));
				hotelSurround.setSurroundName(typesafeGetString(ent.get("name")));
				hotelSurround.setHotelSourceId(hotelid);
				hotelSurrounds.add(hotelSurround);
			}
		}

		return hotelSurrounds;
	}

	@SuppressWarnings("unchecked")
	private List<RoomTypeCombination> parseDataNodeForRoomtype(String hotelid, Map<String, Object> dataNode)
			throws HotelDetailParseException {
		List<RoomTypeCombination> combinations = new ArrayList<RoomTypeCombination>();

		if (dataNode.containsKey("rooms")) {
			if (dataNode.get("rooms") != null && List.class.isAssignableFrom(dataNode.get("rooms").getClass())) {
				List<Map<String, Object>> rooms = (List<Map<String, Object>>) dataNode.get("rooms");
				for (Map<String, Object> room : rooms) {
					RoomTypeCombination roomtypeComb = null;

					String roomtypeKey = "";
					if (room.containsKey("key") && room.get("key") != null
							&& String.class.isAssignableFrom(room.get("key").getClass())) {
						roomtypeKey = (String) room.get("key");
					}

					try {
						roomtypeComb = parseRoomtypeComb(hotelid, room);
					} catch (Exception ex) {
						logger.warn(String.format("failed to parse roomtypecomb for key %s", roomtypeKey), ex);
					}

					if (roomtypeComb != null) {
						combinations.add(roomtypeComb);
					}
				}
			} else {
				logger.warn(String.format("invalid rooms class in hotelid:%s", hotelid));
			}
		} else {
			logger.warn(String.format("no rooms found in hotelid:%s", hotelid));
		}

		return combinations;
	}

	private String typesafeGetString(Object attribute) {
		String attrVal = "";

		if (attribute != null && String.class.isAssignableFrom(attribute.getClass())) {
			attrVal = (String) attribute;
		} else if (attribute != null && Double.class.isAssignableFrom(attribute.getClass())) {
			attrVal = String.valueOf((Double) attribute);
		}

		return attrVal;
	}

	private Double typesafeGetDouble(Object attribute) {
		Double attrVal = 0.0;

		if (attribute != null && Double.class.isAssignableFrom(attribute.getClass())) {
			attrVal = (Double) attribute;
		}

		return attrVal;
	}

	private BigDecimal typesafeGetBigDecimal(Object attribute) {
		if (attribute != null && Double.class.isAssignableFrom(attribute.getClass())) {
			Double attrVal = (Double) attribute;

			try {
				return BigDecimal.valueOf(attrVal);
			} catch (Exception ex) {
				return new BigDecimal(0);
			}
		} else if (attribute != null && String.class.isAssignableFrom(attribute.getClass())) {
			String attrVal = (String) attribute;

			try {
				return BigDecimal.valueOf(Double.parseDouble(attrVal));
			} catch (Exception ex) {
				return new BigDecimal(0);
			}
		}

		return new BigDecimal(0);
	}

	private String getValueFromUrlByName(Object url, String name) {
		Map<String, String> params = new HashMap<>();

		if (url != null && String.class.isAssignableFrom(url.getClass())) {
			String urlStr = (String) url;

			String[] temp1 = urlStr.split("\\?");
			if (temp1.length == 2) {
				for (String kv : temp1[1].split("&")) {
					String[] temp2 = kv.split("=");
					if (temp2.length == 2) {
						params.put(temp2[0], temp2[1]);
					}
				}
			}
		}

		return params.get(name);
	}

	@SuppressWarnings("unchecked")
	private RoomTypeCombination parseRoomtypeComb(String hotelid, Map<String, Object> roomComb)
			throws HotelDetailParseException {
		RoomTypeCombination roomtypeComb = new RoomTypeCombination();

		RoomType roomtype = new RoomType();
		roomtypeComb.setRoomtype(roomtype);

		String roomtypeKey = typesafeGetString(roomComb.get("key"));

		roomtype.setRoomtypeKey(typesafeGetString(roomComb.get("key")));
		roomtype.setHotelSourceId(hotelid);
		roomtype.setCount(typesafeGetDouble(roomComb.get("count")).longValue());
		roomtype.setRoomName(typesafeGetString(roomComb.get("roomName")));
		roomtype.setRoomType(typesafeGetDouble(roomComb.get("roomType")).toString());
		roomtype.setArea(typesafeGetString(roomComb.get("area")));
		roomtype.setCurrencySign(typesafeGetString(roomComb.get("currencySign")));
		roomtype.setMprice(typesafeGetBigDecimal(roomComb.get("mprice")));
		roomtype.setHasQuickCheckIn(typesafeGetString(roomComb.get("hasQuickCheckIn")));
		roomtype.setNetworkPrice(typesafeGetString(roomComb.get("netWorkPrice")));
		roomtype.setHaveCoupons(typesafeGetString(roomComb.get("haveConpons")));
		roomtype.setRoominfoDesc(typesafeGetString(roomComb.get("roomInfoDesc")));
		roomtype.setOuterShow(typesafeGetString(roomComb.get("outerShow")));
		roomtype.setRoomOrderCount(typesafeGetDouble(roomComb.get("roomOrderCount")).longValue());
		roomtype.setHasTuangou(typesafeGetDouble(roomComb.get("hasTuangou")).toString());

		if (roomComb.containsKey("rtDescInfo") && roomComb.get("rtDescInfo") != null
				&& Map.class.isAssignableFrom(roomComb.get("rtDescInfo").getClass())) {
			Map<String, Object> rtDescInfo = (Map<String, Object>) roomComb.get("rtDescInfo");

			roomtype.setOuterShow(typesafeGetString(rtDescInfo.get("outerShow")));
			roomtype.setRtArea(typesafeGetString(rtDescInfo.get("rtArea")));
			roomtype.setRtFloor(typesafeGetString(rtDescInfo.get("rtFloor")));
			roomtype.setRtBroadband(typesafeGetString(rtDescInfo.get("rtBroadband")));
			roomtype.setRtBedtype(typesafeGetString(rtDescInfo.get("rtBedType")));
			roomtype.setRtAddbed(typesafeGetString(rtDescInfo.get("rtAddbed")));
			roomtype.setBath(typesafeGetString(rtDescInfo.get("bath")));
			roomtype.setWindow(typesafeGetString(rtDescInfo.get("window")));
			roomtype.setWifi(typesafeGetString(rtDescInfo.get("wifi")));
			roomtype.setMaxCustomers(typesafeGetDouble(rtDescInfo.get("maxCustomers")).longValue());
			roomtype.setAddBedPrice(typesafeGetDouble(rtDescInfo.get("addBedPrice")).longValue());
			roomtype.setRoomCategory(typesafeGetString(rtDescInfo.get("roomCategory")));
		}

		Object rtDesc1 = roomComb.get("rtDesc1");
		Object rtDesc2 = roomComb.get("rtDesc2");

		List<RoomTypeDesc> roomtypeDescs = new ArrayList<RoomTypeDesc>();
		roomtypeComb.setRoomtypeDescs(roomtypeDescs);

		if (rtDesc1 != null && List.class.isAssignableFrom(rtDesc1.getClass())) {
			List<Map<String, Object>> desc1 = (List<Map<String, Object>>) rtDesc1;
			for (Map<String, Object> desc : desc1) {
				RoomTypeDesc roomtypeDesc = new RoomTypeDesc();

				roomtypeDesc.setTitle(typesafeGetString(desc.get("title")));
				roomtypeDesc.setContent(typesafeGetString(desc.get("content")));
				roomtypeDesc.setRoomTypeKey(roomtypeKey);
				roomtypeDesc.setHotelSourceId(hotelid);

				roomtypeDescs.add(roomtypeDesc);
			}
		}

		if (rtDesc2 != null && List.class.isAssignableFrom(rtDesc2.getClass())) {
			List<Map<String, Object>> desc2 = (List<Map<String, Object>>) rtDesc2;
			for (Map<String, Object> desc : desc2) {
				RoomTypeDesc roomtypeDesc = new RoomTypeDesc();

				roomtypeDesc.setTitle(typesafeGetString(desc.get("title")));
				roomtypeDesc.setContent(typesafeGetString(desc.get("content")));
				roomtypeDesc.setRoomTypeKey(roomtypeKey);
				roomtypeDesc.setHotelSourceId(hotelid);

				roomtypeDescs.add(roomtypeDesc);
			}
		}

		if (roomComb.containsKey("vendors") && roomComb.get("vendors") != null
				&& List.class.isAssignableFrom(roomComb.get("vendors").getClass())) {
			List<Map<String, Object>> vendors = (List<Map<String, Object>>) roomComb.get("vendors");

			List<RoomTypePrice> roomtypePrices = new ArrayList<RoomTypePrice>();
			roomtypeComb.setRoomtypePrices(roomtypePrices);
			for (Map<String, Object> vendor : vendors) {
				RoomTypePrice roomtypePrice = new RoomTypePrice();
				roomtypePrices.add(roomtypePrice);

				roomtypePrice.setPrice(typesafeGetBigDecimal(getValueFromUrlByName(vendor.get("orderInfoBook"), "retailPrice")));
				roomtypePrice.setOprice(typesafeGetBigDecimal(getValueFromUrlByName(vendor.get("orderInfoBook"), "priceCut")));
				roomtypePrice.setRealPrice(typesafeGetBigDecimal(vendor.get("realPrice")));
				roomtypePrice.setOriginPrice(roomtypePrice.getPrice().add(roomtypePrice.getOprice()));
				roomtypePrice.setShowPrice(typesafeGetBigDecimal(vendor.get("showPrice")));
				roomtypePrice.setOtaShowPrice(typesafeGetBigDecimal(vendor.get("otaShowPrice")));
				roomtypePrice.setWrapperName(typesafeGetString(vendor.get("wrapperName")));
				roomtypePrice.setWrapperId(typesafeGetString(vendor.get("wrapperid")));
				roomtypePrice.setRoomTypeKey(roomtypeKey);
				roomtypePrice.setHotelSourceId(hotelid);

				if (vendor.get("allRoomCountArr") != null
						&& List.class.isAssignableFrom(vendor.get("allRoomCountArr").getClass())) {
					List<Double> allRoomCounts = (List<Double>) vendor.get("allRoomCountArr");

					if (allRoomCounts != null && allRoomCounts.size() > 0) {
						roomtypePrice
								.setAllRoomCount(allRoomCounts.get(0) != null ? allRoomCounts.get(0).longValue() : 0L);
					}
				}

				if (vendor.get("availableRoomCountArr") != null
						&& List.class.isAssignableFrom(vendor.get("availableRoomCountArr").getClass())) {
					List<Double> availableRoomCounts = (List<Double>) vendor.get("availableRoomCountArr");

					if (availableRoomCounts != null && availableRoomCounts.size() > 0) {
						roomtypePrice.setAvailableRoomcount(
								availableRoomCounts.get(0) != null ? availableRoomCounts.get(0).longValue() : 0L);
					}
				}
			}
		}

		if (roomComb.containsKey("images") && roomComb.get("images") != null
				&& List.class.isAssignableFrom(roomComb.get("images").getClass())) {
			List<Map<String, Object>> images = (List<Map<String, Object>>) roomComb.get("images");
			List<RoomTypeImg> roomtypeImgs = new ArrayList<RoomTypeImg>();


			for (Map<String, Object> image : images) {
				RoomTypeImg roomtypeImg = new RoomTypeImg();

				roomtypeImg.setRoomtypeKey(roomtypeKey);
				roomtypeImg.setHotelSourceId(hotelid);
				roomtypeImg.setTitle(typesafeGetString(image.get("title")));
				roomtypeImg.setAuthor(typesafeGetString(image.get("author")));
				roomtypeImg.setBaseUrl(typesafeGetString(image.get("baseUrl")));
				roomtypeImgs.add(roomtypeImg);
			}
			roomtypeComb.setRoomtypeImgs(roomtypeImgs);
		}

		return roomtypeComb;
	}

	private class CommentCombination {
		private CommentSum commentSum;

		private Map<Comment, List<CommentImg>> commentDetails;

		public CommentSum getCommentSum() {
			return commentSum;
		}

		public void setCommentSum(CommentSum commentSum) {
			this.commentSum = commentSum;
		}

		public Map<Comment, List<CommentImg>> getCommentDetails() {
			return commentDetails;
		}

		public void setCommentDetails(Map<Comment, List<CommentImg>> commentDetails) {
			this.commentDetails = commentDetails;
		}
	}

	private class HotelCombination {
		private List<RoomTypeCombination> roomtypeCombs;

		private QunarHotel hotelInfo;

		private List<HotelSurround> hotelSurrounds;

		private List<HotelFacilities> hotelfacilities;

		private CommentCombination commentComb;

		public CommentCombination getCommentComb() {
			return commentComb;
		}

		public void setCommentComb(CommentCombination commentComb) {
			this.commentComb = commentComb;
		}

		public List<RoomTypeCombination> getRoomtypeCombs() {
			return roomtypeCombs;
		}

		public void setRoomtypeCombs(List<RoomTypeCombination> roomtypeCombs) {
			this.roomtypeCombs = roomtypeCombs;
		}

		public List<HotelSurround> getHotelSurrounds() {
			return hotelSurrounds;
		}

		public void setHotelSurrounds(List<HotelSurround> hotelSurrounds) {
			this.hotelSurrounds = hotelSurrounds;
		}

		public List<HotelFacilities> getHotelfacilities() {
			return hotelfacilities;
		}

		public void setHotelfacilities(List<HotelFacilities> hotelfacilities) {
			this.hotelfacilities = hotelfacilities;
		}

		public QunarHotel getHotelInfo() {
			return hotelInfo;
		}

		public void setHotelInfo(QunarHotel hotelInfo) {
			this.hotelInfo = hotelInfo;
		}
	}

	private class RoomTypeCombination {
		private RoomType roomtype;

		private List<RoomTypeImg> roomtypeImgs;

		private List<RoomTypeDesc> roomtypeDescs;

		private List<RoomTypePrice> roomtypePrices;

		public List<RoomTypeImg> getRoomtypeImgs() {
			return roomtypeImgs;
		}

		public void setRoomtypeImgs(List<RoomTypeImg> roomtypeImgs) {
			this.roomtypeImgs = roomtypeImgs;
		}

		public List<RoomTypePrice> getRoomtypePrices() {
			return roomtypePrices;
		}

		public void setRoomtypePrices(List<RoomTypePrice> roomtypePrices) {
			this.roomtypePrices = roomtypePrices;
		}

		public RoomType getRoomtype() {
			return roomtype;
		}

		public void setRoomtype(RoomType roomtype) {
			this.roomtype = roomtype;
		}

		public List<RoomTypeDesc> getRoomtypeDescs() {
			return roomtypeDescs;
		}

		public void setRoomtypeDescs(List<RoomTypeDesc> roomtypeDescs) {
			this.roomtypeDescs = roomtypeDescs;
		}

	}

}
