package com.zk.springboot.mapper;


import com.zk.springboot.pojo.Student;
import org.apache.ibatis.annotations.*;

@Mapper
public interface StudentMapper {


    @Select("select * from student where name = #{name}")
    public Student findByName(String name) ;

    @Insert("insert into  student(name) values(#{name)")
    public Student insertStudent(@Param("name")String name);

    @Update("update student set name=#{name} where id=#{id}")
    public int updateStudent(@Param("name") String name,@Param("id") int id);

    @Delete("delete from student where id=#{id})")
    public int deleteStudent(@Param("id") int id);

}
