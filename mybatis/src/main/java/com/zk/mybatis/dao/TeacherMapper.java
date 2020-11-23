package com.zk.mybatis.dao;

import com.zk.mybatis.pojo.Teacher;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> queryAll();

    Teacher queryById(int id);

    int deleteById(int id);

    int addTeacher(Teacher teacher);

    int updateTeacher(Teacher teacher);

}
