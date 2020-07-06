package com.example.code.controller;

import com.example.code.dao.VipDAO;
import com.example.code.entity.Vip;
import org.hamcrest.Matchers;
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

public class VipControllerTest {
    @Autowired
    private VipDAO vipDAO;

    @Test
    public void testSave(){
        Vip vip = new Vip();
        vip.setName("aa");
        vip.setPh("10000");

        assertThat(vip.getName(), Matchers.is(vipDAO.save(vip).getName()));
        assertThat(vip.getPh(), Matchers.is(vipDAO.save(vip).getPh()));

    }
}