package com.cy.cyshopspringboot.mapper;

import com.cy.cyshopspringboot.viewobject.CartVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartMapper{

    List<CartVO> selectCartMessageAll(Integer memberId);

}
