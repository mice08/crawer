package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.GdRoomType;
import com.mk.crawer.biz.model.crawer.GdRoomTypeExample;

import java.util.List;

public interface GdRoomTypeMapper {
    int countByExample(GdRoomTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdRoomType record);

    int insertSelective(GdRoomType record);

    List<GdRoomType> selectByExample(GdRoomTypeExample example);

    GdRoomType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GdRoomType record);

    int updateByPrimaryKey(GdRoomType record);
}