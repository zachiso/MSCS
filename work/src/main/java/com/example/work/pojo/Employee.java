package com.example.demo.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class Employee {
    private Integer id;
    private String laseName;
    private String email;
    private Integer gender;
    private Department department;
    private Date birth;

    public Employee(Integer id, String laseName, String email, Integer gender, Department department) {
        this.id = id;
        this.laseName = laseName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
