package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.CommentImg;

public interface CommentImgMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CommentImg record);

    CommentImg selectByPrimaryKey(Long id);
}