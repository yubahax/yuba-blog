package com.example.blog.util;

import lombok.Data;

import java.io.Serializable;

@Data
public class  RestBean<T> implements Serializable {
    private int code;
    private String msg;

    private T data;


    public RestBean() {
    }

    public RestBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RestBean(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
