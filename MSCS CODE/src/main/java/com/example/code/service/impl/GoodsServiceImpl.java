package com.example.code.service.impl;

import com.example.code.dao.GoodsDAO;
import com.example.code.entity.Goods;
import com.example.code.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDAO goodsDao;

    @Override
    public void insert(Goods goods)
    {
        if(goods.getName() == "" || goods.getPri() == "" || goods.getType() == ""){

        }else{
            goodsDao.save(goods);
        }
    }

    @Override
    public List<Goods> getAllGoods() {
        return goodsDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {

            goodsDao.deleteById(id);

    }

    @Override
    public Goods getGoodsById(Integer id) {
        return goodsDao.findById(id).orElse(null);
    }

    @Override
    public void updateGoods(Goods goods) {
        if(getGoodsById(goods.getId()) == null){

        }else{
            goodsDao.save(goods);
        }
    }
    }

