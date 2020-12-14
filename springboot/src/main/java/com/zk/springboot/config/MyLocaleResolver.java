package com.zk.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Configuration
public class MyLocaleResolver  implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String l = request.getParameter("L");
        Locale locale=Locale.getDefault();
        if(!StringUtils.isEmpty(l)){
            String[] s = l.split("_");
            locale=new Locale(s[0],s[1]);//语言,国家
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }


    @Bean
    public MyLocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}

