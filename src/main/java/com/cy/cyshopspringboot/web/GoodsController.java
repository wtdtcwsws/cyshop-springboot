package com.cy.cyshopspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version 1.0.0
 * @ClassName GoodsController
 * @Description TODO
 * @Author Administrator
 * @date 2019/11/129:16
 */
@Controller
public class GoodsController {

    @GetMapping("/goods.html")
    public String login() {
        return "goods";
    }
}
