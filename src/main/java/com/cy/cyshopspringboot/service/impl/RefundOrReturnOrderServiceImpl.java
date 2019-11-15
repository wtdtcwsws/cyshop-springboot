package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.RefundOrReturnOrder;
import com.cy.cyshopspringboot.mapper.RefundOrReturnOrderMapper;
import com.cy.cyshopspringboot.service.RefundOrReturnOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: RefundOrReturnOrderServiceImpl
 * @Description:
 * @Author: 罗海
 * @Date: 2019/11/15 15:34
 **/
@Service
public class RefundOrReturnOrderServiceImpl implements RefundOrReturnOrderService {

    @Autowired
    private RefundOrReturnOrderMapper refundOrReturnOrderMapper;

    @Override
    public boolean insertAll(Integer count, Integer orderId, String reason, String descibe, String type) {

        Integer num = refundOrReturnOrderMapper.updateReturn(count,orderId,reason,descibe,type);

        if( num > 0){
            return true;
        }

        return false;
    }
}
