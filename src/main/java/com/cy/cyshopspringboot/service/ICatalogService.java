package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Catalog1;
import com.cy.cyshopspringboot.domain.Catalog2;
import com.cy.cyshopspringboot.domain.Catalog3;
import com.cy.cyshopspringboot.viewobject.Catalog1VO;

import java.util.List;

public interface ICatalogService {
    /**
     * 查询所有一级分类
     * @return
     */
    List<Catalog1> select1All();

    /**
     * 查询所有二级分类
     * @return
     */
    List<Catalog2> select2All();

    /**
     * 查询所有三级分类
     * @return
     */
    List<Catalog3> select3All();

    /**
     * 组装三级分类
     * @return
     */
    List<Catalog1VO> getCatalog();

    /**
     * 通过三级分类id获得三级分类
     * @return
     */
    List<Catalog3> getCatalog3ById(String c3Id);
}
