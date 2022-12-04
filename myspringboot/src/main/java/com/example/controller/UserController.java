package com.example.controller;


import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    public UserService userService;

    @GetMapping("/getUserByName")
    public User getUserByName(String name) {
        User user =  userService.getUserByName(name);
        return user;
    }

    @GetMapping("/getUserById")
    public User getUserById(String id) {
        User user =  userService.getUserById(id);
        return user;
    }



}
