package com.mircroservice.login.controller;

import com.mircroservice.entity.User;
import com.mircroservice.login.service.UserFeign;
import com.mircroservice.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserFeign userFeign;

    @GetMapping("/findByUserName")
    public void findByUserName(@RequestBody User user){
        userService.Login(user);
    }

    @RequestMapping("/getFeignInfo")
    public String getFeignInfo(){
        return userFeign.getName();
    }
}
