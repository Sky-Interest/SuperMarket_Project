package com.supermarket.dao.impl;

import com.supermarket.dao.GoodsDao;
import com.supermarket.entity.Goods;
import com.supermarket.entity.Vip;
import com.supermarket.util.JDBCUtil;
import org.junit.Test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public void addGoods(Goods goods) {
        String sql = "INSERT INTO goods(c_number,c_name,c_price,vip_price,inventory)values(?,?,?,?,?)";

        JDBCUtil.update(sql,goods.getC_number(),goods.getC_name(),goods.getC_price(),goods.getVip_price(),goods.getInventory());

    }

    @Override
    public void updateGoods(Goods goods) {
        String sql = "update goods set c_number=?,c_name=?,c_price=?,vip_price=?,inventory=? where c_number=?";

        JDBCUtil.update(sql,goods.getC_number(),goods.getC_name(),goods.getC_price(),goods.getVip_price(),goods.getInventory());

    }

    @Override
    public void removeGoods(int goods_num) {
        String sql = "delete from goods where c_number=?";

        JDBCUtil.update(sql,goods_num);
    }

    @Override
    public Goods getGoods(int goods_num) {
        String sql = "select * from goods where c_number=?";
        ResultSet rs = null;
        Goods goods = null;
        try {
            rs = JDBCUtil.query(sql,goods_num);
            while (rs.next()){
                goods = new Goods(rs.getString("c_number"),//所需Int
                        rs.getString("c_name"),
                        rs.getDouble("c_price"),
                        rs.getDouble("vip_price"),
                        rs.getInt("inventory"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return goods;
    }

    @Override
    public List<Goods> getGoodsAll() {
        String sql = "select * from goods";
        ResultSet rs = null;
        List<Goods> goodses= new ArrayList<>();
        try {
            rs = JDBCUtil.query(sql);
            while (rs.next()){
                Goods goods = new Goods(rs.getString("c_number"),//所需Int
                        rs.getString("c_name"),
                        rs.getDouble("c_price"),
                        rs.getDouble("vip_price"),
                        rs.getInt("inventory"));
                goodses.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.closeConn(JDBCUtil.conn,JDBCUtil.pst,rs);
        }
        return goodses;
    }
}
