package com.zklearn.multidatasource.service;


import com.zklearn.multidatasource.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    int addUser(User user);
}
