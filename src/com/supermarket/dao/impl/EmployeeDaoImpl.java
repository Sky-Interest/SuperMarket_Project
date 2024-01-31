package com.supermarket.dao.impl;

import com.supermarket.dao.EmployeeDao;
import com.supermarket.entity.Employee;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void addEmployee(Employee employee) {

        String sql = "INSERT INTO employee(number,username,password,sex,phone,role)values(?,?,?,?,?,?)";

        JDBCUtil.update(sql, employee.getNumber(), employee.getUsername(), employee.getPassword(), employee.getSex(), employee.getPhone(), employee.getRole(), employee.getRemark());

    }

    @Override
    public void updateEmployee(Employee employee) {


        String sql = "update employee set username=?,password=?,sex=?,phone=?,role=? where number=?";

        JDBCUtil.update(sql, employee.getUsername(), employee.getPassword(), employee.getSex(), employee.getPhone(), employee.getRole());

    }

    @Override
    public void removeEmployee(String employee_num) {

        String sql = "delete from employee where number=?";

        JDBCUtil.update(sql, employee_num);


    }

    @Override
    public Employee getEmployeeNum(String employee_num) {
        String sql = "select * from employee where password=?";
        ResultSet rs = null;
        Employee employee = null;
        try {
            rs = JDBCUtil.query(sql, employee_num);
            while (rs.next()) {
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
        } finally {
            JDBCUtil.closeConn(JDBCUtil.conn, JDBCUtil.pst, rs);
        }
        return employee;

    }

    @Override
//    public Employee getEmployeeNumNamePsw(String employee_num, String employee_password) {
//        String sql = "select * from employee where number='?' and password='?'";
//        ResultSet rs = null;
//        Employee employee = null;
//        try {
//            rs = JDBCUtil.query(sql,employee_num,employee_password);
//            while (rs.next()){
//                employee = new Employee(rs.getString("number"),
//                        rs.getString("username"),
//                        rs.getString("password"),
//                        rs.getString("sex"),
//                        rs.getString("phone"),
//                        rs.getInt("role"),
//                        rs.getInt("remark"));
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
//        }
//        return employee;
//
//    }
    //查询账号和密码
    public Employee getEmployeeNumNamePsw(String employee_num, String employee_password) {
        String sql ="SELECT*FROM employee WHERE number=? and password=? ";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
        Employee employees = null;
        try {
            employees = qr.query(sql,rsh,employee_num,employee_password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
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
