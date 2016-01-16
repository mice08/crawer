package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.CommentSum;

public interface CommentSumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentSum record);

    CommentSum selectByPrimaryKey(Long id);

}