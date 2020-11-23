package com.zk.spring.config;


import com.zk.spring.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages={"com.zk.spring"})
public class MyConfig2 {

    @Bean
    public User getUser(){
        return new User();
    }

}
