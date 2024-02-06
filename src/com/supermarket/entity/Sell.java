package com.supermarket.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class Sell {
    private int s_c_number;
    private int s_quantity;
    private LocalDateTime s_time;
    private String s_e_number;
    private String s_vip_number;

    public Sell() {
    }

    @Override
    public String toString() {
        return "Sell{" +
                "s_c_number=" + s_c_number +
                ", s_quantity=" + s_quantity +
                ", s_time=" + s_time +
                ", s_e_number='" + s_e_number + '\'' +
                ", s_vip_number='" + s_vip_number + '\'' +
                '}';
    }

    public int getS_c_number() {
        return s_c_number;
    }

    public void setS_c_number(int s_c_number) {
        this.s_c_number = s_c_number;
    }

    public int getS_quantity() {
        return s_quantity;
    }

    public void setS_quantity(int s_quantity) {
        this.s_quantity = s_quantity;
    }

    public LocalDateTime getS_time() {
        return s_time;
    }

    public void setS_time(LocalDateTime s_time) {
        this.s_time = s_time;
    }

    public String getS_e_number() {
        return s_e_number;
    }

    public void setS_e_number(String s_e_number) {
        this.s_e_number = s_e_number;
    }

    public String getS_vip_number() {
        return s_vip_number;
    }

    public void setS_vip_number(String s_vip_number) {
        this.s_vip_number = s_vip_number;
    }

    public Sell(int s_c_number, int s_quantity, LocalDateTime s_time, String s_e_number, String s_vip_number) {
        this.s_c_number = s_c_number;
        this.s_quantity = s_quantity;
        this.s_time = s_time;
        this.s_e_number = s_e_number;
        this.s_vip_number = s_vip_number;
    }
}
