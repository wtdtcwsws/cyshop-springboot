package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.ShoppingCart;
import com.cy.cyshopspringboot.viewobject.CartVO;

import java.util.List;

public interface CartService {

    List<CartVO> cartMessageAll(Integer memberId);

    int createShoppingCart(ShoppingCart shoppingCart);
}
