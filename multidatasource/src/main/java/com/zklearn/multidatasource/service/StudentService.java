package com.zklearn.multidatasource.service;


import com.zklearn.multidatasource.pojo.Student;
import com.zklearn.multidatasource.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {

    int addStudent(Student student);
}
