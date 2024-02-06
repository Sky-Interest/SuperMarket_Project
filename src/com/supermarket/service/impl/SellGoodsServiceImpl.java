package com.supermarket.service.impl;

import com.supermarket.dao.SellGoodsDao;
import com.supermarket.dao.impl.SellGoodsDaoImpl;
import com.supermarket.entity.SellGoods;
import com.supermarket.service.SellGoodsService;

import java.util.Date;
import java.util.List;

public class SellGoodsServiceImpl implements SellGoodsService {
    SellGoodsDao dao = new SellGoodsDaoImpl();
    @Override
    public List<SellGoods> getDaySellGoods(Date start_date, Date end_date){
        return dao.getDaySellGoods(start_date, end_date);
    }
}
