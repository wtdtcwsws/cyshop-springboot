package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.MemberAddress;

public interface IMemberAddressService {

    MemberAddress selectById(Integer id);
}
