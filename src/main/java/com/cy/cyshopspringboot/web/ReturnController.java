package com.cy.cyshopspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: ReturnController
 * @Description:
 * @Author: 罗海
 * @Date: 2019/11/12 16:52
 **/
@Controller
public class ReturnController {


    @RequestMapping("/return")







    public String returns() {
        return "return";
    }
}
