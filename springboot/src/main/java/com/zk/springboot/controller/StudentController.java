package com.zk.springboot.controller;

import com.zk.springboot.pojo.Student;
import com.zk.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/student")
@Controller
public class StudentController {


    @Autowired
    StudentService studentService;

    @ResponseBody
    @GetMapping("/{name}")
    public Student findByName(@PathVariable("name") String name){
        Student student = studentService.findByName(name);
        return student;
    }


}
