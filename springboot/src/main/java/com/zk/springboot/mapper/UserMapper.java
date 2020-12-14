package com.zk.springboot.mapper;

import com.zk.springboot.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserMapper {

    List<User> queryAll();

    User queryById(int id);

    int deleteById(int id);

    int addUser(User user);

    int updateUser(User user);

    List<User> getUserByRowBounds();

}
