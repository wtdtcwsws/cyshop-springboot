package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Member;

import java.util.List;

public interface IMemberService {

    Member selectById(Integer id);

    List<Member> login(Member login);
}
