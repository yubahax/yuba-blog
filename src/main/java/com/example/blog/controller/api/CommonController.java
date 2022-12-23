package com.example.blog.controller.api;


import com.example.blog.entity.User;
import com.example.blog.service.CommonService;
import com.example.blog.service.UserService;
import com.example.blog.util.ParamVail;
import com.example.blog.util.RedisUtils;
import com.example.blog.util.RestBean;
import com.example.blog.util.RestGenerator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController("/common")
public class CommonController {

    @Resource
    CommonService commonService;

    @Resource
    UserService userService;

    @Resource
    RedisUtils redisUtils;

    @GetMapping("/register")
    public RestBean register(@RequestParam("name")String name ,@RequestParam("password")String password){
        if(!ParamVail.vailString(name) || !ParamVail.vailString(password) || password.length()<8 || password.length()>16) {
            return RestGenerator.errorResult("参数输入错误，注册失败");
        }

        if(commonService.isUserExist(name)) {
           return RestGenerator.errorResult("用户名已经存在，注册失败");
        } else {
           commonService.addUser(new User(name,password,"user",1));
           return RestGenerator.successResult("注册成功");
        }
    }
    public RestBean verifyCode(@RequestParam("email") String email) {
        if (!ParamVail.isEmail(email)) {
            return RestGenerator.errorResult("请输入正确邮箱！");
        }
        try {
            commonService.sendVerifyCode(email);
            return RestGenerator.successResult();
        } catch (Exception e) {
            return RestGenerator.errorResult( "邮箱发送失败!");
        }
    }


    @GetMapping("/reset")
    public RestBean reset(@RequestParam("name") String name,@RequestParam("password")String password, @RequestParam("email")String email, @RequestParam("code")String code) {
        if (!ParamVail.vailString(name)||!ParamVail.vailString(password) || password.length() < 8 || password.length() > 16) {
            return RestGenerator.errorResult("参数输入错误，修改失败");
        }
        if (commonService.doVerify(email, code)) {
            User user = userService.selectUserByName(name);
            if(user==null) {
                return RestGenerator.errorResult("用户名不存，修改失败");
            }
            user.setPassword(new BCryptPasswordEncoder().encode(password));
            userService.updateUser(user);
            return RestGenerator.successResult("密码修改成功");
        }
        else {
            return RestGenerator.errorResult("验证码输入错误，修改失败");
        }
    }

    @GetMapping("/page/{num}/{size}")
    public RestBean page(@PathVariable("num") int num,
                         @PathVariable("size") int size) {

//        IPage<User> page=new IPage<>(num,size);
        return RestGenerator.successResult(userService.selectPageVo(num,size));

    }
}
