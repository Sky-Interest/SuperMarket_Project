package com.supermarket.dao;

import com.supermarket.entity.Vip;

import java.util.List;

public interface VipDao {
    void addVip(Vip vip);
    void updateVip(Vip vip);
    void removeVip(String vip_num);
    void getVipNumber(String vip_num);

    List<Vip> getVipAll();
}