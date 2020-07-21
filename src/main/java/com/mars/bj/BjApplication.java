package com.mars.bj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mars.bj.dao")
public class BjApplication {

    public static void main(String[] args) {
        SpringApplication.run(BjApplication.class, args);
    }

}
