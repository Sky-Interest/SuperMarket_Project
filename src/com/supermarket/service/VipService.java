package com.supermarket.service;

import com.supermarket.entity.Vip;

import java.util.List;

public interface VipService {
    void addVip(Vip vip);

//    void updateVip(Vip vip);

    void updateVip(String v_number, Vip vip);

    void removeVip(String vip_num);

//    Vip getVipNumber(String vip_num);

    Vip getVipNum(String v_number);

    List<Vip>getVipAll();
}
