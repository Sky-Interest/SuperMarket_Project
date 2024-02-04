package com.supermarket.service.impl;

import com.supermarket.dao.GoodsDao;
import com.supermarket.dao.impl.GoodsDaoImpl;
import com.supermarket.entity.Goods;
import com.supermarket.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    GoodsDao dao = new GoodsDaoImpl();
    @Override
    public void addGoods(Goods goods) {
        dao.addGoods(goods);
    }

    @Override
    public void updateGoods(Goods goods) {
        dao.updateGoods(goods);
    }

    @Override
    public void removeGoods(int goods_num) {
        dao.removeGoods(goods_num);
    }

    @Override
    public Goods checkInventoryFromGoodsNum(int goods_num ,int inventory) {
        return dao.checkInventoryFromGoodsNum(goods_num,inventory);
    }

    @Override
    public List<Goods> getGoodsAll() {
        return dao.getGoodsAll();
    }
}
