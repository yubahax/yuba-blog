package com.example.blog.controller.page;

import org.springframework.web.bind.annotation.RequestMapping;



public class CommonPageController {

    @RequestMapping("/login")
    public String login() {return "login";}

    @RequestMapping("/index")
    public String index() {return "index";}
}
