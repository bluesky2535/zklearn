package com.zk.mybatis.dao;

import com.zk.mybatis.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> queryAll();

    User queryById(int id);

    int deleteById(int id);

    int addUser(User user);

    int updateUser(User user);

    List<User> getUserByRowBounds();

    @Select("select * from user where id =#{id}")
    User getByAnnotation(int id);

}
