package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Sku;
import com.cy.cyshopspringboot.domain.Spu;

import java.util.List;

/**
 * @version 1.0.0
 * @InterfaceName IGoodsService
 * @Description TODO
 * @Author 吴桐
 * @date 2019/11/1211:25
 */
public interface IGoodsService {
    /**
     * 通过三级分类查找所有商品spu
     * @param catalog3Id
     * @return
     */
    List<Spu> getSpuByCatalog3Id(String catalog3Id);

    /**
     * 用通过关键字搜索商品spu，通过模糊查询实现
     * @param keyword 搜索关键字
     * @return
     */
    List<Spu> getSpuByKeyword(String keyword);

    /**
     * 通过spuid查询spu对象
     * @param id
     * @return
     */
    List<Spu> getSpuById(String id);

    /**
     * 通过spuid获得skus
     * @param id
     * @return
     */
    List<Sku> getSkuBySpuId(Integer id);
}
