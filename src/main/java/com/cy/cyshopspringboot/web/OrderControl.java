package com.cy.cyshopspringboot.web;


import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.domain.MemberAddress;
import com.cy.cyshopspringboot.domain.Order;
import com.cy.cyshopspringboot.service.IMemberAddressService;
import com.cy.cyshopspringboot.service.IMemberService;
import com.cy.cyshopspringboot.service.IOrderInfoService;
import com.cy.cyshopspringboot.service.IOrderService;
import com.cy.cyshopspringboot.viewobject.OrderInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
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
    @Autowired
    IOrderInfoService iOrderInfoService;
    @Autowired
    IMemberService iMemberService;
    @Autowired
    IMemberAddressService iMemberAddressService;
    /**
     * 查询返回订单列表
     * @return
     */
    @RequestMapping("/order-history")
    public Mono<String> orderList(Model model){
    //联动了要加登录的用户id @RequestMapping("id") integer id
        //测试用户id为5
        List<OrderInfoVO> list = iOrderInfoService.sellectAllInfo(5);
        model.addAttribute("orders",list);
        return Mono.create(orderListMono->orderListMono.success("order-history"));
    }

    /**
     * 查询返回订单列表
     * @return
     */
    @RequestMapping("/order-information")
    public Mono<String> orderInfo(@RequestParam("oid") Integer oid,@RequestParam("sid") Integer sid, Model model){



        OrderInfoVO orderInfoVO = iOrderInfoService.selectByOrderId(oid,sid);


        BigDecimal discount = orderInfoVO.getDiscounts().multiply(orderInfoVO.getPrice());

        orderInfoVO.setDiscounts(discount);

        Member member = iMemberService.selectById(orderInfoVO.getMid());


        MemberAddress address = iMemberAddressService.selectById(orderInfoVO.getAddress());


        model.addAttribute("order",orderInfoVO);
        model.addAttribute("member",member);
        model.addAttribute("address",address);
        return Mono.create(orderListMono->orderListMono.success("order-information"));
    }

}
