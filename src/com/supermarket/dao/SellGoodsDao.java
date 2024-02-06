package com.supermarket.dao;

import com.supermarket.entity.SellGoods;

import java.util.Date;
import java.util.List;

public interface SellGoodsDao {
    List<SellGoods> getDaySellGoods(Date start_date, Date end_date);
}
