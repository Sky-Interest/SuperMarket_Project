package com.supermarket.service;

import com.supermarket.dao.SellGoodsDao;
import com.supermarket.dao.impl.SellGoodsDaoImpl;
import com.supermarket.entity.SellGoods;

import java.util.Date;
import java.util.List;

public interface SellGoodsService {

    List<SellGoods> getDaySellGoods(Date start_date, Date end_date);
}
