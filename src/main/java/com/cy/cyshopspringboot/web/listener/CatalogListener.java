package com.cy.cyshopspringboot.web.listener;

import com.cy.cyshopspringboot.service.ICatalogService;
import com.cy.cyshopspringboot.viewobject.Catalog1VO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

/**
 * @version 1.0.0
 * @ClassName CatalogListener
 * @Description TODO
 * @Author 吴桐
 * @date 2019/11/1510:50
 */
@WebListener
public class CatalogListener implements ServletContextListener {
    @Autowired
    private ICatalogService iCatalogService;
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(">>>>>>>>>>加载中<<<<<<<<<<");
        ServletContext application = sce.getServletContext();
        List<Catalog1VO> catalogS = iCatalogService.getCatalog();
        application.setAttribute("catalogs", catalogS);
        System.out.println(">>>>>>>>>>加载三级分类到application<<<<<<<<<<");

    }
}
