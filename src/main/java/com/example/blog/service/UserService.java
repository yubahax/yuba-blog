package com.example.blog.service;

import com.example.blog.entity.User;
import com.example.blog.mapper.UserMapper;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.core.metadata.IPage;
import javax.annotation.Resource;
import java.util.List;

@Service
public interface UserService {

    /**
     * 修改用户信息
     * @param user 用户信息
     */
    public void updateUser(User user);

    public List<User> selectPageVo(int num,int size);

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
     * 根据name查找用户信息
     * @param name 用户名
     * @return 用户实体类
     */
    public User selectUserByName(String name);

}
