package com.example.blog.service;

import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public interface UserService {

    /**
     * 修改用户信息
     * @param user 用户信息
     */
    public void updateUser(User user);

    /**
     * 增加用户
     * @param user 用户名
     * @return 用户实体类
     */
    public void addUser(User user);

    /**
     * 删除用户
     * @param id 用户编号
     * @return 用户实体类
     */
    public void deleteByName(int id);

    /**
     * 根据id查找用户信息
     * @param id 用户编号
     * @return 用户实体类
     */
    public User selectUserById(int id);

    /**
     * 判断当前用户名是否已经注册
     * @param name 用户名
     * @return true为已经注册，false为未注册
     */
    public boolean isUserExist(String name);

}
