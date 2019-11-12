package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.MemberAddress;
import com.cy.cyshopspringboot.viewObject.ConfirmOrderVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
@Controller
public class CheckoutController {

    @RequestMapping("/checkout")
    public Mono<String> checkout(Model model){
//        ConfirmOrderVO confirmOrderVO = new ConfirmOrderVO();
//        MemberAddress  memberAddress = new MemberAddress();
//        List<MemberAddress> memberAddressess = new ArrayList<>();
//        memberAddress.setSpecificAddress("成都市");
//        memberAddress.setConsigneeName("小红");
//        memberAddress.setMemberId(6);
//        memberAddress.setId(3);
//        memberAddress.setPhone("13112345678");
//        memberAddressess.add(memberAddress);
//        model.addAttribute("memberAddressess",memberAddressess);
        return Mono.create(checkoutMono->checkoutMono.success("checkout"));
    }

    @RequestMapping("/payment")
    public Mono<String> payment(){
        return Mono.create(paymentMono->paymentMono.success("payment"));
    }
}