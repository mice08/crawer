package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.RoomTypeMapping;

import java.util.HashMap;
import java.util.List;

/**
 * Created by jeashi on 2016/1/8.
 */
public interface IRoomTypeMappingService {

    public int deleteByPrimaryKey(Long id);

    public int insert(RoomTypeMapping record);

    public  int insertSelective(RoomTypeMapping record);

    public  RoomTypeMapping  selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(RoomTypeMapping record);


    public int updateByPrimaryKey(RoomTypeMapping record);

    public List<RoomTypeMapping> queryRoomTypeMapping(HashMap hm);
}
