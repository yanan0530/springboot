package com.example.datajdbc.controller;

import com.example.datajdbc.mapper.UserMapper;
import com.example.datajdbc.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public Users insetUser(Users users){
        userMapper.insertUser(users);
        return users;
    }
    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") Integer id){
        return userMapper.getUserById(id);
    }
}
