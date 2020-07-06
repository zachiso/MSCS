package com.example.code.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Vip {
    @Id
    @GeneratedValue
    private  Integer id;
    private  String name;
    private  String ph;
}
