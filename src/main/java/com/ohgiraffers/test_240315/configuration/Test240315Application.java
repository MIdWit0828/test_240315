package com.ohgiraffers.test_240315.configuration;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = "com.ohgiraffers.test_240315")
@MapperScan(basePackages = "com.ohgiraffers.test_240315", annotationClass = Mapper.class)
public class Test240315Application {

    public static void main(String[] args) {
        SpringApplication.run(Test240315Application.class, args);
    }

}
