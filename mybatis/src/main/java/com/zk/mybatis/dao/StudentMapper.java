package com.zk.mybatis.dao;

import com.zk.mybatis.pojo.Student;
import com.zk.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {

    List<Student> queryAll();

    Student queryById(int id);

    int deleteById(int id);

    int addStudent(Student student);

    int updateStudent(Student student);


}
