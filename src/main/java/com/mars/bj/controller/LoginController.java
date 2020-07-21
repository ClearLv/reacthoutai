package com.mars.bj.controller;

import com.mars.bj.pojo.Customer;
import com.mars.bj.pojo.User;
import com.mars.bj.result.Result;
import com.mars.bj.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("api/login")
    public Result login(User user1){
        String username = user1.getUsername();
        String userpwd = user1.getPassword();
        User user = userService.findByName(username);
        if(userpwd.equals(user.getPassword())){
            return new Result(200);
        }else {
            return new Result(400);
        }
//        if(username == "admin" && userpwd == "123"){
//            return new Result(200);
//        }else {
//            return new Result(400);
//        }
    }
}