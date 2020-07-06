package com.example.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue
    private  Integer id;
    private  String username;
    private  String pwd;
    private  String cha;
}
