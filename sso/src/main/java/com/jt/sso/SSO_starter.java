package com.jt.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@MapperScan("com.jt.sso.mapper")
@EnableEurekaClient
public class SSO_starter {
    public static void main(String[] args) {
        SpringApplication.run(SSO_starter.class,args);
    }
}
