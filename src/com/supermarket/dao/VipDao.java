package com.supermarket.dao;

import com.supermarket.entity.Vip;

import java.util.List;

public interface VipDao {
    void addVip(Vip vip);
//    void updateVip(Vip vip);

    void updateVip(String v_number, Vip vip);

    void removeVip(String vip_number);
//    Vip getVipNumber(String vip_num);

    Vip getVipNum(String v_number);

    List<Vip> getVipAll();

    //查询账号和密码
//    Vip getVipNumNamePsw(String vip_number);
}
