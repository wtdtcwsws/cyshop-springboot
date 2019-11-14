package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.Sku;
import com.cy.cyshopspringboot.mapper.SkuMapper;
import com.cy.cyshopspringboot.service.ISkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhy
 * @version 1.0.0
 * @function TODO
 * @date 2019年9月4日下午3:01:42
 * @place 工作地点
 * @remarks TODO
 */
@Service
public class SkuServiceImpl implements ISkuService {
    @Autowired
    private SkuMapper skuMapper;

    @Override
    public Sku selectSkuById(String skuId) {
        Sku sku = new Sku();
        sku.setId(Integer.parseInt(skuId));
        List<Sku> skus = skuMapper.select(sku);
        return skus.get(0);
    }
}
