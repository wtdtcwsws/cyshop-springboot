package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Order;

import java.util.List;

/**
 * @version 1.0.0
 * @InterfaceName IOrderService
 * @Description TODO
 * @Author 王苑鹏
 * @date 2019/11/12 18:53
 */
public interface IOrderService {
    /**
     * 查询所有订单
     * @return
     */
    List<Order> selectAll();

    /**
     * 查询订单信息
     * @param memberId 用户ID
     * @return
     */
    List<Order> selectAllByMenId(Integer memberId);

    /**
     * 查询订单信息
     * @param orderId 订单ID
     * @return
     */
    Order selectById(Integer orderId);

}
