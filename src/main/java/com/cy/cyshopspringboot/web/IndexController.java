package com.cy.cyshopspringboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index.html")
    public String index(Model model) {
        model.addAttribute("message", "Hello World");
        return "index";
    }

    @GetMapping("/404.html")
    public String page404() {
        return "404";
    }
}