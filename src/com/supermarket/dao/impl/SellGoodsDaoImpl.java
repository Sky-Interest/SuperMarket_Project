package com.supermarket.dao.impl;

import com.supermarket.dao.SellGoodsDao;
import com.supermarket.entity.SellGoods;
import com.supermarket.util.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SellGoodsDaoImpl implements SellGoodsDao {
    @Override
    public List<SellGoods> getDaySellGoods(Date start_date, Date end_date) {
        String sql ="SELECT c_number," +
                "                c_name," +
                "                c_price," +
                "                vip_price," +
                "                inventory," +
                "        SUM(s_quantity) AS 'total_quantity'," +
                "                SUM(s_quantity*c_price) AS 'total_price' " +
                "        FROM goods INNER JOIN sell_info " +
                "        ON c_number = s_c_number " +
                "        WHERE s_time BETWEEN ? AND ? " +
                "        GROUP BY c_number";

        QueryRunner qr = new QueryRunner(JDBCUtil.ds);
        ResultSetHandler<List<SellGoods>> rsh = new BeanListHandler<>(SellGoods.class);
        List<SellGoods> sellGoods = null;
        try {
            sellGoods = qr.query(sql,rsh,start_date,end_date);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sellGoods;
    }
}
