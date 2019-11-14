package com.cy.cyshopspringboot;

import com.cy.cyshopspringboot.mapper.MemberMapper;
import com.cy.cyshopspringboot.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CyshopspringbootApplicationTests {

    @Autowired
    private CartService cartService;

    @Test
    public void contextLoads() {

        System.out.println(cartService.cartMessageAll(2));


    }

}
