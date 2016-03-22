package com.mk.crawer.biz.mapper.crawer;

import com.mk.crawer.biz.model.crawer.GdCommentDetail;
import com.mk.crawer.biz.model.crawer.GdHotel;

import java.util.List;

public interface GdCommentDetailMapper {
    public List<GdCommentDetail> qureyByPramas(GdCommentDetail bean);
    public GdCommentDetail getByPramas(GdCommentDetail bean);
    public Integer save(GdCommentDetail bean);
    public Integer delete(Integer id);
    public Integer updateById(GdCommentDetail bean);
    public Integer count(GdCommentDetail bean);
}