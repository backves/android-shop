package com.example.androidshop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.androidshop.mapper")
public class AndroidShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(AndroidShopApplication.class, args);
    }

}

