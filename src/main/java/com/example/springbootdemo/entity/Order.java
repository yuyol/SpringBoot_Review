package com.example.springbootdemo.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("t_order")
public class Order {
    private int id;
    private String ordertime;
    private int total;
    private int uid;

    @TableField(exist = false)
    private User user;

    public Order(){}

    public Order(int id, String orderTime, int total, int uid) {
        this.id = id;
        this.ordertime = orderTime;
        this.total = total;
        this.uid = uid;
    }

    public int getId() {
        return id;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public int getTotal() {
        return total;
    }

    public int getUid() {
        return uid;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", ordertime='" + ordertime + '\'' +
                ", total=" + total +
                ", uid=" + uid +
                ", user=" + user +
                '}';
    }
}
