package com.cy.cyshopspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="com.cy.cyshopspringboot.mapper")
@ServletComponentScan(basePackages = "com.cy.cyshopspringboot.web.listener")
public class CyshopspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyshopspringbootApplication.class, args);
    }

}
