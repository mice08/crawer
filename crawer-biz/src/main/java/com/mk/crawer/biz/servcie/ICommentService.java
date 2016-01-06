package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.Comment;
import com.mk.crawer.biz.model.crawer.CommentExample;

import java.util.List;

public interface ICommentService {
    int countByExample(CommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByExample(CommentExample example);

    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}