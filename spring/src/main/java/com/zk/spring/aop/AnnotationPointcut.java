package com.zk.spring.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
public class AnnotationPointcut {

    @Before("execution(* com.zk.spring.aop.*.*(..))")
    public void before(){
        System.out.println("注解方式执行方法前");
    }

    @After("execution(* com.zk.spring.aop.*.*(..))")
    public void after(){
        System.out.println("注解方式执行方法后");
    }

    @Around("execution(* com.zk.spring.aop.*.*(..))")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("注解方式执行方法环绕前");
        Object proceed = joinPoint.proceed();
        System.out.println("注解方式执行方法环绕后");
        System.out.println(joinPoint.getSignature());
    }
}
