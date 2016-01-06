package com.mk.crawer.biz.mapper.umember;

import com.mk.crawer.biz.moudle.UMember;

import java.util.List;

/**
 * Created by kirinli on 15/9/9.
 */
public interface UMemberMapper {
    List<UMember> getByParams(UMember uMember);
}
