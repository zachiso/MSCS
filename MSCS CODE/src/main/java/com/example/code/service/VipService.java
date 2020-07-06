package com.example.code.service;

import com.example.code.entity.User;
import com.example.code.entity.Vip;

import java.util.List;

public interface VipService {
    void insert(Vip vip);
    List<Vip> getAllVip();
    void deleteById(Integer id);
    Vip getVipById(Integer id);
    void updateVip(Vip vip);
}
