package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.domain.Order;
import tk.mybatis.mapper.common.Mapper;

public interface OrderMapper extends Mapper<Order> {
    int updateOrderPaymentTime(int orderId);
}