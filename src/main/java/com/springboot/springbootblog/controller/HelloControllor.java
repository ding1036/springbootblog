package com.springboot.springbootblog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloControllor{
    @RequestMapping("/hello")
    public String hello(){
        return  "Hello World";
    }
}
