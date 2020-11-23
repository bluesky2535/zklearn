package com.zk.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMarket {


    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MarketService marketservice = context.getBean("marketservice", MarketService.class);
        marketservice.goShopping();

    }

}
