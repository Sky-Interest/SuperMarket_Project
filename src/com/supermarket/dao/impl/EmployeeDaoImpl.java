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

//        String sql = "INSERT INTO employee(number,username,password,sex,phone,role)values(?,?,?,?,?,?)";
//
//        JDBCUtil.update(sql, employee.getNumber(), employee.getUsername(), employee.getPassword(), employee.getSex(), employee.getPhone(), employee.getRole(), employee.getRemark());
//        String sql = "INSERT INTO employee(number,username,password,sex,phone,role)values(?,?,?,?,?,?)";
//        ;
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
//        Employee employees = null;
//        try {
//            employees = qr.insert(sql,employees.getNumber(),employees.getUsername(),employees.getPassword(),employees.getSex(),employees.getPhone(), employee.getRole());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //添加
        String sql = "INSERT INTO employee(number,username,password,sex,phone,role,remark)values(?,?,?,?,?,?,?)";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,employee.getNumber(),employee.getUsername(),employee.getPassword(),employee.getSex(),employee.getPhone(), employee.getRole(),employee.getRemark());
            System.out.println("插入成功...");
        } catch (SQLException e) {
            System.out.println("插入失败...");
        }

    }

    @Override
    public void updateEmployee(String employee_num, Employee employee) {
//        String sql = "update employee set username=?,password=?,sex=?,phone=?,role=? where number=?";
//
//        JDBCUtil.update(sql, employee.getUsername(), employee.getPassword(), employee.getSex(), employee.getPhone(), employee.getRole());
//        String sql = "update employee set username=?,password=?,sex=?,phone=?,role=? where number=?";
//        ;
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
//        Employee employees = null;
//        try {
//            employees = qr.query(sql,rsh,employees.getUsername(),employees.getPassword(),employees.getSex(),employees.getPhone(),2,employees.getNumber());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        //修改
        String sql = "update employee set username=?,password=?,sex=?,phone=?,role=?,remark=? where number=?";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,employee.getUsername(),employee.getPassword(),employee.getSex(),employee.getPhone(),2, employee.getRemark(),employee_num);
            System.out.println("修改成功...");
        } catch (SQLException e) {
            System.out.println("修改失败...");
        }
    }

    @Override
    public void removeEmployee(String employee_num) {
//        String sql = "delete from employee where number=?";
//
//        JDBCUtil.update(sql, employee_num);
        String sql = "delete from employee where number=?";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,employee_num);
            System.out.println("删除成功...");
        } catch (SQLException e) {
            System.out.println("删除失败...");
        }
    }

    @Override
    public Employee getEmployeeNum(String employee_num) {
        //查询
        String sql ="SELECT*FROM employee WHERE number=?";

        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        //封装
        ResultSetHandler<Employee> rsh = new BeanHandler<>(Employee.class);
        Employee employee = null;
        try {
            employee = qr.query(sql,rsh,employee_num);

        } catch (SQLException e) {
            System.out.println("查询失败！");
        }catch (NullPointerException e){
            System.out.println("不存在此员工!");
        }
        return employee;

    }

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
    @Override
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
    }//查询账号和密码
    @Override
    public List<Employee> getEmployeesAll() {
//        ResultSet rs = null;
//        List<Employee> employees= new ArrayList<>();
//        try {
//            rs = JDBCUtil.query(sql);
//            while (rs.next()){
//                Employee employee = new Employee(rs.getString("number"),
//                        rs.getString("username"),
//                        rs.getString("password"),
//                        rs.getString("sex"),
//                        rs.getString("phone"),
//                        rs.getInt("role"),
//                        rs.getInt("remark"));
//                employees.add(employee);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
//        }
        String sql = "select * from employee";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<List<Employee>> rh = new BeanListHandler<>(Employee.class);
        List<Employee> employees = null;
        try {
            employees = qr.query(sql,rh);
            for (Employee employee : employees) {
                //循环形式输出
                System.out.println(employee);
            }
        }catch (Exception e) {
            System.out.println("查询失败");
        }
        return employees;
    }


}
