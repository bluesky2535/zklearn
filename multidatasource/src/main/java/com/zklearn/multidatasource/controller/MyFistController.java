package com.zklearn.multidatasource.controller;


import com.zklearn.multidatasource.service.StudentService;
import com.zklearn.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("first")
public class MyFistController {


    @Autowired
    UserService userService;
    @Autowired
    StudentService studentService;

    @GetMapping("hello")
    public String test(){
        System.out.println("hello");
        return "hello";
    }


    @GetMapping("testuser")
    public String testuser(){
        System.out.println("testuser");
        userService.addUser(null);
        return "testuser";
    }

    @GetMapping("teststudent")
    public String teststudent(){
        System.out.println("teststudent");
        studentService.addStudent(null);
        return "teststudent";
    }
}
