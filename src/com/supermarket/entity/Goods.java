package com.supermarket.entity;

public class Goods {
    private String c_number;
    private String c_name;
    private double c_price;
    private double vip_price;
    private int inventory;//库存

    @Override
    public String toString() {
        return "Goods{" +
                "c_number='" + c_number + '\'' +
                ", c_name='" + c_name + '\'' +
                ", c_price=" + c_price +
                ", vip_price=" + vip_price +
                ", inventory=" + inventory +
                '}';
    }

    public String getC_number() {
        return c_number;
    }

    public void setC_number(String c_number) {
        this.c_number = c_number;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public double getC_price() {
        return c_price;
    }

    public void setC_price(double c_price) {
        this.c_price = c_price;
    }

    public double getVip_price() {
        return vip_price;
    }

    public void setVip_price(double vip_price) {
        this.vip_price = vip_price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public Goods(String c_number, String c_name, double c_price, double vip_price, int inventory) {
        this.c_number = c_number;
        this.c_name = c_name;
        this.c_price = c_price;
        this.vip_price = vip_price;
        this.inventory = inventory;
    }

    public Goods() {
    }


}
