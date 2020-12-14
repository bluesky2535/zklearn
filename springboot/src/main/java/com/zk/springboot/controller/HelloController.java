package com.zk.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HelloController {



    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/hello")
    public String hello(Map<String,String> map) throws Exception {
        map.put("key1","value1");
        if(1==1){
            throw new Exception("myException");
        }
        return "hello";
    }
    @RequestMapping("/hello1")
    public String hello1(Map<String,String> map)  {
        map.put("key1","value1");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/queryList")
    public Map<String,Object> queryList(){
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from springboot");
        return maps.get(0);
    }
}
