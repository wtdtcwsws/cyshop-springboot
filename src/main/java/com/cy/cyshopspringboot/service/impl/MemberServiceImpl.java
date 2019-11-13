package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.mapper.MemberMapper;
import com.cy.cyshopspringboot.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    MemberMapper memberMapper;
    @Override
    public Member selectById(Integer id) {
        return memberMapper.selectByPrimaryKey(id);
    }
}
