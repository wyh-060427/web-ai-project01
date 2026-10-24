package com.wyh.Service.impl;

import com.wyh.Dao.UserDao;
import com.wyh.Dao.impl.UserDaoImpl;
import com.wyh.Service.UserService;
import com.wyh.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//@Component//表示当前类是一个Spring管理的bean
@Service
public class UserServiceImpl implements UserService {
    @Autowired//应用程序运行时，会自动的查询类型的bean对象，并赋值给该成员变量
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        List<String> lines=userDao.findAll();
        //2.解析用户信息，封装为User对象，  list集合
        List<com.wyh.pojo.User> userList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String username = parts[1];
            String password = parts[2];
            String name=parts[3];
            Integer age = Integer.parseInt(parts[4]);
            LocalDateTime updateTime=LocalDateTime.parse(parts[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new com.wyh.pojo.User(id, username, password, name, age, updateTime);
        }).toList();
        return userList;
    }
}
