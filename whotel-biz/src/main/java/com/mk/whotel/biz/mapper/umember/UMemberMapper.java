package com.mk.whotel.biz.mapper.umember;

import com.mk.whotel.biz.moudle.UMember;

import java.util.List;

/**
 * Created by kirinli on 15/9/9.
 */
public interface UMemberMapper {
    List<UMember> getByParams(UMember uMember);
}
