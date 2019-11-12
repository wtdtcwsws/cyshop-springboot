package com.cy.cyshopspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: CartController
 * @Description:
 * @Author: 罗海
 * @Date: 2019/11/12 16:06
 **/
@Controller
public class CartController {


    @RequestMapping("/cart")
    public String cart(){
        return "cart";
    }



}
