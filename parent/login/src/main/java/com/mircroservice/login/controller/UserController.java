package com.mircroservice.login.controller;

import com.mircroservice.entity.User;
import com.mircroservice.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findByUserName")
    public void findByUserName(@RequestBody User user){
        userService.Login(user);
    }
}
