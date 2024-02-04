package com.supermarket.service;

import com.supermarket.entity.Clock;

import java.util.List;

public interface ClockService {
    List<Clock> getSalaryAll();
    List<Clock> getSalaryToday();

//    void addSalary(Clock clock);
    void addSalaryOut(Clock clock);

    void addSalaryIn(Clock clock);
}
