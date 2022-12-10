package com.example.blog.controller.api;

import com.example.blog.entity.User;
import com.example.blog.service.UserService;
import com.example.blog.util.ParamVail;
import com.example.blog.util.RestBean;
import com.example.blog.util.RestGenerator;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController("/common")
public class CommonController {

    @Resource
    UserService userService;

    @GetMapping("/register")
    public RestBean register(@RequestParam("name")String name ,@RequestParam("password")String password){
        if(!ParamVail.vailString(name) || !ParamVail.vailString(password) || password.length()<8 || password.length()>16) {
            return RestGenerator.errorResult("参数输入错误，注册失败");
        }

        if(userService.isUserExist(name)) {
           return RestGenerator.errorResult("用户名已经存在，注册失败");
        } else {
           userService.addUser(new User(name,password,"user",1));
           return RestGenerator.successResult("注册成功");
        }
    }

}
