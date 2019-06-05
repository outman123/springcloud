package com.example.springcloud.service.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping(value = "hi")
    public  String hello(String message){
        return message;
    }

}
