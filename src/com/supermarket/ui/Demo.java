package com.supermarket.ui;

import com.supermarket.entity.Employee;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        JDBCUtil.getConnection();
//        String sql = "SELECT * FROM t_book";

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
