package com.example.service;

import com.example.mapper.UserDao;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements  UserService{


    @Autowired
    public UserDao userDao;

    @Override
    public User getUserByName(String name) {
        User user = new User();
        user.setName("慕容白");
        user.setSex("男");
        user.setAge(27);
        return user;
    }

    @Override
    public User getUserById(String id) {
        User user = userDao.getUserById(id);
        return user;
    }
}
