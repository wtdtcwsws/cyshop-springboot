package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.MemberAddress;
import com.cy.cyshopspringboot.mapper.MemberAddressMapper;
import com.cy.cyshopspringboot.service.IMemberAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberAddressServiceImpl implements IMemberAddressService {
    @Autowired
    MemberAddressMapper memberAddressMapper;
    @Override
    public MemberAddress selectById(Integer id) {
        return memberAddressMapper.selectByPrimaryKey(id);
    }
}
