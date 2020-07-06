package com.example.code.controller;

import com.example.code.dao.UserDAO;
import com.example.code.entity.User;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class UserControllerTest {
    @Autowired
    private UserDAO userDAO;
    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("aa");
        user.setPwd("123456");
        user.setCha("bb");
        assertThat(user.getUsername(), Matchers.is(userDAO.save(user).getUsername()));
        assertThat(user.getPwd(), Matchers.is(userDAO.save(user).getPwd()));
        assertThat(user.getCha(), Matchers.is(userDAO.save(user).getCha()));
    }

}