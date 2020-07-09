package com.example.code.dao;

import com.example.code.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@Mapper
public interface UserDAO extends JpaRepository<User, Integer> {
    @Query("select o from User o where o.username = ?1 and o.pwd = ?2")
    public User getByPasswordAndUsername(String username,String pwd);
}
