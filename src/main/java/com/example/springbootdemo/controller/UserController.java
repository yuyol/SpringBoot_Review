package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.mapper.UserMapper;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    /**
     * dynamic agent, automatic instantiation
     * auto injection
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * query user from database by using mybatis
     * @return
     */
    @GetMapping("/queryUser")
    public List query() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
        // converted to JSON automatically
        return users;
    }

    @PostMapping("/insertUser")
    public String insert(User user) {
        int insert = userMapper.insert(user);
        System.out.println(user);
        if(insert>0) return "success";
        else return "fail";
    }

    @ApiOperation("get User by ID")
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
