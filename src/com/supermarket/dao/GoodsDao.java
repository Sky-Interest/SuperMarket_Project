package com.supermarket.dao;

import com.supermarket.entity.Goods;

import java.util.List;

public interface GoodsDao {
    void addGoods(Goods goods);

    List<Goods> getLowGoods(int inventory);

    void updateGoods(Goods goods);
    void removeGoods(int goods_num);
    Goods checkInventoryFromGoodsNum(int goods_num ,int inventory);

    Goods getGoodsName(int c_number);

    List<Goods> getGoodsAll();
}
