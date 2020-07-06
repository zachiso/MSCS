package com.example.code.dao;

import com.example.code.entity.Vip;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface VipDAO extends JpaRepository<Vip,Integer> {

}
