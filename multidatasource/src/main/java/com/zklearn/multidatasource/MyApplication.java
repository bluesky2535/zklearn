package com.zklearn.multidatasource;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})//解决循环依赖
@MapperScan("com.zklearn.multidatasource.dao")
public class MyApplication {

public static void main(String[] args) {
    SpringApplication.run(MyApplication.class, args);
}

}