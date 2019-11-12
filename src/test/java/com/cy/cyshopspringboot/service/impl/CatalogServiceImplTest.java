package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.service.ICatalogService;
import com.cy.cyshopspringboot.viewobject.Catalog1VO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class CatalogServiceImplTest {
@Autowired
    private ICatalogService iCatalogService;

    @Test
    public void getCatalog() {
        List<Catalog1VO> catalog1VOS = iCatalogService.getCatalog();
        Assert.assertNotNull(catalog1VOS);
        System.out.println(catalog1VOS);
    }
}