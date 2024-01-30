package com.supermarket.service.impl;

import com.supermarket.dao.EmployeeDao;
import com.supermarket.dao.impl.EmployeeDaoImpl;
import com.supermarket.entity.Employee;
import com.supermarket.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeDao dao = new EmployeeDaoImpl();

    @Override
    public void addEmployee(Employee employee) {
        dao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        dao.updateEmployee(employee);
    }

    @Override
    public void removeEmployee(String employee_num) {
        dao.removeEmployee(employee_num);
    }

    @Override
    public Employee getEmployeeNum(String employee_num) {
        return dao.getEmployeeNum(employee_num);
    }

    @Override
    public List<Employee> getEmployeesAll() {
        return dao.getEmployeesAll();
    }
}
