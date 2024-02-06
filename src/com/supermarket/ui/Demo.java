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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
//        JDBCUtil.getConnection();
//        String sql = "SELECT * FROM t_book";
//        boolean flag = true;
//        while (flag) {
//            try {
//
//                if(!flag) {
//
//                    break;
//                }
//                while (flag) {
//                    EmployeeService employeeService = new EmployeeServiceImpl();
//                    Scanner sc = new Scanner(System.in);
//                    System.out.println("请输入您的账号:");
//                    String enumber = sc.next();
//                    System.out.println("请输入您的密码:");
//                    String epsw = sc.next();
//                    Employee employeeNum = employeeService.getEmployeeNumNamePsw(enumber, epsw);
//                    System.out.println(employeeNum.toString());
//                    if(employeeNum !=null){
//                        flag = false;
//                        break;
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("账号或密码错误，请重新输入");
//            }
//        }
        Scanner sc = new Scanner(System.in);
        boolean flag1 = false;
        Date date = null;
        String input = null;
        while (!flag1) {
            System.out.print("请输入日期（格式为yyyy-MM-dd）：");
            input = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            try {
                date = sdf.parse(input);
                flag1 = true;
            } catch (Exception e) {
                System.out.println("输入的日期格式不正确，请重新输入。");
            }
        }

        // 查询符合该日期格式的时间范围
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startDateString = input + " 00:00:00";
        String endDateString = input + " 23:59:59";

        try {
            Date startDate = sdf2.parse(startDateString);
            Date endDate = sdf2.parse(endDateString);
            System.out.println(startDate);
            System.out.println(endDate);

            System.out.println("符合该日期格式的时间范围：");
            System.out.println(sdf2.format(startDate) + " 至 " + sdf2.format(endDate));
        } catch (Exception e) {
            System.out.println("查询时间范围出现错误。");
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
