package com.zk.ssmbuild.controller;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession=request.getSession();
        System.out.println("====登录拦截器处理前=====");
        //登录页面和执行登录会放行
        if(request.getRequestURI().contains("gologin") ||request.getRequestURI().contains("login") ){
            return true;
        }
        if(httpSession.getAttribute("userLoginInfo")!=null){
            return true;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/gologin.jsp").forward(request,response);
        return false;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    @Nullable ModelAndView modelAndView) throws Exception{
        System.out.println("====登录拦截器清理=====");


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("====登录拦截器处理后=====");

    }

    public static void main(String[] args) {
        System.out.println(1);
    }
}
