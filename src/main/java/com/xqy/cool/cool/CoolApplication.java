package com.xqy.cool.cool;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xqy.cool.cool.mapper")
public class CoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoolApplication.class, args);
    }

}
