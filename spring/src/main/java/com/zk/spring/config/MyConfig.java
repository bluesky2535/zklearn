package com.zk.spring.config;


import com.zk.spring.User;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages={"com.zk.spring"})
@Import(MyConfig2.class)
public class MyConfig {

    @Bean
    @Scope("prototype")
    public User getUser(){
        return new User();
    }

}
