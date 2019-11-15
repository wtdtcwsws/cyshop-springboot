package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.domain.RefundOrReturnOrder;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;
@Repository
public interface RefundOrReturnOrderMapper extends Mapper<RefundOrReturnOrder> {

    Integer updateReturn(@Param("count") Integer count, @Param("orderId") Integer orderId, @Param("describe") String describe, @Param("reason") String reason, @Param("type") String type);

}