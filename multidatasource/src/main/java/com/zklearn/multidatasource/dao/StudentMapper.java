package com.zklearn.multidatasource.dao;


import com.zklearn.multidatasource.pojo.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface StudentMapper {

    int addStudent(@Param("student") Student student);

}
