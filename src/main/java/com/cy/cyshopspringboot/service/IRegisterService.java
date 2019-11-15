package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Member;

public interface IRegisterService {
    int findMemberByAccount(String account);

    int registerMember(Member member);
}
