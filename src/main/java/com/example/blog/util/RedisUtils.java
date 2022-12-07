package com.example.blog.util;


import com.example.blog.entity.User;
import com.example.blog.entity.UserDetail;
import com.example.blog.mapper.UserDetailMapper;
import com.example.blog.mapper.UserMapper;
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
    UserDetailMapper detailMapper;

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

    public UserDetail getStudent() {
        User user = this.getUser();
        UserDetail detail = (UserDetail) this.get("user"+user.getId()+"detail");
        if (detail == null) {
            detail = detailMapper.selectById(user.getId());
            this.set("user"+user.getId()+"detail",detail);
        }
        return detail;
    }
}