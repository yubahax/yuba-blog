package com.example.blog.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

public class UserDetail {
    @TableId
    private int id;
    @TableField("name")
    private String name;
    @TableField("sex")
    private String sex;
    @TableField("age")
    private int age;
    @TableField("email")
    private String email;
    @TableField("phone")
    private String phone;
    @TableField("headImage")
    private String headImage;
}
