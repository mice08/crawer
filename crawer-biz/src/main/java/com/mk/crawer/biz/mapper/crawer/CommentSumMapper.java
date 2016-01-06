package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.CommentSum;
import com.mk.crawer.biz.model.crawer.CommentSumExample;
import java.util.List;

public interface CommentSumMapper {
    int countByExample(CommentSumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentSum record);

    int insertSelective(CommentSum record);

    List<CommentSum> selectByExample(CommentSumExample example);

    CommentSum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentSum record);

    int updateByPrimaryKey(CommentSum record);
}