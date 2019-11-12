package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.Spu;
import com.cy.cyshopspringboot.service.ICatalogService;
import com.cy.cyshopspringboot.service.IGoodsService;
import com.cy.cyshopspringboot.viewobject.Catalog1VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @version 1.0.0
 * @ClassName GoodsController
 * @Description TODO
 * @Author 吴桐
 * @date 2019/11/129:16
 */
@Controller
public class GoodsController {
    @Autowired
    private ICatalogService iCatalogService;
    @Autowired
    private IGoodsService iGoodsService;

    /**
     * 登录主页显示三级分类
     * @param model
     * @return
     */
    @RequestMapping("/")
    public Mono<String> index(Model model) {
        List<Catalog1VO> catalogS = iCatalogService.getCatalog();
        model.addAttribute("catalogs", catalogS);
        return Mono.create(indexMono->indexMono.success("index"));
    }

    /**
     *  选择三级分类进入商品列表
     * @param id 三级分类id，可以通过三级分类id找到对应的商品列表
     * @return
     */
//    @RequestMapping("/goods")
//    public Mono<String> enterCatalog(@RequestParam(value = "id",required = false) String id,Model model) {
//        List<Spu> spus = iGoodsService.getSpuByCatalog3Id(id);
//        model.addAttribute("spus", spus);
//        System.out.println(">>>>>>>>>>>>enterCatalog<<<<<<<<<<");
//        return Mono.create(indexMono->indexMono.success("goods"));
//    }

    @RequestMapping("/goods")
    public Mono<String> enterGoods() {

        System.out.println(">>>>>>>>>>>>enterGoods<<<<<<<<<<");
        return Mono.create(indexMono->indexMono.success("goods"));
    }

    @RequestMapping("/category")
    public Mono<String> enterCatalog() {
        System.out.println(">>>>>>>>>>>>enterCatalog2<<<<<<<<<<");
        return Mono.create(indexMono->indexMono.success("category"));
    }

}
