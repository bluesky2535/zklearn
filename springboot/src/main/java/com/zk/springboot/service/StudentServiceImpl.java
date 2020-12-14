package com.zk.springboot.service;

import com.zk.springboot.mapper.StudentMapper;
import com.zk.springboot.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentServiceImpl  implements StudentService{

    @Autowired
    StudentMapper studentMapper;
    @Override
    public Student findByName(String name) {
        Student student = studentMapper.findByName(name);
        return student;
    }

    @Override
    public Student insertStudent(String name) {
        Student student = studentMapper.insertStudent(name);
        return student;
    }

    @Override
    public int updateStudent(String name, int id) {
        int i = studentMapper.updateStudent(name, id);
        return i;
    }

    @Override
    public int deleteStudent(int id) {
        int i = studentMapper.deleteStudent(id);
        return i;
    }
}
