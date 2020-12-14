package com.zk.springboot.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

/*    @ResponseBody
    @ExceptionHandler
    public Map<String,Object> handleException(Exception e){
        Map<String,Object> map=new HashMap<>();
        map.put("code","自定义异常处理器");
        map.put("message",e.getMessage());
        return map;
    }*/
    @ExceptionHandler
    public String handleException(Exception e, HttpServletRequest request){
        Map<String,Object> map=new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",400);
        map.put("code","自定义异常处理器");
        map.put("message",e.getMessage());
        request.setAttribute("myhandleexec",map);
        return "forward:/error";
    }
}
