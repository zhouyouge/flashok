package com.hz.flashok;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.hz.service","com.hz.controller"})
@MapperScan("com.hz.dao")
public class FlashokApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlashokApplication.class, args);
    }
}
