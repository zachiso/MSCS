package com.example.code.controller;

import com.example.code.dao.StaffDAO;
import com.example.code.entity.Staff;
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

public class StaffControllerTest {
    @Autowired
    private StaffDAO staffDAO;

    @Test
    public void testSave(){
        Staff staff = new Staff();
        staff.setName("aa");
        staff.setGender("male");
        staff.setPh("10000");
        staff.setPo("manage");

        assertThat(staff.getName(), Matchers.is(staffDAO.save(staff).getName()));
        assertThat(staff.getGender(), Matchers.is(staffDAO.save(staff).getGender()));
        assertThat(staff.getPh(), Matchers.is(staffDAO.save(staff).getPh()));
        assertThat(staff.getPo(), Matchers.is(staffDAO.save(staff).getPo()));
    }
}