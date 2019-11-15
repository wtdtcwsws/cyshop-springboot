package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.mapper.OrderMapper;
import com.cy.cyshopspringboot.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
@Service
public class PaymentServiceImpl implements IPaymentService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public int updateOrderPaymentTime(int orderId) {
//        int orderId = Integer.parseInt(oId);
        return orderMapper.updateOrderPaymentTime(orderId);
    }
}
