package com.example.blog.service;

import com.example.blog.entity.User;
import com.example.blog.entity.UserDetail;

public interface UserDetailService {
    /**
     * 根据用户编号查找用户详情信息
     * @param id 用户编号
     * @return 用户详情信息实体类
     */
    public UserDetail selectUserDetailById(int id);

    /**
     * 修改用户详情信息
     * @param userDetail 用户信息
     */
    public void updateUserDetail(UserDetail userDetail);

    /**
     * 增加用户详情信息
     * @param userDetail 用户编号

     */
    public void addUserDetail(UserDetail userDetail);

}
