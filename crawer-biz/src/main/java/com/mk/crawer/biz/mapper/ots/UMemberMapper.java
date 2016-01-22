package com.mk.crawer.biz.mapper.ots;

import java.util.List;

import com.mk.crawer.biz.model.ots.UMember;

/**
 * Created by kirinli on 15/9/9.
 */
public interface UMemberMapper {
    List<UMember> getByParams(UMember uMember);
}
