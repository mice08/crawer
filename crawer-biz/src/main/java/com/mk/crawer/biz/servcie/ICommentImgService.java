package com.mk.crawer.biz.servcie;

import com.mk.crawer.biz.model.crawer.CommentImg;
import com.mk.crawer.biz.model.crawer.CommentImgExample;

import java.util.List;

public interface ICommentImgService {
    int countByExample(CommentImgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommentImg record);

    int insertSelective(CommentImg record);

    List<CommentImg> selectByExample(CommentImgExample example);

    CommentImg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CommentImg record);

    int updateByPrimaryKey(CommentImg record);
}