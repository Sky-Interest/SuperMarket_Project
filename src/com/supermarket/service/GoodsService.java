package com.supermarket.service;

import com.supermarket.entity.Goods;

import java.util.List;

public interface GoodsService {
    void addGoods(Goods goods);
    void updateGoods(Goods goods);
    void removeGoods(int goods_num);
    Goods checkInventoryFromGoodsNum(int goods_num, int inventory);

    Goods getGoodsName(int c_number);

    List<Goods> getGoodsAll();
}
