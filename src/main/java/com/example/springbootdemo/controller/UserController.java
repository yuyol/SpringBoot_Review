package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user/{id}")
    public String getUserById(@PathVariable int id) {
        System.out.println(id);
        return "retrieve data by user id";
    }

    @PutMapping("/user")
    public String update(User user) {
        return "update user";
    }

    @PostMapping("/user")
    public String save(User user) {
        return "add user";
    }

    @DeleteMapping("/user/{id}")
    public String deleteById(@PathVariable int id) {
        System.out.println(id);
        return "delete id by user";
    }
}
