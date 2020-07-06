package com.example.code.service;

import com.example.code.entity.Staff;

import java.util.List;

public interface StaffService {
    void insert(Staff staff);
    List<Staff> getAllStaff();
    void deleteById(Integer id);
    Staff getStaffById(Integer id);
    void updateStaff(Staff staff);
}
