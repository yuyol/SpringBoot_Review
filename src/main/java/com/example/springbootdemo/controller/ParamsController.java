package com.example.springbootdemo.controller;

import com.example.springbootdemo.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class ParamsController {

    @RequestMapping(value = "/getTest1", method = RequestMethod.GET)
    public String getTest1() {
        return "GET request";
    }

    @RequestMapping(value = "/getTest2", method = RequestMethod.GET)
    public String getTest2(String nickname, String phone) {
        return nickname+":"+phone;
    }

    // @RequestParam: map the parameter to the value, parameter is mandatory
    // required = false: parameter is optional
    @RequestMapping(value = "/getTest3", method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname", required = false) String name) {
        return name;
    }

    @RequestMapping(value = "/postTest1", method = RequestMethod.POST)
    public String postTest1() {
        return "POST request";
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(String username, String password) {
        return username + ":" + password;
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(User user) {
        System.out.println(user);
        return "POST request";
    }

    // receive JSON format
    @RequestMapping(value = "/postTest4", method = RequestMethod.POST)
    public String postTest4(@RequestBody User user) {
        System.out.println(user);
        return "POST request";
    }

    @GetMapping("/test/**")
    public String test() {
        return "test";
    }
}
