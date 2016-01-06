package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.RoomTypeDesc;
import com.mk.crawer.biz.model.crawer.RoomTypeDescExample;

import java.util.List;

public interface IRoomTypeDescService {
    int countByExample(RoomTypeDescExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypeDesc record);

    int insertSelective(RoomTypeDesc record);

    List<RoomTypeDesc> selectByExample(RoomTypeDescExample example);

    RoomTypeDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypeDesc record);

    int updateByPrimaryKey(RoomTypeDesc record);
}