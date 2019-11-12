package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.MemberAddress;
import com.cy.cyshopspringboot.domain.Order;
import com.cy.cyshopspringboot.domain.OrderItem;
import com.cy.cyshopspringboot.service.CheckoutService;

import java.util.List;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
public class CheckoutServiceImpl implements CheckoutService {

    @Override
    public List<MemberAddress> findAderessByMemberId(String id) {
        return null;
    }

    @Override
    public int addAddress(MemberAddress memberAddress) {
        return 0;
    }

    @Override
    public int updateAddress(MemberAddress memberAddress) {
        return 0;
    }

    @Override
    public int insertOrder(Order order) {
        return 0;
    }

    @Override
    public int insertOrderItem(OrderItem orderItem) {
        return 0;
    }
}
