package com.cy.cyshopspringboot.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberMapperTest {
    @Autowired
    private MemberMapper memberMapper;
    @Test
    public void select() {
        memberMapper.selectAll();
    }

}