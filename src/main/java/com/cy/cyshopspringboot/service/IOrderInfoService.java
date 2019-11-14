package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.viewobject.OrderInfoVO;

import java.util.List;

public interface IOrderInfoService {

    List<OrderInfoVO> sellectAllInfo(Integer id);

    OrderInfoVO selectByOrderId(Integer orderId,Integer sid);
}
