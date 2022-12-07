package com.example.blog.service.serviceImpl;


import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service

public class UserAuthService implements UserDetailsService {

    @Resource
    UserMapper mapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User data = mapper.selectByName(username);
        if(data == null) {
            throw new UsernameNotFoundException("用户 "+username+" 登录失败，用户名不存在！");
        }
        return org.springframework.security.core.userdetails.User
                .withUsername(data.getName())
                .password(data.getPassword())
                .roles(data.getRole())
                .build();
    }
}

