package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    Comment selectByPrimaryKey(Long id);
}