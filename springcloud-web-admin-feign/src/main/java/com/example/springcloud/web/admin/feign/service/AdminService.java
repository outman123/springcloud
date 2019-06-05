package com.example.springcloud.web.admin.feign.service;

import com.example.springcloud.web.admin.feign.service.hystrix.AdminSeiviceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "springcloud-service-admin",fallback = AdminSeiviceHystrix.class)
public interface AdminService {

    @GetMapping(value="hi")
    String hello(@RequestParam(value = "message")String message);
}
