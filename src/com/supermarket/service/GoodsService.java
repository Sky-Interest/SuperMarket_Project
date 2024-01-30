package com.supermarket.service;

import com.supermarket.entity.Goods;

import java.util.List;

public interface GoodsService {
    void addGoods(Goods goods);
    void updateGoods(Goods goods);
    void removeGoods(int goods_num);
    Goods getGoods(int goods_num);

    List<Goods> getGoodsAll();
}
