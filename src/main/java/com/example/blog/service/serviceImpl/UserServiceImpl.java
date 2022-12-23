package com.example.blog.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import com.example.blog.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    RedisUtils redisUtils;



    @Override
    public void updateUser(User user) {
        redisUtils.set("user"+user.getId(),user);
        userMapper.updateById(user);
    }



    @Override
    public void deleteByName(int id) {
        User user = (User) redisUtils.get("user"+id);
        if (user!=null) {
            redisUtils.set(user.getName(), null);
        }
        userMapper.deleteById(id);
    }

    @Override
    public User selectUserById(int id) {

        User user = (User) redisUtils.get("user"+id);
        if (user == null) {
            user=userMapper.selectById(id);
            redisUtils.set("user"+id,user);
        }
        return user;
    }
    @Override
    public List<User> selectPageVo(int num,int size) {
        Page<User> userPage = new Page<>(num,size);
        return  userMapper.selectPage(userPage,null).getRecords();
    }
    @Override
    public User selectUserByName(String name) {
        return userMapper.selectByName(name);
    }
}
