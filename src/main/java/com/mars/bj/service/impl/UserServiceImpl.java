package com.mars.bj.service.impl;

import com.mars.bj.dao.UserMapper;
import com.mars.bj.pojo.User;
import com.mars.bj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int addUser(User user) {
        return userMapper.insertUser(user);
    }
}
