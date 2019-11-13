package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.CartMessage;
import com.cy.cyshopspringboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import javax.xml.ws.Response;
import java.util.List;

/**
 * @ClassName: CartController
 * @Description:
 * @Author: 罗海
 * @Date: 2019/11/12 16:06
 **/
@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public Mono<String> cart(Model model) {

        List<CartMessage> cartMessages = cartService.cartMessageAll(2);

        model.addAttribute("gouwuche",cartMessages);

        return Mono.create(indexMono->indexMono.success("cart"));
    }


}
