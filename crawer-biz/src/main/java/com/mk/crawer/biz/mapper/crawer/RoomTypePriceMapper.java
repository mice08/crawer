package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.RoomTypePrice;
import com.mk.crawer.biz.model.RoomTypePriceExample;
import java.util.List;

public interface RoomTypePriceMapper {
    int countByExample(RoomTypePriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypePrice record);

    int insertSelective(RoomTypePrice record);

    List<RoomTypePrice> selectByExample(RoomTypePriceExample example);

    RoomTypePrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypePrice record);

    int updateByPrimaryKey(RoomTypePrice record);
}