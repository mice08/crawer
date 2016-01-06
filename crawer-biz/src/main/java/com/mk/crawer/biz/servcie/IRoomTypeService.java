package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.RoomType;
import com.mk.crawer.biz.model.crawer.RoomTypeExample;

import java.util.List;

public interface IRoomTypeService {
    int countByExample(RoomTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomType record);

    int insertSelective(RoomType record);

    List<RoomType> selectByExample(RoomTypeExample example);

    RoomType selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomType record);

    int updateByPrimaryKey(RoomType record);
}