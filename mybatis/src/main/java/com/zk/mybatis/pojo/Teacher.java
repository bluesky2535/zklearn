package com.zk.mybatis.pojo;

import lombok.Data;

import java.util.List;


@Data
public class Teacher {
    int id;
    String name;
    List<Student> studentList;
}
