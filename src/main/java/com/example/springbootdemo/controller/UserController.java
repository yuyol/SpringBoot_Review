package com.example.springbootdemo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootdemo.entity.Order;
import com.example.springbootdemo.entity.User;
import com.example.springbootdemo.mapper.OrderMapper;
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

    @Autowired
    private OrderMapper orderMapper;


    ///////////////////////////////////  paging search  ////////////////////////////////////

    @GetMapping("/user/findByPage")
    public IPage findByPage() {
        Page<User> page = new Page<>(0,2);
        IPage ipage = userMapper.selectPage(page, null);
        return ipage;
    }



    ///////////////////////////////////  query wrapper  ////////////////////////////////////

    @GetMapping("/user/findByCond")
    public List<User> findByCond() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","yy");
        return userMapper.selectList(queryWrapper);
    }



    ///////////////////////////////////  multi tables  //////////////////////////////////////
    @GetMapping("/user/findUser")
    public List<User> findUsers() {
        return userMapper.selectAllUserAndOrders();
    }

    @GetMapping("/user/findAllOrders")
    public List<Order> findOrders() {
        return orderMapper.selectAllOrdersAndUser();
    }


    ///////////////////////////////////  MyBatis plus  ////////////////////////////////////
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



    ////////////////////////////////////  MyBatis  //////////////////////////////////////


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
