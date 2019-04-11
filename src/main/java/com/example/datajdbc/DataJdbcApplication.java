package com.example.datajdbc;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DataJdbcApplication {
    public static void main(String[] args) {
        SpringApplication.run(DataJdbcApplication.class, args);
    }
}
