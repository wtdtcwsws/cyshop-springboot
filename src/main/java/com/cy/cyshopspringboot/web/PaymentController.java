package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.service.IPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    @Autowired
    private IPaymentService iPaymentService;

    @RequestMapping("/payment")
    public Mono<String> payment(){
        return Mono.create(paymentMono->paymentMono.success("payment"));
    }

    @RequestMapping("/confirmPayment")
    public void confirmPayment(HttpSession session, HttpServletResponse response) throws IOException {
        Integer orderId = (Integer)session.getAttribute("orderId");
        System.out.println(orderId);
        int valid = iPaymentService.updateOrderPaymentTime(orderId);
        if (valid>0) {
//            return Mono.create(confirmPaymentMono -> confirmPaymentMono.success("/order-history"));
            response.sendRedirect("/order-history");
        }else {
//        return Mono.create(confirmPaymentMono -> confirmPaymentMono.success("payment"));
            response.sendRedirect("/payment");
        }
    }
}
