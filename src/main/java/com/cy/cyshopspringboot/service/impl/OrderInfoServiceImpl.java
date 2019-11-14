package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.mapper.OrderInfoVOMapper;
import com.cy.cyshopspringboot.service.IOrderInfoService;
import com.cy.cyshopspringboot.viewobject.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements IOrderInfoService {
    @Autowired
    OrderInfoVOMapper orderInfoVOMapper;
    @Override
    public List<OrderInfoVO> sellectAllInfo(Integer id) {
        return orderInfoVOMapper.sellectAllInfo(id);
    }

    @Override
    public OrderInfoVO selectByOrderId(Integer orderId,Integer sid) {
        return orderInfoVOMapper.selectByOrderId(orderId,sid);
    }

}
