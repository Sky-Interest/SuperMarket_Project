package com.supermarket.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Clock {
    private int clock_id;
    private String employee_no;
    private LocalDateTime clock_in_time;
    private LocalDateTime clock_off_time;
    private Date clock_date;
    //下面是考勤系统专有字段
    private Date work_date;
    private String username;
    private String diff_in_status;
    private String diff_off_time;//表列名是这个，实际上是diff_off_status

    @Override
    public String toString() {
        return "Clock{" +
                "clock_id=" + clock_id +
                ", employee_no='" + employee_no + '\'' +
                ", clock_in_time=" + clock_in_time +
                ", clock_off_time=" + clock_off_time +
                ", clock_date=" + clock_date +
                ", work_date=" + work_date +
                ", username='" + username + '\'' +
                ", diff_in_status='" + diff_in_status + '\'' +
                ", diff_off_time='" + diff_off_time + '\'' +
                '}';
    }

    public int getClock_id() {
        return clock_id;
    }

    public void setClock_id(int clock_id) {
        this.clock_id = clock_id;
    }

    public String getEmployee_no() {
        return employee_no;
    }

    public void setEmployee_no(String employee_no) {
        this.employee_no = employee_no;
    }

    public LocalDateTime getClock_in_time() {
        return clock_in_time;
    }

    public void setClock_in_time(LocalDateTime clock_in_time) {
        this.clock_in_time = clock_in_time;
    }

    public LocalDateTime getClock_off_time() {
        return clock_off_time;
    }

    public void setClock_off_time(LocalDateTime clock_off_time) {
        this.clock_off_time = clock_off_time;
    }

    public Date getClock_date() {
        return clock_date;
    }

    public void setClock_date(Date clock_date) {
        this.clock_date = clock_date;
    }

    public Date getWork_date() {
        return work_date;
    }

    public void setWork_date(Date work_date) {
        this.work_date = work_date;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDiff_in_status() {
        return diff_in_status;
    }

    public void setDiff_in_status(String diff_in_status) {
        this.diff_in_status = diff_in_status;
    }

    public String getDiff_off_time() {
        return diff_off_time;
    }

    public void setDiff_off_time(String diff_off_time) {
        this.diff_off_time = diff_off_time;
    }

    public Clock(int clock_id, String employee_no, LocalDateTime clock_in_time, LocalDateTime clock_off_time, Date clock_date, Date work_date, String username, String diff_in_status, String diff_off_time) {
        this.clock_id = clock_id;
        this.employee_no = employee_no;
        this.clock_in_time = clock_in_time;
        this.clock_off_time = clock_off_time;
        this.clock_date = clock_date;
        this.work_date = work_date;
        this.username = username;
        this.diff_in_status = diff_in_status;
        this.diff_off_time = diff_off_time;
    }

    public Clock() {
    }


}
