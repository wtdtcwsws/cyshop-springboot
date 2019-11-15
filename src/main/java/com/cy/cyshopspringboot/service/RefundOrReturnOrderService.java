package com.cy.cyshopspringboot.service;

public interface RefundOrReturnOrderService {

    boolean insertAll(Integer count,Integer orderId,String reason,String descibe,String type );

}
