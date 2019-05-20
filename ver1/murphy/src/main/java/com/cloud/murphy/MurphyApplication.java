package com.cloud.murphy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cloud.murphy.dao")
public class MurphyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MurphyApplication.class, args);
    }

}
