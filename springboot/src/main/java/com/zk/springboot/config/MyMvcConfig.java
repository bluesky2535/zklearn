package com.zk.springboot.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC的自定义配置可以在该类进行配置
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {



    /**
     * 自己定义的拦截器类
     * @return
     */
    @Bean
    SysUserLoginInterceptor sysUserLoginInterceptor() {
        return new SysUserLoginInterceptor();
    }

    /**
     * 添加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sysUserLoginInterceptor());
    }
}
