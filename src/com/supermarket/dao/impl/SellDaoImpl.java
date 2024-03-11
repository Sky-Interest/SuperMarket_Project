package com.supermarket.dao.impl;

import com.supermarket.dao.SellDao;
import com.supermarket.entity.Sell;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SellDaoImpl implements SellDao {
    @Override
    public void addSell(int s_c_number, int s_quantity, Date date, String s_e_number, String s_vip_number) {
        String sql = "INSERT INTO sell_info(s_c_number,s_quantity,s_time,s_e_number,s_vip_number)" +
                "VALUES(?,?,?,?,?) ";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,s_c_number,s_quantity,date,s_e_number,s_vip_number);
        } catch (SQLException e) {
//            e.printStackTrace();
            System.out.println("添加数据失败！");

        }
    }

    @Override
    public List<Sell> getDaySell(Date start_date , Date end_date) {
        String sql ="SELECT * FROM sell_info where s_time BETWEEN ? AND ? ";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<List<Sell>> rsh = new BeanListHandler<>(Sell.class);
        List<Sell> sells = null;
        try {
            sells = qr.query(sql,rsh,start_date,end_date);
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("数据获取失败！");
        }
        return sells;
    }
    //获取所有销售信息
    @Override
    public List<Sell> getAllSell() {
        String sql ="SELECT * FROM sell_info";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<List<Sell>> rsh = new BeanListHandler<>(Sell.class);
        List<Sell> sells = null;
        try {
            sells = qr.query(sql,rsh);
        } catch (SQLException e) {
            e.printStackTrace();
//            System.out.println("数据获取失败！");
        } catch (NullPointerException e ){
            System.out.println("销售信息为空!");
        }
        return sells;
    }


}
