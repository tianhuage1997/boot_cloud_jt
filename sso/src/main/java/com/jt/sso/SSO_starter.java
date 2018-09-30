package com.jt.sso;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jt.sso.mapper")
public class SSO_starter {
    public static void main(String[] args) {
        SpringApplication.run(SSO_starter.class,args);
    }
}
