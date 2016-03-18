package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.RoomType;

import java.util.List;
import java.util.Map;

public interface RoomTypeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RoomType record);

	int insertSelective(RoomType record);

	RoomType selectByPrimaryKey(Long id);

	List<RoomType> selectByKeys(Map<String, Object> parameters);
	List<Map<String, String>>selectImgByKeys(Map<String, Object> parameters);
	void insertImg(Map<String, Object> parameters);
}