package com.user.controller;

import com.user.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Value("${spring.rabbitmq.host}")
    private String sex;

    @RequestMapping("/name")
    public String getName(){
        System.out.println("user:"+sex);
        return sex;
    }
}
