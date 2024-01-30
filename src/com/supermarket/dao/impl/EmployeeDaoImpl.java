package com.supermarket.dao.impl;

import com.supermarket.dao.EmployeeDao;
import com.supermarket.entity.Employee;
import com.supermarket.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee(number,username,password,sex,phone,role)values(?,?,?,?,?,?)";

        JDBCUtil.update(sql, employee.getEmployee_num(), employee.getEmployee_uname(),employee.getEmployee_psw(),employee.getEmployee_sex(),employee.getEmployee_phone(),employee.getEmployee_role(),employee.getEmployee_remark());

    }

    @Override
    public void updateEmployee(Employee employee) {


        String sql = "update employee set username=?,password=?,sex=?,phone=?,role=? where number=?";

        JDBCUtil.update(sql,employee.getEmployee_uname(),employee.getEmployee_psw(),employee.getEmployee_sex(),employee.getEmployee_phone(),employee.getEmployee_role(),employee.getEmployee_remark(),employee.getEmployee_num());

    }

    @Override
    public void removeEmployee(String employee_num) {

        String sql = "delete from employee where number=?";

        JDBCUtil.update(sql,employee_num);


    }

    @Override
    public Employee getEmployeeNum(String employee_num) {
        String sql = "select * from employee where number=?";
        ResultSet rs = null;
        Employee employee = null;
        try {
            rs = JDBCUtil.query(sql,employee_num);
            while (rs.next()){
                employee = new Employee(rs.getString("number"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("sex"),
                        rs.getString("phone"),
                        rs.getInt("role"),
                        rs.getInt("remark"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return employee;

    }

    @Override
    public List<Employee> getEmployeesAll() {
        String sql = "select * from employee";
        ResultSet rs = null;
        List<Employee> employees= new ArrayList<>();
        try {
            rs = JDBCUtil.query(sql);
            while (rs.next()){
                Employee employee = new Employee(rs.getString("number"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("sex"),
                        rs.getString("phone"),
                        rs.getInt("role"),
                        rs.getInt("remark"));
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return employees;
    }
}
