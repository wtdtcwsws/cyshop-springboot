package com.cy.cyshopspringboot.web;

import com.cy.cyshopspringboot.domain.Catalog3;
import com.cy.cyshopspringboot.domain.Member;
import com.cy.cyshopspringboot.domain.Sku;
import com.cy.cyshopspringboot.domain.Spu;
import com.cy.cyshopspringboot.service.ICatalogService;
import com.cy.cyshopspringboot.service.IGoodsService;
import com.cy.cyshopspringboot.viewobject.Catalog1VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String index(Model model, HttpServletRequest request) {
        List<Catalog1VO> catalogS = iCatalogService.getCatalog();
        model.addAttribute("catalogs", catalogS);
        request.getServletContext().setAttribute("catalogs", catalogS);
        return "index";
    }
    @RequestMapping("/logout")
    public String logout(Model model,HttpSession session) {
        List<Catalog1VO> catalogS = iCatalogService.getCatalog();
        model.addAttribute("catalogs", catalogS);
        session.removeAttribute("loginfo");
        return "redirect:/index.html";
    }

    /**
     * 通过商品列表进入商品详情页面
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/goods")
    public Mono<String> enterGoods(@RequestParam(value = "id", required = false) String id,@RequestParam(value = "c3", required = false) String c3, Model model) {
        List<Spu> spus = iGoodsService.getSpuById(id);
        model.addAttribute("spu", spus.get(0));
        Catalog3 catalog3 =  iCatalogService.getCatalog3ById(c3).get(0);
        model.addAttribute("catalog3", catalog3);

        List<Sku> skus = iGoodsService.getSkuBySpuId(spus.get(0).getId());
        model.addAttribute("skus", skus);
        return Mono.create(indexMono->indexMono.success("goods"));
    }

    /**
     *  选择三级分类进入商品列表
     * @param c3 三级分类id，可以通过三级分类id找到对应的商品列表
     * @return
     */
    @RequestMapping("/category")
    public Mono<String> enterCatalog(@RequestParam(value = "c3",required = false)String c3,Model model) {
        List<Spu> spus= iGoodsService.getSpuByCatalog3Id(c3);
         Catalog3 catalog3 =  iCatalogService.getCatalog3ById(c3).get(0);
        System.out.println(spus);

        model.addAttribute("spus", spus);
        model.addAttribute("catalog3", catalog3);
        return Mono.create(indexMono->indexMono.success("category"));
    }

}
