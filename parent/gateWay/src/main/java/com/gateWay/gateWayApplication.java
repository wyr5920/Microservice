package com.gateWay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class gateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(gateWayApplication.class,args);
    }
}
