package com.example.code.service;

import com.example.code.entity.User;

import java.util.List;

public interface UserService {
    void insert(User user);
    List<User> getAllUser();
    void deleteById(Integer id);
    User getUserById(Integer id);
    void updateUser(User user);
}
