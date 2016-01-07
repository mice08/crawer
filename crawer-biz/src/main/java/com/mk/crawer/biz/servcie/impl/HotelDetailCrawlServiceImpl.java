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
import com.mk.crawer.biz.mapper.crawer.HotelFacilitiesMapper;
import com.mk.crawer.biz.mapper.crawer.HotelSurroundMapper;
import com.mk.crawer.biz.mapper.crawer.RoomTypeDescMapper;
import com.mk.crawer.biz.mapper.crawer.RoomTypeMapper;
import com.mk.crawer.biz.mapper.crawer.RoomTypePriceMapper;
import com.mk.crawer.biz.model.crawer.HotelDetailParseException;
import com.mk.crawer.biz.model.crawer.HotelFacilities;
import com.mk.crawer.biz.model.crawer.HotelSurround;
import com.mk.crawer.biz.model.crawer.RoomType;
import com.mk.crawer.biz.model.crawer.RoomTypeDesc;
import com.mk.crawer.biz.model.crawer.RoomTypePrice;
import com.mk.crawer.biz.servcie.HotelDetailCrawlService;
import com.mk.crawer.biz.utils.DateUtils;
import com.mk.crawer.biz.utils.HttpUtils;

@Service
public class HotelDetailCrawlServiceImpl implements HotelDetailCrawlService {

	private final String hotelDetailUrl = "http://pad.qunar.com/api/hotel/hoteldetail?city=%s&cityUrl=%s&checkInDate=%s&checkOutDate=%s&keywords=&location=&seq=%s&clickNum=0&isLM=0&type=0";

	private final Logger logger = Logger.getLogger(HotelDetailCrawlServiceImpl.class);

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

	public void crawl(List<String> hotelIds, String city, String cityUrl) throws Exception {
		Date day = new Date();
		String strCurDay = DateUtils.getStringFromDate(day, DateUtils.FORMATSHORTDATETIME);
		String strNextDay = DateUtils.getStringFromDate(DateUtils.addDays(day, 1), DateUtils.FORMATSHORTDATETIME);

		String hotelid = hotelIds.get(0);
		String invokeUrl = String.format(hotelDetailUrl, city, cityUrl, strCurDay, strNextDay,
				String.format("%s_%s", cityUrl, hotelid));

		if (logger.isDebugEnabled()) {
			logger.debug(invokeUrl);
		}

		Date beforeTime = new Date();

		String jsonString = "";
		try {
			jsonString = HttpUtils.doPost(invokeUrl, new HashMap<String, String>());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to post with url %s", invokeUrl);
			logger.error(errorMsg, ex);
			throw new Exception(errorMsg, ex.getCause());
		}

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
			persistHotelSurround(hotelComb.getHotelSurrounds());
		} catch (Exception ex) {
			String errorMsg = String.format("failed to persistHotelSurround in hotelid %s", hotelid);
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
						List<HotelFacilities> hotelFacilities = parseDataNodeForHotelFacilities(hotelid,
								(Map<String, Object>) jsonNode);

						if (hotelFacilities != null) {
							hotelComb.setHotelfacilities(hotelFacilities);
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

	/**
	 * with no transaction intentionally,
	 * <p>
	 * data may have integrity issue
	 * 
	 * @param roomtypeCombs
	 * @throws Exception
	 */
	private void persistRoomtypeCombs(List<RoomTypeCombination> roomtypeCombs) throws Exception {
		for (RoomTypeCombination roomtypeComb : roomtypeCombs) {
			RoomType roomtype = roomtypeComb.getRoomtype();
			List<RoomTypeDesc> roomtypeDescs = roomtypeComb.getRoomtypeDescs();
			List<RoomTypePrice> roomtypePrices = roomtypeComb.getRoomtypePrices();

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

			if (roomtypePrices != null) {
				for (RoomTypePrice roomtypePrice : roomtypePrices) {
					try {
						roomtypePriceMapper.insert(roomtypePrice);
					} catch (Exception ex) {
						logger.error("failed to roomtypePriceMapper.insert", ex);
					}
				}
			}
		}
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

	@SuppressWarnings("unchecked")
	private List<HotelSurround> parseDataNodeForHotelSurrounds(String hotelid, Map<String, Object> dataNode)
			throws HotelDetailParseException {
		List<HotelSurround> hotelSurrounds = new ArrayList<HotelSurround>();

		if (dataNode.get("traffic") != null && List.class.isAssignableFrom(dataNode.get("traffic").getClass())) {
			List<Map<String, Object>> traffics = (List<Map<String, Object>>) dataNode.get("traffic");

			for (Map<String, Object> traffic : traffics) {
				HotelSurround hotelSurround = new HotelSurround();
				hotelSurrounds.add(hotelSurround);

				hotelSurround.setDistance(typesafeGetString(traffic.get("distance")));
				hotelSurround.setGpoint(typesafeGetString(traffic.get("gpoint")));
				hotelSurround.setSurroundName(typesafeGetString(traffic.get("name")));
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
		roomtype.setHotelSourceId(typesafeGetString(roomComb.get("key")));
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
			for (Map<String, Object> vendor : vendors) {
				RoomTypePrice roomtypePrice = new RoomTypePrice();
				roomtypePrices.add(roomtypePrice);

				roomtypePrice.setPrice(typesafeGetBigDecimal(vendor.get("price")));
				roomtypePrice.setRealPrice(typesafeGetBigDecimal(vendor.get("realPrice")));
				roomtypePrice.setOriginPrice(typesafeGetBigDecimal(vendor.get("originPrice")));
				roomtypePrice.setShowPrice(typesafeGetBigDecimal(vendor.get("showPriceInt")));
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
					List<Long> availableRoomCounts = (List<Long>) vendor.get("availableRoomCountArr");

					if (availableRoomCounts != null && availableRoomCounts.size() > 0) {
						roomtypePrice.setAvailableRoomcount(
								availableRoomCounts.get(0) != null ? availableRoomCounts.get(0).longValue() : 0L);
					}
				}
			}
		}

		return roomtypeComb;
	}

	private class HotelCombination {
		private List<RoomTypeCombination> roomtypeCombs;

		private List<HotelSurround> hotelSurrounds;

		private List<HotelFacilities> hotelfacilities;

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
	}

	private class RoomTypeCombination {
		private RoomType roomtype;

		private List<RoomTypeDesc> roomtypeDescs;

		private List<RoomTypePrice> roomtypePrices;

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
