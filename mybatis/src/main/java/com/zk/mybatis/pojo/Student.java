package com.zk.mybatis.pojo;


import lombok.Data;

@Data
public class Student{
    int id;
    String name;
    Teacher teacher;
}
