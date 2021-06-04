package com.xtyu.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xtyu.demo.mapper")
@SpringBootApplication
public class ShardingJdbcDomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcDomeApplication.class, args);
    }

}
