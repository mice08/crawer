package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.GdRoomPic;
import com.mk.crawer.biz.model.crawer.GdRoomPicExample;

import java.util.List;

public interface GdRoomPicMapper {
    int countByExample(GdRoomPicExample example);

    int deleteByPrimaryKey(Long id);

    int insert(GdRoomPic record);

    int insertSelective(GdRoomPic record);

    List<GdRoomPic> selectByExample(GdRoomPicExample example);

    GdRoomPic selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GdRoomPic record);

    int updateByPrimaryKey(GdRoomPic record);

    int batchInsert(List<GdRoomPic> gdRoomPicVector);
}