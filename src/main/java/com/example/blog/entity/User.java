package com.example.blog.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @TableId(type = IdType.AUTO)
    private int id;

    @TableField("name")
    private String name;

    @TableField("password")
    private String password;

    @TableField("role")
    private String role;

    @TableField("isalive")
    private int isalive;

    public User(String name, String password, String role, int isalive) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.isalive = isalive;
    }
}
