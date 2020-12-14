package com.zk.springboot.controller;

import com.zk.springboot.mapper.UserMapper;
import com.zk.springboot.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/user")
@Controller
public class UserController {


    @Autowired
    UserMapper userMapper;


    @ResponseBody
    @GetMapping("/{id}")
    public User findByName(@PathVariable("id") int id){
        User user = userMapper.queryById(id);
        return user;
    }


}
