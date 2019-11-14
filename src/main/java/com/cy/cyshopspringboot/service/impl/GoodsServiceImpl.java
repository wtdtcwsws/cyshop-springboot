package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.Sku;
import com.cy.cyshopspringboot.domain.Spu;
import com.cy.cyshopspringboot.mapper.SkuMapper;
import com.cy.cyshopspringboot.mapper.SpuMapper;
import com.cy.cyshopspringboot.service.IGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0.0
 * @ClassName GoodsServiceImpl
 * @Description TODO
 * @Author 吴桐
 * @date 2019/11/1211:26
 */
@Service
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private SpuMapper spuMapper;
    @Autowired
    private SkuMapper skuMapper;
    @Override
    public List<Spu> getSpuByCatalog3Id(String catalog3Id) {
        Spu spu = new Spu();
        spu.setCatalog3Id(Integer.parseInt(catalog3Id));
        return spuMapper.select(spu);
    }

    @Override
    public List<Spu> getSpuByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<Spu> getSpuById(String id) {
        Spu spu = new Spu();
        spu.setId(Integer.parseInt(id));
        return spuMapper.select(spu);
    }

    @Override
    public List<Sku> getSkuBySpuId(Integer id) {
        Sku sku = new Sku();
        sku.setSpuId(id);
        return skuMapper.select(sku);
    }
}
