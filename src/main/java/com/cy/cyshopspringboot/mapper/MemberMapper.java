package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.domain.Member;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

public interface MemberMapper extends Mapper<Member> {
    int findMemberByAccount(String account);
}