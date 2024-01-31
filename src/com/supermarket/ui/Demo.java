package com.supermarket.ui;

import com.supermarket.entity.Employee;
import com.supermarket.service.EmployeeService;
import com.supermarket.service.impl.EmployeeServiceImpl;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
//        JDBCUtil.getConnection();
//        String sql = "SELECT * FROM t_book";
        boolean flag = true;
        while (flag) {
            try {

                if(!flag) {

                    break;
                }
                while (flag) {
                    EmployeeService employeeService = new EmployeeServiceImpl();
                    Scanner sc = new Scanner(System.in);
                    System.out.println("请输入您的账号:");
                    String enumber = sc.next();
                    System.out.println("请输入您的密码:");
                    String epsw = sc.next();
                    Employee employeeNum = employeeService.getEmployeeNumNamePsw(enumber, epsw);
                    System.out.println(employeeNum.toString());
                    if(employeeNum !=null){
                        flag = false;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("账号或密码错误，请重新输入");
            }
        }

    }
    @Test
    public void fun4(){
        String sql = "SELECT * FROM employee";
        //查询
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        //
        ResultSetHandler<List<Employee>> rh = new BeanListHandler<>(Employee.class);
        try {
            List<Employee> books = qr.query(sql, rh);
            for (Employee book : books) {
                System.out.println(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
