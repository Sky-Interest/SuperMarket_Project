package com.supermarket.entity;

import java.util.Date;

public class Vip {
    private String v_number;
    private String v_name;
    private int v_score;
    private String v_phone;
    private Date v_date;

    @Override
    public String toString() {
        return "Vip{" +
                "v_number='" + v_number + '\'' +
                ", v_name='" + v_name + '\'' +
                ", v_score=" + v_score +
                ", v_phone='" + v_phone + '\'' +
                ", v_date=" + v_date +
                '}';
    }

    public String getV_number() {
        return v_number;
    }

    public void setV_number(String v_number) {
        this.v_number = v_number;
    }

    public String getV_name() {
        return v_name;
    }

    public void setV_name(String v_name) {
        this.v_name = v_name;
    }

    public int getV_score() {
        return v_score;
    }

    public void setV_score(int v_score) {
        this.v_score = v_score;
    }

    public String getV_phone() {
        return v_phone;
    }

    public void setV_phone(String v_phone) {
        this.v_phone = v_phone;
    }

    public Date getV_date() {
        return v_date;
    }

    public void setV_date(Date v_date) {
        this.v_date = v_date;
    }

    public Vip(String v_number, String v_name, int v_score, String v_phone, Date v_date) {
        this.v_number = v_number;
        this.v_name = v_name;
        this.v_score = v_score;
        this.v_phone = v_phone;
        this.v_date = v_date;
    }

    public Vip() {
    }


}
