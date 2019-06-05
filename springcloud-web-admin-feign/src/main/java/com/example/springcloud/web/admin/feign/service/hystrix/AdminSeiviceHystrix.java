package com.example.springcloud.web.admin.feign.service.hystrix;

import com.example.springcloud.web.admin.feign.service.AdminService;

public class AdminSeiviceHystrix implements AdminService {
    @Override
    public String hello(String message) {
        return message + "request error";
    }
}
