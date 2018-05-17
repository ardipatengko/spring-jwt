package com.example.springjwt.springjwt.persistence.service;

import com.example.springjwt.springjwt.persistence.entity.User;

import java.util.List;

public interface UserService {
    String login(String userName, String passWord) throws Exception; //TODO: Using custom Exception to catch Error code & description
    User whoAmI(String token) throws Exception; //TODO: Using custom Exception to catch Error code & description
    User saveUser(User user);
    List<User> getAllUser();
}
