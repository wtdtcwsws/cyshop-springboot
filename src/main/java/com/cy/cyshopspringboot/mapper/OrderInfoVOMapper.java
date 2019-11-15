package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.viewobject.OrderInfoVO;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface OrderInfoVOMapper {

    List<OrderInfoVO> sellectAllInfo(Integer id,Integer limit);

    OrderInfoVO selectByOrderId(Integer orderId,Integer sid);

    Integer selectCount(Integer uid);
}
