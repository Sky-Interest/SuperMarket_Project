package com.supermarket.dao;

import com.supermarket.entity.Clock;

import java.util.List;

public interface ClockDao {
    List<Clock> getSalaryAll();
    List<Clock> getSalaryToday();

    void addSalaryIn(Clock clock);

    void addSalaryOut(Clock clock);
}
