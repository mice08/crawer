package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.RoomTypeMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 2016/1/8.
 */
public interface  IRoomTypeMappingBusinessService {

    public RoomTypeMapping queryByPrimaryKey(Long  id);

    public  int  insert(RoomTypeMapping  roomTypeMapping);

    public int deleteByPrimaryKey(Long id);

    public  int update(RoomTypeMapping record);

    public List<RoomTypeMapping> queryHotelMapping(HashMap hm);
}
