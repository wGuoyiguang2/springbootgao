package com.example.service;


import com.example.model.User;

public interface UserService {

  public User getUserByName(String name);

  public User getUserById(String id);

}
