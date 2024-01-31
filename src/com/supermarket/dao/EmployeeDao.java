package com.supermarket.dao;

import com.supermarket.entity.Employee;

import java.util.List;

public interface EmployeeDao {

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void removeEmployee(String employee_num);

    Employee getEmployeeNum(String employee_num);

    Employee getEmployeeNumNamePsw(String employee_num, String employee_password);

    List<Employee> getEmployeesAll();

}
