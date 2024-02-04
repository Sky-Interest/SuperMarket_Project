package com.supermarket.service.impl;

import com.supermarket.dao.ClockDao;
import com.supermarket.dao.impl.ClockDaoImpl;
import com.supermarket.entity.Clock;
import com.supermarket.service.ClockService;

import java.util.List;

public class ClockServiceImpl implements ClockService {
    ClockDao dao = new ClockDaoImpl();
    @Override
    public List<Clock> getSalaryAll() {
        return dao.getSalaryAll();
    }

    @Override
    public List<Clock> getSalaryToday() {
        return dao.getSalaryToday();
    }
    @Override
    public void addSalaryIn(Clock clock){dao.addSalaryIn(clock);}
    public void addSalaryOut(Clock clock){dao.addSalaryOut(clock);};

}
