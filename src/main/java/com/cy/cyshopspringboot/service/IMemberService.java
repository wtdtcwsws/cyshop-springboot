package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Member;

public interface IMemberService {

    Member selectById(Integer id);
}
