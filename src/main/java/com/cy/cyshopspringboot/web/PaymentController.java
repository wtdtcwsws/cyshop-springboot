package com.cy.cyshopspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
@Controller
public class PaymentController {

    @RequestMapping("/payment")
    public Mono<String> payment(){
        return Mono.create(paymentMono->paymentMono.success("payment"));
    }
}
