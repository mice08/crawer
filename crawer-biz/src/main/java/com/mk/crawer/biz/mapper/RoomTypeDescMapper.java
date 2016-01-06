package com.mk.crawer.biz.mapper;

import com.mk.crawer.biz.model.RoomTypeDesc;
import com.mk.crawer.biz.model.RoomTypeDescExample;
import java.util.List;

public interface RoomTypeDescMapper {
    int countByExample(RoomTypeDescExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypeDesc record);

    int insertSelective(RoomTypeDesc record);

    List<RoomTypeDesc> selectByExample(RoomTypeDescExample example);

    RoomTypeDesc selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypeDesc record);

    int updateByPrimaryKey(RoomTypeDesc record);
}