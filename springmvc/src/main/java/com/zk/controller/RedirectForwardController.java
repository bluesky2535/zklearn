package com.zk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 重定向和转发
 */
@Controller
@RequestMapping("redirectForwardController")
public class RedirectForwardController {

    @GetMapping("/hello/{param1}/{param2}")
    public String getHello(@PathVariable String param1, @PathVariable String param2, Model model){
        model.addAttribute("key",param1+param2);
        //会被视图解析器处理
        return "forward:/annotationController/hello";
    }
    @GetMapping("/hello1/{param1}/{param2}")
    public String getHello1(@PathVariable String param1,@PathVariable String param2,Model model){
        model.addAttribute("key",param1+param2);
        //会被视图解析器处理
        return "redirect:/annotationController/hello";
    }

}
