package com.mk.crawer.biz.servcie.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mk.crawer.biz.mapper.RoomTypeMapper;
import com.mk.crawer.biz.model.HotelDetailParseException;
import com.mk.crawer.biz.model.HotelSurround;
import com.mk.crawer.biz.model.RoomType;
import com.mk.crawer.biz.model.RoomTypeDesc;
import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.HttpUtils;

@Service
public class HotelDetailCrawlServiceImpl implements HotelDetailCrawlService {
	private final String hotelDetailUrl = "http://pad.qunar.com/api/hotel/hoteldetail?city=%s&cityUrl=%s&checkInDate=%s&checkOutDate=%s&keywords=&location=&seq=%s&clickNum=0&isLM=0&type=0";

	private final Logger logger = Logger.getLogger(HotelDetailCrawlServiceImpl.class);

	private final Gson gson = new Gson();

	@Autowired
	private RoomTypeMapper roomtypeMapper;

	public void crawl(List<String> hotelIds, String city, String cityUrl) throws Exception {
		Date day = new Date();
		String strCurDay = DateUtils.getStringFromDate(day, DateUtils.FORMATSHORTDATETIME);
		String strNextDay = DateUtils.getStringFromDate(DateUtils.addDays(day, 1), DateUtils.FORMATSHORTDATETIME);

		String hotelid = hotelIds.get(0);
		String invokeUrl = String.format(hotelDetailUrl, city, cityUrl, strCurDay, strNextDay, hotelid);

		String jsonString = "";
		try {
			jsonString = HttpUtils.doPost(invokeUrl, new HashMap<String, String>());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to post with url %s", invokeUrl);
			logger.error(errorMsg, ex);
			throw new Exception(errorMsg, ex.getCause());
		}

		List<RoomTypeCombination> roomtypeCombs = this.parseJson(hotelid, jsonString);
		try {
			persistRoomtypeCombs(roomtypeCombs);
		} catch (Exception ex) {
			String errorMsg = String.format("failed to persistRoomtypeCombs in hotelid %s", hotelid);
			logger.error(errorMsg, ex);
			throw new Exception(errorMsg, ex.getCause());
		}

	}

	@SuppressWarnings("unchecked")
	private List<RoomTypeCombination> parseJson(String hotelid, String json) throws Exception {
		Map<String, Object> jsonContent = gson.fromJson(json, new TypeToken<Map<String, Object>>() {
		}.getType());
		List<RoomTypeCombination> roomtypeCombs = null;

		for (String key : jsonContent.keySet()) {
			Object jsonNode = jsonContent.get(key);

			if ("status".equals(key)) {
				if (jsonNode == null || !jsonNode.getClass().isAssignableFrom(Double.class)
						|| ((Double) jsonNode) != 0) {
					logger.warn(String.format("invalid status %s received...", jsonNode));
				}
			}

			if ("data".equals(key)) {
				if (jsonNode != null && jsonNode.getClass().isAssignableFrom(Map.class)) {
					try {
						roomtypeCombs = parseDataNodeForRoomtype(hotelid, (Map<String, Object>) jsonNode);
					} catch (Exception ex) {
						logger.error(String.format("failed to parse roomtypes for hotelid:%s", hotelid), ex);
					}

					parseDataNodeForHotelSurround(hotelid, (Map<String, Object>) jsonNode);
					
					
				} else {
					logger.warn("invalid data node received, skip...");
					continue;
				}
			}
		}

		return roomtypeCombs;
	}

	private void persistRoomtypeCombs(List<RoomTypeCombination> roomtypeCombs) throws Exception {
		for (RoomTypeCombination roomtypeComb : roomtypeCombs) {
			RoomType roomtype = roomtypeComb.getRoomtype();

			roomtypeMapper.insert(roomtype);
		}
	}

	@SuppressWarnings("unchecked")
	private HotelSurround parseDataNodeForHotelSurround(String hotelid, Map<String, Object> dataNode)
			throws HotelDetailParseException {
		HotelSurround hotelSurround = new HotelSurround();

		return hotelSurround;
	}

	@SuppressWarnings("unchecked")
	private List<RoomTypeCombination> parseDataNodeForRoomtype(String hotelid, Map<String, Object> dataNode)
			throws HotelDetailParseException {
		List<RoomTypeCombination> combinations = new ArrayList<RoomTypeCombination>();

		if (dataNode.containsKey("rooms")) {
			if (dataNode.get("rooms") != null && dataNode.get("rooms").getClass().isAssignableFrom(List.class)) {
				List<Map<String, Object>> rooms = (List<Map<String, Object>>) dataNode.get("rooms");
				for (Map<String, Object> room : rooms) {
					RoomTypeCombination roomtypeComb = null;

					String roomtypeKey = "";
					if (room.containsKey("key") && room.get("key") != null
							&& room.get("key").getClass().isAssignableFrom(String.class)) {
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

		if (attribute != null && attribute.getClass().isAssignableFrom(String.class)) {
			attrVal = (String) attribute;
		}

		return attrVal;
	}

	private Double typesafeGetDouble(Object attribute) {
		Double attrVal = 0.0;

		if (attribute != null && attribute.getClass().isAssignableFrom(Double.class)) {
			attrVal = (Double) attribute;
		}

		return attrVal;
	}

	private BigDecimal typesafeGetBigDecimal(Object attribute) {
		if (attribute != null && attribute.getClass().isAssignableFrom(Double.class)) {
			Double attrVal = (Double) attribute;

			try {
				return BigDecimal.valueOf(attrVal);
			} catch (Exception ex) {
				return new BigDecimal(0);
			}
		}

		return new BigDecimal(0);
	}

	@SuppressWarnings("unchecked")
	private RoomTypeCombination parseRoomtypeComb(String hotelid, Map<String, Object> roomComb)
			throws HotelDetailParseException {
		RoomTypeCombination roomtypeComb = new RoomTypeCombination();

		RoomType roomtype = new RoomType();
		roomtypeComb.setRoomtype(roomtype);

		String roomtypeKey = typesafeGetString(roomComb.get("key"));

		roomtype.setKey(typesafeGetString(roomComb.get("key")));
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
				&& roomComb.get("rtDescInfo").getClass().isAssignableFrom(Map.class)) {
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

		if (rtDesc1 != null && rtDesc1.getClass().isAssignableFrom(List.class)) {
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

		if (rtDesc2 != null && rtDesc2.getClass().isAssignableFrom(List.class)) {
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

		return roomtypeComb;
	}

	private class RoomTypeCombination {
		private RoomType roomtype;

		private List<RoomTypeDesc> roomtypeDescs;

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
