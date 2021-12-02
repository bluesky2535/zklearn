package com.zklearn.multidatasource.service.impl;

import com.zklearn.multidatasource.dao.UserMapper;
import com.zklearn.multidatasource.pojo.User;
import com.zklearn.multidatasource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public int addUser(User user) {
        User u=new User();
        u.setAge(10);
        u.setId(20);
        u.setName("我能");
        System.out.println(u);
        userMapper.addUser(u);
        return 1;
    }
}
