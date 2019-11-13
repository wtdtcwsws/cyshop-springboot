package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.viewobject.Catalog1VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @author lz - PC
 * @date 2019/11/12 - 17:50
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public Mono<String> index(Model model) {


        return Mono.create(indexMono->indexMono.success("login"));
    }


}
