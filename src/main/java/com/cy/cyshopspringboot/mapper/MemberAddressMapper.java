package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.domain.MemberAddress;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MemberAddressMapper extends Mapper<MemberAddress> {
    List<MemberAddress> findAllByMemberId(String id);
}