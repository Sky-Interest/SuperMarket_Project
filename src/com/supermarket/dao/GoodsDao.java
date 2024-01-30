package com.supermarket.dao;

import com.supermarket.entity.Goods;

import java.util.List;

public interface GoodsDao {
    void addGoods(Goods goods);
    void updateGoods(Goods goods);
    void removeGoods(String goods_num);
    void getGoods(String goods_num);

    List<Goods> getGoodsAll();
}
