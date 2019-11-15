package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.SkuImg;
import com.cy.cyshopspringboot.mapper.SkuImgMapper;
import com.cy.cyshopspringboot.service.ISkuImgService;
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
public class SkuImgServiceImpl implements ISkuImgService {

    @Autowired
    private SkuImgMapper skuImgMapper;

    @Override
    public String selectSkuImgUrlById(String id) {
        SkuImg skuImg = new SkuImg();
        skuImg.setId(Integer.parseInt(id));
        List<SkuImg> skuImgs = skuImgMapper.select(skuImg);
        skuImg = skuImgs.get(0);
        return skuImg.getUrl();
    }
}
