package com.mk.crawer.biz.mapper.crawer;


import com.mk.crawer.biz.model.crawer.GdPlatformRoomType;
import com.mk.crawer.biz.model.crawer.GdPlatformRoomTypeExample;

import java.util.List;

public interface GdPlatformRoomTypeMapper {
    int countByExample(GdPlatformRoomTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdPlatformRoomType record);

    int insertSelective(GdPlatformRoomType record);

    List<GdPlatformRoomType> selectByExample(GdPlatformRoomTypeExample example);

    GdPlatformRoomType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GdPlatformRoomType record);

    int updateByPrimaryKey(GdPlatformRoomType record);

    int batchInsert(List<GdPlatformRoomType> gdPlatformRoomTypeVector);
}