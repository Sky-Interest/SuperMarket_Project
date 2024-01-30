package com.supermarket.entity;

public class Employee {

    private String employee_num;
    private String employee_uname;
    private String employee_psw;
    private String employee_sex;
    private String employee_phone;
    private int employee_role;
    private int employee_remark;

    public Employee() {
    }

    public String getEmployee_num() {
        return employee_num;
    }

    public void setEmployee_num(String employee_num) {
        this.employee_num = employee_num;
    }

    public String getEmployee_uname() {
        return employee_uname;
    }

    public void setEmployee_uname(String employee_uname) {
        this.employee_uname = employee_uname;
    }

    public String getEmployee_psw() {
        return employee_psw;
    }

    public void setEmployee_psw(String employee_psw) {
        this.employee_psw = employee_psw;
    }

    public String getEmployee_sex() {
        return employee_sex;
    }

    public void setEmployee_sex(String employee_sex) {
        this.employee_sex = employee_sex;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public int getEmployee_role() {
        return employee_role;
    }

    public void setEmployee_role(int employee_role) {
        this.employee_role = employee_role;
    }

    public int getEmployee_remark() {
        return employee_remark;
    }

    public void setEmployee_remark(int employee_remark) {
        this.employee_remark = employee_remark;
    }

    public Employee(String employee_num, String employee_uname, String employee_psw, String employee_sex, String employee_phone, int employee_role, int employee_remark) {
        this.employee_num = employee_num;
        this.employee_uname = employee_uname;
        this.employee_psw = employee_psw;
        this.employee_sex = employee_sex;
        this.employee_phone = employee_phone;
        this.employee_role = employee_role;
        this.employee_remark = employee_remark;
    }



    @Override
    public String toString() {
        return "employee{" +
                "employee_num='" + employee_num + '\'' +
                ", employee_uname='" + employee_uname + '\'' +
                ", employee_psw='" + employee_psw + '\'' +
                ", employee_sex='" + employee_sex + '\'' +
                ", employee_phone='" + employee_phone + '\'' +
                ", employee_role=" + employee_role +
                ", employee_remark=" + employee_remark +
                '}';
    }



}
