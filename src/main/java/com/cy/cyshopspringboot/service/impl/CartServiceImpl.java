package com.cy.cyshopspringboot.service.impl;

import com.cy.cyshopspringboot.domain.ShoppingCart;
import com.cy.cyshopspringboot.mapper.ShoppingCartMapper;
import com.cy.cyshopspringboot.viewobject.CartVO;
import com.cy.cyshopspringboot.mapper.CartMapper;
import com.cy.cyshopspringboot.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: CartService
 * @Description: 实现所有购物车的操作
 * @Author: 罗海
 * @Date: 2019/11/13 11:52
 **/
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartMapper cartMapper;
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public List<CartVO> cartMessageAll(Integer memberId) {
        return cartMapper.selectCartMessageAll(memberId);
    }

    @Override
    public int createShoppingCart(ShoppingCart shoppingCart) {
        return shoppingCartMapper.insertshoppingCart(shoppingCart);
    }
}
