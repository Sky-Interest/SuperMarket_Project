package com.supermarket.entity;

public class Goods {
    private String goods_num;
    private String goods_name;
    private double goods_price;
    private double goods_vip_price;
    private int goods_inventory;//库存

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goods_num='" + goods_num + '\'' +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_vip_price=" + goods_vip_price +
                ", goods_inventory=" + goods_inventory +
                '}';
    }

    public Goods(String goods_num, String goods_name, double goods_price, double goods_vip_price, int goods_inventory) {
        this.goods_num = goods_num;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_vip_price = goods_vip_price;
        this.goods_inventory = goods_inventory;
    }

    public String getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(String goods_num) {
        this.goods_num = goods_num;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public double getGoods_vip_price() {
        return goods_vip_price;
    }

    public void setGoods_vip_price(double goods_vip_price) {
        this.goods_vip_price = goods_vip_price;
    }

    public int getGoods_inventory() {
        return goods_inventory;
    }

    public void setGoods_inventory(int goods_inventory) {
        this.goods_inventory = goods_inventory;
    }
}
