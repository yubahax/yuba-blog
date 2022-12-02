package com.example.blog.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Resource
    StudentMapper studentMapper;

    @Resource
    UserMapper userMapper;

    /**
     * 根据key读取数据
     */
    public Object get(final String key) {
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 写入数据
     */
    public boolean set(final String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value,12, TimeUnit.HOURS);
            //储存信息12小时后过期
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public User getUser() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String name = authentication.getName();
        User user = (User) this.get(name);
        if(user == null) {
            user = userMapper.selectByName(name);
            this.set(name,user);
        }
        return user;
    }

    public Student getStudent() {
        User user = this.getUser();
        Student student = (Student) this.get("user"+user.getId()+"student");
        if (student == null) {
            student = studentMapper.getStudentByUserId(user.getId());
            this.set("user"+user.getId()+"student",student);
        }
        return student;
    }
}