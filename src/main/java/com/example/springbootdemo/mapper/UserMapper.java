package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /*

    @Select("select * from user")
    public List<User> find();

    @Insert("insert into user values(#{id},#{username},#{password})")
    public int insert(User user);
    */
    @Select("Select * from user where id = #{id}")
    List<User> selectById(int id);

    // select all the users and their orders
    @Select("Select * from user")
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "id", property = "orders", javaType = List.class,
                    many = @Many(select = "com.example.springbootdemo.mapper.OrderMapper.selectByUid")
            )
    })
    List<User> selectAllUserAndOrders();

}
