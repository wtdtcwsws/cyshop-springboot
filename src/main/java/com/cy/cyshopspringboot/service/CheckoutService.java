package com.cy.cyshopspringboot.service;


import com.cy.cyshopspringboot.domain.MemberAddress;
import com.cy.cyshopspringboot.domain.Order;
import com.cy.cyshopspringboot.domain.OrderItem;

import java.util.List;

public interface CheckoutService {
    List<MemberAddress> findAderessByMemberId(String id);
    int addAddress(MemberAddress memberAddress);
    int updateAddress(MemberAddress memberAddress);
    int insertOrder(Order order);
    int insertOrderItem(OrderItem orderItem);
}
