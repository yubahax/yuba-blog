package com.example.blog.service.serviceImpl;

import com.example.blog.entity.User;
import com.example.blog.entity.UserDetail;
import com.example.blog.mapper.UserDetailMapper;
import com.example.blog.service.UserDetailService;
import com.example.blog.util.RedisUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetilServiceImpl implements UserDetailService {

    @Resource
    UserDetailMapper userDetailMapper;

    @Resource
    RedisUtils redisUtils;

    @Override
    public UserDetail selectUserDetailById(int id) {
        UserDetail userDetail = (UserDetail) redisUtils.get("userDetail"+id);
        if (userDetail==null) {
             userDetail = userDetailMapper.selectById(id);
             redisUtils.set("userDetail"+id,userDetail);
        }
        return  userDetail;
    }

    @Override
    public void updateUserDetail(UserDetail userDetail) {
        User user = redisUtils.getUser();
        redisUtils.set("userDetail"+user.getId(),userDetail);
        userDetailMapper.updateById(userDetail);
    }

    @Override
    public void addUserDetail(UserDetail userDetail) {
        User user = redisUtils.getUser();
        redisUtils.set("userDetail"+user.getId(),userDetail);
        userDetailMapper.insert(userDetail);
    }
}
