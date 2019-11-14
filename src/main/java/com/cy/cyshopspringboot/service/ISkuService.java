package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.Sku;

public interface ISkuService {
    Sku selectSkuById(String skuId);
}
