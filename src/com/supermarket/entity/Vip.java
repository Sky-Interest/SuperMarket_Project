package com.supermarket.entity;

import java.util.Date;

public class Vip {
    private String vip_num;
    private String vip_name;
    private int vip_score;
    private String vip_phone;
    private Date vip_date;

    public Vip() {
    }

    @Override
    public String toString() {
        return "Vip{" +
                "vip_num='" + vip_num + '\'' +
                ", vip_name='" + vip_name + '\'' +
                ", vip_score='" + vip_score + '\'' +
                ", vip_phone='" + vip_phone + '\'' +
                ", vip_date=" + vip_date +
                '}';
    }

    public Vip(String vip_num, String vip_name, int vip_score, String vip_phone, Date vip_date) {
        this.vip_num = vip_num;
        this.vip_name = vip_name;
        this.vip_score = vip_score;
        this.vip_phone = vip_phone;
        this.vip_date = vip_date;
    }

    public String getVip_num() {
        return vip_num;
    }

    public void setVip_num(String vip_num) {
        this.vip_num = vip_num;
    }

    public String getVip_name() {
        return vip_name;
    }

    public void setVip_name(String vip_name) {
        this.vip_name = vip_name;
    }

    public int getVip_score() {
        return vip_score;
    }

    public void setVip_score(int vip_score) {
        this.vip_score = vip_score;
    }

    public String getVip_phone() {
        return vip_phone;
    }

    public void setVip_phone(String vip_phone) {
        this.vip_phone = vip_phone;
    }

    public Date getVip_date() {
        return vip_date;
    }

    public void setVip_date(Date vip_date) {
        this.vip_date = vip_date;
    }
}
