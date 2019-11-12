package com.cy.cyshopspringboot.web;


import com.cy.cyshopspringboot.domain.Order;
import com.cy.cyshopspringboot.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @version 1.0.0
 * @ClassName GoodsController
 * @Description TODO
 * @Author 王苑鹏
 * @date 2019/11/129:16
 */
@Controller
public class OrderControl {

    @Autowired
    IOrderService iOrderService;
    /**
     * 查询返回订单列表
     * @return
     */
    @RequestMapping("/order-history")
    public Mono<String> orderList(Model model){
    //联动了要加登录的用户id @RequestMapping("id") integer id
        //测试用户id为5
        List<Order> orders = iOrderService.selectAllByMenId(5);
        model.addAttribute("orders",orders);
        return Mono.create(orderListMono->orderListMono.success("order-history"));
    }
}
