package com.example.code.service;

import com.example.code.entity.Goods;


import java.util.List;

public interface GoodsService {
    void insert(Goods goods);
    List<Goods> getAllGoods();
    void deleteById(Integer id);
    Goods getGoodsById(Integer id);
    void updateGoods(Goods goods);
}
