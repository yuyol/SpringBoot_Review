package com.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // http://domain name:port/hello
    // http://domain name:port/hello?nickname=zhangsan&phone=123
    @GetMapping("/hello")
    public String hello(String nickname, String phone) {
        System.out.println(nickname);
        return "hello";
    }
}
