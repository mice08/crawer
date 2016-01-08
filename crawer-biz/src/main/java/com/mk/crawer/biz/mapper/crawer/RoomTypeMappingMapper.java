package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.RoomTypeMapping;
import com.mk.crawer.biz.model.crawer.RoomTypeMappingExample;
import java.util.List;

public interface RoomTypeMappingMapper {
    int countByExample(RoomTypeMappingExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypeMapping record);

    int insertSelective(RoomTypeMapping record);

    List<RoomTypeMapping> selectByExample(RoomTypeMappingExample example);

    RoomTypeMapping selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypeMapping record);

    int updateByPrimaryKey(RoomTypeMapping record);
}