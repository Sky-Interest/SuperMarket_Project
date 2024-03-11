package com.supermarket.dao;

import com.supermarket.entity.Clock;
import com.supermarket.entity.Employee;
import com.supermarket.entity.Vip;

import java.util.List;

public interface EmployeeDao {

    void addEmployee(Employee employee);

//    void addVip(Vip vip);

    void updateEmployee(String employee_num, Employee employee);

//    void updateVip(String v_number, Vip vip);

    void removeEmployee(String employee_num);

//    void removeVip(String v_number);

    //查询员工编号
//    Vip getVipNum(String v_number);

    Employee getEmployeeNum(String employee_num);

    Employee getEmployeeSellNum(String employee_num);

    Employee getEmployeeNumNamePsw(String employee_num, String employee_password);

    List<Employee> getEmployeesAll();

//    List<Clock> getSalaryAll();

//    List<Vip> getVipAll();
}
