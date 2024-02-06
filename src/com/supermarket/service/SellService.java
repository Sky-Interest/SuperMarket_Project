package com.supermarket.service;

import com.supermarket.dao.SellDao;
import com.supermarket.dao.impl.SellDaoImpl;
import com.supermarket.entity.Sell;

import java.util.Date;
import java.util.List;

public interface SellService {

    void addSell(int s_c_number, int s_quantity, Date date, String s_e_number, String s_vip_number);

    List<Sell> getDaySell(Date start_date, Date end_date);

    List<Sell> getAllSell();
}
