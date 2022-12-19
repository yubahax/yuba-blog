package com.example.blog.service;

import com.example.blog.entity.User;

public interface CommonService {

    void sendVerifyCode(String email);

    /**
     * 判断当前用户名是否已经注册
     * @param name 用户名
     * @return true为已经注册，false为未注册
     */
    public boolean isUserExist(String name);

    /**
     * 增加用户
     * @param user 用户名
     * @return 用户实体类
     */
    public void addUser(User user);
}
