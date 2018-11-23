package com.jt.cart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@MapperScan("com.jt.cart.mapper")
@EnableEurekaClient
public class Cart_starter {
    public static void main(String[] args) {
        SpringApplication.run(Cart_starter.class,args);
    }
}
