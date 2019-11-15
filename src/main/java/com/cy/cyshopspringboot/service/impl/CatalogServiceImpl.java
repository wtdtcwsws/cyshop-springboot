package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.Catalog1;
import com.cy.cyshopspringboot.domain.Catalog2;
import com.cy.cyshopspringboot.domain.Catalog3;
import com.cy.cyshopspringboot.mapper.Catalog1Mapper;
import com.cy.cyshopspringboot.mapper.Catalog2Mapper;
import com.cy.cyshopspringboot.mapper.Catalog3Mapper;
import com.cy.cyshopspringboot.service.ICatalogService;
import com.cy.cyshopspringboot.viewobject.Catalog1VO;
import com.cy.cyshopspringboot.viewobject.Catalog2VO;
import com.cy.cyshopspringboot.viewobject.Catalog3VO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0.0
 * @ClassName CatalogServiceImpl
 * @Description TODO
 * @Author 吴桐
 * @date 2019/11/1210:28
 */
@Service
public class CatalogServiceImpl implements ICatalogService {
    @Autowired
    private Catalog1Mapper catalog1Mapper;
    @Autowired
    private Catalog2Mapper catalog2Mapper;
    @Autowired
    private Catalog3Mapper catalog3Mapper;

    @Override
    public List<Catalog1> select1All() {

        return catalog1Mapper.selectAll();
    }

    @Override
    public List<Catalog2> select2All() {
        return catalog2Mapper.selectAll();
    }

    @Override
    public List<Catalog3> select3All() {
        return catalog3Mapper.selectAll();
    }

    @Override
    public List<Catalog1VO> getCatalog() {
        List<Catalog1> catalog1s = select1All();
        List<Catalog1VO> catalog1VOs = new ArrayList<>();
        for (Catalog1 c1 : catalog1s) {
            Catalog1VO catalog1VO = new Catalog1VO();
            catalog1VO.setId(c1.getId());
            catalog1VO.setName(c1.getName());
            catalog1VOs.add(catalog1VO);
        }
//        System.out.println(catalog1VOs);
        List<Catalog2> catalog2s = select2All();
        List<Catalog2VO> catalog2VOs = new ArrayList<>();
        for (Catalog2 c2 : catalog2s) {
            Catalog2VO catalog2VO = new Catalog2VO();
            catalog2VO.setId(c2.getId());
            catalog2VO.setName(c2.getName());
            catalog2VO.setPid(c2.getCatalog1Id());
            catalog2VOs.add(catalog2VO);
        }
//        System.out.println(catalog2VOs);
        List<Catalog3> catalog3s = select3All();
        List<Catalog3VO> catalog3VOs = new ArrayList<>();
        for (Catalog3 c3 : catalog3s) {
            Catalog3VO catalog3VO = new Catalog3VO();
            catalog3VO.setId(c3.getId());
            catalog3VO.setName(c3.getName());
            catalog3VO.setPid(c3.getCatalog2Id());
            catalog3VOs.add(catalog3VO);
        }
//        System.out.println(catalog3VOs);

        for (Catalog1VO c1o : catalog1VOs) {
            for (Catalog2VO c2o : catalog2VOs) {
                if (c2o.getPid().equals(c1o.getId())) {
                    c1o.getChildren().add(c2o);
                    for (Catalog3VO c3o : catalog3VOs) {
                        if (c3o.getPid().equals(c2o.getId())) {
                            c2o.getChildren().add(c3o);
                        }
                    }
                }
            }
        }
//        System.out.println(catalog1VOs);

//        Catalog1VO catalog1VO = new Catalog1VO();


        return catalog1VOs;
    }

    @Override
    public List<Catalog3> getCatalog3ById(String c3Id) {
        Catalog3 catalog3 = new Catalog3();
        catalog3.setId(Integer.parseInt(c3Id));

        return catalog3Mapper.select(catalog3);
    }
}
