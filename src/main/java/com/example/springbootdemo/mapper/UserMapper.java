package com.example.springbootdemo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootdemo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    /**
     * Search all the users
     * @return
     */
//    @Select("select * from user")
//    public List<User> find();

    /**
     * insert into all user
     * @param user
     * @return
     */
//    @Insert("insert into user values(#{id},#{username},#{password})")
//    public int insert(User user);
}
