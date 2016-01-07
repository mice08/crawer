package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.CommentMapper;
import com.mk.crawer.biz.model.crawer.Comment;
import com.mk.crawer.biz.model.crawer.CommentExample;
import com.mk.crawer.biz.servcie.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class CommentServiceImpl implements ICommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public int countByExample(CommentExample example) {
        return commentMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }

    @Override
    public List<Comment> selectByExample(CommentExample example) {
        return commentMapper.selectByExample(example);
    }

    @Override
    public Comment selectByPrimaryKey(Long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Comment record) {
        return commentMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Comment record) {
        return commentMapper.updateByPrimaryKey(record);
    }
}
