package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.domain.CartMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper{

    List<CartMessage> selectCartMessageAll(Integer memberId);

}
