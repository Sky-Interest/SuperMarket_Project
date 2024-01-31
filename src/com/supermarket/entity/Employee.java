package com.supermarket.entity;

public class Employee {

    private String number;
    private String username;
    private String password;
    private String sex;
    private String phone;
    private int role;
    private int remark;

    @Override
    public String toString() {
        return "Employee{" +
                "number='" + number + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", remark=" + remark +
                '}';
    }

    public Employee(String number, String username, String password, String sex, String phone, int role, int remark) {
        this.number = number;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.phone = phone;
        this.role = role;
        this.remark = remark;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getRemark() {
        return remark;
    }

    public void setRemark(int remark) {
        this.remark = remark;
    }

    public Employee() {
    }


}
