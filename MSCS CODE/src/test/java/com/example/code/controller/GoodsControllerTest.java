package com.example.code.controller;

import com.example.code.dao.GoodsDAO;
import com.example.code.entity.Goods;
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

public class GoodsControllerTest {
    @Autowired
    private GoodsDAO goodsDAO;

    @Test
    public void testSave(){
        Goods goods = new Goods();
        goods.setName("aa");
        goods.setPri("1000");
        goods.setType("dailyThing");
        assertThat(goods.getName(), Matchers.is(goodsDAO.save(goods).getName()));
        assertThat(goods.getPri(), Matchers.is(goodsDAO.save(goods).getPri()));
        assertThat(goods.getType(), Matchers.is(goodsDAO.save(goods).getType()));
    }
}