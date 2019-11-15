package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.viewobject.OrderInfoVO;

import java.util.List;

public interface IOrderInfoService {

    List<OrderInfoVO> sellectAllInfo(Integer id,Integer limit);

    OrderInfoVO selectByOrderId(Integer orderId,Integer sid);

    Integer selectCount(Integer uid);
}
