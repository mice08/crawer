package com.mk.crawer.biz.servcie.impl;

import com.mk.crawer.biz.mapper.crawer.CommentImgMapper;
import com.mk.crawer.biz.model.crawer.CommentImg;
import com.mk.crawer.biz.model.crawer.CommentImgExample;
import com.mk.crawer.biz.servcie.ICommentImgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by kirinli on 16/1/6.
 */
public class CommentImgService implements ICommentImgService {
    @Autowired
    private CommentImgMapper commentImgMapper;

    @Override
    public int countByExample(CommentImgExample example) {
        return commentImgMapper.countByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return commentImgMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(CommentImg record) {
        return commentImgMapper.insert(record);
    }

    @Override
    public int insertSelective(CommentImg record) {
        return commentImgMapper.insertSelective(record);
    }

    @Override
    public List<CommentImg> selectByExample(CommentImgExample example) {
        return commentImgMapper.selectByExample(example);
    }

    @Override
    public CommentImg selectByPrimaryKey(Long id) {
        return commentImgMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(CommentImg record) {
        return commentImgMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(CommentImg record) {
        return commentImgMapper.updateByPrimaryKey(record);
    }
}
