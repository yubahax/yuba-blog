package com.example.blog.entity;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

public class UserDetail {
    @TableId
    private int id;
    @TableField("name")
    private String name;
    @TableField("email")
    private String email;
    @TableField("phone")
    private String phone;
    @TableField("headImage")
    private String headImage;
}
