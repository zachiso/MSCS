package com.example.code.service.impl;

import com.example.code.dao.UserDAO;
import com.example.code.entity.User;
import com.example.code.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.swing.*;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDao;

    @Override
    public void insert(User user) {
        if(user.getUsername() == "" || user.getCha() == "" || user.getPwd() == ""){

        }else{
            userDao.save(user);
        }
    }

    @Override
    public List<User> getAllUser() {
        return userDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        if(getUserById(id) == null){
            JOptionPane.showMessageDialog(null,"请输入有效数据");
        }else{
            userDao.deleteById(id);
        }
    }

    @Override
    public User getUserById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public void updateUser(User user) {

            userDao.save(user);

    }

    @Override
    public User getUser(String username, String pwd) {
        return userDao.getByPasswordAndUsername(username,pwd);
    }


}
