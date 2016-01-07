package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.RoomType;

public interface RoomTypeMapper {
	int deleteByPrimaryKey(Long id);

	int insert(RoomType record);

	int insertSelective(RoomType record);

	RoomType selectByPrimaryKey(Long id);
}