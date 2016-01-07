package com.mk.crawer.biz.mapper.crawer;

import java.util.List;
import java.util.Map;

import com.mk.crawer.biz.model.crawer.RoomType;

public interface RoomTypeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RoomType record);

	int insertSelective(RoomType record);

	RoomType selectByPrimaryKey(Long id);
	
	List<RoomType> selectByKeys(Map<String, Object> parameters);
	
}