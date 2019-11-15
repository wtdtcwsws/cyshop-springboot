package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.domain.Sku;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface SkuMapper extends Mapper<Sku> {
}