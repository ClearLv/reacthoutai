package com.mars.bj.controller;

import com.mars.bj.pojo.Customer;
import com.mars.bj.pojo.User;
import com.mars.bj.result.Result;
import com.mars.bj.service.UserService;
import com.mars.bj.utils.ResultUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public Result login(User user1 , HttpSession session){
        String username = user1.getUsername();
        String name = HtmlUtils.htmlEscape(username);
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(name , user1.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
//            return new Result(200);
            return ResultUtils.success("登陆成功");
        }catch (Exception e){
            return ResultUtils.error(500 , e.getMessage().toString());
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user){
        String username = user.getUsername();
        User byName = userService.findByName(username);
        if(byName != null){
            return ResultUtils.error(500,"该用户已存在");
        }

        String password = user.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String md5 = new SimpleHash("md5", password, salt, 2).toString();

        user.setUsername(username);
        user.setSalt(salt);
        user.setPassword(md5);

        int i = userService.addUser(user);
        if(i > 0){
            return ResultUtils.success("success");
        }else {
            return ResultUtils.error(500,"插入失败");
        }

    }
}
