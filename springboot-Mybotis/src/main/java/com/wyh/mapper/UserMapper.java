package com.wyh.mapper;

import com.wyh.pojo.User;
import lombok.Setter;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper //应用程序在运行时，会自动的为该接口创建一个实现类对象（代理对象），并且会自动将该实现类对象存入IOC容器 - bean
public interface UserMapper {
    //@Select("select * from user")
    public List<User> findAll();

    @Update("update user set username=#{username},password=#{password},name=#{name},age=#{age} where id=#{id}")
    public Integer updateage(User user);

    @Delete("delete from user where id=#{id}")
    public Integer deleteid(Integer id);

    @Insert("insert into user(username,password,name,age) values (#{username},#{password},#{name},#{age})")
    public Integer insertdata(User user);

    @Select("select * from user where username=#{username} and password=#{password}")
    public List<User> selectData(@Param("username") String username,@Param("password") String password);
}
