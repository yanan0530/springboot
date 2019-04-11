package com.example.datajdbc.controller;

import com.example.datajdbc.mapper.UserMapper;
import com.example.datajdbc.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/user")
    public Users insetUser(Users users) {
        userMapper.insertUser(users);
        return users;
    }

    @GetMapping("/user/{id}")
    public Users getUser(@PathVariable("id") Integer id) {
        return userMapper.getUserById(id);
    }

    @GetMapping("/userlist")
    public List<Users> getUserList() {
        List<Users> list = userMapper.getUserList();
        return list;
    }
    @PostMapping("/adduser")
    public void addUser(@RequestBody Users user) {
        userMapper.insertUser(user);
    }
    @GetMapping("/delUser")
    public Boolean delUser(@RequestParam("id") Integer id) {
        return  userMapper.deleteUserById(id);
    }

}
