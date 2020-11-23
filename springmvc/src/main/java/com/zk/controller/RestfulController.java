package com.zk.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulController {

//    @RequestMapping("/hello/{param1}/{param2}")
//    public String hello(@PathVariable String param1,@PathVariable String param2,Model model){
//        model.addAttribute("key",param1+param2);
//        //会被视图解析器处理
//        return "test";
//    }
    @GetMapping("/hello/{param1}/{param2}")
    public String getHello(@PathVariable String param1,@PathVariable String param2,Model model){
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
    @DeleteMapping("/hello/{param1}/{param2}")
    public String deleteHello(@PathVariable String param1,@PathVariable String param2,Model model){
        model.addAttribute("key",param1+param2);
        //会被视图解析器处理
        return "test";
    }
    @PutMapping("/hello/{param1}/{param2}")
    public String putHello(@PathVariable String param1,@PathVariable String param2,Model model){
        model.addAttribute("key",param1+param2);
        //会被视图解析器处理为test.jsp
        return "test";
    }
}
