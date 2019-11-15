package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.mapper.MemberMapper;
import com.cy.cyshopspringboot.service.IRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
@Service
public class RegisterServiceImpl implements IRegisterService {
    @Autowired
    private MemberMapper memberMapper;
    @Override
    public int findMemberByAccount(String account) {
        return memberMapper.findMemberByAccount(account);
    }

    @Override
    public int registerMember(Member member) {
        return memberMapper.insert(member);
    }
}
