package com.mars.bj.service;

import com.mars.bj.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User findByName(String name);
}
