package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.Order;
import com.cy.cyshopspringboot.domain.RoleResource;
import com.cy.cyshopspringboot.mapper.OrderMapper;
import com.cy.cyshopspringboot.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {
    @Autowired
    OrderMapper orderMapper;

    @Override
    public List<Order> selectAll() {
        return orderMapper.selectAll();
    }

    @Override
    public List<Order> selectAllByMenId(Integer memberId) {
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("memberId",memberId);
        return orderMapper.selectByExample(example);
    }

    @Override
    public Order selectById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
