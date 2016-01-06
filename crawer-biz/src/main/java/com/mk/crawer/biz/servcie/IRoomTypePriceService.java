package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.RoomTypePrice;
import com.mk.crawer.biz.model.crawer.RoomTypePriceExample;

import java.util.List;

public interface IRoomTypePriceService {
    int countByExample(RoomTypePriceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RoomTypePrice record);

    int insertSelective(RoomTypePrice record);

    List<RoomTypePrice> selectByExample(RoomTypePriceExample example);

    RoomTypePrice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoomTypePrice record);

    int updateByPrimaryKey(RoomTypePrice record);
}