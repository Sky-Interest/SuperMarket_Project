package com.supermarket.service;

import com.supermarket.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmployee(String employee_num);

    Employee getEmployeeNum(String employee_num);

    List<Employee> getEmployeesAll();

}