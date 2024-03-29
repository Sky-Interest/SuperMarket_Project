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
    public void updateEmployee(String employee_num,Employee employee) {
        dao.updateEmployee(employee_num,employee);
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
    public Employee getEmployeeSellNum(String employee_num) {
        return dao.getEmployeeSellNum(employee_num);
    }


    @Override
    public List<Employee> getEmployeesAll() {
        return dao.getEmployeesAll();
    }

    @Override
    public Employee getEmployeeNumNamePsw(String employee_num, String employee_password){
        return dao.getEmployeeNumNamePsw(employee_num,employee_password);
    }
//    @Override
//    public List<Clock> getSalaryAll() {
//        return dao.getSalaryAll();
//    }
}
