package com.jt.manage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(exclude={
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
@MapperScan("com.jt.manage.mapper")
@EnableEurekaClient
public class ManageStart {
	public static void main(String[] args) {
		SpringApplication.run(ManageStart.class,  args);
	}
}
