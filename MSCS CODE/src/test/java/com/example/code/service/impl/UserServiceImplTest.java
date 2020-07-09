package com.example.code.service.impl;

import com.example.code.entity.User;
import com.example.code.service.UserService;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void getLearn(){
        User user = userService.getUserById(101);
        Assert.assertThat(user.getUsername(), Matchers.is(("admin")));
    }
}