package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Member;

import java.util.List;

/**
 * @author lz - PC
 * @date 2019/11/14 - 15:11
 */
public interface LoginService {

    List<Member> selectAll();

    List<Member> getMember();
}
