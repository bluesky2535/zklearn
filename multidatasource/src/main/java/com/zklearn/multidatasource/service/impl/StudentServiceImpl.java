package com.zklearn.multidatasource.service.impl;

import com.zklearn.multidatasource.dao.StudentMapper;
import com.zklearn.multidatasource.pojo.Student;
import com.zklearn.multidatasource.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentMapper studentMapper;
    @Override
    public int addStudent(Student student) {
        Student s=new Student();
        s.setId(10);
        s.setName("张胜男");
        System.out.println(s);

        studentMapper.addStudent(s);

        return 1;
    }
}
