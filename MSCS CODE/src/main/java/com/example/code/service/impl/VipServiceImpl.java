package com.example.code.service.impl;

import com.example.code.dao.VipDAO;
import com.example.code.entity.User;
import com.example.code.entity.Vip;
import com.example.code.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class VipServiceImpl implements VipService {
    @Autowired
    VipDAO vipDao;

    @Override
    public void insert(Vip vip) {
        if(vip.getName() == "" || vip.getPh() == ""){

        }else{
            vipDao.save(vip);
        }
    }

    @Override
    public List<Vip> getAllVip() {
        return vipDao.findAll();
    }


    @Override
    public void deleteById(Integer id) {

            vipDao.deleteById(id);

    }

    @Override
    public Vip getVipById(Integer id) {
        return vipDao.findById(id).orElse(null);
    }


    @Override
    public void updateVip(Vip vip) {
        if(getVipById(vip.getId()) == null){

        }else{
            vipDao.save(vip);
        }
    }
    }

