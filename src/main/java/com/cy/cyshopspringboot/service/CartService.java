package com.cy.cyshopspringboot.service;

import com.cy.cyshopspringboot.domain.CartMessage;

import java.util.List;

public interface CartService {

    List<CartMessage> cartMessageAll(Integer memberId);

}
