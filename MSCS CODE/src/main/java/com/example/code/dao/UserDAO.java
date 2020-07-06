package com.example.code.dao;

import com.example.code.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;

@Mapper
public interface UserDAO extends JpaRepository<User, Integer> {

}
