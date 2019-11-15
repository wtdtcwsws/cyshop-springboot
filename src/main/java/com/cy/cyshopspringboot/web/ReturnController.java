package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.domain.Sku;
import com.cy.cyshopspringboot.domain.SkuImg;
import com.cy.cyshopspringboot.service.ISkuImgService;
import com.cy.cyshopspringboot.service.ISkuService;
import org.hibernate.validator.constraints.EAN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ReturnController
 * @Description:
 * @Author: 罗海
 * @Date: 2019/11/12 16:52
 **/
@Controller
public class ReturnController {

    @Autowired
    private ISkuService iSkuService;

    @Autowired
    private ISkuImgService iSkuImgService;

    @RequestMapping("/return")
    public Mono<String> returnLogin(Model model) {
        // sku数据传输
        Sku skus = iSkuService.selectSkuById("3");
        model.addAttribute("skuMessage",skus);
        // sku图片传输
        String url = iSkuImgService.selectSkuImgUrlById("1");
        System.out.println(url);
        model.addAttribute("skuURL",url);

        return Mono.create(returnMono -> returnMono.success("return"));
    }
}
