package com.zk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/annotationController")
public class AnnotationController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("key","注解controller");
        //会被视图解析器处理
        return "test";
    }

}
