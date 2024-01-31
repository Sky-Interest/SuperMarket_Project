package com.supermarket.dao.impl;

import com.supermarket.dao.VipDao;
import com.supermarket.entity.Employee;
import com.supermarket.entity.Vip;
import com.supermarket.util.JDBCUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VipDaoImpl implements VipDao {
    @Override
    public void addVip(Vip vip) {
        String sql = "INSERT INTO vip(v_number,v_name,v_score,v_phone,v_date)values(?,?,?,?,?)";

        JDBCUtil.update(sql, vip.getV_number(), vip.getV_name(), vip.getV_score(), vip.getV_phone(), vip.getV_date());

    }

    @Override
    public void updateVip(Vip vip) {
        String sql = "update vip set v_number=?,v_name=?,v_score=?,v_phone=?,v_date=? where v_number=?";

        JDBCUtil.update(sql, vip.getV_number(), vip.getV_name(), vip.getV_score(), vip.getV_phone(), vip.getV_date());


    }

    @Override
    public void removeVip(String vip_num) {
        String sql = "delete from vip where v_number=?";

        JDBCUtil.update(sql,vip_num);
    }

    @Override
    public Vip getVipNumber(String vip_num) {
        String sql = "select * from vip where v_number=?";
        ResultSet rs = null;
        Vip vip = null;
        try {
            rs = JDBCUtil.query(sql,vip_num);
            while (rs.next()){
                vip = new Vip(rs.getString("v_number"),
                        rs.getString("v_name"),
                        rs.getInt("v_score"),
                        rs.getString("v_phone"),
                        rs.getDate("v_date"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return vip;

    }

    @Override
    public List<Vip> getVipAll() {
        String sql = "select * from vip";
        ResultSet rs = null;
        List<Vip> vips= new ArrayList<>();
        try {
            rs = JDBCUtil.query(sql);
            while (rs.next()){
                Vip vip = new Vip(rs.getString("v_number"),
                        rs.getString("v_name"),
                        rs.getInt("v_score"),
                        rs.getString("v_phone"),
                        rs.getDate("v_date"));
                vips.add(vip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return vips;
    }
}
