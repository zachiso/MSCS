package com.example.code.service.impl;

import com.example.code.dao.StaffDAO;
import com.example.code.entity.Staff;
import com.example.code.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

@Service
public class StaffServiceImpl implements StaffService {
    @Autowired
    private StaffDAO staffDao;

    @Override
    public void insert(Staff staff){
    if(staff.getGender() == "" || staff.getName() == "" || staff.getPh() == "" || staff.getPo() == ""){

    }else{
        staffDao.save(staff);
    }
    }

    @Override
    public List<Staff> getAllStaff() {
        return staffDao.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        if(getStaffById(id) == null){
            JOptionPane.showMessageDialog(null,"请输入有效数据");
        }else{
            staffDao.deleteById(id);
        }
    }

    @Override
    public Staff getStaffById(Integer id) {
        return staffDao.findById(id).orElse(null);
    }

    @Override
    public void updateStaff(Staff staff) {
        if(getStaffById(staff.getId()) == null){

        }else{
            staffDao.save(staff);
        }
    }
    }

