package com.example.blog.service.serviceImpl;

import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import com.example.blog.util.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    RedisUtils redisUtils;

    @Override
    public void updateUser(User user) {
        redisUtils.set(user.getName(),user);
        userMapper.updateById(user);

    }

    @Override
    public void addUser(User user) {
        redisUtils.set(user.getName(),user);
        userMapper.insert(user);
    }

    @Override
    public void deleteByName(int id) {
        User user = redisUtils.getUser();
        if(user!=null){
            redisUtils.set(user.getName(), null);
        }
        userMapper.deleteById(id);

    }

    @Override
    public User selectUserById(int id) {

        User user = (User) redisUtils.get("user"+id);
        if(user == null){
            user=userMapper.selectById(id);
            redisUtils.set("user"+id,user);
        }
        return user;
    }
}
