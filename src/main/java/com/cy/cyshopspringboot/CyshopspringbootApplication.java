package com.cy.cyshopspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages="com.cy.cyshopspringboot.mapper")
public class CyshopspringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(CyshopspringbootApplication.class, args);
    }

}
