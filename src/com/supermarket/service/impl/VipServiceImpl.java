package com.supermarket.service.impl;

import com.supermarket.dao.VipDao;
import com.supermarket.dao.impl.VipDaoImpl;
import com.supermarket.entity.Vip;
import com.supermarket.service.VipService;

import java.util.List;

public class VipServiceImpl implements VipService {
    VipDao dao = new VipDaoImpl();
    @Override
    public void addVip(Vip vip) {
        dao.addVip(vip);
    }

    @Override
    public void updateVip(String v_number, Vip vip) {
        dao.updateVip(v_number,vip);
    }

    @Override
    public void removeVip(String vip_num) {
        dao.removeVip(vip_num);
    }

    @Override
    public Vip getVipNum(String v_number) {
        return dao.getVipNum(v_number);

    }

    @Override
    public List<Vip> getVipAll() {
        return dao.getVipAll();
    }
}
