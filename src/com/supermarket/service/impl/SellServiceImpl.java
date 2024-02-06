package com.supermarket.service.impl;

import com.supermarket.dao.SellDao;
import com.supermarket.dao.impl.SellDaoImpl;
import com.supermarket.entity.Sell;
import com.supermarket.service.SellService;

import java.util.Date;
import java.util.List;

public class SellServiceImpl implements SellService {
    SellDao dao = new SellDaoImpl();
    @Override
    public void addSell(int s_c_number, int s_quantity, Date date, String s_e_number, String s_vip_number){
        dao.addSell(s_c_number,s_quantity,date,s_e_number,s_vip_number);
    }
    @Override
    public List<Sell> getDaySell(Date start_date, Date end_date){
        return dao.getDaySell(start_date, end_date);
    };
    @Override
    public List<Sell> getAllSell(){
        return dao.getAllSell();
    }
}
