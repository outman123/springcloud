package com.example.springcloud.web.admin.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "error")
    public String hello(String message){
        return  restTemplate.getForObject("http://springcloud-service-admin/hi?message="+message,String.class);
    }
    public  String error(String message){
        return message + " request error";
    }
}
