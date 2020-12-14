package com.zk.springboot.service;

import com.zk.springboot.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {


    public Student findByName(String name) ;

    public Student insertStudent(String name);

    public int updateStudent( String name, int id);

    public int deleteStudent( int id);
}
