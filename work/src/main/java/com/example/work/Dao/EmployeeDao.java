package com.example.demo.Dao;

import com.example.demo.pojo.Employee;
import com.example.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static{
        employees = new HashMap<Integer, Employee>();
        employees.put(1001,new Employee(1001, "aa","123456@qq.com",1,new Department(101,"后勤部门")));
        employees.put(1002,new Employee(1002, "bb","123456@qq.com",1,new Department(102,"后勤部门")));
        employees.put(1003,new Employee(1003, "cc","123456@qq.com",1,new Department(103,"后勤部门")));
        employees.put(1004,new Employee(1004, "dd","123456@qq.com",1,new Department(104,"后勤部门")));
        employees.put(1005,new Employee(1005, "ee","123456@qq.com",1,new Department(105,"后勤部门")));
    }
    private static Integer ininId = 1006;
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(ininId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }
    public Collection<Employee> getAll(){
        return employees.values();
    }
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }
    public void delete(Integer id){
        employees.remove(id);
    }

}
