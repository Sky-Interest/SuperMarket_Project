package com.supermarket.entity;

import java.math.BigDecimal;

public class SellGoods {
    private int c_number;
    private String c_name;
    private BigDecimal c_price;
    private BigDecimal vip_price;
    private int inventory;
    private int total_quantity;
    private BigDecimal total_price;

    public SellGoods() {
    }

    @Override
    public String toString() {
        return "SellGoods{" +
                "c_number=" + c_number +
                ", c_name='" + c_name + '\'' +
                ", c_price=" + c_price +
                ", vip_price=" + vip_price +
                ", inventory=" + inventory +
                ", total_quantity=" + total_quantity +
                ", total_price=" + total_price +
                '}';
    }

    public int getC_number() {
        return c_number;
    }

    public void setC_number(int c_number) {
        this.c_number = c_number;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public BigDecimal getC_price() {
        return c_price;
    }

    public void setC_price(BigDecimal c_price) {
        this.c_price = c_price;
    }

    public BigDecimal getVip_price() {
        return vip_price;
    }

    public void setVip_price(BigDecimal vip_price) {
        this.vip_price = vip_price;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public BigDecimal getTotal_price() {
        return total_price;
    }

    public void setTotal_price(BigDecimal total_price) {
        this.total_price = total_price;
    }

    public SellGoods(int c_number, String c_name, BigDecimal c_price, BigDecimal vip_price, int inventory, int total_quantity, BigDecimal total_price) {
        this.c_number = c_number;
        this.c_name = c_name;
        this.c_price = c_price;
        this.vip_price = vip_price;
        this.inventory = inventory;
        this.total_quantity = total_quantity;
        this.total_price = total_price;
    }
}
