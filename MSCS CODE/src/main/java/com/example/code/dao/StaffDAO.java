package com.example.code.dao;

import com.example.code.entity.Staff;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface StaffDAO extends JpaRepository<Staff, Integer> {
}
