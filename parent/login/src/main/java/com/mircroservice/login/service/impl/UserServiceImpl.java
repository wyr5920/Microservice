package com.mircroservice.login.service.impl;

import com.mircroservice.entity.User;
import com.mircroservice.login.mapper.UserMapper;
import com.mircroservice.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void Login(User user) {
        userMapper.selectById(user.getId());
    }
}
