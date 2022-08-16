package com.user.controller;

import com.user.entity.UserAuthoritiesInfo;
import com.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {

    @Value("${spring.rabbitmq.host}")
    private String sex;

    @Autowired
    private IUserService userService;

    @RequestMapping("/name")
    public String getName(){
        System.out.println("user:"+sex);
        return sex;
    }

    @RequestMapping("/getPermissionInfo/{index}")
    public UserAuthoritiesInfo getPermissionInfo(@PathVariable String index){
        return userService.getPermissionInfo(index);
    }

    @RequestMapping("/redisTest")
    public void redisTest(){
        userService.register("redis","redisTest");
    }

    @RequestMapping("/getRedisValue")
    public String getRedisValue(){
        return userService.getRedisValue("redis");
    }
}
