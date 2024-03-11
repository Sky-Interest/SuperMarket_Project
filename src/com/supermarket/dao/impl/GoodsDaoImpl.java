package com.supermarket.dao.impl;

import com.supermarket.dao.GoodsDao;
import com.supermarket.entity.Goods;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public void addGoods(Goods goods) {
//        String sql = "INSERT INTO goods(c_number,c_name,c_price,vip_price,inventory)values(?,?,?,?,?)";
//
//        JDBCUtil.update(sql,goods.getC_number(),goods.getC_name(),goods.getC_price(),goods.getVip_price(),goods.getInventory());
        String sql = "UPDATE goods SET inventory= ? WHERE c_number =?";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        try {
            qr.update(sql, goods.getInventory(), goods.getC_number());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public List<Goods> getLowGoods(int inventory) {
        String sql ="SELECT * FROM goods where inventory <=?";
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler <List<Goods>> rsh = new BeanListHandler<>(Goods.class);
        List <Goods> goods = null;
        try {
            goods = qr.query(sql,rsh,inventory);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return goods;
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
    public Goods checkInventoryFromGoodsNum(int goods_num ,int inventory) {
        QueryRunner qr = new QueryRunner();
        String sql = "SELECT c_number, c_name, c_price, vip_price, inventory FROM goods WHERE c_number = ?";
//        Map<String, Object> row = qr.query(sql, new MapListHandler(), goodsNumber);
        ResultSetHandler<Goods> rh = new BeanHandler<>(Goods.class);

        Goods goods_info;
        try {
            goods_info = qr.query(sql,rh);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Integer.valueOf(goods_info.getInventory()) >= inventory:
        // 将goods_info对象的inventory属性转换为整数，然后检查它是否大于或等于inventory变量。
        if (goods_info!= null && Integer.valueOf(goods_info.getInventory()) >= inventory) {
//            return new Goods(row.get("c_number").toString(), row.get("c_name").toString(),
//                    Double.valueOf(row.get("c_price").toString()), Double.valueOf(row.get("vip_price").toString()),
//                    Integer.valueOf(row.get("inventory").toString()));
            System.out.println("货号:"+ goods_info.getC_number()+"\t货名:"+ goods_info.getC_name()+"\t价格:"+ goods_info.getC_price()+"\tVip价格:"+ goods_info.getVip_price()+"\t库存:"+ goods_info.getInventory());
        }
        return goods_info;
    }
    @Override
    public Goods getGoodsName(int c_number) {
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
//        System.out.println("商品列表:");
//        System.out.println("编号\t名称\t普通价格\tVIP价格\t库存");

        String sql = "SELECT * from goods where c_number = ?";
        ResultSetHandler<Goods> rh = new BeanHandler<>(Goods.class);

        Goods goods_info = null;
        try {
            goods_info = qr.query(sql,rh,c_number);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return goods_info;
    }

    @Override
    public List<Goods> getGoodsAll() {
        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        System.out.println("商品列表:");
        System.out.println("编号\t名称\t普通价格\tVIP价格\t库存");

        String sql = "SELECT * from goods";
        ResultSetHandler<List<Goods>> rh = new BeanListHandler<>(Goods.class);

        List<Goods> goods_info = null;
        try {
            goods_info = qr.query(sql,rh);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (Goods goods : goods_info) {
            System.out.println(goods.getC_number()+ "\t" +
                    goods.getC_name() + "\t" +
                    goods.getC_price() + "\t" +
                    goods.getVip_price() + "\t" +
                    goods.getInventory());
        }
        return goods_info;
    }
}
