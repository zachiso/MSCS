package com.example.code.service.impl;

import com.example.code.dao.StaffDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class StaffServiceImplTest {
    @Autowired
    private StaffDAO staffDAO;

    @Test
    public void testSave(){
        System.out.println(staffDAO.findAll().toString());
    }
}