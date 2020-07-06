package com.example.code.dao;

import com.example.code.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface GoodsDAO extends JpaRepository<Goods,Integer> {

}
