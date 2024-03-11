package com.supermarket.dao.impl;

import com.supermarket.dao.VipDao;
import com.supermarket.entity.Vip;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class VipDaoImpl implements VipDao {
    @Override

    public void addVip(Vip vip) {

        String sql = "INSERT INTO vip(v_number,v_name,v_phone,v_date)values(?,?,?,?)";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,vip.getV_number(),vip.getV_name(),vip.getV_phone(),vip.getV_date());
            System.out.println("插入成功...");
        } catch (SQLException e) {
            System.out.println("插入失败...");
        }

    }

    @Override
    public void updateVip(String v_number, Vip vip) {
        String sql = "update vip set v_name=?,v_score=?,v_phone=?,v_date=? where v_number=?";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,vip.getV_name(),vip.getV_score(),vip.getV_phone(), vip.getV_date(),v_number);
            System.out.println("修改成功...");
        } catch (SQLException e) {
            System.out.println("修改失败...");
        }
    }

    @Override
    public void removeVip(String v_number) {
//        String sql = "delete from employee where number=?";
//
//        JDBCUtil.update(sql, employee_num);
        String sql = "delete from vip where v_number=?";
        //创建runner对象
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql,v_number);
            System.out.println("删除成功...");
        } catch (SQLException e) {
            System.out.println("删除失败...");
        }
    }

    @Override
    public Vip getVipNum(String v_number) {
        //查询
        String sql ="SELECT*FROM vip WHERE v_number=?";

        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        //封装
        ResultSetHandler<Vip> rsh = new BeanHandler<>(Vip.class);
        Vip vip = null;
        try {
            vip = qr.query(sql,rsh,v_number);

        } catch (SQLException e) {
//            System.out.println("查询失败！");
        }catch (NullPointerException e){
            System.out.println("不存在此会员!");
        }
        return vip;
    }

//    @Override
//    public Vip getVipNumNamePsw(String vip_number) {
//        String sql ="SELECT*FROM vip WHERE v_number=?";
//
//        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//
//        ResultSetHandler<Vip> rsh = new BeanHandler<>(Vip.class);
//
//        Vip vips = null;
//        try {
//            vips = qr.query(sql,rsh,vip_number);
//        } catch (SQLException e) {
//            System.out.println("会员号输入错误,请重新输入!");
//        }
//
//        return vips;
//    }

    @Override
    public List<Vip> getVipAll() {

        String sql = "select * from vip";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<List<Vip>> rh = new BeanListHandler<>(Vip.class);
        List<Vip> vips = null;
        try {
            vips = qr.query(sql,rh);
//            for (Employee employee : employees) {
//                //循环形式输出
//                System.out.println(employee);
//            }
        }catch (Exception e) {
            System.out.println("查询失败!");
        }
//        return employees;
        return vips.stream()
                .peek(vip -> System.out.println("VIP编号:"+vip.getV_number()+
                        "\tVIP名称:"+ vip.getV_name()+
                        "\tVIP积分:"+ vip.getV_score()+
                        "\tVIP手机号:"+ vip.getV_phone()+
                        "\tVIP注册日期:"+ vip.getV_date())) // 在遍历过程中打印员工信息
                .collect(Collectors.toList()); // 收集并返回修改后的集合
    }

    //查询账号和密码

}
