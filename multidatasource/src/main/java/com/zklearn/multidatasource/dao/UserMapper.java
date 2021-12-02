package com.zklearn.multidatasource.dao;



import com.zklearn.multidatasource.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    int addUser(@Param("user") User user);
}
