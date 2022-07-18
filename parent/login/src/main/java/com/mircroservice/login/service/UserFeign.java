package com.mircroservice.login.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "user-config")
public interface UserFeign {

    @RequestMapping("/user/name")
    String getName();
}
